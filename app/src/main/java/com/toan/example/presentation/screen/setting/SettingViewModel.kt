package com.toan.example.presentation.screen.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toan.example.data.local.SettingPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor( private val settingPreferences: SettingPreferences):ViewModel() {
    private val _isDarkMode = MutableStateFlow<Boolean>(false)
    val isDarkMode = _isDarkMode.asStateFlow()

    init {
        viewModelScope.launch {
            _isDarkMode.value = settingPreferences.isDarkMode()
        }
    }

    fun setDarkMode(){
        viewModelScope.launch {
            val currentMode = settingPreferences.isDarkMode()
            settingPreferences.setDarkMode(!currentMode)
            _isDarkMode.value = settingPreferences.isDarkMode()
        }
    }
}