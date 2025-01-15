package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hakkasuru.kopicalculator.drink.DrinkOptionsScreen

@Preview
@Composable
private fun DrinkOptionsScreenPreview() {
    DrinkOptionsScreen(
        drinkID = "coffee",
        navigateBack = {}
    )
}