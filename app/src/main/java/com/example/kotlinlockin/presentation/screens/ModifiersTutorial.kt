package com.example.kotlinlockin.presentation.screens

import TopicTemplate
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlinlockin.R

@Composable
fun ModifiersTutorial() {
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp, vertical = 18.dp
        ),
        verticalArrangement = Arrangement.spacedBy(space = 20.dp),
    ) {
        ExampleOne()
        ExampleTwo()
        ExampleThree()
    }
}

@Composable
private fun ExampleOne() {
    TopicTemplate(
        topicTitle = "Example 1",
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    Color.Blue
                )
        )
        Text(
            text = "Simple Example"
        )
    }
}

@Composable
private fun ExampleTwo() {
    TopicTemplate(
        topicTitle = "Example 2",
    ) {
        Column {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .padding(20.dp)
                    .background(Color.Red)
                    .padding(20.dp)
                    .background(Color.Green)
                    .padding(20.dp)
                    .background(Color.Blue),

                )
            Box(Modifier.height(10.dp))
            Box(
                modifier = Modifier.size(200.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(20.dp)
                        .background(Color.Red)
                        .padding(20.dp)
                        .background(Color.Green)
                        .padding(20.dp)
                        .background(Color.Blue),
                    text = "Some Text",
                )
            }
        }
    }
}

@Composable
private fun ExampleThree() {
    TopicTemplate(
        topicTitle = "Example 3",
    ) {
        Text(text = "Here things broke, In first example the size was set to 200, and not changed to 100.")
        Box(Modifier.height(5.dp))
        Column {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue)
                    .size(100.dp)
            )
            Box(Modifier.height(10.dp))
            Text(text = "The size(30.dp) modifier was completely ignored!")
            Box(Modifier.height(5.dp))
            Box(Modifier.size(100.dp)) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Blue)
                        .size(30.dp)
                        .offset(30.dp, 30.dp),
                    contentDescription = null
                )
            }
            Box(Modifier.height(35.dp))
            Text(
                text = "Modifiers don’t just “set sizes” — they work with something called constraints. Think of constraints as rules about how big or small something can be.\n" + "\n" + "When you use size(200.dp), you’re not just saying “make this 200dp.” You’re saying “this MUST be exactly 200dp - no smaller, no bigger.”\n" + "\n" + "So when you later add size(100.dp), it’s trying to say “this MUST be exactly 100dp,” but it can’t, because the previous size modifier has already locked the constraints to exactly 200dp. The modifier chain continues with those constraints—they don’t change.\n" + "\n" + "It’s like if someone tells you “you must be exactly 6 feet tall” and then someone else says “you must be exactly 5 feet tall.” The second rule can’t work because you’re already locked into the first one."
            )
            Box(Modifier.height(10.dp))
            Text(
                text = "Instead of memorizing complex rules about modifier ordering, I just remember this:\n" + "\n" + "Read it naturally — most modifiers work exactly like you’d expect\n" + "First size wins — when multiple size modifiers conflict, the first one locks it in\n" + "Constraints flow down — each modifier receives constraints from the previous one and might modify them",
            )
            Box(Modifier.height(10.dp))
            Text(
                text = "Instead of memorizing complex rules about modifier ordering, I follow a simple mental model that feels natural and practical. I read modifiers as if I’m describing the layout step by step — most of them behave just as you’d expect. When multiple size-related modifiers are used, the first one takes priority and determines the size. Additionally, constraints always flow downward, meaning each modifier receives and potentially alters the constraints from the one before it. While this isn’t the most technically precise explanation of how the constraint system works, it’s the mental model that helps me reason about Compose layouts effectively in everyday development.",
            )
        }
    }
}