package com.example.mitujjain

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        var mediaPlayer = MediaPlayer.create(this ,R.raw.sound)
        mediaPlayer.start()

        val handler = Handler()
        handler.postDelayed({
            val x = Intent(this, MainActivity::class.java)
            startActivity(x)
            finish()
        },3000)
        }



}
