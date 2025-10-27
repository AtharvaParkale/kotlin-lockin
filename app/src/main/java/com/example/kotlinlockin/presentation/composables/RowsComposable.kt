import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


@Composable
fun RowComposable() {
    TopicTemplate("Rows") {
        Column {
            Row {
                Text(
                    text = "Text1",
                    modifier = Modifier.background(Color.Red),
                    fontWeight = FontWeight(weight = 500)
                )
                Text(
                    text = "Text2",
                    modifier = Modifier.background(Color.Blue),
                    fontWeight = FontWeight(weight = 500)
                )
                Text(
                    text = "Text3",
                    modifier = Modifier.background(Color.Yellow),
                    fontWeight = FontWeight(weight = 500)
                )
            }
        }
    }
}