package com.example.myapp.ui.theme.screens.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R
import com.example.myapp.navigation.ROUTE_ADD_CLIENT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoard(navController: NavController){
    Box(){
        Image(
            painter = painterResource(id = R.drawable.logo4) ,
            contentDescription = "dashboard background",
            contentScale = ContentScale.FillBounds)
    }
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        TopAppBar(
            title = { Text(text = "Equity Bank" )},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Home,
                        contentDescription = "Home")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Cyan,
                titleContentColor = Color.Blue,
                navigationIconContentColor = Color.Red
            ),

            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Person,
                        contentDescription = "My Profile")
                }
                IconButton(onClick ={}) {
                    Icon(imageVector = Icons.Filled.Search,
                        contentDescription = "My Profile")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Menu,
                        contentDescription = "My Profile")
                }


            })
        Row (modifier = Modifier.wrapContentWidth()) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable{
                        navController.navigate(ROUTE_ADD_CLIENT)
                              },
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(modifier = Modifier.height(70.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = "New Client"
                    )
                    Box(
                        modifier = Modifier.matchParentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            color = Color.Blue,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            text = "NEW CLIENT"
                        )
                    }

                }
            }
            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(modifier = Modifier.height(70.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = "view details"
                    )
                    Box(
                        modifier = Modifier.matchParentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            color = Color.Blue,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            text = "NEW CLIENT"
                        )
                    }

                }
            }
            Card(modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(modifier = Modifier.height(70.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = "services"
                    )
                    Box(
                        modifier = Modifier.matchParentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            color = Color.Blue,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            text = "SERVICES"
                        )
                    }

                }
            }

        }
        Row (modifier = Modifier.wrapContentWidth()) {
            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(modifier = Modifier.height(70.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = "welcome"
                    )
                    Box(
                        modifier = Modifier.matchParentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            color = Color.Blue,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            text = "WELCOME"
                        )
                    }

                }
            }
            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(modifier = Modifier.height(70.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = "Our Branch"
                    )
                    Box(
                        modifier = Modifier.matchParentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            color = Color.Blue,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            text = "OUR BRANCH"
                        )
                    }

                }
            }
            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(modifier = Modifier.height(70.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = "Products"
                    )
                    Box(
                        modifier = Modifier.matchParentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            color = Color.Blue,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            text = "PRODUCTS"
                        )
                    }

                }
            }
        }

    }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashBoardPreview(){
    DashBoard(rememberNavController())
}