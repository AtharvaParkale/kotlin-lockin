package com.example.kotlinlockin.common.data

class GetRecompositionTutorialData {
}

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
        description = "What happens:\n" +
                "\t•\tOnly the Text(“Count: count”) recomposes when count changes.\n" +
                "\t•\tButton and inner Text(\"Increment\") do not recompose since they don’t read count.\n" +
                "\n" +
                "Reason: Compose tracks which functions read which states.",
    ),


    Example(
        title = "⚠\uFE0F Example 2: Everything re-runs if all code is in one block",
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
        description = "What happens:\n" +
                "\t•\tWhen count changes, the entire Column lambda recomposes (so Button & its child Text too).\n" +
                "\t•\tSlightly more work than needed.\n" +
                "\n" +
                "Fix: Split into smaller composables \uD83D\uDC47"
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
                "    Button(onClick) {\n" +
                "        Text(\"Increment\")\n" +
                "    }\n" +
                "}",
        description = "Now:\n" +
                "\t•\tOnly CountText recomposes when count changes.\n" +
                "\t•\tIncrementButton stays untouched — because its parameters didn’t change.\n" +
                "\n" +
                "✅ This is a good practice — isolate state reads in small composables."
    ),
    Example(
        title = "⚠\uFE0F Example 4: Passing unstable lambdas causes recomposition",
        code = "@Composable\n" +
                "fun Parent() {\n" +
                "    var text by remember { mutableStateOf(\"Hello\") }\n" +
                "    Child(onClick = { println(text) }) // \uD83D\uDC48 new lambda every recomposition\n" +
                "}\n" +
                "\n" +
                "@Composable\n" +
                "fun Child(onClick: () -> Unit) {\n" +
                "    Button(onClick) { Text(\"Click\") }\n" +
                "}",
        description = "Problem:\n" +
                "\t•\tChild recomposes every time text changes, even though it doesn’t read text.\n" +
                "\t•\tBecause { println(text) } is a new lambda instance on each composition.\n"
    )
)