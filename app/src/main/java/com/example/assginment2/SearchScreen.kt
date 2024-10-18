package com.example.assginment2.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.assginment2.models.UserRepository
import com.example.assginment2.models.User
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchPage() {
    var query by remember { mutableStateOf("") }
    val filteredUsers = UserRepository.users.filter { it.username.contains(query, ignoreCase = true) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        SearchBar(query, onQueryChanged = { query = it })

        Spacer(modifier = Modifier.height(16.dp))

        if (filteredUsers.isEmpty()) {
            Text(text = "No users found", modifier = Modifier.padding(16.dp))
        } else {
            LazyColumn {
                items(filteredUsers.size) { index ->
                    SearchResultItem(userIndex = index, filteredUsers)
                }
            }
        }
    }
}

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    BasicTextField(
        value = query,
        onValueChange = onQueryChanged,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        decorationBox = { innerTextField ->
            if (query.isEmpty()) {
                Text(text = "Search by username", color = Color.Gray)
            }
            innerTextField()
        }
    )
}

@Composable
fun SearchResultItem(userIndex: Int, users: List<User>) {
    val user = users[userIndex]

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = user.profileImageResId),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(25.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = user.username)
            Text(text = user.bio, color = Color.Gray)
        }
    }
}

@Preview(showBackground=true)
@Composable
fun ShowSearchPage() {
    SearchPage()
}