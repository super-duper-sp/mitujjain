package com.example.mitujjain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class TeachersActivity : AppCompatActivity() {


    private lateinit var dbrf :DatabaseReference
    private lateinit var teacherRecyclerView: RecyclerView
    private lateinit var teacherArrayList: ArrayList<Teachers>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teachers)


        teacherRecyclerView=findViewById(R.id.teachersList)
        teacherRecyclerView.layoutManager=LinearLayoutManager(this)
        teacherRecyclerView.setHasFixedSize(true)


        teacherArrayList= arrayListOf<Teachers>()


        //dbref = FirebaseDatabase.getInstance().getReference("Users")

        //dbref.setValue(User("Yashar Khan", "Ranchi Jharkhand","7"))


        getUserData()
    }




    private fun getUserData() {

        dbrf = FirebaseDatabase.getInstance().getReference("Teachers")
        dbrf.addValueEventListener(object:ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for(teacherSnapshot in snapshot.children){

                        val teacher =teacherSnapshot.getValue(Teachers::class.java)
                        teacherArrayList.add(teacher!!)
                    }

                    val adapter =TAdapter(teacherArrayList)
                    teacherRecyclerView.adapter = adapter
                }


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

//
    }

}
