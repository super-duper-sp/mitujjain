package com.example.mitujjain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


 class GAdapter( private val gallerylist: ArrayList<Gallerys>,val context: Context): RecyclerView.Adapter <GAdapter.GViewHolder>() {




     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        return GViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GViewHolder, position: Int) {
        val currentItem = gallerylist[position]

        holder.title.text = currentItem.title
        Glide.with(context).load(currentItem.image).into(holder.image)


    }

    override fun getItemCount(): Int {
        return gallerylist.size
    }


    class GViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.design_image)

    }


}