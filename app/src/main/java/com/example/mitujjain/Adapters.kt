package com.example.mitujjain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class Adapters(val context:Context): RecyclerView.Adapter <Adapters.CViewHolder>() {

 lateinit var list:List<Int>

 fun setContentList(list:List<Int>){
     this.list=list
 }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.list_image, parent, false)
        return CViewHolder(View)
    }

    override fun onBindViewHolder(holder: CViewHolder, position: Int) {
      holder.image.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class CViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image=itemView.findViewById<RoundedImageView>(R.id.list_item_image)
    }

}