package com.example.mitujjain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class GalleryActivity : AppCompatActivity() {


    private lateinit var dbref :DatabaseReference
    private lateinit var galleryRecyclerView: RecyclerView
    private lateinit var galleryArrayList: ArrayList<Gallerys>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)


        galleryRecyclerView=findViewById(R.id.galleryList)
        galleryRecyclerView.layoutManager=LinearLayoutManager(this)
        galleryRecyclerView.setHasFixedSize(true)


        galleryArrayList= arrayListOf<Gallerys>()


        //dbref = FirebaseDatabase.getInstance().getReference("Users")

        //dbref.setValue(User("Yashar Khan", "Ranchi Jharkhand","7"))


        getUserData()
    }




    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Gallerys")
        dbref.addValueEventListener(object:ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for(gallerySnapshot in snapshot.children){

                        val gallery =gallerySnapshot.getValue(Gallerys::class.java)
                        galleryArrayList.add(gallery!!)
                    }

                    val adapter =GAdapter(galleryArrayList,this@GalleryActivity)
                    galleryRecyclerView.adapter = adapter
                }


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

//
    }

}
