package com.hakkasuru.kopicalculator

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.hakkasuru.kopicalculator.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val colorScheme = if (isSystemInDarkTheme()) AppTheme.darkScheme else AppTheme.lightScheme
    MaterialTheme(colorScheme = colorScheme) {
        KopiApp()
    }
}