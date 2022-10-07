package com.example.ibstakehome.ui.presentation.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserItem(
 user:com.example.ibstakehome.network.dto.Result,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .size(50.dp),
            shape = CircleShape,
            elevation = 2.dp,

            ) {
           GlideImage(
               imageModel = user.picture.medium,
               imageOptions = ImageOptions(
                       contentScale = ContentScale.FillBounds,
                   )
           )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                Modifier.padding(10.dp,0.dp),
                verticalArrangement = Arrangement.Center
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
                    text = "Address: No ${user.location.street.number}, ${user.location.street.name} Str",
                    color = Color.Black,
                )
            }

        }
    }
}