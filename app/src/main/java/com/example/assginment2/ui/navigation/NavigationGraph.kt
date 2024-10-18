package com.example.assginment2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assginment2.ui.home.HomeFeedScreen
import com.example.assginment2.ui.search.SearchPage
import com.example.assginment2.ui.addpost.AddPostScreen
import com.example.assginment2.ui.notifications.NotificationScreen
import com.example.assginment2.ui.profile.ProfilePage

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) {
            HomeFeedScreen()
        }
        composable(BottomNavItem.Search.route) {
            SearchPage()
        }
        composable(BottomNavItem.AddPost.route) {
            AddPostScreen(onPostAdded = {})
        }
        composable(BottomNavItem.Notifications.route) {
            NotificationScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfilePage(username = "asan123")
        }
    }
}
