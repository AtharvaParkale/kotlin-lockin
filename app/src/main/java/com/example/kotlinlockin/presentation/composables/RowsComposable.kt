import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun RowComposable() {
    Column {
        TitleComposable("Rows")
        Box(modifier = Modifier.size(10.dp))
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