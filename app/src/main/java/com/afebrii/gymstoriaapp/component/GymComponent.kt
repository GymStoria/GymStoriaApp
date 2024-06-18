package com.afebrii.gymstoriaapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.Model.Gym
import com.afebrii.gymstoriaapp.ui.theme.GymStoriaAppTheme
import com.afebrii.gymstoriaapp.Screen.*

@Composable
fun GymComponent(
    gym: Gym,
    modifier: Modifier = Modifier,
    onItemClicked: @Composable (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
            }
    ) {
        Image(
            painter = painterResource(id = gym.photo),
            contentDescription = gym.nama,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(60.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = gym.nama, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = " ${gym.status}")
            }
        }
    }
}