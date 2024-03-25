package com.example.android_application_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}