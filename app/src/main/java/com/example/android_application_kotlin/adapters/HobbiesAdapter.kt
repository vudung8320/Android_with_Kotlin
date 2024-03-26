package com.example.android_application_kotlin.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android_application_kotlin.models.Hobby
import com.example.android_application_kotlin.R

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // inflate --> return this layout (R.layout.list_item) as a view
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    // Suggest is responsible for binding all data to the view that are being created
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHobby!!.title + " Clicked !", Toast.LENGTH_SHORT)
                    .show()
            }

            itemView.findViewById<ImageView>(R.id.imgShare).setOnClickListener {
                val message: String = "My hobby is: " + currentHobby!!.title
                val intent = Intent()

                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent, "Share to app:"))
            }
        }

        fun setData(hobby: Hobby?, pos: Int) {
            itemView.findViewById<TextView>(R.id.txvTitle).text = hobby!!.title

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}