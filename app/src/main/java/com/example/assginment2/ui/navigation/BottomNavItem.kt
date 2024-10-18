package com.example.assginment2.ui.navigation

import com.example.assginment2.R

sealed class BottomNavItem(val title: String, val route: String, val icon: Int) {
    object Home : BottomNavItem("Home", "home", R.drawable.ic_home)
    object Search : BottomNavItem("Search", "search", R.drawable.ic_search)
    object AddPost : BottomNavItem("Add Post", "add_post", R.drawable.ic_add_post)
    object Notifications : BottomNavItem("Notifications", "notifications", R.drawable.ic_notifications)
    object Profile : BottomNavItem("Profile", "profile", R.drawable.ic_profile)
}
