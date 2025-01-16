package com.hakkasuru.kopicalculator

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hakkasuru.kopicalculator.drink.DrinkOptionsScreen
import com.hakkasuru.kopicalculator.home.HomeScreen

@Composable
fun KopiApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold {
        NavHost(
            navController = navController,
            startDestination = AppDestination.HOME.route
        ) {
            composable(route = AppDestination.HOME.route) {
                HomeScreen(
                    navigateToDrinkOptions = {
                        navController.navigate(
                            AppDestination.DRINK_OPTIONS.route
                                .replace("{${DestinationArgs.ARG_ID}}", it)
                        )
                    }
                )
            }
            composable(
                route = AppDestination.DRINK_OPTIONS.route,
                arguments = listOf(
                    navArgument(DestinationArgs.ARG_ID) {
                        type = NavType.StringType
                        nullable = false
                        defaultValue = ""
                    }
                )
            ) { navBackStackEntry ->
                val drinkID = navBackStackEntry.arguments?.getString(DestinationArgs.ARG_ID) ?: ""
                DrinkOptionsScreen(
                    drinkID = drinkID,
                    navigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}