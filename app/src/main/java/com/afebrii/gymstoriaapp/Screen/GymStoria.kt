package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.afebrii.gymstoriaapp.navigation.Screen
import com.afebrii.gymstoriaapp.Screen.RegisterScreen

@Composable
fun GymStoria(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val context = LocalContext.current

    Scaffold {
            contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Onboarding.route,
            modifier = modifier.padding(contentPadding)
        ){
            composable(Screen.Beranda.route) {
                BerandaScreen()
            }

            composable(Screen.Login.route) {
                LoginScreen()
            }

            composable(Screen.Register.route) {
                RegisterScreen(navController)
            }

            composable(Screen.Onboarding.route) {
                OnBoardingScreen(navController)
            }
        }
    }


}