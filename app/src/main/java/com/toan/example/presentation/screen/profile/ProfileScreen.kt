package com.toan.example.presentation.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.toan.example.presentation.screen.userScreen.ui.UserItem
import com.toan.example.presentation.screen.userScreen.viewModel.UserViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ProfileScreen(userViewModel: UserViewModel) {
    val users by userViewModel.usersDatabase.collectAsState()

    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding
        ) {
            items(users) { user ->
                UserItem(user, userViewModel, true)
            }
        }
    }
}