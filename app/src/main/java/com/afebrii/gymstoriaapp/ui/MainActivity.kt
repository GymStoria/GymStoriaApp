package com.afebrii.gymstoriaapp.ui

import MainViewModel
import com.afebrii.gymstoriaapp.Screen.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    private val mainViewModelInstance by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalMainViewModel provides mainViewModelInstance) {
                Navigation(navController)
            }
        }
    }
}
