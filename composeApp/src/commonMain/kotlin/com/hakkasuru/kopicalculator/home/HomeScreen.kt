package com.hakkasuru.kopicalculator.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hakkasuru.kopicalculator.widgets.OptionCard
import kopicalculator.composeapp.generated.resources.Res
import kopicalculator.composeapp.generated.resources.coffee_beans
import kopicalculator.composeapp.generated.resources.tea_bag_left

@Composable
fun HomeScreen(
    navigateToDrinkOptions: (drinkID: String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Choose your drink", fontSize = 48.sp)
        Spacer(Modifier.height(16.dp))
        DrinkOption(
            onTap = navigateToDrinkOptions
        )
    }
}

@Composable
private fun DrinkOption(
    onTap: (drinkID: String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OptionCard(
            title = "Coffee",
            imageRes = Res.drawable.coffee_beans,
            onTap = {
                onTap("coffee")
            }
        )
        Spacer(Modifier.height(16.dp))
        OptionCard(
            title = "Tea",
            imageRes = Res.drawable.tea_bag_left,
            onTap = {
                onTap("tea")
            }
        )
    }
}