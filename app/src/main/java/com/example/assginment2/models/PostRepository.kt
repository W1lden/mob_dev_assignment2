package com.example.assginment2.models
import androidx.compose.runtime.mutableStateListOf
import com.example.assginment2.R

data class Post(
    val id: Int,
    val username: String,
    val caption: String,
    val imageResId: Int,
    val likes: Int
)

object PostRepository {
    private var currentId = 0

    // List to store posts
    private val _posts = mutableStateListOf(
        Post(
            id = currentId++,
            username = "asan123",
            caption = "My first post!",
            imageResId = R.drawable.sample_image1,
            likes = 120
        ),
        Post(
            id = currentId++,
            username = "asan123",
            caption = "My second post!",
            imageResId = R.drawable.sample_image5,
            likes = 120
        ),
        Post(
            id = currentId++,
            username = "asan123",
            caption = "My third post!",
            imageResId = R.drawable.sample_image6,
            likes = 120
        ),
        Post(
            id = currentId++,
            username = "john_doe",
            caption = "Loving the view",
            imageResId = R.drawable.sample_image2,
            likes = 95
        ),
        Post(
            id = currentId++,
            username = "alibek_777",
            caption = "hello world",
            imageResId = R.drawable.sample_image3,
            likes = 68
        ),
        Post(
            id = currentId++,
            username = "nurzhan17",
            caption = "the weekend",
            imageResId = R.drawable.sample_image4,
            likes = 75
        )
    )

    val posts: List<Post>
        get() = _posts

    fun addPost(post: Post) {
        _posts.add(post)
    }

    fun nextId(): Int {
        return currentId++
    }
}
