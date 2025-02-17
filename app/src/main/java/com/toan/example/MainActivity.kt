package com.toan.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.compose.rememberNavController
import com.toan.example.presentation.navigation.BottomNavigationBar
import com.toan.example.presentation.navigation.NavGraph
import com.toan.example.presentation.screen.setting.SettingViewModel
import com.toan.example.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val settingViewModel: SettingViewModel = hiltViewModel()
    val isDarkMode by settingViewModel.isDarkMode.collectAsState()
    AppTheme (darkTheme = isDarkMode){
        Scaffold(bottomBar = { BottomNavigationBar(navController) })
        { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            )
            {
                NavGraph(navController)
            }

        }
    }

}
