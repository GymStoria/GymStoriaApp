package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.Screen.LoginScreen
import com.afebrii.gymstoriaapp.Screen.OnBoardingScreen
//import com.afebrii.gymstoriaapp.Screen.BerandaScreen
import com.afebrii.gymstoriaapp.navigation.NavigationItem
import com.afebrii.gymstoriaapp.navigation.Screen
//import com.afebrii.gymstoriaapp.screen.RegisterScreen

//import com.afebrii.gymstoriaapp.Screen.RegisterScreen

@Composable
fun BerandaScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    var isButton1Clicked by remember { mutableStateOf(true) }
    var isButton2Clicked by remember { mutableStateOf(false) }
    var isButton3Clicked by remember { mutableStateOf(false) }
    var isButton4Clicked by remember { mutableStateOf(false) }

    val itemsContentTerdekat = listOf(
        ItemContent("Judul Terdekat 1", "Keterangan Terdekat 1", R.drawable.logos_facebook),
        ItemContent("Judul Terdekat 2", "Keterangan Terdekat 2", R.drawable.logos_facebook),
        ItemContent("Judul Terdekat 3", "Keterangan Terdekat 3", R.drawable.logos_facebook),
    )

    val itemsContentPopuler = listOf(
        ItemContent("Judul Populer 1", "Keterangan Populer 1", R.drawable.logos_facebook),
        ItemContent("Judul Populer 2", "Keterangan Populer 2", R.drawable.logos_facebook),
        ItemContent("Judul Populer 3", "Keterangan Populer 3", R.drawable.logos_facebook),
    )

    val itemsContentPromo = listOf(
        ItemContent("Judul Promo 1", "Keterangan Promo 1", R.drawable.logos_facebook),
        ItemContent("Judul Promo 2", "Keterangan Promo 2", R.drawable.logos_facebook),
        ItemContent("Judul Promo 3", "Keterangan Promo 3", R.drawable.logos_facebook),
    )

    val itemsContentBuka24Jam = listOf(
        ItemContent("Judul Buka 24 Jam 1", "Keterangan Buka 24 Jam 1", R.drawable.logos_facebook),
        ItemContent("Judul Buka 24 Jam 2", "Keterangan Buka 24 Jam 2", R.drawable.logos_facebook),
        ItemContent("Judul Buka 24 Jam 3", "Keterangan Buka 24 Jam 3", R.drawable.logos_facebook),
    )

    val itemsToShow = when {
        isButton1Clicked -> itemsContentTerdekat
        isButton2Clicked -> itemsContentPopuler
        isButton3Clicked -> itemsContentPromo
        isButton4Clicked -> itemsContentBuka24Jam
        else -> itemsContentTerdekat
    }



    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Lokasimu Sekarang",
                color = Color.Gray,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            )
            Text(
                text = "Jalan Gunamarwan, Tasikmalaya",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 35.dp, start = 16.dp)
            )
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 48.dp, top = 16.dp)
            )
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Favorite",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 15.dp)
            )
            var searchText by remember { mutableStateOf("") }
            TextField(
                value = searchText,
                onValueChange = {  },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(end = 17.dp, start = 17.dp, top = 70.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(
                        text = "Search",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                singleLine = true,
                shape = RoundedCornerShape(20.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .padding(top = 11.dp)
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = "REKOMENDASI",
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
                    .size(80.dp)
                    .clip(shape = CircleShape)
                    .clickable {
                        isButton1Clicked = true
                        isButton2Clicked = false
                        isButton3Clicked = false
                        isButton4Clicked = false
                    }
            ) {
                val imagePainter = painterResource(if (isButton1Clicked) R.drawable.icon_terdekat_aktif else R.drawable.icon_terdekat_tidak_aktif)
                Image(
                    painter = imagePainter,
                    contentDescription = "Home",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
                    .size(80.dp)
                    .clip(shape = CircleShape)
                    .clickable {
                        isButton1Clicked = false
                        isButton2Clicked = true
                        isButton3Clicked = false
                        isButton4Clicked = false
                    }
            ) {
                val imagePainter = painterResource(if (isButton2Clicked) R.drawable.icon_popular_aktif else R.drawable.icon_populer_tidak_aktif)
                Image(
                    painter = imagePainter,
                    contentDescription = "Home",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
                    .size(80.dp)
                    .clip(shape = CircleShape)
                    .clickable {
                        isButton1Clicked = false
                        isButton2Clicked = false
                        isButton3Clicked = true
                        isButton4Clicked = false
                    }
            ) {
                val imagePainter = painterResource(if (isButton3Clicked) R.drawable.icon_promo_aktif else R.drawable.icon_promo_tidak_aktif)
                Image(
                    painter = imagePainter,
                    contentDescription = "Home",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
                    .size(80.dp)
                    .clickable {
                        isButton1Clicked = false
                        isButton2Clicked = false
                        isButton3Clicked = false
                        isButton4Clicked = true
                    }
            ) {
                val imagePainter = painterResource(if (isButton4Clicked) R.drawable.icon_24_jam_aktif else R.drawable.icon_24_jam_tidak_aktif)
                Image(
                    painter = imagePainter,
                    contentDescription = "Home",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(itemsToShow) { itemContent ->
                // Item di dalam LazyVerticalGrid
                Card(
                    modifier = Modifier
                        .padding(10.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        // Gambar
                        Image(
                            painter = painterResource(id = itemContent.imageResId),
                            contentDescription = "Image ${itemContent.title}",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .align(Alignment.CenterHorizontally)
                        )

                        // Judul teks
                        Text(
                            text = itemContent.title,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth()

                        )

                        // Teks keterangan
                        Text(
                            text = itemContent.description,
                            color = Color.Gray,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

data class ItemContent(val title: String, val description: String, val imageResId: Int)

@Preview(showBackground = true)
@Composable
fun BerandaScreenPreview() {
    BerandaScreen()
}
