package com.example.android_application_kotlin.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_application_kotlin.adapters.HobbiesAdapter
import com.example.android_application_kotlin.R
import com.example.android_application_kotlin.models.Supplier

class HobbiesActivity : ComponentActivity() {
    companion object {
        val TAG: String = HobbiesActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecycleView()
    }

    private fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        val recyclerViewVar = findViewById<RecyclerView>(R.id.recycleView)
        val adapter = HobbiesAdapter(this, Supplier.hobbies)

        recyclerViewVar.layoutManager = layoutManager
        recyclerViewVar.adapter = adapter
    }
}