package com.example.kotlinlockin.common.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.core.net.toUri
import com.example.kotlinlockin.DummyActivity
import com.example.kotlinlockin.common.data.entity.Example

fun getOnClickIntentExamples(context: Context): List<Example> = listOf(
    Example(
        title = "1\uFE0F⃣ Open Another Activity (Explicit Intent)",
        code = "@Composable\n" +
                "fun OpenActivityExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(context, SecondActivity::class.java)\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Open Second Activity\")\n" +
                "    }\n" +
                "}",
        description = "Used to navigate between activities inside your app." +
                "\n✅ Use when:\n" +
                "You want to move to another screen/activity within the same app",
    ) {
        Button(onClick = {
            val intent = Intent(context, DummyActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Open Second Activity")
        }
    },

    Example(
        title = "2\uFE0F⃣ Open a Web Page (Implicit Intent)",
        code = "@Composable\n" +
                "fun OpenWebPageExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(\"https://developer.android.com\"))\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Open Website\")\n" +
                "    }\n" +
                "}",
        description = "Launches a browser or web app." +
                "\n✅ Use when:\n" +
                "You want to open external web links or documentation.",
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, "https://developer.android.com".toUri())
            context.startActivity(intent)
        }) {
            Text("Open Website")
        }
    },

    Example(
        title = "3\uFE0F⃣ Make a Phone Call / Dialer",
        code = "@Composable\n" +
                "fun DialPhoneExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(\"tel:9876543210\"))\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Call Now\")\n" +
                "    }\n" +
                "}",
        description = "Opens the phone dialer with a number filled in." +
                "\n✅ Use when:\n" +
                "You want to initiate a call (ACTION_DIAL is safe; ACTION_CALL needs permission).",
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_DIAL, "tel:7350427767".toUri())
            context.startActivity(intent)
        }) {
            Text("Call Now")
        }
    },

    Example(
        title = "4\uFE0F⃣ Send an Email",
        code = "@Composable\n" +
                "fun SendEmailExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(Intent.ACTION_SENDTO).apply {\n" +
                "            data = Uri.parse(\"mailto:\")\n" +
                "            putExtra(Intent.EXTRA_EMAIL, arrayOf(\"support@example.com\"))\n" +
                "            putExtra(Intent.EXTRA_SUBJECT, \"Feedback from Compose App\")\n" +
                "        }\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Send Email\")\n" +
                "    }\n" +
                "}",
        description = "Opens Gmail or mail client with details pre-filled." +
                "\n✅ Use when:\n" +
                "You want to send feedback or contact via email.\n",
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "mailto:".toUri()
                putExtra(Intent.EXTRA_EMAIL, arrayOf("support@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Feedback from Compose App")
            }
            context.startActivity(intent)
        }) {
            Text("Send Email")
        }
    },
    Example(
        title = "5\uFE0F⃣ Open a Location in Maps",
        code = "@Composable\n" +
                "fun OpenLocationExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val gmmIntentUri = Uri.parse(\"geo:37.7749,-122.4194?q=San+Francisco\")\n" +
                "        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)\n" +
                "        mapIntent.setPackage(\"com.google.android.apps.maps\")\n" +
                "        context.startActivity(mapIntent)\n" +
                "    }) {\n" +
                "        Text(\"Open Location\")\n" +
                "    }\n" +
                "}",
        description = "✅ Use when:\n" +
                "You want to show a location or address in Google Maps.",
    ) {
        Button(onClick = {
            val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?q=San+Francisco")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)
        }) {
            Text("Open Location")
        }
    },
    Example(
        title = "6\uFE0F⃣ Open Camera App",
        code = "@Composable\n" +
                "fun OpenCameraExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Open Camera\")\n" +
                "    }\n" +
                "}",
        description = "✅ Use when:\n" +
                "You want to capture an image (for custom camera, use CameraX).",
    ) {
        Button(onClick = {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            context.startActivity(intent)
        }) {
            Text("Open Camera")
        }
    },
    Example(
        title = " 7\uFE0F⃣ Pick an Image from Gallery",
        code = "@Composable\n" +
                "fun PickImageExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Pick Image\")\n" +
                "    }\n" +
                "}",
        description = "✅ Use when:\n" +
                "User needs to select a photo from gallery.",
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            context.startActivity(intent)
        }) {
            Text("Pick Image")
        }
    },
    Example(
        title = "8\uFE0F⃣ Open YouTube or a Video Link",
        code = "@Composable\n" +
                "fun OpenYouTubeExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(\"https://www.youtube.com/watch?v=ekB0w7tkG7k\"))\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Play Video\")\n" +
                "    }\n" +
                "}",
        description = "✅ Use when:\n" +
                "You want to open external apps like YouTube, Spotify, etc.",
    ) {
        Button(onClick = {
            val intent = Intent(
                Intent.ACTION_VIEW,
                "https://www.youtube.com/watch?v=ekB0w7tkG7k".toUri()
            )
            context.startActivity(intent)
        }) {
            Text("Play Video")
        }
    },
    Example(
        title = "9\uFE0F⃣ Share Text / Link",
        code = "@Composable\n" +
                "fun ShareTextExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(Intent.ACTION_SEND).apply {\n" +
                "            type = \"text/plain\"\n" +
                "            putExtra(Intent.EXTRA_TEXT, \"Check out this awesome Compose tutorial!\")\n" +
                "        }\n" +
                "        context.startActivity(Intent.createChooser(intent, \"Share via\"))\n" +
                "    }) {\n" +
                "        Text(\"Share Text\")\n" +
                "    }\n" +
                "}",
        description = "✅ Use when:\n" +
                "You want to share content to other apps (WhatsApp, Gmail, etc.).",
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out this awesome Compose tutorial!")
            }
            context.startActivity(Intent.createChooser(intent, "Share via"))
        }) {
            Text("Share Text")
        }
    },
    Example(
        title = "10\uFE0F⃣ Open Settings",
        code = "@Composable\n" +
                "fun OpenSettingsExample(context: Context = LocalContext.current) {\n" +
                "    Button(onClick = {\n" +
                "        val intent = Intent(android.provider.Settings.ACTION_SETTINGS)\n" +
                "        context.startActivity(intent)\n" +
                "    }) {\n" +
                "        Text(\"Open Settings\")\n" +
                "    }\n" +
                "}",
        description = "✅ Use when:\n" +
                "You want to send the user to device settings, Wi-Fi, or app permissions.\n",
    ) {
        Button(onClick = {
            val intent = Intent(android.provider.Settings.ACTION_SETTINGS)
            context.startActivity(intent)
        }) {
            Text("Open Settings")
        }
    }


)