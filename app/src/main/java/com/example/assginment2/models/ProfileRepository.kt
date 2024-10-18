package com.example.assginment2.models

import com.example.assginment2.R

object ProfileRepository {
    val profile = Profile(
        username = "asan123",
        bio = "Exploring Android Development with Jetpack Compose",
        postsCount = 3,
        profileImageResId = R.drawable.sample_image1, // Your profile image here
        posts = listOf(
            R.drawable.sample_image1, // Replace with actual drawable images
            R.drawable.sample_image2,
            R.drawable.sample_image3
        )
    )
}

data class Profile(
    val username: String,
    val bio: String,
    val postsCount: Int,
    val profileImageResId: Int,
    val posts: List<Int>
)
