package com.example.assginment2.ui.notifications

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Notification(
    val type: String,
    val message: String
)

object NotificationRepository {
    val notifications = listOf(
        Notification(type = "like", message = "asan123 liked your post"),
        Notification(type = "comment", message = "john_doe commented: Nice photo!"),
        Notification(type = "like", message = "jane_smith liked your post"),
        Notification(type = "comment", message = "asan123 commented: Great work!"),
        Notification(type = "like", message = "john_doe liked your post")
    )
}

@Composable
fun NotificationScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(NotificationRepository.notifications.size) { index ->
            NotificationItem(notification = NotificationRepository.notifications[index])
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Text(text = notification.message)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowNotificationScreen() {
    NotificationScreen()
}
