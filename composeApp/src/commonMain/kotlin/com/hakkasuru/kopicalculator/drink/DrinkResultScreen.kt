package com.hakkasuru.kopicalculator.drink

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hakkasuru.kopicalculator.widgets.AppBar
import kopicalculator.composeapp.generated.resources.Res
import kopicalculator.composeapp.generated.resources.coffee_beans
import kopicalculator.composeapp.generated.resources.drink_hot
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrinkResult(
    options: List<String>,
    onOrderAgain: () -> Unit,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Your Order",
                onNavigationIconTap = navigateBack
            )
        }
    ) { paddingValues ->
        val (drink, drinkDescription) = mapToResult(options)
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.size(64.dp),
                            painter = painterResource(Res.drawable.drink_hot),
                            contentDescription = "drink option image"
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = drink,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.height(16.dp))
                        Row {
                            Icon(
                                imageVector = Icons.Rounded.PlayCircle,
                                contentDescription = "Play Sound",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(32.dp),
                    ) {
                        Text(
                            text = "What does it mean?",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.surfaceTint
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = drinkDescription,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            Button(
                onClick = onOrderAgain,
                modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.BottomCenter)
            ) {
                Text("Order Again", modifier = Modifier.padding(8.dp), fontSize = 16.sp)
            }
        }
    }
}

private fun mapToResult(options: List<String>): Pair<String, String> {
    var drink = when (options[0]) {
        "coffee" -> "Kopi"
        "tea" -> "Teh"
        "mixed" -> "Yuen Yang"
        else -> "Unknown"
    }

    var drinkDescription = when (options[0]) {
        "coffee" -> "The classic Singapore coffee"
        "tea" -> "The classic Singapore tea"
        "mixed" -> "A unique drink where coffee and tea are mixed"
        else -> "Unknown"
    }

    when (options[1]) {
        "Condensed" -> {
            drinkDescription += " with condensed milk"
        }
        "Evaporated" -> {
            drink += " C"
            drinkDescription += " with evaporated milk"
        }
        "None" -> {
            drink += " O"
            drinkDescription += " without milk"
        }
        else -> Unit
    }

    when (options[2]) {
        "Normal" -> {
            drinkDescription += " and normal sugar"
        }
        "More" -> {
            drink += " Gah Dai"
            drinkDescription += " and extra sweetness"
        }
        "Less" -> {
            drink += " Siew Dai"
            drinkDescription += " and less sugar"
        }
        "None" -> {
            drink += " Kosong"
            drinkDescription += " and no sugar"
        }
        else -> Unit
    }

    when (options[3]) {
        "Normal" -> {
            drinkDescription += ", with regular strength"
        }
        "Weak" -> {
            drink += " Po"
            drinkDescription += ", but weaker (more diluted)"
        }
        "Strong" -> {
            drink += " Gao"
            drinkDescription += ", but stronger and more concentrated"
        }
        "No Water" -> {
            drink += " Di Lo"
            drinkDescription += ", with no water added (extra concentrated)"
        }
        else -> Unit
    }

    when (options[4]) {
        "No Ice" -> {
            drinkDescription += ", served hot"
        }
        "Ice" -> {
            drink += " Beng"
            drinkDescription += ", served with ice"
        }
        else -> Unit
    }

    drinkDescription += ". This is how locals would order at a kopitiam (traditional coffee shop)."

    return Pair(drink, drinkDescription)
}