package com.toan.example.presentation.screen.userScreen.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toan.example.data.local.UserDatabaseRepository
import com.toan.example.domain.model.User
import com.toan.example.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val userDatabaseRepository: UserDatabaseRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users = _users.asStateFlow()

    private val _usersDatabase = MutableStateFlow<List<User>>(emptyList())
    val usersDatabase: StateFlow<List<User>> = _usersDatabase

    init {
        loadUsers()
        getAllUserDatabase()
    }


    private fun loadUsers() {
        viewModelScope.launch {
            try {
                _users.value = getUserUseCase.execute()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

     fun getAllUserDatabase(){
        viewModelScope.launch {
            userDatabaseRepository.allUsers.collect{ userList ->
                _usersDatabase.value = userList
            }
        }
    }

    fun addUser(user: User){
        viewModelScope.launch {
            try {
                userDatabaseRepository.insertUser(user)
                Log.d("TTT::addUser",user.name)
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            userDatabaseRepository.deleteUser(user)
        }

    }

}