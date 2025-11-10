package com.example.kotlinlockin.common.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.data.entity.Example


fun getFormFieldExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ TextField (for text input)",
        description = "Used to take text input from the user — like name, email, etc." +
                "\n ✅ Notes:\n" +
                "\t•\tvalue → current input text\n" +
                "\t•\tonValueChange → updates value when user types\n" +
                "\t•\tUse remember { mutableStateOf() } to store user input\n" +
                "\t•\tlabel and placeholder improve UX",
        code = "@Composable\n" +
                "fun TextFieldExample() {\n" +
                "    var name by remember { mutableStateOf(\"\") }\n" +
                "\n" +
                "    Column(modifier = Modifier.padding(16.dp)) {\n" +
                "        Text(text = \"Enter your name:\")\n" +
                "        TextField(\n" +
                "            value = name,\n" +
                "            onValueChange = { name = it },\n" +
                "            label = { Text(\"Name\") },\n" +
                "            placeholder = { Text(\"Type here...\") }\n" +
                "        )\n" +
                "        Text(text = \"Hello, name\")\n" +
                "    }\n" +
                "}",
    ) {
        var name by remember { mutableStateOf("") }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Enter your name:")
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                placeholder = { Text("Type here...") }
            )
            Text(text = "Hello, $name")
        }
    },
    Example(
        title = "2\uFE0F⃣ OutlinedTextField",
        description = "Same as TextField but with outlined border — looks cleaner in forms." +
                "\n ✅ Use for input-heavy screens (e.g., login/signup forms).",
        code = "" +
                "@Composable\n" +
                "fun OutlinedTextFieldExample() {\n" +
                "    var email by remember { mutableStateOf(\"\") }\n" +
                "\n" +
                "    OutlinedTextField(\n" +
                "        value = email,\n" +
                "        onValueChange = { email = it },\n" +
                "        label = { Text(\"Email\") },\n" +
                "        singleLine = true,\n" +
                "        modifier = Modifier\n" +
                "            .fillMaxWidth()\n" +
                "            .padding(16.dp)\n" +
                "    )\n" +
                "}",
    ) {
        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    },
    Example(
        title = "3\uFE0F⃣ Checkbox (for multiple selections)",
        description = "✅ Notes:\n" +
                "\t•\tUse for Yes/No or multi-select options\n" +
                "\t•\tonCheckedChange updates the state\n" +
                "\t•\tYou can also disable with enabled = false",
        code = "@Composable\n" +
                "fun CheckboxExample() {\n" +
                "    var isChecked by remember { mutableStateOf(false) }\n" +
                "\n" +
                "    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {\n" +
                "        Checkbox(\n" +
                "            checked = isChecked,\n" +
                "            onCheckedChange = { isChecked = it }\n" +
                "        )\n" +
                "        Text(text = if (isChecked) \"Checked\" else \"Unchecked\")\n" +
                "    }\n" +
                "}",
    ) {
        var isChecked by remember { mutableStateOf(false) }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Text(text = if (isChecked) "Checked" else "Unchecked")
        }
    },
    Example(
        title = "4\uFE0F⃣ RadioButton (for single selection)",
        description = "Used when you have multiple options but only one can be selected." +
                "\n✅ Notes:\n" +
                "\t•\tOnly one radio button should be selected at a time.\n" +
                "\t•\tCommon for surveys, preferences, and settings.",
        code = "@Composable\n" +
                "fun RadioButtonExample() {\n" +
                "    val options = listOf(\"Kotlin\", \"Java\", \"Python\")\n" +
                "    var selectedOption by remember { mutableStateOf(options[0]) }\n" +
                "\n" +
                "    Column(modifier = Modifier.padding(16.dp)) {\n" +
                "        Text(\"Select your favorite language:\")\n" +
                "        options.forEach { option ->\n" +
                "            Row(verticalAlignment = Alignment.CenterVertically) {\n" +
                "                RadioButton(\n" +
                "                    selected = selectedOption == option,\n" +
                "                    onClick = { selectedOption = option }\n" +
                "                )\n" +
                "                Text(option)\n" +
                "            }\n" +
                "        }\n" +
                "        Text(\"Selected: selectedOption\")\n" +
                "    }\n" +
                "}",
    ) {
        val options = listOf("Kotlin", "Java", "Python")
        var selectedOption by remember { mutableStateOf(options[0]) }

        Column(modifier = Modifier.padding(16.dp)) {
            Text("Select your favorite language:")
            options.forEach { option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                    Text(option)
                }
            }
            Text("Selected: $selectedOption")
        }
    },
    Example(
        title = "5\uFE0F⃣ Switch (for toggles / on-off states)",
        description = "Used to turn settings ON or OFF." +
                "\n✅ Notes:\n" +
                "\t•\tSimilar to Checkbox, but used for settings-like toggles.\n" +
                "\t•\tProvides better visual feedback for ON/OFF states.",
        code = "@Composable\n" +
                "fun SwitchExample() {\n" +
                "    var isEnabled by remember { mutableStateOf(false) }\n" +
                "\n" +
                "    Row(\n" +
                "        verticalAlignment = Alignment.CenterVertically,\n" +
                "        modifier = Modifier.padding(16.dp)\n" +
                "    ) {\n" +
                "        Switch(\n" +
                "            checked = isEnabled,\n" +
                "            onCheckedChange = { isEnabled = it }\n" +
                "        )\n" +
                "        Spacer(modifier = Modifier.width(8.dp))\n" +
                "        Text(if (isEnabled) \"Enabled\" else \"Disabled\")\n" +
                "    }\n" +
                "}",
    ) {
        var isEnabled by remember { mutableStateOf(false) }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Switch(
                checked = isEnabled,
                onCheckedChange = { isEnabled = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(if (isEnabled) "Enabled" else "Disabled")
        }
    },
    Example(
        title = "6\uFE0F⃣ Combine them into a Form Example",
        description = "Here’s a small form UI combining all the above:" +
                "✅ Explanation:\n" +
                "\t•\tCollects multiple inputs.\n" +
                "\t•\tButton is enabled only if checkbox is checked.\n" +
                "\t•\tShows how to use multiple state variables for form fields.",
        code = "@Composable\n" +
                "fun FormExample() {\n" +
                "    var name by remember { mutableStateOf(\"\") }\n" +
                "    var acceptTerms by remember { mutableStateOf(false) }\n" +
                "    val options = listOf(\"Male\", \"Female\", \"Other\")\n" +
                "    var selectedGender by remember { mutableStateOf(options[0]) }\n" +
                "    var notificationsEnabled by remember { mutableStateOf(false) }\n" +
                "\n" +
                "    Column(\n" +
                "        modifier = Modifier\n" +
                "            .padding(16.dp)\n" +
                "            .fillMaxWidth(),\n" +
                "        verticalArrangement = Arrangement.spacedBy(12.dp)\n" +
                "    ) {\n" +
                "        OutlinedTextField(\n" +
                "            value = name,\n" +
                "            onValueChange = { name = it },\n" +
                "            label = { Text(\"Name\") },\n" +
                "            modifier = Modifier.fillMaxWidth()\n" +
                "        )\n" +
                "\n" +
                "        Text(\"Select Gender:\")\n" +
                "        options.forEach { option ->\n" +
                "            Row(verticalAlignment = Alignment.CenterVertically) {\n" +
                "                RadioButton(\n" +
                "                    selected = selectedGender == option,\n" +
                "                    onClick = { selectedGender = option }\n" +
                "                )\n" +
                "                Text(option)\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        Row(verticalAlignment = Alignment.CenterVertically) {\n" +
                "            Checkbox(checked = acceptTerms, onCheckedChange = { acceptTerms = it })\n" +
                "            Text(\"Accept terms and conditions\")\n" +
                "        }\n" +
                "\n" +
                "        Row(verticalAlignment = Alignment.CenterVertically) {\n" +
                "            Switch(\n" +
                "                checked = notificationsEnabled,\n" +
                "                onCheckedChange = { notificationsEnabled = it }\n" +
                "            )\n" +
                "            Text(\"Enable Notifications\")\n" +
                "        }\n" +
                "\n" +
                "        Button(\n" +
                "            onClick = { println(\"Form submitted!\") },\n" +
                "            enabled = acceptTerms\n" +
                "        ) {\n" +
                "            Text(\"Submit\")\n" +
                "        }\n" +
                "    }\n" +
                "}",
    ) {
        var name by remember { mutableStateOf("") }
        var acceptTerms by remember { mutableStateOf(false) }
        val options = listOf("Male", "Female", "Other")
        var selectedGender by remember { mutableStateOf(options[0]) }
        var notificationsEnabled by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Text("Select Gender:")
            options.forEach { option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedGender == option,
                        onClick = { selectedGender = option }
                    )
                    Text(option)
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = acceptTerms, onCheckedChange = { acceptTerms = it })
                Text("Accept terms and conditions")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )
                Text("Enable Notifications")
            }

            Button(
                onClick = { println("Form submitted!") },
                enabled = acceptTerms
            ) {
                Text("Submit")
            }
        }
    }
)