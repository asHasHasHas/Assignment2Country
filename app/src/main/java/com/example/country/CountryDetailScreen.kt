package com.example.country

import Country
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CountryDetailScreen(navController: NavController, country: Country){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Back Button
            Row(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(onClick = {navController.popBackStack()}){
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Text(
                    text = country.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            //Map of Country
            Image(
                painter = painterResource(id = country.map),
                contentDescription = "${country.name} Map",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            //Country Fact
            Text(
                text = country.fact,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }
    }
}