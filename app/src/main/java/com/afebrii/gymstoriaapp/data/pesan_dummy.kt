package com.afebrii.gymstoriaapp.data

import java.util.*

data class Pesan(
    val text: String?=null,
    val recipient_id: String,
    val time: Long = Calendar.getInstance().timeInMillis,
    var isOut: Boolean = false
)

val pesan_dummy = listOf(
    Pesan(
        text = "Great!",
        recipient_id = "the jade",
        isOut = false
    ),
    Pesan(
        text = "I Am Good",
        recipient_id = "user",
        isOut = true
    ),
    Pesan(
        text = "Hi, How Are You ?",
        recipient_id = "the jade",
        isOut = false
    ),
    Pesan(
        text = "Hi !",
        recipient_id = "user",
        isOut = true
    ),
)
