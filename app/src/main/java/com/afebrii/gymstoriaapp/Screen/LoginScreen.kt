package com.afebrii.gymstoriaapp.Screen

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afebrii.gymstoriaapp.R


@Composable
fun LoginScreen()
{
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Text(text = "MASUK", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF8A2BE2))

        Spacer(modifier = Modifier.height(75.dp))

        OutlinedTextField(value = "", onValueChange ={}, label ={
            Text(text = "Nama Pengguna")
        },shape = RoundedCornerShape(10.dp) )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = "",
            onValueChange ={},
            label ={ Text(text = "Password") },
            shape = RoundedCornerShape(10.dp),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {})
            {
                Text(text = "Lupa Kata Sandi ?", fontSize = 13.sp, fontWeight = FontWeight.Medium)
            }
        }



        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { },
            modifier = Modifier.size(width = 300.dp, height = 40.dp,),
            colors = ButtonDefaults.buttonColors(Color (0xFF8A2BE2)),
        ) {
            Text(text = "Masuk", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = "Atau Masuk Dengan", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .padding(horizontal = 100.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ){
            Image(painter = painterResource(id = R.drawable.google), contentDescription ="Google", modifier = Modifier.size(50.dp).clickable {
                //Google
            })
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription ="Facebook", modifier = Modifier.size(50.dp).clickable {
                //Facebook
            })
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Tidak Punya Akun ? ", fontSize = 13.sp, fontWeight = FontWeight.Normal)

            Text(text = "Daftar", fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.clickable {
                //Menu Daftar
            })

            Spacer(modifier = Modifier.height(50.dp))

        }
    }


}