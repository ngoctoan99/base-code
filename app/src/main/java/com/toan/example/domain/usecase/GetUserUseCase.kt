package com.toan.example.domain.usecase

import com.toan.example.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {
    suspend fun execute() = repository.getUsers()
}