package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example


fun getRecompositionExample(): List<Example> = listOf(
    Example(
        title = "✅ Example 1: Basic state-driven recomposition",
        code = "@Composable\n" +
                "fun Counter() {\n" +
                "    var count by remember { mutableStateOf(0) }\n" +
                "\n" +
                "    Text(\"Count: count\")   // Reads count → recomposes when count changes\n" +
                "\n" +
                "    Button(onClick = { count++ }) {\n" +
                "        Text(\"Increment\")   // Does NOT recompose when count changes\n" +
                "    }\n" +
                "}",
        description = "Only the Text that reads count is recomposed when count changes.",
        composableWidget = {}
    ),

    Example(
        title = "⚠️ Example 2: Everything re-runs if all code is in one block",
        code = "@Composable\n" +
                "fun CounterBad() {\n" +
                "    var count by remember { mutableStateOf(0) }\n" +
                "\n" +
                "    Column {\n" +
                "        Text(\"Count: count\")\n" +
                "        Button(onClick = { count++ }) {\n" +
                "            Text(\"Increment\")\n" +
                "        }\n" +
                "    }\n" +
                "}",
        description = "Whole Column recomposes because it directly reads count.",
        composableWidget = {}
    ),

    Example(
        title = "✅ Example 3: Scoped recomposition using smaller composables",
        code = "@Composable\n" +
                "fun CounterGood() {\n" +
                "    var count by remember { mutableStateOf(0) }\n" +
                "\n" +
                "    Column {\n" +
                "        CountText(count)\n" +
                "        IncrementButton { count++ }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "@Composable\n" +
                "fun CountText(count: Int) {\n" +
                "    Text(\"Count: count\")\n" +
                "}\n" +
                "\n" +
                "@Composable\n" +
                "fun IncrementButton(onClick: () -> Unit) {\n" +
                "    Button(onClick) { Text(\"Increment\") }\n" +
                "}",
        description = "Only CountText recomposes when count changes.",
        composableWidget = {}
    ),

    Example(
        title = "⚠️ Example 4: Passing unstable lambdas causes recomposition",
        code = "@Composable\n" +
                "fun Parent() {\n" +
                "    var text by remember { mutableStateOf(\"Hello\") }\n" +
                "    Child(onClick = { println(text) }) // New lambda every recomposition\n" +
                "}\n" +
                "\n" +
                "@Composable\n" +
                "fun Child(onClick: () -> Unit) {\n" +
                "    Button(onClick) { Text(\"Click\") }\n" +
                "}",
        description = "Child recomposes every time text changes because onClick lambda changes.\n\n✅ Fix: use remember { ... } to stabilize the lambda.",
        composableWidget = {}
    ),

    Example(
        title = "✅ Example 5: Stabilizing lambda with remember",
        code = "@Composable\n" +
                "fun ParentFixed() {\n" +
                "    var text by remember { mutableStateOf(\"Hello\") }\n" +
                "    val onClickRemembered = remember(text) { { println(text) } }\n" +
                "    Child(onClickRemembered)\n" +
                "}",
        description = "Now the lambda is stable (only recreated when text changes).",
        composableWidget = {}
    ),

    Example(
        title = "⚡ Example 6: Remember avoids unnecessary recomposition work",
        code = "@Composable\n" +
                "fun HeavyCalculationExample() {\n" +
                "    var input by remember { mutableStateOf(10) }\n" +
                "    val result = remember(input) {\n" +
                "        heavyCalculation(input)\n" +
                "    }\n" +
                "\n" +
                "    Text(\"Result: result\")\n" +
                "    Button(onClick = { input++ }) { Text(\"Recalculate\") }\n" +
                "}\n" +
                "\n" +
                "fun heavyCalculation(x: Int): Int {\n" +
                "    Thread.sleep(1000)\n" +
                "    return x * x\n" +
                "}",
        description = "remember caches results. heavyCalculation runs only when input changes, not every recomposition.",
        composableWidget = {}

    ),

    Example(
        title = "✅ Example 7: derivedStateOf to avoid redundant recomposition",
        code = "@Composable\n" +
                "fun DerivedStateExample() {\n" +
                "    var items by remember { mutableStateOf(listOf(1, 2, 3)) }\n" +
                "    val total by remember {\n" +
                "        derivedStateOf { items.sum() }\n" +
                "    }\n" +
                "\n" +
                "    Text(\"Total: total\")\n" +
                "    Button(onClick = { items = items + (items.size + 1) }) {\n" +
                "        Text(\"Add Item\")\n" +
                "    }\n" +
                "}",
        description = "derivedStateOf recalculates only when items actually change — efficient for derived values.",
        composableWidget = {}
    ),

    Example(
        title = "✅ Example 8: Keys control recomposition scope in LazyColumn",
        code = "@Composable\n" +
                "fun KeyExample() {\n" +
                "    val items = listOf(\"A\", \"B\", \"C\")\n" +
                "    LazyColumn {\n" +
                "        items(items, key = { it }) { item ->\n" +
                "            Text(\"Item: item\")\n" +
                "        }\n" +
                "    }\n" +
                "}",
        description = "Using key prevents Compose from recomposing all items when list order changes. Only affected item recomposes.",
        composableWidget = {}
    ),

    Example(
        title = "✅ Example 9: Side effects like LaunchedEffect do not cause recomposition",
        code = "@Composable\n" +
                "fun LaunchExample(input: String) {\n" +
                "    LaunchedEffect(input) {\n" +
                "        println(\"Launched with input\")\n" +
                "    }\n" +
                "\n" +
                "    Text(\"Input: input\")\n" +
                "}",
        description = "LaunchedEffect runs on key change but does NOT trigger recomposition — it's a side effect, not UI logic.",
        composableWidget = {}
    )
)