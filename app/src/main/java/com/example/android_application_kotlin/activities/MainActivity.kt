package com.example.android_application_kotlin.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.android_application_kotlin.Constants
import com.example.android_application_kotlin.R
import com.example.android_application_kotlin.showToast

class MainActivity : ComponentActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myBtn = findViewById<Button>(R.id.btnShowToast)
        val userMess = findViewById<EditText>(R.id.etUserMessage)
        val sendBtn = findViewById<Button>(R.id.btnSendMsgToNextActivity)

        myBtn.setOnClickListener {
            Log.i(TAG, "Button was clicked !")
            showToast("Button was clicked !")
        }

        sendBtn.setOnClickListener {
            val message: String = userMess.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)

            startActivity(intent)
        }

        findViewById<Button>(R.id.btnShareToOtherApps).setOnClickListener {
            val message: String = userMess.text.toString()
            val intent = Intent()

            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to app:"))
        }

        findViewById<Button>(R.id.btnRecycleViewDemo).setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)

            startActivity(intent)
        }
    }
}

