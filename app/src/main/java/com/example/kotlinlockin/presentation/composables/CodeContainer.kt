import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodeViewer(code: String) {
    val formattedCode = remember(code) { formatKotlinCode(code) }
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight / 5)
            .background(
                Color(
                    0xFF1E1E1E
                ),
            )
            .padding(12.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(formattedCode.lines().size) { index ->
                val line = formattedCode.lines()[index]

                Text(
                    text = buildAnnotatedString {
                        when {
                            line.trim().startsWith("fun") -> {
                                withStyle(SpanStyle(color = Color(0xFF569CD6))) { append(line) }
                            }

                            line.contains("(") && line.contains(")") -> {
                                withStyle(SpanStyle(color = Color(0xFF9CDCFE))) { append(line) }
                            }

                            line.contains("=") -> {
                                withStyle(SpanStyle(color = Color(0xFFDCDCAA))) { append(line) }
                            }

                            else -> append(line)
                        }
                    },
                    fontFamily = FontFamily.Monospace,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    color = Color(0xFFD4D4D4)
                )
            }
        }
    }
}

fun formatKotlinCode(code: String): String {
    val cleaned = code.replace(Regex("\\s+"), " ") // collapse excessive spaces
        .replace("{", " {\n").replace("}", "\n}").replace("(", "(\n").replace(")", "\n)")
        .replace(";", "").replace(",", ", ").replace(" )", ")").replace(" (", "(")
        .replace("= ", "= ").replace(" =", " =").trim()

    val lines = cleaned.split("\n").map { it.trim() }.filter { it.isNotEmpty() }
    val builder = StringBuilder()
    var indentLevel = 0

    for (rawLine in lines) {
        val line = rawLine

        // Adjust indentation BEFORE printing closing braces
        if (line.startsWith("}")) indentLevel--

        // Apply indentation
        builder.append("    ".repeat(indentLevel)).append(line).append("\n")

        // Adjust indentation AFTER opening braces
        if (line.endsWith("{")) indentLevel++

        // Handle function parameter grouping
        if (line.endsWith("(")) indentLevel++
        if (line.startsWith(")")) indentLevel--
    }

    // Normalize line breaks
    return builder.toString().replace(Regex("\n{3,}"), "\n\n") // max 2 line breaks
        .trimEnd()
}