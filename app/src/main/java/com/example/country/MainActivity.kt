package com.example.country

import Country
import CountryList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.country.ui.theme.CountryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    CountryListScreen(countries  = CountryList)
                }
            }
        }
    }
}

@Composable
fun CountryListScreen(countries: List<Country>){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        items(countries){ country ->
            CountryRow(country)
        }
    }
}

@Composable
fun CountryRow(country: Country) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color.White)
            .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        //Country Flag Code
        Image(
            painter = painterResource(id = country.flag),
            contentDescription = "${country.name} Flag",
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(4.dp))
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        )
        Spacer(modifier =  Modifier.width(12.dp))

        //Country Name & Currency
        Column {
            Text(text = "Country: ${country.name}", fontWeight = FontWeight.Bold,fontSize = 16.sp)
            Text(text = "Currency: ${country.currency}", fontSize = 14.sp, color = Color.DarkGray )
        }

    }
}


//Preview
@Preview(showBackground = true)
@Composable
fun PreviewCountryList(){
    CountryListScreen(countries = CountryList)
}

