package com.example.ibstakehome.ui.presentation.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun UserItem(
 user:com.example.ibstakehome.network.dto.Result,
){
    Box (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {

            Text(
                text = "${user.name.title} ${user.name.first} ${user.name.last}",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                text = "Email: ${user.email}",
                color = Color.Black,
            )
            Text(
                text = "Address: No ${user.location.street.number}, ${user.location.street.name}",
                color = Color.Black,
            )
        }

    }
}