package com.example.kotlinlockin.common.data

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.kotlinlockin.common.data.entity.Example

fun getIconsAndImagesExamples(): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ What are Images and Icons in Jetpack Compose",
        code = "",
        description = "Jetpack Compose lets you easily load and display:\n" +
                "\t•\tStatic images from resources (painterResource)\n" +
                "\t•\tRemote images from the internet (using Coil)\n" +
                "\t•\tVector icons using the Icon() composable\n" +
                "\n" +
                "You can style them with modifiers, shapes, borders, and sizes — like any other composable.",
    ) {

    },
    Example(
        title = "2\uFE0F⃣ Displaying a Local Image (from drawable folder)",
        code = "@Composable\n" +
                "fun LocalImageExample() {\n" +
                "    Image(\n" +
                "        painter = painterResource(id = R.drawable.sample_image),\n" +
                "        contentDescription = \"Sample Image\",\n" +
                "        modifier = Modifier\n" +
                "            .size(150.dp)\n" +
                "            .clip(RoundedCornerShape(12.dp)),\n" +
                "        contentScale = ContentScale.Crop\n" +
                "    )\n" +
                "}",
        description = "✅ Explanation:\n" +
                "\t•\tpainterResource() loads an image from the res/drawable folder.\n" +
                "\t•\tcontentDescription improves accessibility.\n" +
                "\t•\tContentScale.Crop fills the box by cropping edges if needed.\n" +
                "\t•\tclip() rounds the corners.",
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_menu_report_image),
            contentDescription = "Sample Image",
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    },
    Example(
        title = "3\uFE0F⃣ Displaying Network Images (using Coil)" +
                "\n=================================" +
                "\n  AsyncImage(\n" +
                "        model = \"https://picsum.photos/300/200\",\n" +
                "        contentDescription = \"Random Image\",\n" +
                "        modifier = Modifier\n" +
                "            .fillMaxWidth()\n" +
                "            .height(200.dp)\n" +
                "            .clip(RoundedCornerShape(12.dp)),\n" +
                "        contentScale = ContentScale.Crop\n" +
                "    )",
        code = "implementation(\"io.coil-kt:coil-compose:2.4.0\")",
        description = "Add dependency in build.gradle" +
                "✅ Explanation:\n" +
                "\t•\tAsyncImage from Coil automatically handles image downloading and caching.\n" +
                "\t•\tmodel is the image URL.\n" +
                "\t•\tSupports placeholders and error images if you want to show defaults.",
    ) {
        AsyncImage(
            model = "https://picsum.photos/300/200",
            contentDescription = "Random Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    },
    Example(
        title = "4\uFE0F⃣ Using Placeholders and Error Images with Coil",
        code = "@Composable\n" +
                "fun CoilImageWithPlaceholder() {\n" +
                "    AsyncImage(\n" +
                "        model = \"https://wrong-url.com/image.jpg\",\n" +
                "        contentDescription = null,\n" +
                "        placeholder = painterResource(R.drawable.placeholder),\n" +
                "        error = painterResource(R.drawable.error_image),\n" +
                "        contentScale = ContentScale.Crop,\n" +
                "        modifier = Modifier\n" +
                "            .size(150.dp)\n" +
                "            .clip(RoundedCornerShape(8.dp))\n" +
                "    )\n" +
                "}",
        description = "✅ Explanation:\n" +
                "\t•\tIf the URL fails, the error image shows.\n" +
                "\t•\tplaceholder shows while loading.\n" +
                "\t•\tGreat for real-world apps like news feeds or product cards.",
    ) {
        AsyncImage(
            model = "https://wrong-url.com/image.jpg",
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_menu_report_image),
            error = painterResource(R.drawable.stat_notify_error),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    },
    Example(
        title = "5\uFE0F⃣ Styling Images",
        code = " Image(\n" +
                "        painter = painterResource(R.drawable.sample_image),\n" +
                "        contentDescription = null,\n" +
                "        modifier = Modifier\n" +
                "            .size(180.dp)\n" +
                "            .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))\n" +
                "            .padding(4.dp)\n" +
                "            .clip(RoundedCornerShape(16.dp)),\n" +
                "        contentScale = ContentScale.Crop\n" +
                "    )",
        description = "✅ Explanation:\n" +
                "\t•\tYou can add borders, padding, shapes, and even click actions to any image.",
    ) {
        Image(
            painter = painterResource(R.drawable.star_on),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
                .padding(4.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
    },
    Example(
        title = "6\uFE0F⃣ Displaying Icons",
        code = "@Composable\n" +
                "fun IconExample() {\n" +
                "    Icon(\n" +
                "        imageVector = Icons.Filled.Favorite,\n" +
                "        contentDescription = \"Favorite Icon\",\n" +
                "        tint = Color.Red,\n" +
                "        modifier = Modifier.size(40.dp)\n" +
                "    )\n" +
                "}",
        description = "Icons are vector graphics — scalable and lightweight.\n" +
                "\n" +
                "Add dependency (if not already):" +
                "\n implementation(\"androidx.compose.material:material-icons-extended:1.5.3\")",
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favorite Icon",
            tint = Color.Red,
            modifier = Modifier.size(40.dp)
        )
    },
    Example(
        title = "7\uFE0F⃣ IconButton Example",
        code = "@Composable\n" +
                "fun IconButtonExample() {\n" +
                "    IconButton(onClick = { println(\"Icon Clicked\") }) {\n" +
                "        Icon(\n" +
                "            imageVector = Icons.Filled.Share,\n" +
                "            contentDescription = \"Share\",\n" +
                "            tint = Color(0xFF1565C0)\n" +
                "        )\n" +
                "    }\n" +
                "}",
        description = "✅ Explanation:\n" +
                "\t•\tIconButton adds ripple effects and proper touch area around the icon.\n" +
                "\t•\tUsed in toolbars, app bars, or cards.",
    ) {
        IconButton(onClick = { println("Icon Clicked") }) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share",
                tint = Color(0xFF1565C0)
            )
        }
    },
    Example(
        title = "8\uFE0F⃣ Combine Image and Icon (Real-world Example)",
        code = "@Composable\n" +
                "fun ImageWithPlayOverlay() {\n" +
                "    Box(modifier = Modifier.size(200.dp)) {\n" +
                "        AsyncImage(\n" +
                "            model = \"https://img.youtube.com/vi/dQw4w9WgXcQ/hqdefault.jpg\",\n" +
                "            contentDescription = \"YouTube Thumbnail\",\n" +
                "            contentScale = ContentScale.Crop,\n" +
                "            modifier = Modifier\n" +
                "                .fillMaxSize()\n" +
                "                .clip(RoundedCornerShape(10.dp))\n" +
                "        )\n" +
                "\n" +
                "        Icon(\n" +
                "            imageVector = Icons.Filled.PlayArrow,\n" +
                "            contentDescription = \"Play\",\n" +
                "            tint = Color.White,\n" +
                "            modifier = Modifier\n" +
                "                .size(50.dp)\n" +
                "                .align(Alignment.Center)\n" +
                "                .background(Color(0x88000000), CircleShape)\n" +
                "                .padding(10.dp)\n" +
                "        )\n" +
                "    }\n" +
                "}",
        description = "✅ Explanation:\n" +
                "\t•\tBox lets you stack composables.\n" +
                "\t•\tAsyncImage shows the thumbnail.\n" +
                "\t•\tIcon overlays a centered play symbol (like YouTube preview).",
    ) {
        Box(modifier = Modifier.size(200.dp)) {
            AsyncImage(
                model = "https://img.youtube.com/vi/dQw4w9WgXcQ/hqdefault.jpg",
                contentDescription = "YouTube Thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
            )

            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
                    .background(Color(0x88000000), CircleShape)
                    .padding(10.dp)
            )
        }
    },
    Example(
        title = "\uD83E\uDDE0 Summary Notes",
        code = "",
        description = "\t•\tUse Image() for local resources.\n" +
                "\t•\tUse AsyncImage() (Coil) for remote URLs.\n" +
                "\t•\tStyle with Modifier.clip, border, padding, size, background.\n" +
                "\t•\tUse ContentScale for image resizing (Crop, Fit, FillBounds).\n" +
                "\t•\tUse Icon() for vector assets.\n" +
                "\t•\tUse IconButton() for clickable icons.\n" +
                "\t•\tIcons come from material-icons-extended.",
    ) {

    },
)