package com.toan.example.presentation.screen.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.toan.example.ui.components.AppText


@Composable
fun SettingScreen(settingViewModel: SettingViewModel) {
    val isDarkMode by settingViewModel.isDarkMode.collectAsState()
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            AppText(text = "Settings Screen",fontSize = 20.sp)
            Switch(
                checked = isDarkMode,
                onCheckedChange = {settingViewModel.setDarkMode()}
            )
            AppText(
                text = if (isDarkMode) "Dark Mode" else "Light Mode",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 20.sp
            )
        }
    }
}