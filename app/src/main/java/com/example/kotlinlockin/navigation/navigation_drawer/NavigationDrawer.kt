import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.composables.TutorialScreen
import com.example.kotlinlockin.common.data.getButtonClicksExamples
import com.example.kotlinlockin.common.data.getCardSurfaceLayoutExamples
import com.example.kotlinlockin.common.data.getCollectAsStateExamples
import com.example.kotlinlockin.common.data.getCustomisingColorExamples
import com.example.kotlinlockin.common.data.getDynamicThemingExamples
import com.example.kotlinlockin.common.data.getFormFieldExamples
import com.example.kotlinlockin.common.data.getIconsAndImagesExamples
import com.example.kotlinlockin.common.data.getMaterialThemeExamples
import com.example.kotlinlockin.common.data.getMutableStateExamples
import com.example.kotlinlockin.common.data.getOnClickIntentExamples
import com.example.kotlinlockin.common.data.getRecompositionExample
import com.example.kotlinlockin.common.data.getStateHoistingExamples
import com.example.kotlinlockin.common.data.getStylingTextExamples
import com.example.kotlinlockin.common.data.getThemeExamples
import com.example.kotlinlockin.common.data.getThemeExamplesPartTwo
import com.example.kotlinlockin.navigation.navigation_drawer.NavigationItems
import com.example.kotlinlockin.presentation.screens.ComposeMustKnow
import com.example.kotlinlockin.presentation.screens.ConstrainedLayoutComposable
import com.example.kotlinlockin.presentation.screens.IntrinsicMeasurements
import com.example.kotlinlockin.presentation.screens.KotlinLayOutScreen
import com.example.kotlinlockin.presentation.screens.ModifiersTutorial
import com.example.kotlinlockin.presentation.screens.live_data.TimerScreen
import com.example.kotlinlockin.presentation.screens.view_model.presentation.ui.PostScreenInitialization
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer() {
    val items = listOf(
        NavigationItems(
            title = "1. Important Keywords",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "2. Compose must know",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "3. Layouts",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "4. Modifiers",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "5. Constrained Layout",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "6. Intrinsic measurements",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "7. Recomposition",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "8. Mutable state",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "9. State Hoisting",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "10. Compose ViewModel",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "11. Observing Live data",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "12. Collect as state",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "13. Styling text",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "14. Buttons and clickable components",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "15. Icons and Images",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "16. Cards/ Surface/ Layout",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "17. Different types of onclick intents",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "18. Form field, Text fields",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "19. Material theme usage",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "20. Customising typography",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "21. Theme part 1",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "22. Theme part 2",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "23. Dynamic Theme",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
        NavigationItems(
            title = "24. Creating a reusable design system",
            selectedIcon = Icons.Filled.KeyboardArrowRight,
            unselectedIcon = Icons.Filled.KeyboardArrowRight
        ),
    )

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState, gesturesEnabled = true, drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.background,
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Top
                ) {
                    itemsIndexed(items) { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = item.title, style = TextStyle(
                                        fontWeight = FontWeight.W600
                                    )
                                )
                            },
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
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                                .fillMaxWidth(),
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = MaterialTheme.colorScheme.onBackground,
                                selectedTextColor = MaterialTheme.colorScheme.background,
                                selectedIconColor = MaterialTheme.colorScheme.background
                            )

                        )
                    }
                }
            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Compose") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply { if (isClosed) open() else close() }
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        scrolledContainerColor = MaterialTheme.colorScheme.background,
                        navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
                        titleContentColor = MaterialTheme.colorScheme.onBackground,
                        actionIconContentColor = MaterialTheme.colorScheme.onBackground,
                        subtitleContentColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            }) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(it),
                horizontalAlignment = Alignment.Start
            ) {
                val context: Context = LocalContext.current;
                when (selectedItemIndex) {
                    0 -> Text("Must know keywords in kotlin")
                    1 -> ComposeMustKnow()
                    2 -> KotlinLayOutScreen()
                    3 -> ModifiersTutorial()
                    4 -> ConstrainedLayoutComposable()
                    5 -> IntrinsicMeasurements()
                    6 -> TutorialScreen(exampleList = getRecompositionExample())
                    7 -> TutorialScreen(exampleList = getMutableStateExamples())
                    8 -> TutorialScreen(exampleList = getStateHoistingExamples())
                    9 -> PostScreenInitialization()
                    10 -> TimerScreen()
                    11 -> TutorialScreen(exampleList = getCollectAsStateExamples())
                    12 -> TutorialScreen(exampleList = getStylingTextExamples())
                    13 -> TutorialScreen(exampleList = getButtonClicksExamples())
                    14 -> TutorialScreen(exampleList = getIconsAndImagesExamples())
                    15 -> TutorialScreen(exampleList = getCardSurfaceLayoutExamples())
                    16 -> TutorialScreen(exampleList = getOnClickIntentExamples(context))
                    17 -> TutorialScreen(exampleList = getFormFieldExamples())
                    18 -> TutorialScreen(exampleList = getMaterialThemeExamples())
                    19 -> TutorialScreen(exampleList = getCustomisingColorExamples())
                    20 -> TutorialScreen(exampleList = getThemeExamples())
                    21 -> TutorialScreen(exampleList = getThemeExamplesPartTwo())
                    22 -> TutorialScreen(exampleList = getDynamicThemingExamples())
                    23 -> TutorialScreen(exampleList = getDynamicThemingExamples())
                }
            }
        }
    }
}