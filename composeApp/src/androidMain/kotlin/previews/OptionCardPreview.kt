package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hakkasuru.kopicalculator.widgets.OptionCard
import kopicalculator.composeapp.generated.resources.Res
import kopicalculator.composeapp.generated.resources.coffee_beans

@Preview
@Composable
private fun OptionCardPreview() {
    OptionCard(
        title = "Coffee",
        subtitle = "Rich and energizing brew",
        imageRes = Res.drawable.coffee_beans,
        onTap = { /* no-op */ }
    )
}