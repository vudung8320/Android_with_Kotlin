package com.example.android_application_kotlin.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.android_application_kotlin.Constants
import com.example.android_application_kotlin.R
import com.example.android_application_kotlin.showToast

class SecondActivity : ComponentActivity() {

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Safe call ?.
        // Safe call with let ?.let { }

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY)
            showToast(msg.toString())

            findViewById<TextView>(R.id.txvUserMessage).text = msg
        }
    }
}