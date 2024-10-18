package com.example.assginment2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assginment2.models.PostRepository

@Composable
fun HomeFeedScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(PostRepository.posts.size) { index ->
            PostItem(postIndex = index)
        }
    }
}

@Composable
fun PostItem(postIndex: Int) {
    val post = PostRepository.posts[postIndex]

    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = post.username, modifier = Modifier.padding(bottom = 8.dp))
        Image(
            painter = painterResource(id = post.imageResId),
            contentDescription = post.caption,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = post.caption, modifier = Modifier.padding(top = 8.dp))
        Text(text = "${post.likes} likes", modifier = Modifier.padding(top = 4.dp))
    }
}

@Preview(showBackground=true)
@Composable
fun ShowHomeFeedScreen() {
    HomeFeedScreen()
}