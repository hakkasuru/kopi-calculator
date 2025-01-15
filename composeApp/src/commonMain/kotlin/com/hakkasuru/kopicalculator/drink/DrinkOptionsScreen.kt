package com.hakkasuru.kopicalculator.drink

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.hakkasuru.kopicalculator.widgets.AppBar

@Composable
fun DrinkOptionsScreen(
    drinkID: String,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Options",
                onNavigationIconTap = navigateBack
            )
        }
    ) {
        Column { }
    }
}