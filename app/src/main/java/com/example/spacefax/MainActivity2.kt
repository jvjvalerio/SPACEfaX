package com.example.spacefax

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val videoView : VideoView = findViewById(R.id.videoView)
        val videoButton = findViewById<Button>(R.id.videoButton)

        videoButton.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.spacelaunch))
        videoView.requestFocus()
        videoView.start()
    }


}