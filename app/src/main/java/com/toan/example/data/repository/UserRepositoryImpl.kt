package com.toan.example.data.repository

import com.toan.example.data.api.ApiService
import com.toan.example.data.local.dao.UserDao
import com.toan.example.domain.model.User
import com.toan.example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService ):UserRepository {
    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}