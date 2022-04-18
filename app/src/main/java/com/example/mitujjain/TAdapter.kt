package com.example.mitujjain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TAdapter(private val teacherlist: ArrayList<Teachers>): RecyclerView.Adapter <TAdapter.TViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.teacher_item, parent, false)
        return TViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TViewHolder, position: Int) {
        val currentItem = teacherlist[position]

        holder.name.text = currentItem.name
        holder.since.text = currentItem.since
        holder.about.text = currentItem.about
        holder.desig.text = currentItem.desig
        holder.dept.text = currentItem.dept

    }

    override fun getItemCount(): Int {
        return teacherlist.size
    }


    class TViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.teacherName)
        val since: TextView = itemView.findViewById(R.id.teacherSince)
        val about: TextView = itemView.findViewById(R.id.teacherAbout)
        val desig: TextView = itemView.findViewById(R.id.teacherDesig)
        val dept: TextView = itemView.findViewById(R.id.teacherDept)

    }


}