package com.example.mitujjain

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    lateinit var adapters:Adapters
    private lateinit var rv: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    var list= mutableListOf<Int>()

        list.add(R.drawable.coding)
        list.add(R.drawable.zest4fest)
        list.add(R.drawable.techexpo)


        rv=findViewById(R.id.viewpager)
        adapters =Adapters(this)
        adapters.setContentList(list)


        rv.adapter = adapters








        val gal: Button = findViewById(R.id.gallery)
        gal.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }



        val button: Button = findViewById(R.id.openmap)
        button.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }


        val teach: Button = findViewById(R.id.teacher)
        teach.setOnClickListener {
            val intent = Intent(this, TeachersActivity::class.java)
            startActivity(intent)
        }

        val stu : Button = findViewById(R.id.student)
        stu.setOnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            startActivity(intent)
        }

        val abu: Button = findViewById(R.id.about)
        abu.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }


    }
}


