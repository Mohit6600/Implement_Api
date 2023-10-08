package com.example.marvel_demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_demo.R
import com.example.marvel_demo.retrofit.response.marvelResponse.MarvelResponse
import com.example.marvel_demo.retrofit.response.marvelResponse.Superhero

class MarvelAdapter(private val context: Context, val list:ArrayList<Superhero>):RecyclerView.Adapter<MarvelAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val image:ImageView = itemView.findViewById(R.id.image)
        val name:TextView = itemView.findViewById(R.id.name)
        val power:TextView = itemView.findViewById(R.id.power)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.marvel_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.name.text = list.get(position).name
        holder.power.text = list.get(position).power

        Glide.with(context).load(list.get(position).url).into(holder.image)


    }
}