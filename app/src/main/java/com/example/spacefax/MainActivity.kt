package com.example.spacefax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(){
    private var fragment: FactFragment?=null

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

        val button = findViewById<Button>(R.id.factButton)
            button.setOnClickListener {
                fragment?.onButtonClick()
            }
    }
}
