package com.afebrii.gymstoriaapp.navigation

sealed class Screen (val route: String){
    data object Beranda : Screen("beranda")
    data object Login: Screen("login")
    data object Register: Screen("register")
    data object Profile: Screen("profile")
    data object Onboarding: Screen("onboarding")
    data object Artikel: Screen("artikel")
}