package com.afebrii.gymstoriaapp.Screen

import MembershipScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Route{
    data class OnBoardingScreen(val name:String = "onboarding"):Route()
    data class LoginScreen(val name:String = "login"):Route()
    data class registerScreen(val name:String = "register"):Route()
}
sealed class Routee(val route: String) {
    class BerandaScreen : Routee("beranda")
    class ArtikelScreen : Routee("artikel")
    class MembershipScreen : Routee("membership")
    class ProfileScreen : Routee("profile")
    class PesanScreen : Routee("pesan")
    class PesanDetailScreen : Routee("pesandetail")
}
//navigasi
@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Route.OnBoardingScreen().name,
    ) {
        composable(route = Route.OnBoardingScreen().name) {
            OnBoardingScreen(
                onMasukClick = {
                    navHostController.navigate(Route.LoginScreen().name)
                }
            )
        }
        composable(route = Route.LoginScreen().name) {
            LoginScreen(
                onLoginClick = {
                    navHostController.navigate(Routee.BerandaScreen().route)
                },
                onSignUpClick = {
                    navHostController.navigate(Route.registerScreen().name)
                }
            )
        }
        composable(route = Route.registerScreen().name) {
            RegisterScreen(
                onDaftarClick = {
                    navHostController.navigate(Route.LoginScreen().name)
                }
            )
        }
        composable(route = Routee.BerandaScreen().route) {
            BottomNavAwareScreen(navController = navHostController) {
                BerandaScreen()
            }
        }
        composable(route = Routee.ArtikelScreen().route) {
            BottomNavAwareScreen(navController = navHostController) {
                ArtikelScreen()
            }
        }
        composable(route = Routee.MembershipScreen().route) {
            BottomNavAwareScreen(navController = navHostController) {
                MembershipScreen()
            }
        }
        composable(route = Routee.ProfileScreen().route) {
            BottomNavAwareScreen(navController = navHostController) {
                ProfileScreen()
            }
        }
        composable(route = Routee.PesanScreen().route) {
            BottomNavAwareScreen(navController = navHostController) {
                PesanScreen(
                    onPesanDetailClick = {
                        navHostController.navigate(Routee.PesanDetailScreen().route)
                    }
                )
            }
        }
        composable(route = Routee.PesanDetailScreen().route) {
            BottomNavAwareScreen(navController = navHostController) {
                PesanDetail()
            }
        }
    }
}

@Composable
fun BottomNavAwareScreen(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        content()
        if (navController.currentDestination?.route in listOf(
                Routee.BerandaScreen().route,
                Routee.ArtikelScreen().route,
                Routee.MembershipScreen().route,
                Routee.ProfileScreen().route,
                Routee.PesanScreen().route
            )
        ) {
            MyBottomAppBar(
                navController = navController,
                items = listOf(
                    BottomNavItem(
                        route = Routee.BerandaScreen().route,
                        icon = Icons.Default.Home,
                        title = "Beranda",
                        onClick = {
                            navController.navigate(Routee.BerandaScreen().route)
                        }
                    ),
                    BottomNavItem(
                        route = Routee.ArtikelScreen().route,
                        icon = Icons.Default.Book,
                        title = "Artikel",
                        onClick = {
                            navController.navigate(Routee.ArtikelScreen().route)
                        }
                    ),
                    BottomNavItem(
                        route = Routee.MembershipScreen().route,
                        icon = Icons.Default.Group,
                        title = "Keanggotaan",
                        onClick = {
                            navController.navigate(Routee.MembershipScreen().route)
                        }
                    ),
                    BottomNavItem(
                        route = Routee.PesanScreen().route,
                        icon = Icons.Default.Mail,
                        title = "Pesan",
                        onClick = {
                            navController.navigate(Routee.PesanScreen().route)
                        }
                    ),
                    BottomNavItem(
                        route = Routee.ProfileScreen().route,
                        icon = Icons.Default.AccountCircle,
                        title = "Profil",
                        onClick = {
                            navController.navigate(Routee.ProfileScreen().route)
                        }
                    )
                ),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}