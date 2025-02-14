package com.toan.example.data.local

import com.toan.example.data.local.dao.UserDao
import com.toan.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDatabaseRepository @Inject constructor(private val userDao: UserDao) {
    val allUsers : Flow<List<User>> = userDao.getAllUsers()

    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
}