package com.example.sprinterval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprinterval.ui.theme.SprintervalTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SprintervalTheme {
                // The void of the app.
                Surface{
                    ScreenNavigation()
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold {
        innerPadding -> Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f)
            ) {
                Text(
                    text = "Categoría",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .clickable { navController.navigate(ScreenLink.TimeRegistryScreenLink.name) }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(80.dp), // Add some padding for better spacing
                    verticalArrangement = Arrangement.SpaceAround, // Distribute space between items
                    horizontalAlignment = Alignment.CenterHorizontally // Center text horizontally
                ) {
                    Text(
                        text = "Mejor tiempo de la categoría",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                        )
                    )
                    Text(
                        text = "Toca para ver el registro de tiempos",
                        color = Color.White,
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .clickable { navController.navigate(ScreenLink.RunScreenLink.name) }
                ) {
                    Text(
                        text = "Get started!",
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun RunScreen(navController: NavController, modifier: Modifier = Modifier){
    Scaffold {
        innerPadding -> Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.05f)
                    .padding(2.dp)
            ) {
                Text(
                    text = "Categoría",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
                Box(
                    modifier = Modifier
                        .background(color = Color.White)
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .clickable { navController.navigate(ScreenLink.MainScreenLink.name) }
                ) {
                    Text(
                        text = "<",
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.05f)
            ) {
                Text(
                    text = "00:00:00",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
                    Text(
                        text = "Comenzar",
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun TimeRegistryScreen(navController: NavController, modifier: Modifier = Modifier){
    Scaffold {
        innerPadding -> Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f)
                    .padding(2.dp)
            ) {
                Text(
                    text = "Categoría",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
                Box(
                    modifier = Modifier
                        .background(color = Color.White)
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .clickable { navController.navigate(ScreenLink.MainScreenLink.name) }
                ) {
                    Text(
                        text = "<",
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {
                Text(
                    text = "Time registry",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                )
            }
        }
    }
}

// Makes screen navigation less error prone.
// use "[Enum].name" to convert the enum to a string.
enum class ScreenLink{
    MainScreenLink,
    RunScreenLink,
    TimeRegistryScreenLink
}

@Composable
fun ScreenNavigation() {
    // "rememberNavController" is used to remember the state of the navigation controller.
    val navController = rememberNavController()
    NavHost(navController, startDestination = ScreenLink.MainScreenLink.name) {
        /*
            Almost like conditionals, but they're more like symbolic links.
            "navController" is passed as an argument to the composables, this way, they can use the
            screen navigation system.
        */
        composable(ScreenLink.MainScreenLink.name) {
            MainScreen(navController)
        }
        composable(ScreenLink.RunScreenLink.name) {
            RunScreen(navController)
        }
        composable(ScreenLink.TimeRegistryScreenLink.name) {
            TimeRegistryScreen(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SprintervalTheme {
        ScreenNavigation()
    }
}