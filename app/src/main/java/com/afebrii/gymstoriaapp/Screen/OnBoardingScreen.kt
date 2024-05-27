package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afebrii.gymstoriaapp.R


@Composable
fun OnBoardingScreen() {
    val currentScreen = remember { mutableStateOf(0) } // Track the current screen index

    val screens = listOf(
        Screen(
            title = "GYM STORIA",
            imageResource = R.drawable.onboarding1,
            title1 = "Telusuri GYM Terdekat",
            description = "Raih kemudahan dalam menemukan Gym dan Fitness Center di kotamu hanya dalam genggaman saja"
        ),
        Screen(
            title = "GYM STORIA",
            imageResource = R.drawable.onboarding2,
            title1 = "Reservasi Online",
            description = "Tak perlu datang langsung, reservasi kini lebih mudah dengan beberapa klik saja"
        ),
        Screen(
            title = "GYM STORIA",
            imageResource = R.drawable.onboarding3,
            title1 = "Beri Rating dan Ulasan",
            description = "Tak perlu datang langsung, reservasi kini lebih mudah dengan beberapa klik saja"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = screens[currentScreen.value].title,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = Color (0xFF8A2BE2),
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(screens[currentScreen.value].imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .padding(bottom = 32.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = screens[currentScreen.value].title1,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = Color (0xFF8A2BE2),
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = screens[currentScreen.value].description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (currentScreen.value > 0) {
                Button(
                    onClick = {
                        currentScreen.value -= 1
                    },
                    modifier = Modifier.size(width = 150.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.White
                    )
                ) {
                    Text(text = "Previous", color = Color(0xFF8A2BE2))
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            )
            {
                Button(
                    onClick = {
                        if (currentScreen.value < screens.lastIndex) {
                            currentScreen.value += 1
                        } else {
                            // Handle the completion of onboarding (e.g., show a login screen)
                        }
                    },
                    modifier = Modifier.size(width = 150.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF8A2BE2),
                    )

                ) {
                    Text(
                        text = if (currentScreen.value == screens.lastIndex) "MASUK" else "LANJUT",
                        color = Color.White
                    )
                }
            }
        }
    }
}


data class Screen(
    val title: String,
    val title1: String,
    val description: String,
    val imageResource: Int
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnBoardingScreen()
}