package com.afebrii.gymstoriaapp.Screen

import MainViewModel
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.ui.theme.putih
import com.afebrii.gymstoriaapp.ui.theme.ungu
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileScreen(viewModel: MainViewModel = viewModel()) {
    val userDataState by viewModel.userData.observeAsState()
    val username = userDataState?.username ?: ""
    val nomorHp = userDataState?.nomor_hp ?: ""
    val email = userDataState?.email ?: ""



    val userData = UserData(username = username, email = email, nomor_hp = nomorHp)
    userData?.let { userData ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(putih),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .shadow(50.dp, shape = RoundedCornerShape(25.dp))
                    .height(120.dp)
                    .background(putih)
            ) {
                val image = createRef()
                val title = createRef()
                val email = createRef()
                val nomor_hp = createRef()
                val editIcon = createRef()

                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .constrainAs(image) {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                        },
                    painter = painterResource(id = R.drawable.icon_user),
                    contentDescription = null
                )

                Text(
                    text = userData.username,
                    modifier = Modifier.constrainAs(title) {
                        top.linkTo(parent.top, margin = 16.dp)
                        start.linkTo(image.end, margin = 16.dp)
                    }
                )

                Text(
                    text = userData.email,
                    modifier = Modifier.constrainAs(email) {
                        top.linkTo(title.bottom, margin = 8.dp)
                        start.linkTo(image.end, margin = 16.dp)
                    }
                )

                Text(
                    text = userData.nomor_hp,
                    modifier = Modifier.constrainAs(nomor_hp) {
                        top.linkTo(email.bottom, margin = 4.dp)
                        start.linkTo(image.end, margin = 16.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = "Edit",
                    modifier = Modifier
                        .constrainAs(editIcon) {
                            top.linkTo(title.top)
                            bottom.linkTo(title.bottom)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                        .size(27.dp)
                        .clickable { /* Handle click event */ }
                        .padding(start = 10.dp)
                )
            }

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .shadow(50.dp, shape = RoundedCornerShape(25.dp))
                    .wrapContentHeight()
                    .background(putih)
            ) {
                val (icon1, text1, arrow1) = createRefs()
                val (icon2, text2, arrow2) = createRefs()
                val (icon3, text3, arrow3) = createRefs()
                val (icon4, text4, arrow4) = createRefs()
                val (icon5, text5, arrow5) = createRefs()
                val (divider1, divider2, divider3, divider4) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.icon_activityhistory),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(icon1) {
                            top.linkTo(parent.top, margin = 10.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                )

                Text(
                    text = "Riwayat Reservasi",
                    modifier = Modifier.constrainAs(text1) {
                        top.linkTo(parent.top, margin = 13.dp)
                        start.linkTo(icon1.end, margin = 11.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_arrow),
                    contentDescription = "Arrow Right",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable { /* Handle click event */ }
                        .constrainAs(arrow1) {
                            top.linkTo(parent.top, margin = 15.dp)
                            start.linkTo(icon1.end, margin = 268.dp)
                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_member),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(icon2) {
                            top.linkTo(text1.bottom, margin = 24.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                )

                Text(
                    text = "Riwayat Keanggotaan",
                    modifier = Modifier.constrainAs(text2) {
                        top.linkTo(text1.bottom, margin = 28.dp)
                        start.linkTo(icon2.end, margin = 12.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_arrow),
                    contentDescription = "Arrow Right",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable { /* Handle click event */ }
                        .constrainAs(arrow2) {
                            top.linkTo(text1.bottom, margin = 27.dp)
                            start.linkTo(icon2.end, margin = 268.dp)
                        }
                )

                // Icon 3
                Image(
                    painter = painterResource(id = R.drawable.icon_language),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(icon3) {
                            top.linkTo(text2.bottom, margin = 24.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                )

                Text(
                    text = "Bahasa",
                    modifier = Modifier.constrainAs(text3) {
                        top.linkTo(text2.bottom, margin = 28.dp)
                        start.linkTo(icon3.end, margin = 12.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_arrow),
                    contentDescription = "Arrow Right",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable { /* Handle click event */ }
                        .constrainAs(arrow3) {
                            top.linkTo(text2.bottom, margin = 27.dp)
                            start.linkTo(icon3.end, margin = 268.dp)
                        }
                )

                // Icon 4
                Image(
                    painter = painterResource(id = R.drawable.icon_help),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(icon4) {
                            top.linkTo(text3.bottom, margin = 24.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                )

                Text(
                    text = "Bantuan",
                    modifier = Modifier.constrainAs(text4) {
                        top.linkTo(text3.bottom, margin = 28.dp)
                        start.linkTo(icon4.end, margin = 12.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_arrow),
                    contentDescription = "Arrow Right",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable { /* Handle click event */ }
                        .constrainAs(arrow4) {
                            top.linkTo(text3.bottom, margin = 27.dp)
                            start.linkTo(icon4.end, margin = 268.dp)
                        }
                )

                // Icon 5
                Image(
                    painter = painterResource(id = R.drawable.icon_settings),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(icon5) {
                            top.linkTo(text4.bottom, margin = 24.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            bottom.linkTo(parent.bottom, margin = 10.dp)
                        }
                )

                Text(
                    text = "Pengaturan",
                    modifier = Modifier.constrainAs(text5) {
                        top.linkTo(text4.bottom, margin = 28.dp)
                        start.linkTo(icon5.end, margin = 12.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_arrow),
                    contentDescription = "Arrow Right",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable { /* Handle click event */ }
                        .constrainAs(arrow5) {
                            top.linkTo(text4.bottom, margin = 27.dp)
                            start.linkTo(icon5.end, margin = 268.dp)
                        }
                )

                val dividers = listOf(divider1, divider2, divider3, divider4)
                dividers.forEachIndexed { index, divider ->
                    Canvas(
                        modifier = Modifier
                            .constrainAs(divider) {
                                top.linkTo(
                                    when (index) {
                                        0 -> text1.bottom
                                        1 -> text2.bottom
                                        2 -> text3.bottom
                                        3 -> text4.bottom
                                        else -> text5.bottom
                                    }
                                )
                                bottom.linkTo(
                                    when (index) {
                                        0 -> text2.top
                                        1 -> text3.top
                                        2 -> text4.top
                                        3 -> text5.top
                                        else -> parent.bottom
                                    }
                                )
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .fillMaxWidth()
                            .height(1.dp)
                            .padding(horizontal = 16.dp)
                    ) {
                        drawLine(
                            color = Color.Gray,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 1.dp.toPx()
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .width(900.dp)
                    .padding(24.dp)
                    .height(48.dp)
            ) {
                Button(
                    onClick = { /* Handle action */ },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(ungu),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Keluar Akun",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
