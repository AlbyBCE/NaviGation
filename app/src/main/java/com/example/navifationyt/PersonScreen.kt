package com.example.navifationyt

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun PersonScreen(navController: NavHostController, person: Person){
Text(text = person.name )
}