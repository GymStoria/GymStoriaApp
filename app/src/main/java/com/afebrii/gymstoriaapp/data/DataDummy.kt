package com.afebrii.gymstoriaapp.data

import com.afebrii.gymstoriaapp.R
import com.afebrii.gymstoriaapp.Model.Gym
object DataDummy {
    val datagyms = listOf(
        Gym(
            id = 1,
            nama = "the jade",
            status = "online",
            photo = R.drawable.the_jade
        ),
        Gym(
            id = 2,
            nama = "vicky gym",
            status = "online",
            photo = R.drawable.viky_gym
        ),
        Gym(
            id = 3,
            nama = "timor gym",
            status = "online",
            photo = R.drawable.timor_gym
        ),
        Gym(
            id = 4,
            nama = "amazon gym",
            status = "online",
            photo = R.drawable.amazon_gym
        ),
        Gym(
            id = 5,
            nama = "virgo gym",
            status = "online",
            photo = R.drawable.virgo_gym
        ),
    )
}