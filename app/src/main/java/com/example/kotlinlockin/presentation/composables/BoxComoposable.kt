import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BoxComposable() {
    Column {
        TitleComposable("Box")
        Box(modifier = Modifier.size(10.dp))
        Box(
            Modifier
                .background(
                    Color.Gray
                )
                .padding(all = 10.dp)
                .size(250.dp)
        ) {
            Text(
                "Center",
                Modifier.align(Alignment.Center),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Top Start",
                Modifier.align(Alignment.TopStart),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Top End",
                Modifier.align(Alignment.TopEnd),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Bottom Start",
                Modifier.align(Alignment.BottomStart),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
            Text(
                "Bottom End",
                Modifier.align(Alignment.BottomEnd),
                fontWeight = FontWeight(weight = 500),
                color = Color.White
            )
        }
    }
}