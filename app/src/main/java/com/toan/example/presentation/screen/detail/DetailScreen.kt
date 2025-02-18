package com.toan.example.presentation.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.toan.example.domain.model.User
import com.toan.example.ui.components.AppText

@Composable
fun DetailScreen(user:User?) {
    AppText("Detail User : ${user?.name}", fontSize = 20.sp)
}