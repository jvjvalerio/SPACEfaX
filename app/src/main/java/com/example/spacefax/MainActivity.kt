package com.example.spacefax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(){

    // Initialization of fragment variable
    private var fragment: FactFragment?=null

    // override onCreate method to implement fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment = FactFragment.newInstance()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer,
                    fragment!!,
                    "factButton").commit()
        }

        // Initialization of factButton variable
        val button = findViewById<Button>(R.id.factButton)

            // setOnClickListener button to update fragment content
            button.setOnClickListener {
                fragment?.onButtonClick()
            }
    }
}
