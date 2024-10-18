package com.example.assginment2.ui.addpost

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.assginment2.R
import com.example.assginment2.models.Post
import com.example.assginment2.models.PostRepository
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddPostScreen(onPostAdded: () -> Unit) {
    var caption by remember { mutableStateOf("") }
    var selectedImage by remember { mutableStateOf(R.drawable.sample_image1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = selectedImage),
            contentDescription = "Selected Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = caption,
            onValueChange = { caption = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                val newPost = Post(
                    id = PostRepository.nextId(),
                    username = "CurrentUser",
                    caption = caption,
                    imageResId = selectedImage,
                    likes = 0
                )
                PostRepository.addPost(newPost)
                onPostAdded()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Upload Post")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowAddPostScreen() {
    AddPostScreen(onPostAdded = {})
}
