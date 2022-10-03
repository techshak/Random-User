package com.example.ibstakehome.repositories

import com.example.ibstakehome.network.UserApi
import com.example.ibstakehome.network.dto.User
import com.example.ibstakehome.repositories.UserRepository
import com.example.ibstakehome.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private  val api: UserApi): UserRepository {
    override suspend fun getUser(): Flow<Resource<User>> {
        return flow{
            emit(Resource.Loading(true))
            val user = try{
                val result = api.getUser()
                emit(Resource.Success(result))
                emit(Resource.Loading(false))
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
        }
    }
}