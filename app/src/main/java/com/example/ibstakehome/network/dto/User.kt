package com.example.ibstakehome.network.dto

import com.example.ibstakehome.network.dto.Info
import com.example.ibstakehome.network.dto.Result

data class User(
    val info: Info,
    val results: List<Result>
)