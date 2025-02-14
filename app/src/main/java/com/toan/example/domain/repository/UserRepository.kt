package com.toan.example.domain.repository

import com.toan.example.domain.model.User

interface UserRepository {
    suspend fun getUsers():List<User>
}