import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.navigation.navigation_drawer.NavigationItems
import com.example.kotlinlockin.presentation.screens.ComposeMustKnow
import com.example.kotlinlockin.presentation.screens.ConstrainedLayoutComposable
import com.example.kotlinlockin.presentation.screens.IntrinsicMeasurements
import com.example.kotlinlockin.presentation.screens.KotlinLayOutScreen
import com.example.kotlinlockin.presentation.screens.ModifiersTutorial
import com.example.kotlinlockin.presentation.screens.MutableStateTutorial
import com.example.kotlinlockin.presentation.screens.RecompositionTutorial
import com.example.kotlinlockin.presentation.screens.StateHoistingTutorial
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer() {
    val items = listOf(
        NavigationItems(
            title = "Important Keywords",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Compose must know",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Layouts",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Modifiers",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Constrained Layout",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Intrinsic measurements",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Recomposition",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Mutable state",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "State Hoisting",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Compose ViewModel",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "Observing Live data",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
    )

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState, drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.title) },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch { drawerState.close() }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        }, gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Demo") }, navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.apply { if (isClosed) open() else close() }
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                })
            }) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(it),
                horizontalAlignment = Alignment.Start
            ) {
                when (selectedItemIndex) {
                    0 -> StateHoistingTutorial()
                    1 -> ComposeMustKnow()
                    2 -> KotlinLayOutScreen()
                    3 -> ModifiersTutorial()
                    4 -> ConstrainedLayoutComposable()
                    5 -> IntrinsicMeasurements()
                    6 -> RecompositionTutorial()
                    7 -> MutableStateTutorial()
                }
            }
        }
    }
}