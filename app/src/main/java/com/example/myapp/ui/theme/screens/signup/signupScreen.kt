package com.example.myapp.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R
import com.example.myapp.data.AuthViewModel
import com.example.myapp.navigation.ROUTE_LOGIN

@Composable
fun SignupScreen(navController: NavController){
    val context = LocalContext.current
    val authViewModel: AuthViewModel = viewModel()
//    one way to load the auth view model(most popular way is declaring it as a variable)
    val isLoading by authViewModel.isLoading.collectAsState()

    var email by remember {
        mutableStateOf(value = "")
    }
    var password by remember {
        mutableStateOf(value="")
    }
    var userName by remember {
        mutableStateOf(value = "")
    }
    var confirmPassword by remember {
        mutableStateOf(value="")
    }
    Column {

        Text(
            text = ("SIGN UP"),
            fontSize = 20.sp,
            color = androidx.compose.ui.graphics.Color.White,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            modifier = Modifier
                .background(Color.Black)
                .padding(20.dp)
                .fillMaxWidth()

        )
        Image(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .height(80.dp),
            painter = painterResource(id = R.drawable.logo1),
            contentDescription = "KRA logo",
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = {newuserName -> userName = newuserName},
//            label = { Text(text = "Enter username") },
            placeholder = { Text(text = "Please enter username") },
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {newEmail -> email = newEmail},
//            label = { Text(text = "Enter Email") },
            placeholder = { Text(text = "Please enter Email") },
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {newPassword -> password = newPassword},
//            label = { Text(text = "Enter Password") },
            placeholder = { Text(text = "Please enter Password") },
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {newConfirmPassword -> confirmPassword = newConfirmPassword},
//            label = { Text(text = "confirm password") },
            placeholder = { Text(text = "Please enter Password")}
        )
        Spacer(modifier = Modifier.height(10.dp))
        androidx.compose.material3.Button(onClick = {
            authViewModel.signup(userName, email, password, confirmPassword, navController, context)
        },
            enabled = !isLoading,
            colors = ButtonDefaults.buttonColors(Color.Blue)) {
            if (isLoading){
                CircularProgressIndicator(color = Color.Black, strokeWidth = 4.dp)
            }else{
                Text(
                    modifier = Modifier,
                    color = Color.White,
                    text = "SIGN UP"
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(
            text = AnnotatedString("Already have an account? Login here"),
            onClick = {
                navController.navigate(ROUTE_LOGIN)
            },
            style = TextStyle(
                color = Color.Blue,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview(){
    SignupScreen(rememberNavController())
}