package com.example.assginment2.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assginment2.models.PostRepository
import com.example.assginment2.models.UserRepository
import com.example.assginment2.models.Post

@Composable
fun ProfilePage(username: String) {
    val user = UserRepository.users.find { it.username == username }
    val userPosts = PostRepository.posts.filter { it.username == username }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        user?.let {
            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                Image(
                    painter = painterResource(id = it.profileImageResId),
                    contentDescription = "${it.username}'s Profile Picture",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 16.dp),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(text = it.username)
                    Text(text = it.bio, modifier = Modifier.padding(top = 4.dp))
                    Text(text = "Posts: ${userPosts.size}", modifier = Modifier.padding(top = 4.dp))
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(userPosts.size) { index ->
                    PostGridItem(post = userPosts[index])
                }
            }
        }
    }
}

@Composable
fun PostGridItem(post: Post) {
    Image(
        painter = painterResource(id = post.imageResId),
        contentDescription = post.caption,
        modifier = Modifier
            .padding(4.dp)
            .size(100.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun ShowProfilePage() {
    ProfilePage("john_doe")
}
