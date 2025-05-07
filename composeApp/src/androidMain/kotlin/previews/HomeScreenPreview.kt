package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hakkasuru.kopicalculator.home.HomeScreen

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        navigateToDrinkOptions = {}
    )
}