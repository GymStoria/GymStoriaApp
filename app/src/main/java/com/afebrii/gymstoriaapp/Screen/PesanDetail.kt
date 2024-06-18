package com.afebrii.gymstoriaapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.afebrii.gymstoriaapp.R
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afebrii.gymstoriaapp.data.pesan_dummy
import com.afebrii.gymstoriaapp.ui.theme.GymStoriaAppTheme
import java.text.SimpleDateFormat
import java.util.Locale


val pesan = mutableStateOf("")

private val BotChatBubbleShape = RoundedCornerShape(0.dp,8.dp,8.dp,8.dp)
private val AuthorChatBubbleShape = RoundedCornerShape(8.dp,0.dp,8.dp,8.dp)

@Composable
fun PesanDetail()
{
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        TopBarSection(
            username = "The Jade",
            profile = painterResource(id = R.drawable.the_jade),
            isOnline = true
        )
        ChatSection(Modifier.weight(1f))
        PesanSection()
    }

}

@Composable
fun TopBarSection(
    username : String,
    profile : Painter,
    isOnline : Boolean

){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color(0xFFFAFAFA)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = profile, contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = username, fontWeight = FontWeight.SemiBold)
                Text(
                    text = if (isOnline) "Online" else "Offline",
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun ChatSection(
    modifier:Modifier = Modifier,
){
    val simpleDateFormat = SimpleDateFormat("h:mm a", Locale.ENGLISH)
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
    ) {
        items(pesan_dummy){chat ->
            PesanItem(
                pesanText = chat.text,
                time = simpleDateFormat.format(chat.time),
                isOut = chat.isOut
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun PesanItem(
    pesanText: String?,
    time: String,
    isOut: Boolean
){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isOut) Alignment.End else Alignment.Start
    ){
        if (pesanText != null){
            if (pesanText != ""){
                Box (
                    modifier = Modifier
                        .background(
                            if (isOut) MaterialTheme.colorScheme.primary else Color(0xFFFAFAFA),
                            shape = if (isOut) AuthorChatBubbleShape else BotChatBubbleShape
                        )
                        .padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                ){
                    Text(
                        text = pesanText,
                        color = Color.White
                    )
                }
            }
        }
        Text(text = time,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 8.dp))
    }

}

@Composable
fun PesanSection()
{
    val context = LocalContext.current
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        OutlinedTextField(
            placeholder = {
                Text ("Pesan...")
            },
            value = pesan.value,
            onValueChange = {
                pesan.value = it
            },
            shape = RoundedCornerShape(25.dp),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_arrow),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {  }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}
