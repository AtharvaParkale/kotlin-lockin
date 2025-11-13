package com.example.kotlinlockin.common.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.common.data.entity.Example

fun getCardSurfaceLayoutExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ Cards",
        description = "What:\n" + "A Card is a Material Design surface used to group related content like text, images, or buttons.\n" + "It provides elevation (shadow), rounded corners, and background color automatically." + "\n✅ Notes:\n" + "\t•\tUse CardDefaults.cardElevation() for shadow height.\n" + "\t•\tUse CardDefaults.cardColors() to customize background color.\n" + "\t•\tCards are ideal for list items, info blocks, and UI sections.",
        code = "fun CardExample() {\n" + "    Card(\n" + "        modifier = Modifier\n" + "            .fillMaxWidth()\n" + "            .padding(10.dp),\n" + "        shape = RoundedCornerShape(12.dp),\n" + "        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)\n" + "    ) {\n" + "        Column(modifier = Modifier.padding(16.dp)) {\n" + "            Text(text = \"Jetpack Compose\", fontWeight = FontWeight.Bold)\n" + "            Spacer(modifier = Modifier.height(8.dp))\n" + "            Text(\"Card provides elevation, shape, and background by default.\")\n" + "        }\n" + "    }\n" + "}",
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Jetpack Compose", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Card provides elevation, shape, and background by default.")
            }
        }
    }, Example(
        title = "2\uFE0F⃣ Surfaces",
        description = "What:\n" + "Surface is a lower-level composable similar to a Card, but with more control.\n" + "It’s the foundation of most Material components and defines a background, shape, color, and elevation." + "\n✅ Notes:\n" + "\t•\tSimilar to a Card, but more flexible — you control everything (color, shape, etc.).\n" + "\t•\tGreat for custom components (e.g., toolbars, headers, cards with custom designs).\n" + "\t•\tSurfaces respect Material theme color schemes.",
        code = "@Composable\n" + "fun SurfaceExample() {\n" + "    Surface(\n" + "        modifier = Modifier\n" + "            .fillMaxWidth()\n" + "            .padding(10.dp),\n" + "        color = Color(0xFFBBDEFB),\n" + "        shadowElevation = 4.dp,\n" + "        shape = RoundedCornerShape(10.dp)\n" + "    ) {\n" + "        Text(\n" + "            text = \"This is a Surface component\",\n" + "            modifier = Modifier.padding(16.dp)\n" + "        )\n" + "    }\n" + "}",
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color(0xFFBBDEFB),
            shadowElevation = 4.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "This is a Surface component", modifier = Modifier.padding(16.dp)
            )
        }
    }, Example(
        title = "\uD83D\uDFE2 Column",
        description = "Places elements vertically (top → bottom)." + "\n✅ Use verticalArrangement to space items, horizontalAlignment for alignment. ",
        code = "@Composable\n" + "fun ColumnExample() {\n" + "    Column(\n" + "        modifier = Modifier.padding(10.dp),\n" + "        verticalArrangement = Arrangement.spacedBy(8.dp)\n" + "    ) {\n" + "        Text(\"Item 1\")\n" + "        Text(\"Item 2\")\n" + "        Text(\"Item 3\")\n" + "    }\n" + "}",
    ) {
        Column(
            modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }
    }, Example(
        title = "\uD83D\uDD35 Row",
        description = "Places elements horizontally (left → right)." + "\n✅ Use Arrangement to control spacing and Alignment for vertical centering.",
        code = "@Composable\n" + "fun RowExample() {\n" + "    Row(\n" + "        modifier = Modifier.fillMaxWidth(),\n" + "        horizontalArrangement = Arrangement.SpaceBetween\n" + "    ) {\n" + "        Text(\"Start\")\n" + "        Text(\"End\")\n" + "    }\n" + "}",
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Start")
            Text("End")
        }
    }, Example(
        title = "\uD83D\uDFE3 Box",
        description = "Stacks elements on top of each other (like a frame or overlay)." + "\n✅ Useful for overlays, badges, or combining text + image.",
        code = "@Composable\n" + "fun BoxExample() {\n" + "    Box(modifier = Modifier.size(120.dp), contentAlignment = Alignment.Center) {\n" + "        Box(\n" + "            modifier = Modifier\n" + "                .size(100.dp)\n" + "                .background(Color.LightGray)\n" + "        )\n" + "        Text(\"Overlay\", color = Color.White)\n" + "    }\n" + "}",
    ) {
        Box(modifier = Modifier.size(120.dp), contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.LightGray)
            )
            Text("Overlay", color = Color.White)
        }
    }, Example(
        title = "\uD83D\uDFE0 LazyColumn / LazyRow",
        description = "Efficiently renders long lists (like RecyclerView)." + "✅ Only visible items are composed → highly efficient.\n" + "✅ Use for scrolling lists, feeds, or recyclers.",
        code = "@Composable\n" + "fun LazyColumnExample() {\n" + "    val items = (1..50).toList()\n" + "\n" + "    LazyColumn(\n" + "        verticalArrangement = Arrangement.spacedBy(8.dp),\n" + "        modifier = Modifier.padding(10.dp)\n" + "    ) {\n" + "        items(items) { item ->\n" + "            Card(\n" + "                modifier = Modifier.fillMaxWidth(),\n" + "                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)\n" + "            ) {\n" + "                Text(\n" + "                    text = \"Item #item\",\n" + "                    modifier = Modifier.padding(16.dp)\n" + "                )\n" + "            }\n" + "        }\n" + "    }\n" + "}",
    ) {
        val items = (1..50).toList()

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(10.dp)
                .height(height = 400.dp)
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Text(
                        text = "Item #$item", modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }, Example(
        title = "4\uFE0F⃣ Summary Notes",
        description = "Cards\n" + "\t•\tReady-made Material surface with elevation and rounded corners.\n" + "\t•\tUsed for displaying grouped content.\n" + "\n" + "Surface\n" + "\t•\tBase composable for background + elevation + shape.\n" + "\t•\tUsed to create custom container styles.\n" + "\n" + "Layout Containers\n" + "\t•\tColumn → vertical stacking.\n" + "\t•\tRow → horizontal stacking.\n" + "\t•\tBox → overlap or overlay items.\n" + "\t•\tLazyColumn / LazyRow → scrollable, efficient lists.",
        code = "",
    ) {

    }

)