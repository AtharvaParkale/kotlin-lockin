package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example


fun getCollectAsStateExamples(): List<Example> = listOf(
    Example(
        title = "Collect as state in compose",
        description = " this is a key Compose concept: collectAsState() is to StateFlow what observeAsState() is to LiveData —\n" +
                "it connects reactive data streams from your ViewModel to your Compose UI, so the UI automatically updates when the data changes.\n" +
                "\n" +
                "Here’s a complete, easy-to-understand explanation \uD83D\uDC47\n" +
                "\n" +
                "⸻\n" +
                "\n" +
                "\uD83D\uDCD8 Using collectAsState() for reactive UI updates\n" +
                "\t1.\tPurpose\n" +
                "collectAsState() is used in Jetpack Compose to collect values from a Kotlin Flow or StateFlow inside a Composable function.\n" +
                "It converts a Flow into a Compose State object so that the UI automatically recomposes whenever the Flow emits a new value.\n" +
                "\t2.\tReactive updates\n" +
                "When the Flow emits a new value, collectAsState() triggers recomposition.\n" +
                "This keeps the UI always in sync with the latest data from ViewModel.\n" +
                "\t3.\tWhy it’s used\n" +
                "\t•\tIt provides a clean, reactive connection between ViewModel and Compose UI\n" +
                "\t•\tIt eliminates the need for manual observers or callbacks\n" +
                "\t•\tIt is lifecycle-aware and cancels collection automatically when the composable leaves the composition",
        code = "",
    ) {

    },
    Example(
        title = "\uD83E\uDDF1 Example 1: Simple counter with StateFlow",
        code = "class CounterViewModel : ViewModel() {\n" +
                "    private val _count = MutableStateFlow(0)\n" +
                "    val count = _count.asStateFlow()\n" +
                "\n" +
                "    fun increment() {\n" +
                "        _count.value++\n" +
                "    }\n" +
                "}" +
                "\n===============================" +
                "\n @Composable\n" +
                "fun CounterScreen(viewModel: CounterViewModel = viewModel()) {\n" +
                "    val count by viewModel.count.collectAsState()\n" +
                "\n" +
                "    Column(\n" +
                "        horizontalAlignment = Alignment.CenterHorizontally,\n" +
                "        verticalArrangement = Arrangement.Center,\n" +
                "        modifier = Modifier.fillMaxSize()\n" +
                "    ) {\n" +
                "        Text(\"Count: count\")\n" +
                "        Button(onClick = { viewModel.increment() }) {\n" +
                "            Text(\"Increment\")\n" +
                "        }\n" +
                "    }\n" +
                "}",
        description = "Explanation\n" +
                "\t•\tcollectAsState() converts the Flow (count) into a Compose State\n" +
                "\t•\tWhenever _count.value changes in ViewModel, Compose recomposes automatically\n" +
                "\t•\tThe UI always reflects the latest value without any manual refresh",
    ) {},
    Example(
        title = "\uD83E\uDDE9 Example 2: UI state with network loading",
        code = "data class UiState(val isLoading: Boolean, val data: String?)\n" +
                "\n" +
                "class DataViewModel : ViewModel() {\n" +
                "    private val _uiState = MutableStateFlow(UiState(isLoading = true, data = null))\n" +
                "    val uiState = _uiState.asStateFlow()\n" +
                "\n" +
                "    init {\n" +
                "        viewModelScope.launch {\n" +
                "            delay(2000)\n" +
                "            _uiState.value = UiState(isLoading = false, data = \"Hello Compose + Flow!\")\n" +
                "        }\n" +
                "    }\n" +
                "}" +
                "\n======================" +
                "\n@Composable\n" +
                "fun DataScreen(viewModel: DataViewModel = viewModel()) {\n" +
                "    val state by viewModel.uiState.collectAsState()\n" +
                "\n" +
                "    when {\n" +
                "        state.isLoading -> CircularProgressIndicator()\n" +
                "        else -> Text(state.data ?: \"No Data\")\n" +
                "    }\n" +
                "}",
        description = "Explanation\n" +
                "\t•\tcollectAsState() collects the uiState from ViewModel\n" +
                "\t•\tWhen _uiState changes (loading → data), Compose automatically recomposes\n" +
                "\t•\tNo observer setup needed — everything is reactive and lifecycle-safe",
    ) {

    },
    Example(
        title = "⚡ Key points to remember",
        description = "\t•\tcollectAsState() bridges Flows and Compose UI\n" +
                "\t•\tIt automatically cancels collection when the Composable is removed\n" +
                "\t•\tUse it with StateFlow or Flow from your ViewModel for reactive UIs\n" +
                "\t•\tUnlike LiveData, StateFlow is fully Kotlin-native and works seamlessly with coroutines\n" +
                "\t•\tCommon pattern:\n" +
                "val state by viewModel.uiState.collectAsState()",
        code = "",
    ) {

    },
)
