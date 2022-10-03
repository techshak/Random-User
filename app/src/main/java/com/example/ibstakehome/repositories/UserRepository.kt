package com.example.ibstakehome.repositories

import com.example.ibstakehome.network.dto.User
import com.example.ibstakehome.utils.Resource

import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun getUser(): Flow<Resource<User>>
}