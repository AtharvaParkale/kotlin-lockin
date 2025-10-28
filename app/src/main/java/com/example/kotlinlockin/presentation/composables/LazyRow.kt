import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.presentation.composables.itemList

val itemList = List(100) { index -> "Item ${index + 1}" }


@Composable
fun LazyRowComposable() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    TopicTemplate(
        "LazyColumn",
        description="Box(modifier=Modifier.fillMaxWidth()){LazyRow{items(itemList){item->Text(item,modifier=Modifier.padding(horizontal=5.dp))}}}"
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyRow {
                items(itemList) { item ->
                    Text(
                        item, modifier = Modifier.padding(
                            horizontal = 5.dp
                        )
                    )
                }
            }
        }
    }
}