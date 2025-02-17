package com.toan.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.gson.Gson
import com.toan.example.domain.model.User
import com.toan.example.presentation.screen.detail.DetailScreen
import com.toan.example.presentation.screen.history.HistoryScreen
import com.toan.example.presentation.screen.setting.SettingScreen
import com.toan.example.presentation.screen.userScreen.ui.UserScreen
import com.toan.example.presentation.screen.userScreen.viewModel.UserViewModel
import java.net.URLDecoder

@Composable
fun NavGraph(navController: NavHostController) {
    val userViewModel: UserViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) { UserScreen(userViewModel,navController) }
        composable(BottomNavItem.History.route) { HistoryScreen(userViewModel,navController) }
        composable(BottomNavItem.Settings.route) { SettingScreen() }
        composable(BottomNavItem.Detail.route) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("user")
            val decodeJson =  json?.let{ URLDecoder.decode(it,"UTF-8")}
            val user =  decodeJson?.let { Gson().fromJson(it,User::class.java) }
            DetailScreen(user)
        }
    }
}