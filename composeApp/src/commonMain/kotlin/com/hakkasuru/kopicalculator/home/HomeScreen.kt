package com.hakkasuru.kopicalculator.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            Text(
                "Choose your drink",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Select your preferred beverage to continue",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(16.dp))
            DrinkOption(
                onTap = navigateToDrinkOptions
            )
        }
    }
}

@Composable
private fun DrinkOption(
    onTap: (drinkID: String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OptionCard(
            title = "Coffee",
            subtitle = "Rich and energizing brew",
            imageRes = Res.drawable.coffee_beans,
            onTap = {
                onTap("coffee")
            }
        )
        Spacer(Modifier.height(16.dp))
        OptionCard(
            title = "Tea",
            subtitle = "Calming and aromatic",
            imageRes = Res.drawable.tea_bag_left,
            onTap = {
                onTap("tea")
            }
        )
        Spacer(Modifier.height(16.dp))
        OptionCard(
            title = "Mixed",
            subtitle = "Best of both worlds",
            imageRes = Res.drawable.tea_bag_left,
            onTap = {
                onTap("mixed")
            }
        )
    }
}