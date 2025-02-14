package com.toan.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toan.example.presentation.screen.profile.ProfileScreen
import com.toan.example.presentation.screen.setting.SettingScreen
import com.toan.example.presentation.screen.userScreen.ui.UserScreen
import com.toan.example.presentation.screen.userScreen.viewModel.UserViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val userViewModel: UserViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) { UserScreen(userViewModel) }
        composable(BottomNavItem.Profile.route) { ProfileScreen(userViewModel) }
        composable(BottomNavItem.Settings.route) { SettingScreen() }
    }
}