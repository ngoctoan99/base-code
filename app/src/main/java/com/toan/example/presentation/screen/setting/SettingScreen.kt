package com.toan.example.presentation.screen.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier


@Composable
fun SettingScreen(settingViewModel: SettingViewModel) {
    val isDarkMode by settingViewModel.isDarkMode.collectAsState()
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Settings Screen")
            Switch(
                checked = isDarkMode,
                onCheckedChange = {settingViewModel.setDarkMode()}
            )
            Text(
                text = if (isDarkMode) "Dark Mode" else "Light Mode",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}