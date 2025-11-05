package com.example.kotlinlockin.presentation.screens.live_data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinlockin.common.composables.TopicCardWithTitleCodeDescription

@Composable
fun TimerScreen(viewModel: TimerViewModel = viewModel()) {
    val seconds by viewModel.seconds.observeAsState(10)

    Column(
        modifier = Modifier
            .padding(20.dp),
    ) {
        TopicCardWithTitleCodeDescription(
            title = "Live data example !",
            code = "val seconds by viewModel.seconds.observeAsState(10) \u2028\u2028————————————————————\u2028\u2028" +
                    "\nclass TimerViewModel : ViewModel() {\n" +
                    "\n" +
                    "    private var timer: CountDownTimer? = null\n" +
                    "    private val _seconds = MutableLiveData(10) // initial value = 10 seconds\n" +
                    "    val seconds: LiveData<Int> get() = _seconds\n" +
                    "\n" +
                    "    fun startTimer() {\n" +
                    "        timer?.cancel() // cancel any previous timer\n" +
                    "        timer = object : CountDownTimer(10_000, 1_000) {\n" +
                    "            override fun onTick(millisUntilFinished: Long) {\n" +
                    "                val timeLeft = (millisUntilFinished / 1000).toInt()\n" +
                    "                _seconds.value = timeLeft\n" +
                    "            }\n" +
                    "\n" +
                    "            override fun onFinish() {\n" +
                    "                _seconds.value = 0\n" +
                    "            }\n" +
                    "        }.start()\n" +
                    "    }\n" +
                    "\n" +
                    "    fun stopTimer() {\n" +
                    "        timer?.cancel()\n" +
                    "    }\n" +
                    "\n" +
                    "    override fun onCleared() {\n" +
                    "        super.onCleared()\n" +
                    "        timer?.cancel() // avoid leaks\n" +
                    "    }\n" +
                    "}\n",
            description = "LiveData automatically updates the UI when data changes (_seconds.value = newValue)\n" +
                    "It enables reactive data flow between ViewModel and UI\n" +
                    "It is lifecycle-aware and updates only when the UI is active\n" +
                    "Acts as a communication bridge between ViewModel and UI\n" +
                    "Works with Compose through observeAsState for automatic recomposition (val seconds by viewModel.seconds.observeAsState(0))\n" +
                    "Supports thread-safe updates using postValue (_seconds.postValue(newValue))\n" +
                    "Helps keep logic separate from UI for cleaner architecture\n" +
                    "In mutableStateOf, you must manually change the variable for UI to recompose (var seconds by mutableStateOf(10); seconds = newValue)\n" +
                    "LiveData automatically notifies observers when its value changes (_seconds.value = 5)\n" +
                    "mutableStateOf triggers recomposition only when you explicitly assign a new value (seconds = 5)\n" +
                    "LiveData pushes updates to the UI automatically\n" +
                    "mutableStateOf requires you to manually update the state in code" +
                    "LiveData object sends updates to the activity or fragment only when it is in the active state (started or resumed). If the activity is not active, LiveData temporarily stops sending data. When the activity becomes active again, it resumes delivering updates.\n" +
                    "LiveData delivers data only when there is a change in the data and only to the active observers. Inactive observers do not receive updates until they become active again.",
        ) {
            Text(
                text = "Time left: $seconds",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(onClick = { viewModel.startTimer() }) {
                    Text("Start")
                }

                Button(onClick = { viewModel.stopTimer() }) {
                    Text("Stop")
                }
            }
        }

    }
}