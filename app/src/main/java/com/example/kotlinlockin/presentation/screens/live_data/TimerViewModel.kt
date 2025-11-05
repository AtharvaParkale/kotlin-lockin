package com.example.kotlinlockin.presentation.screens.live_data

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    private var timer: CountDownTimer? = null
    private val _seconds = MutableLiveData(10) // initial value = 10 seconds
    val seconds: LiveData<Int> get() = _seconds

    fun startTimer() {
        timer?.cancel() // cancel any previous timer
        timer = object : CountDownTimer(10_000, 1_000) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = (millisUntilFinished / 1000).toInt()
                _seconds.value = timeLeft
            }

            override fun onFinish() {
                _seconds.value = 0
            }
        }.start()
    }

    fun stopTimer() {
        timer?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel() // avoid leaks
    }
}