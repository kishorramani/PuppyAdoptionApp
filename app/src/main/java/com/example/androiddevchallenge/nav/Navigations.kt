package com.example.androiddevchallenge.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.pet.PetDetailsContent
import com.example.androiddevchallenge.pets.PetListContent

@Composable
fun SetUpNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "petList") {
        composable("petList") { PetListContent(navController) }
        composable(
            "detail/{petId}",
            arguments = listOf(navArgument("petId") { type = NavType.IntType })
        ) { backStackEntry ->
            PetDetailsContent(backStackEntry.arguments?.getInt("petId") ?: 0)
        }
    }
}