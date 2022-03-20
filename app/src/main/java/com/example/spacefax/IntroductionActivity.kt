package com.example.spacefax

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import com.apollographql.apollo3.ApolloClient
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class IntroductionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        // Initialization of videoView and videoButton variables
        val videoView: VideoView = findViewById(R.id.videoView)
        val videoButton = findViewById<Button>(R.id.videoButton)

        // Initialization of shared preferences variable according to documentation
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        // apolloClient for GraphQL Queries
        fun apolloClient()=
            ApolloClient.Builder().serverUrl("https://api.spacex.land/graphql/").build()

        // CoRoutine implemented specifically for querying the API
        GlobalScope.launch(Dispatchers.IO) {
            val data = apolloClient().query(SpacefaxQuery()).execute()
            val jsonString = Gson().toJson(data.data)
            editor.putString(PREF_KEY_DATA, jsonString)
            editor.apply()
        }

        // setOnClickListener for proceeding to MainActivity
        videoButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Set spacelaunch video to videoview
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.spacelaunch))

        // Start spacelaunch video upon creation of IntroductionActivity
        videoView.start()
    }
}

// Initialization of global variable to be used in the Model class
const val PREF_KEY_DATA = "PREF_KEY_DATA"