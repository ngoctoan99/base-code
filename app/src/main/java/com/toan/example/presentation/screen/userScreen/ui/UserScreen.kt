package com.toan.example.presentation.screen.userScreen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.toan.example.domain.model.User
import com.toan.example.presentation.navigation.BottomNavItem
import com.toan.example.presentation.screen.userScreen.viewModel.UserViewModel
import com.toan.example.ui.components.AppText


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun UserScreen(userViewModel: UserViewModel,navController: NavHostController) {
    val users by userViewModel.users.collectAsState()

    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding
        ) {
            items(users) { user ->
                UserItem(user, userViewModel,navController)
            }
        }
    }
}


@Composable
fun UserItem(user: User, userViewModel: UserViewModel,navController: NavHostController, isDelete: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                if (isDelete) {
                    userViewModel.deleteUser(user)
                } else {
                    userViewModel.addUser(user)
                    navController.navigate(BottomNavItem.Detail.createRoute(user))
                }


            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Red, shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                AppText(
                    text = "${user.id}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Column(modifier = Modifier.padding(16.dp))
            {
                AppText(text = "ID: ${user.id}",style = MaterialTheme.typography.bodyLarge, fontSize = 20.sp)
                AppText(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyLarge, fontSize = 20.sp)
                AppText(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyLarge, fontSize = 20.sp)
            }
        }

    }
}