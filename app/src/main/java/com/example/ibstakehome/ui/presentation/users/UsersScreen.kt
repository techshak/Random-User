package com.example.ibstakehome.ui.presentation.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ibstakehome.network.dto.Result
import java.time.format.TextStyle
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun UsersScreen(
    viewModel: UserItemViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    var filtered: List<Result>

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "User List",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .padding(10.dp,30.dp,10.dp,10.dp)
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.width(4.dp))

            //Search Bar
            TextField(
                value = textState.value,
                onValueChange = { value ->
                    textState.value = value
                },
                modifier = Modifier
                    .padding(7.dp,0.dp)
                    .fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                ),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                },
                trailingIcon = {
                    if (textState.value != TextFieldValue("")) {
                        IconButton(
                            onClick = {
                                textState.value =
                                    TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(15.dp)
                                    .size(24.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    leadingIconColor = Color.Black,
                    trailingIconColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
            }
            LazyColumn (
                modifier = Modifier
                    .padding(10.dp,30.dp,10.dp,0.dp)
                    ){
                val searchedText = textState.value.text
                filtered = if (searchedText.isEmpty()){
                    state.user
                } else{
                    val resultList = ArrayList<Result>()
                    for (user in state.user) {
                        if (user.toString().lowercase(Locale.getDefault())
                                .contains(searchedText.lowercase(Locale.getDefault()))
                        ) {
                            resultList.add(user)
                        }
                    }
                    resultList
                }
                items(filtered.size){ i ->
                    val user = filtered[i]
                    UserItem(
                        user = user
                    )
                    if(i < state.user.size){
                        Divider(
                        )
                    }

                }
            }
        }
    }
}



