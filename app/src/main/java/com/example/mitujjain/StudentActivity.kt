package com.example.mitujjain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class StudentActivity : AppCompatActivity() {


    private lateinit var dbref :DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)


        userRecyclerView=findViewById(R.id.userList)
        userRecyclerView.layoutManager=LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)


        userArrayList= arrayListOf<User>()


       //dbref = FirebaseDatabase.getInstance().getReference("Users")

      //dbref.setValue(User("Yashar Khan", "Ranchi Jharkhand","7"))


        getUserData()
    }




    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Users")
        dbref.addValueEventListener(object:ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){

                        val user =userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)
                    }

                    val adapter =MyAdapter(userArrayList)
                    userRecyclerView.adapter = adapter
                }


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

//
    }

}
