package com.toan.example.data.api

import com.toan.example.domain.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers():List<User>
}