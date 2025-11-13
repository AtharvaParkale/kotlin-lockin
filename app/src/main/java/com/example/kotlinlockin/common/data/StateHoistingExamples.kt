package com.example.kotlinlockin.common.data

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kotlinlockin.common.data.entity.Example

fun getStateHoistingExamples(): List<Example> {
    return listOf(
        Example(
            title = "What is state hoisting?",
            description = "State hoisting is an essential pattern in composable UI " + "development where the state is moved (or \"hoisted\") from a child " + "composable function to a higher-level parent. This means the child " + "becomes stateless, simply displaying the data it's given and sending " + "user events back to the parent, which now owns the state (acting as the " + "single source of truth). This practice is beneficial because it significantly " + "improves the reusability of the child component, makes testing easier " + "by separating UI from state logic, and gives the parent better control " + "to manage, save, or synchronize data across the application.",
            code = "",
            composableWidget = {},
        ),
        Example(
            title = "\uD83E\uDE9C Step 1: Start with state inside composable (unhoisted)",
            description = "➡\uFE0F This works fine, but now:\n" + "\t•\tYou can’t reset the count from outside.\n" + "\t•\tYou can’t share the same count between multiple components.\n" + "\t•\tThe logic is trapped inside this composable.",
            code = "@Composable\n" + "fun Counter() {\n" + "    var count by remember { mutableStateOf(0) }\n" + "\n" + "    Column {\n" + "        Text(\"Count: count\")\n" + "        Button(onClick = { count++ }) {\n" + "            Text(\"Add\")\n" + "        }\n" + "    }\n" + "}",
            composableWidget = {
                var count by remember { mutableStateOf(0) }

                Column {
                    Text("Count: $count")
                    Button(onClick = { count++ }) {
                        Text("Add")
                    }
                }
            },
        ),
        Example(
            title = "\uD83E\uDE9C Step 2: Hoist the state up",
            description = "Move count and onCountChange to the parent:" + "Now this composable is stateless — it just uses whatever value you give " + "it and notifies the parent when something should change." + "\t•\tCounterScreen controls the state.\n" + "\t•\tCounter just handles UI and user interactions.\n" + "\t•\tBoth can recompose independently.",
            code = "@Composable\n" + "fun Counter(count: Int, onCountChange: (Int) -> Unit) {\n" + "    Column {\n" + "        Text(\"Count: count\")\n" + "        Button(onClick = { onCountChange(count + 1) }) {\n" + "            Text(\"Add\")\n" + "        }\n" + "    }\n" + "}",
            composableWidget = {
                var count by remember { mutableStateOf(0) }

                Counter(
                    count = count, onCountChange = { count = it })
            },
        ),
        Example(
            title = "\uD83E\uDDF1 Common Pattern Signature",
            description = "TextField(value, onValueChange) is exactly using this pattern — " + "the parent manages the text state, and TextField just reflects it.",
            code = "@Composable\n" + "fun MyComposable(\n" + "    value: T,\n" + "    onValueChange: (T) -> Unit\n" + ")",
            composableWidget = {},
        ),
        Example(
            title = "⚠\uFE0F When not to hoist",
            description = "If the state:\n" + "\t•\tIs completely local to the composable (like animation progress, toggle expansion, or small visual flag),\n" + "\t•\tAnd does not need to be controlled from outside,\n" + "\n" + "then you can keep it inside (unhoisted).\n" + "Example: a dropdown that only manages its own expanded/collapsed state.",
            code = "",
            composableWidget = {},
        ),
    )
}

@Composable
fun Counter(count: Int, onCountChange: (Int) -> Unit) {
    Column {
        Text("Count: $count")
        Button(onClick = { onCountChange(count + 1) }) {
            Text("Add")
        }
    }
}