package com.afebrii.gymstoriaapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.afebrii.gymstoriaapp.Screen.LoginScreen
import com.afebrii.gymstoriaapp.Screen.OnBoardingScreen
import com.afebrii.gymstoriaapp.Screen.RegisterScreen
//import com.afebrii.gymstoriaapp.Screen.BerandaScreen
import com.afebrii.gymstoriaapp.ui.theme.GymStoriaAppTheme
import com.afebrii.gymstoriaapp.Screen.GymStoria

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
                GymStoria()
            }
        }
}