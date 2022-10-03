package com.example.ibstakehome.network


import com.example.ibstakehome.network.dto.User
import retrofit2.http.GET

interface UserApi {
    @GET("api")
    suspend fun getUser(): User

    companion object{
        const val BASE_URL = "https://randomuser.me/"
    }
}