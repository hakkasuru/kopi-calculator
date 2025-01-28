package com.hakkasuru.kopicalculator.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun OptionCard(
    title: String,
    imageRes: DrawableResource,
    onTap: () -> Unit,
    modifier: Modifier = Modifier.size(256.dp)
) {
    Box(modifier = modifier) {
        Card(modifier.matchParentSize()) {
            Column(
                modifier = Modifier.clickable { onTap() }.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(128.dp),
                    painter = painterResource(imageRes),
                    contentDescription = "drink option image"
                )
                Spacer(Modifier.height(8.dp))
                Text(text = title, fontSize = 32.sp)
            }
        }
    }
}