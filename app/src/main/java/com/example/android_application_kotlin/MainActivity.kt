package com.example.android_application_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myBtn = findViewById<Button>(R.id.btnShowToast)
        val userMess = findViewById<EditText>(R.id.etUserMessage)
        val sendBtn = findViewById<Button>(R.id.btnSendMsgToNextActivity)

        myBtn.setOnClickListener {
            Log.i("Main Activity", "Button was clicked !")
            Toast.makeText(this, "Button was clicked !", Toast.LENGTH_SHORT).show()
        }

        sendBtn.setOnClickListener {
            val message: String = userMess.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("user_message", message)
            startActivity(intent)
        }
    }
}

