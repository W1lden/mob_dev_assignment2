package com.example.assginment2.models

import com.example.assginment2.R

data class User(
    val username: String,
    val bio: String,
    val profileImageResId: Int
)

object UserRepository {
    val users = listOf(
        User(
            username = "asan123",
            bio = "Software Developer",
            profileImageResId = R.drawable.sample_image1
        ),
        User(
            username = "john_doe",
            bio = "Photographer and Traveler",
            profileImageResId = R.drawable.sample_image2
        ),
        User(
            username = "jane_smith",
            bio = "Graphic Designer",
            profileImageResId = R.drawable.sample_image3
        ),
        User(
            username = "alibek_777",
            bio = "ML Engineer",
            profileImageResId = R.drawable.sample_image7
        ),
        User(
            username = "nurzhan17",
            bio = "Gamer",
            profileImageResId = R.drawable.sample_image8
        )
    )
}
