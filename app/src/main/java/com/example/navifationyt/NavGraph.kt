package com.example.navifationyt

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
            }, navArgument(DETAIL_ARGUMENT_KEY2) {
                type = NavType.StringType
            })
            ) {
            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY2).toString())
            DetailScreen(navController,it.arguments?.getInt(DETAIL_ARGUMENT_KEY), it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
        }
        composable(
            route = "person/{person}",
            arguments = listOf(
                navArgument("person"){
                    type=PersonParamType()
                }
               )
        ){
            val person = it.arguments?.getParcelable("person", Person::class.java)
            PersonScreen(navController, person = person!!)
        }
    }
}