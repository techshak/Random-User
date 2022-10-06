package com.example.ibstakehome.ui.presentation.users

import com.example.ibstakehome.network.dto.Result

data class UserListState(
    val user:List<Result> = emptyList(),
    val isLoading: Boolean = false,
)