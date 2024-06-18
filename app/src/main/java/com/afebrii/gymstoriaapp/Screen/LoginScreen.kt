package com.afebrii.gymstoriaapp.Screen

import MainViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afebrii.gymstoriaapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel?> { null }

@Composable
fun LoginScreen(onLoginClick: () -> Unit, onSignUpClick: () -> Unit) {
    val auth = FirebaseAuth.getInstance()
    val viewModel = LocalMainViewModel.current ?: error("No MainViewModel provided")
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "MASUK",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF8A2BE2)
        )

        Spacer(modifier = Modifier.height(75.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.size(width = 325.dp, height = 60.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.size(width = 325.dp, height = 60.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { }) {
                Text(
                    text = "Lupa Kata Sandi ?",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            viewModel.userDataRef.orderByChild("email").equalTo(email)
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onDataChange(snapshot: DataSnapshot) {
                                        if (snapshot.exists()) {
                                            for (userSnapshot in snapshot.children) {
                                                val username = userSnapshot.child("username").getValue(String::class.java)
                                                val nomorHp = userSnapshot.child("nomor_hp").getValue(String::class.java)
                                                val userData = username?.let { nomorHp?.let { it1 -> UserData(username = it, email = email, nomor_hp = it1) } }

                                                userData?.let { viewModel.setUserData(it) }
                                            }
                                        }
                                    }

                                    override fun onCancelled(error: DatabaseError) {
                                    }
                                })
                            onLoginClick()
                        } else {
                            showDialog = true
                            dialogMessage = "Email atau password tidak ditemukan"
                        }
                    }
            },
            modifier = Modifier.size(width = 300.dp, height = 40.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF8A2BE2)),
        ) {
            Text(text = "Masuk", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .padding(horizontal = 100.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ){
            Image(painter = painterResource(id = R.drawable.google), contentDescription ="Google", modifier = Modifier
                .size(50.dp)
                .clickable {
                    //Google
                })
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription ="Facebook", modifier = Modifier
                .size(50.dp)
                .clickable {
                    //Facebook
                })
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Tidak Punya Akun ? ",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = "Daftar",
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.clickable { onSignUpClick() }
            )

            Spacer(modifier = Modifier.height(50.dp))
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Error") },
                text = { Text(text = dialogMessage) },
                confirmButton = {
                    Button(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(Color(0xFF8A2BE2))
                    ) {
                        Text(text = "OK")
                    }
                }
            )
        }
    }
}
