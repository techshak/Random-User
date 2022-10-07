package com.example.ibstakehome.ui.presentation.users

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibstakehome.repositories.UserRepository
import com.example.ibstakehome.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserItemViewModel @Inject constructor(
    private val userRepository: UserRepository
):ViewModel(){
    var state by mutableStateOf(UserListState())
    init {
        getThree()
    }

  private fun getUser() =
        viewModelScope.launch {
            userRepository.getUser()
                .collect{result->
                    when(result){
                        is Resource.Success -> {
                            result.data?.let { user->
                                for(item in user.results){
                                 state.user.add(item)
                                    Log.d("TEST", item.name.first)
                                }
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    private fun getThree(){
        val numberOfUsers = arrayOf(1,2,3)
        for(i in numberOfUsers) {
            getUser()
        }
    }
}

