package com.example.kotlinlockin.common.data

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.data.entity.Example

@SuppressLint("UnrememberedMutableState")
fun getMutableStateExamples(): List<Example> {
    return listOf(
        Example(
            title = "Example 1 : Usage of mutable state",
            description = "Basic example",
            code = "@Composable\n" +
                    "fun TextFieldWithText() {\n" +
                    "    val stringState = remember { mutableStateOf(\"\") }\n" +
                    "    TextField(\n" +
                    "        value = stringState.value,\n" +
                    "        onValueChange = { stringState.value = it }\n" +
                    "    )\n" +
                    "\n" +
                    "    Text(stringState.value)\n" +
                    "}",
            composableWidget = {
                val stringState = remember { mutableStateOf("") }
                Column {
                    TextField(
                        value = stringState.value,
                        onValueChange = { stringState.value = it }
                    )

                    Text(stringState.value)
                }

            }

        ),
        Example(
            title = "✅ Example 2: Basic state usage",
            code = "@Composable\n" +
                    "fun Counter() {\n" +
                    "    var count by remember { mutableStateOf(0) }\n" +
                    "\n" +
                    "    Column {\n" +
                    "        Text(\"Count: count\") // Reads count → recomposes when count changes\n" +
                    "        Button(onClick = { count++ }) {\n" +
                    "            Text(\"Increment\")\n" +
                    "        }\n" +
                    "    }\n" +
                    "}",
            description = "This is the most basic use of mutableStateOf.\n" +
                    "When count changes, only the Text displaying it recomposes.\n" +
                    "Compose automatically tracks which composables read which state.",
            composableWidget = {
                var count by remember { mutableStateOf(0) }

                Column {
                    Text("Count: $count")
                    Button(onClick = { count++ }) {
                        Text("Increment")
                    }
                }
            }
        ),
        Example(
            title = "⚠\uFE0F Example 2: Forgetting remember causes reset",
            code = "@Composable\n" +
                    "fun BadCounter() {\n" +
                    "    var count = mutableStateOf(0) // ❌ No remember\n" +
                    "\n" +
                    "    Button(onClick = { count.value++ }) {\n" +
                    "        Text(\"Count: count.value}\")\n" +
                    "    }\n" +
                    "}",
            description = "Here, the count variable is recreated every recomposition, so it resets to 0 each time.\n" +
                    "Always wrap state in remember to preserve its value across recompositions.",
            composableWidget = {
                val count = mutableIntStateOf(0) // ❌ No remember

                Button(onClick = { count.intValue++ }) {
                    Text("Count: ${count.intValue}")
                }
            }

        ),
        Example(
            title = "✅ Example 3: Preserving state with remember",
            code = "@Composable\n" +
                    "fun GoodCounter() {\n" +
                    "    var count by remember { mutableStateOf(0) }\n" +
                    "\n" +
                    "    Button(onClick = { count++ }) {\n" +
                    "        Text(\"Count: count\")\n" +
                    "    }\n" +
                    "}",
            description = "Using remember stores the state in the composition memory, so it survives recompositions.\n" +
                    "Each click correctly updates and displays the count.",
            composableWidget = {
                var count by remember { mutableStateOf(0) }

                Button(onClick = { count++ }) {
                    Text("Count: $count")
                }
            }
        ),
        Example(
            title = "✅ Example 4: rememberSaveable survives configuration changes",
            description = "rememberSaveable works like remember but also saves state in a Bundle.\n" +
                    "It survives configuration changes like screen rotation or process death.",
            code = "@Composable\n" +
                    "fun CounterSaveable() {\n" +
                    "    var count by rememberSaveable { mutableStateOf(0) }\n" +
                    "\n" +
                    "    Column(horizontalAlignment = Alignment.CenterHorizontally) {\n" +
                    "        Text(\"Count: count\")\n" +
                    "        Button(onClick = { count++ }) { Text(\"Increment\") }\n" +
                    "    }\n" +
                    "}",
            composableWidget = {
                var count by rememberSaveable { mutableStateOf(0) }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Count: $count")
                    Button(onClick = { count++ }) { Text("Increment") }
                }
            }
        ),
        Example(
            title = "⚠\uFE0F Example 5: Large scope state causes extra recompositions",
            description = "Here, when age changes, the entire Column recomposes — including name.\n" +
                    "Even though name didn’t change!\n" +
                    "Avoid putting too much state in one scope; split into smaller composables.",
            code = "@Composable\n" +
                    "fun ProfileBad() {\n" +
                    "    var name by remember { mutableStateOf(\"Atharva\") }\n" +
                    "    var age by remember { mutableStateOf(22) }\n" +
                    "\n" +
                    "    Column {\n" +
                    "        Text(\"Name: name\")\n" +
                    "        Text(\"Age: age\")\n" +
                    "        Button(onClick = { age++ }) { Text(\"Increase Age\") }\n" +
                    "    }\n" +
                    "}",
            composableWidget = {
                var name by remember { mutableStateOf("Atharva") }
                var age by remember { mutableStateOf(22) }

                Column {
                    Text("Name: $name")
                    Text("Age: $age")
                    Button(onClick = { age++ }) { Text("Increase Age") }
                }
            },
        ),
        Example(
            title = "✅ Example 6: Scoped state in smaller composables",
            description = "Now only AgeSection recomposes when age changes.\n" +
                    "NameSection remains stable.\n" +
                    "This pattern improves performance and keeps recomposition local.",
            code = "@Composable\n" +
                    "fun ProfileGood() {\n" +
                    "    var name by remember { mutableStateOf(\"Atharva\") }\n" +
                    "    var age by remember { mutableStateOf(22) }\n" +
                    "\n" +
                    "    Column {\n" +
                    "        NameSection(name)\n" +
                    "        AgeSection(age) { age++ }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "@Composable\n" +
                    "fun NameSection(name: String) {\n" +
                    "    Text(\"Name: name\")\n" +
                    "}\n" +
                    "\n" +
                    "@Composable\n" +
                    "fun AgeSection(age: Int, onIncrement: () -> Unit) {\n" +
                    "    Text(\"Age: age\")\n" +
                    "    Button(onClick = onIncrement) { Text(\"Increase Age\") }\n" +
                    "}",
            composableWidget = {
                var name by remember { mutableStateOf("Atharva") }
                var age by remember { mutableStateOf(22) }

                Column {
                    NameSection(name)
                    AgeSection(age) { age++ }
                }
            }
        ),
        Example(
            title = "✅ Example 7: Derived State Usage",
            description = "\t•\tYou’re declaring a reactive piece of state.\n" +
                    "\t•\tEvery time query changes → Compose knows and triggers recomposition for all composables that read it.\n" +
                    "\n" +
                    "So anything that directly reads query (like TextField) will recompose." +
                    "\t•\tThis is a static list of items.\n" +
                    "\t•\tUsing remember means it’s created only once and reused across recompositions.\n" +
                    "\t•\tSo items itself will never trigger recompositions." +
                    "Here’s where the magic happens \uD83E\uDE84\n" +
                    "\n" +
                    "Normally, if you wrote:" +
                    "then:\n" +
                    "\t•\tThe filter() runs every recomposition, even if result doesn’t change.\n" +
                    "\t•\tThat can cause redundant work and UI recomposition for the list.\n" +
                    "\n" +
                    "But with derivedStateOf:\n" +
                    "\t•\tCompose tracks that filteredList depends on query.\n" +
                    "\t•\tIt computes the filtered list only when query actually changes.\n" +
                    "\t•\tThen it compares the new value with the previous one.\n" +
                    "\t•\tIf they are equal, it does not notify downstream UI — meaning your LazyColumn won’t recompose unnecessarily.\n" +
                    "\n" +
                    "This is basically Compose’s “smart caching” system for computed data." +
                    "\t•\tUser types in this field.\n" +
                    "\t•\tEvery keystroke updates query.\n" +
                    "\t•\tSince query is a mutableState, Compose recomposes this function.\n" +
                    "\t•\tDuring recomposition:\n" +
                    "\t•\tderivedStateOf checks if filteredList actually changed.\n" +
                    "\t•\tIf not → it doesn’t notify UI." +
                    "\t•\tDisplays the filtered list.\n" +
                    "\t•\tThis list will recompose only when filteredList value changes.\n" +
                    "\t•\tIf you type something that doesn’t change the filtering result (e.g., extra spaces, or typing the same text again), the list won’t redraw — saving performance.",
            composableWidget = {
                var query by remember { mutableStateOf("") }
                val items = remember { listOf("Apple", "Banana", "Orange", "Mango") }

                // Derived state (computed from query)
                val filteredList by remember {
                    derivedStateOf {
                        items.filter { it.contains(query, ignoreCase = true) }
                    }
                }

                Column {
                    TextField(
                        value = query,
                        onValueChange = { query = it },
                        label = { Text("Search") }
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                    ) {
                        items(filteredList) { item ->
                            Text(item)
                        }
                    }
                }
            },
            code = "@Composable\n" +
                    "fun DerivedStateExample() {\n" +
                    "    var query by remember { mutableStateOf(\"\") }\n" +
                    "    val items = remember { listOf(\"Apple\", \"Banana\", \"Orange\", \"Mango\") }\n" +
                    "\n" +
                    "    // Derived state (computed from query)\n" +
                    "    val filteredList by remember {\n" +
                    "        derivedStateOf {\n" +
                    "            items.filter { it.contains(query, ignoreCase = true) }\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    Column {\n" +
                    "        TextField(\n" +
                    "            value = query,\n" +
                    "            onValueChange = { query = it },\n" +
                    "            label = { Text(\"Search\") }\n" +
                    "        )\n" +
                    "\n" +
                    "        LazyColumn {\n" +
                    "            items(filteredList) { item ->\n" +
                    "                Text(item)\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}"
        )

    )
}

@Composable
fun NameSection(name: String) {
    Text("Name: $name")
}

@Composable
fun AgeSection(age: Int, onIncrement: () -> Unit) {
    Text("Age: $age")
    Button(onClick = onIncrement) { Text("Increase Age") }
}