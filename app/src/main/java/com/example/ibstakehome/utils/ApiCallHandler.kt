package com.example.ibstakehome.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ApiCallHandler {
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {
        return withContext(Dispatchers.IO){
            try {
                val response: Response<T> = apiToBeCalled()
                if (response.isSuccessful) {
                    Resource.Success(data = response.body()!!)
                } else {
                    Resource.Error( "Something went wrong", null)
                }
            }catch (e: HttpException){
                Resource.Error(message = e.message ?: "Something went wrong",null)
            }catch (e: IOException) {
                Resource.Error("Please check your network connection", null)
            }catch (e: Exception) {
                Resource.Error("Something went wrong", null)
            }
        }
    }
}