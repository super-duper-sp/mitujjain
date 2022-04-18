package com.example.mitujjain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView



class MyAdapter(private val userlist: ArrayList<User>): RecyclerView.Adapter <MyAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentitem=userlist[position]

        holder.name.text=currentitem.name
        holder.branch.text=currentitem.branch
        holder.year.text=currentitem.year
    }

    override fun getItemCount(): Int {
        return userlist.size
    }



    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    val name :TextView= itemView.findViewById(R.id.studentName)
    val branch :TextView= itemView.findViewById(R.id.studentBranch)
    val year :TextView= itemView.findViewById(R.id.studentYear)
    }



}