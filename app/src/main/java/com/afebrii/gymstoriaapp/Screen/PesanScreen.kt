package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afebrii.gymstoriaapp.data.DataDummy
import com.afebrii.gymstoriaapp.Model.Gym
import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.component.GymComponent

@Composable
fun PesanScreen(
    modifier: Modifier = Modifier,
    gyms: List<Gym> = DataDummy.datagyms,
    onPesanDetailClick: (Gym) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "PESAN",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(10.dp)
            )

            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(end = 17.dp, start = 17.dp, top = 40.dp)
                    .fillMaxWidth()
                    .height(40.dp),
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

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(gyms) { gym ->
                GymComponent(gym = gym) {
                    onPesanDetailClick(gym)
                }
            }
        }
    }
}