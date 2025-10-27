import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopicTemplate(topicTitle: String, content: @Composable () -> Unit) {
    Column {
        TitleComposable(topicTitle)
        Box(modifier = Modifier.size(10.dp))
        content()
    }
}
