package com.hakkasuru.kopicalculator.drink

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hakkasuru.kopicalculator.widgets.AppBar

@Composable
fun DrinkOptionsScreen(
    drinkID: String,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = when (drinkID) {
                    "coffee" -> "Coffee Options"
                    "tea" -> "Tea Options"
                    "mixed" -> "Mixed Options"
                    else -> "Options"
                },
                onNavigationIconTap = navigateBack
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().consumeWindowInsets(innerPadding).padding(innerPadding)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Milk Options", fontSize = 16.sp)
                Spacer(Modifier.height(4.dp))
                OptionsBar(listOf("Condensed", "Evaporated", "None"))
                Spacer(Modifier.height(12.dp))
                Text(text = "Sugar Options", fontSize = 16.sp)
                Spacer(Modifier.height(4.dp))
                OptionsBar(listOf("Normal", "More", "Less", "None"))
                Spacer(Modifier.height(12.dp))
                Text(text = "Coffee Strength", fontSize = 16.sp)
                Spacer(Modifier.height(4.dp))
                OptionsBar(listOf("Normal", "Weak", "Strong", "No Water"))
                Spacer(Modifier.height(12.dp))
                Text(text = "Ice", fontSize = 16.sp)
                Spacer(Modifier.height(4.dp))
                OptionsBar(listOf("No Ice", "Ice"))
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.BottomCenter)) {
                Text(text = "Calculate", modifier = Modifier.padding(8.dp), fontSize = 16.sp)
            }
        }
    }
}

@Composable
private fun OptionsBar(options: List<String>) {
    var selectedIndex by remember { mutableStateOf(0) }
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, option ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = { selectedIndex = index },
                selected = selectedIndex == index
            ) {
                Text(text = option, modifier = Modifier.padding(4.dp))
            }
        }
    }
}