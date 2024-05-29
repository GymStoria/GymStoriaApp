package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.CardMembership
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import com.afebrii.gymstoriaapp.navigation.Screen
import com.afebrii.gymstoriaapp.navigation.NavigationItem
import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.Screen.*
import androidx.compose.material3.Icon
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun GymStoria(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) {
            contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Beranda.route,
            modifier = modifier.padding(contentPadding)
        ){
            composable(Screen.Beranda.route) {
                BerandaScreen()
            }

            composable(Screen.Login.route) {
                LoginScreen()
            }

            composable(Screen.Register.route) {
                RegisterScreen(navController = navController)
            }

            composable(Screen.Onboarding.route) {
                OnBoardingScreen(navController = navController)
            }

            composable(Screen.Artikel.route) {
                ArtikelScreen()
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_beranda),
                icon = Icons.Default.Home,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_artikel),
                icon = Icons.Default.Article,
                screen = Screen.Artikel
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_keanggotaan),
                icon = Icons.Default.CardMembership,
                screen = Screen.Artikel
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_pesan),
                icon = Icons.Default.Chat,
                screen = Screen.Artikel
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profil),
                icon = Icons.Default.Person,
                screen = Screen.Profile
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun FrontEndPrev() {
    GymStoria()
}