package com.example.ibstakehome.ui.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ibstakehome.navigation.Screens
import java.util.regex.Pattern

@Composable
fun LoginScreen(
    navController: NavController
){
    val regex = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
            + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
            + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");
    var email by remember{ mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val isValidMail = regex.matcher(email.text).matches();
    val isValidPass = password.text.count() > 6
    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp,0.dp)
            .background(color = Color.White),
    verticalArrangement = Arrangement.Center,
    ){
        Text(
            text = "Login",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {newText->
                email = newText
            },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier
                .padding(0.dp, 40.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        )
        Text(
            text = if (!isValidMail && email.text.isNotEmpty()) "Invalid email format" else " ",
            color = Color.Red,
        )

        OutlinedTextField(
            value = password,
            label = { Text("Password") },
            onValueChange = {newText->
                password = newText
            },
            singleLine = true,
            modifier = Modifier
                .padding(0.dp, 7.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            visualTransformation = PasswordVisualTransformation(),
        )

        Text(
            text = if (!isValidPass && password.text.isNotEmpty()) "Password must exceed 6 characters" else " ",
            color = Color.Red,
        )

        Button(
            onClick = {
                        if(isValidMail && isValidPass){
                            navController.navigate(Screens.UserScreen.route)
                        }
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp)
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 15.sp,
            )
        }


    }
}