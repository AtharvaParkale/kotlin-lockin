package com.example.kotlinlockin.common.data

import com.example.kotlinlockin.common.data.entity.Example

fun getAdvanceModifierExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ Modifier Chaining (Most Important Concept)",
        description = "\uD83E\uDDE0 Key Rules:\n" + "\t•\tModifier order matters ❗\n" + "\t•\tThe same modifier placed earlier or later gives different results.",
        code = "Modifier\n" + "    .padding(16.dp)\n" + "    .background(Color.Blue)\n" + "    .size(100.dp)\n" + "    .clip(RoundedCornerShape(12.dp))"
    ) {

    },
    Example(
        " 2\uFE0F⃣ clip() — Cut the shape of the composable",
        description = "\uD83E\uDDE0 Without clip()\n" + "\n" + "Image will be square.\n" + "\n" + "\uD83E\uDDE0 With clip(CircleShape)\n" + "\n" + "Image becomes circular.",
        code = "Image(\n" + "    painter = painterResource(id = R.drawable.profile),\n" + "    contentDescription = \"\",\n" + "    modifier = Modifier\n" + "        .size(120.dp)\n" + "        .clip(CircleShape)\n" + ")",
    ) {

    },
    Example(
        title = "3\uFE0F⃣ background() — Sets background behind content\n",
        description = "\uD83E\uDDE0 Order matters:\n" + "\t•\tbackground → padding = nicer yellow box\n" + "\t•\tpadding → background = yellow only around the padded area",
        code = "Text(\n" + "    \"Hello\",\n" + "    modifier = Modifier\n" + "        .background(Color.Yellow)\n" + "        .padding(8.dp)\n" + ")",
    ) {

    },
    Example(
        title = "4\uFE0F⃣ drawBehind() — Custom drawing behind the composable",
        description = "\n" + "This gives you low-level canvas access behind the content.\n" + "\n" + "Example: Draw a custom underline\n" + "\uD83E\uDDE0 drawBehind:\n" + "\t•\tDraws BEHIND content\n" + "\t•\tRuns on Canvas\n" + "\t•\tYou can draw lines, circles, shapes, etc.",
        code = "Text(\n" + "    \"Hello\",\n" + "    modifier = Modifier.drawBehind {\n" + "        val strokeWidth = 4.dp.toPx()\n" + "        drawLine(\n" + "            color = Color.Red,\n" + "            start = Offset(0f, size.height),\n" + "            end = Offset(size.width, size.height),\n" + "            strokeWidth = strokeWidth\n" + "        )\n" + "    }\n" + ")",
    ) {

    },
    Example(
        title = "5\uFE0F⃣ drawWithContent() — Draw behind AND on top of content",
        description = "",
        code = "Modifier.drawWithContent {\n" + "    drawContent()  // draw original UI\n" + "    drawRect(Color.Red.copy(alpha = 0.2f)) // overlay on top\n" + "}",
    ) {

    },
    Example(
        title = "6\uFE0F⃣ shape + background + clip combo",
        description = "Important:\n" + "\t•\tclip before background = background respects shape\n" + "\t•\tbackground then clip = big rectangle clipped later\n" + "\n" + "Correct order = clip → background → padding",
        code = "Modifier\n" + "    .clip(RoundedCornerShape(12.dp))\n" + "    .background(Color(0xFFE3F2FD))\n" + "    .padding(12.dp)",
    ) {

    },
    Example(
        title = "7\uFE0F⃣ Using chained modifiers for UI effects",
        description = "",
        code = "Image(\n" + "    painter = painterResource(id = R.drawable.profile),\n" + "    contentDescription = \"\",\n" + "    modifier = Modifier\n" + "        .size(120.dp)\n" + "        .clip(CircleShape)\n" + "        .border(3.dp, Color.Blue, CircleShape)\n" + ")",
    ) {

    },
    Example(
        title = "8\uFE0F⃣ debug Border — See Layout Boundaries",
        description = "",
        code = "Modifier.border(1.dp, Color.Red)",
    ) {

    },
    Example(
        title = "9\uFE0F⃣ Summary (Copy-Paste Notes)",
        description = "\t•\tModifiers are applied in order — order changes UI.\n" + "\t•\tclip() cuts shape of composable.\n" + "\t•\tbackground() draws behind content.\n" + "\t•\tdrawBehind() lets you draw custom canvas shapes behind.\n" + "\t•\tdrawWithContent() draws behind and in front of actual UI.\n" + "\t•\tCommon sequence: clip → background → padding.\n" + "\t•\tborder() + clip() helps create profile pics, chips, badges.\n" + "\t•\tUse border(Color.Red) for layout debugging.",
        code = "",
    ) {}
)
