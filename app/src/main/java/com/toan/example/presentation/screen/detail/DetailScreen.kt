package com.toan.example.presentation.screen.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.toan.example.domain.model.User

@Composable
fun DetailScreen(user:User?) {
    Text("Detail User : ${user?.name}")
}