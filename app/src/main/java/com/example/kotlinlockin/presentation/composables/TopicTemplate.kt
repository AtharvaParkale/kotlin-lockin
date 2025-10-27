import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TopicTemplate(topicTitle: String, content: @Composable () -> Unit) {

    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(all = 20.dp)) {
            TitleComposable(topicTitle)
            Box(modifier = Modifier.size(10.dp))
            content()
            Box(modifier = Modifier.size(5.dp))
            Text(
                text = "View Code",
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            )
            AnimatedVisibility(visible = isExpanded) {
                CodeViewer(
                    code = "fun TitleComposable(title:String){Text(text=title" +
                            ",fontWeight=FontWeight(weight=600),fontSize=18.sp)}"
                )
            }

        }
    }


}
