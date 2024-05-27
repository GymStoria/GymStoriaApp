package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.text.style.TextOverflow
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
import com.afebrii.gymstoriaapp.ui.theme.ungu

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
        ItemContent("The Jade", "Jl. HZ Mustofa", R.drawable.the_jade, 4.5f, true),
        ItemContent("Virgo Gym", "Jl. Bebedilan No.27", R.drawable.virgo_gym, 3.5f, false),
    )

    val itemsContentPopuler = listOf(
        ItemContent("Amazon Gym", "Jl. Cikunten", R.drawable.amazon_gym, 4.8f, true),
        ItemContent("ProMuscle Gym", "Jl. Bantar,Argasari", R.drawable.promuscle, 4.2f, true),
    )

    val itemsContentPromo = listOf(
        ItemContent("OB Fitness", "Jl. Plaza Asia", R.drawable.ob_fitness, 4.0f, false),
        ItemContent("Latanza Gym", "Jl. Dawagung", R.drawable.latanza, 4.6f, true),
    )

    val itemsContentBuka24Jam = listOf(
        ItemContent("Viky Gym", "Jl. Ibrahim", R.drawable.viky_gym, 3.9f, false),
        ItemContent("Timor Gym", "Jl. Manggungsari", R.drawable.timor_gym, 4.7f, true),
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
                        // Box untuk gambar
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.5f) // Rasio lebar-ke-tinggi
                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                        ) {
                            // Gambar
                            Image(
                                painter = painterResource(id = itemContent.imageResId),
                                contentDescription = "Image ${itemContent.title}",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        // Judul teks
                        Text(
                            text = itemContent.title,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp, vertical = 8.dp)
                                .fillMaxWidth()
                        ) {
                            // Judul teks
                            Text(
                                text = itemContent.title,
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 8.dp)
                                    .fillMaxWidth()
                            )

                            // Teks keterangan
                            Text(
                                text = itemContent.description.take(15) + if (itemContent.description.length > 15) "..." else "",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 4.dp)
                                    .fillMaxWidth(),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
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
                            // Rating
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth().padding(top = 4.dp) // Tambahkan padding top di sini
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = "Rating",
                                    tint = Color.Yellow,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = "${itemContent.rating}",
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    modifier = Modifier.padding(start = 4.dp) // Tambahkan padding start di sini
                                )
                                // Status "Sedang Ramai" atau "Sepi"
                                Box(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        .clip(shape = RoundedCornerShape(8.dp))
                                        .background(if (itemContent.isBusy) ungu else Color.Gray)
                                        .wrapContentSize(Alignment.Center) // Membuat latar belakang menyesuaikan ukuran konten
                                ) {
                                    Text(
                                        text = if (itemContent.isBusy) "Sedang Ramai" else "Sepi",
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

data class ItemContent(val title: String, val description: String, val imageResId: Int, val rating: Float, val isBusy: Boolean)

@Preview(showBackground = true)
@Composable
fun BerandaScreenPreview() {
    BerandaScreen()
}
