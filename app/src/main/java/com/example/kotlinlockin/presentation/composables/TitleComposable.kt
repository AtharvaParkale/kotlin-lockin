import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Heading(title: String) {
    Text(
        text = "=> $title",
        fontWeight = FontWeight(weight = 600),
        fontSize = 20.sp
    )
}