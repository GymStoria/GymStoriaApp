package com.afebrii.gymstoriaapp.Screen

import android.content.Context
import android.os.Build
import android.service.autofill.UserData
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.ui.theme.ungu
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

val auth = Firebase.auth
val database = Firebase.database

// Step 4: Definisikan model data
data class User(
    val username: String,
    val email: String,
    val password: String,
    val phoneNumber: String
)

@Composable
fun RegisterScreen(
    onDaftarClick:()-> Unit) {
    val poppinsExtraBold = Font(resId = R.font.poppins_extrabold, weight = FontWeight.ExtraBold)
    val poppinsRegular = Font(resId = R.font.poppins_reguler, weight = FontWeight.Normal)
    val poppinsfontReguler = FontFamily(poppinsRegular)
    val poppinsfontExtraBold = FontFamily(poppinsExtraBold)
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nomor_hp by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    @RequiresApi(Build.VERSION_CODES.P)
    fun registerUserToFirebase(
        username: String,
        email: String,
        password: String,
        confirmPassword: String,
        nomor_hp: String,
        onDaftarClick: () -> Unit
    ) {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || nomor_hp.isEmpty()) {
            showDialog = true
            dialogMessage = "Harap lengkapi semua kolom."
            return
        }

        if (password != confirmPassword) {
            showDialog = true
            dialogMessage = "Password dan konfirmasi password tidak cocok."
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { authTask ->
                if (authTask.isSuccessful) {
                    val currentUser = auth.currentUser
                    val userId = currentUser?.uid ?: ""
                    val userRef = database.getReference("users").child(userId)
                    val userData = hashMapOf(
                        "username" to username,
                        "nomor_hp" to nomor_hp,
                        "email" to email
                    )

                    userRef.setValue(userData)
                        .addOnSuccessListener {
                            showDialog = true
                            dialogMessage = "Registrasi berhasil. Silahkan login."
                            onDaftarClick()
                        }
                        .addOnFailureListener { exception ->
                            showDialog = true
                            dialogMessage = "Gagal menyimpan data pengguna: ${exception.message}"
                        }
                } else {
                    showDialog = true
                    dialogMessage = "Gagal membuat akun: ${authTask.exception?.message}"
                }
            }
    }

    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "DAFTAR",
                fontSize = 30.sp,
                fontFamily = poppinsfontExtraBold,
                modifier = Modifier
                    .padding(top = 20.dp),
                color = colorResource(id = R.color.ungu)
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Nama Pengguna") },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedLeadingIconColor = ungu,
                    unfocusedLeadingIconColor = ungu,
                    focusedLabelColor = ungu,
                    unfocusedLabelColor = ungu,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = ungu,
                    unfocusedIndicatorColor = ungu,
                    unfocusedPlaceholderColor = ungu,
                ), leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "Username")
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedLeadingIconColor = ungu,
                    unfocusedLeadingIconColor = ungu,
                    focusedLabelColor = ungu,
                    unfocusedLabelColor = ungu,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = ungu,
                    unfocusedIndicatorColor = ungu,
                    unfocusedPlaceholderColor = ungu,
                ), leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 8.dp)
            )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = ungu,
                unfocusedLeadingIconColor = ungu,
                focusedLabelColor = ungu,
                unfocusedLabelColor = ungu,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = ungu,
                unfocusedIndicatorColor = ungu,
                unfocusedPlaceholderColor = ungu,
                ), leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Ulangi Password") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = ungu,
                unfocusedLeadingIconColor = ungu,
                focusedLabelColor = ungu,
                unfocusedLabelColor = ungu,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = ungu,
                unfocusedIndicatorColor = ungu,
                unfocusedPlaceholderColor = ungu,
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
            OutlinedTextField(
                value = nomor_hp,
                onValueChange = { nomor_hp = it },
                label = { Text(text = "Nomor HP") },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedLeadingIconColor = ungu,
                    unfocusedLeadingIconColor = ungu,
                    focusedLabelColor = ungu,
                    unfocusedLabelColor = ungu,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = ungu,
                    unfocusedIndicatorColor = ungu,
                    unfocusedPlaceholderColor = ungu,
                ), leadingIcon = {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = "nomor_hp")
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 8.dp)
            )

        Button(
            onClick = {
                registerUserToFirebase(username, email, password, confirmPassword, nomor_hp) {
                    onDaftarClick()
                }
            },
            colors = ButtonDefaults.buttonColors(ungu),
            contentPadding = PaddingValues(
                start = 60.dp,
                end = 60.dp,
                top = 8.dp,
                bottom = 8.dp
            ),
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Text(text = "DAFTAR", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
        }


        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Pesan") },
                text = { Text(text = dialogMessage) },
                confirmButton = {
                    Button(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(ungu)
                    ) {
                        Text(text = "OK")
                    }
                }
            )
        }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "Atau daftar dengan",
                fontSize = 15.sp,
                fontFamily = poppinsfontReguler,
                modifier = Modifier
                    .padding(top = 20.dp),
                color = colorResource(id = R.color.black)
            )
            Spacer(modifier = Modifier.height(7.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.devicon_google),
                            contentDescription = "Google Icon",
                            modifier = Modifier.padding(end = 10.dp)
                                .size(40.dp, 40.dp)
                        )
                    }
                )
                IconButton(
                    onClick = { /*TODO*/ },

                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.logos_facebook),
                            contentDescription = "Google Icon",
                            modifier = Modifier
                                .size(40.dp, 37.dp)
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(7.dp))

            val annotatedString = AnnotatedString.Builder("Punya Akun? MASUK").apply {
                addStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.black),
                        fontSize = 15.sp,
                        fontFamily = poppinsfontReguler,
                        textDecoration = TextDecoration.None
                    ), start = 0, end = 11
                )
                addStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.black),
                        fontSize = 15.sp,
                        fontFamily = poppinsfontReguler,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ), start = 12, end = 17
                )
            }.toAnnotatedString()

            ClickableText(
                text = annotatedString,
                onClick = { offset ->

                },
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
