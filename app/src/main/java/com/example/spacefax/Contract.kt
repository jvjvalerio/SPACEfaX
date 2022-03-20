package com.example.spacefax

import android.content.Context

interface Contract {

    // Interface for updating View
    interface View {

        // Method to change activity appearance
        fun changeAppearance(image: Int, randomFact: String)

        // Method to obtain the View Context for use
        fun getViewContext(): Context
    }

    // Interface for Model
    interface Model {

        // Method to obtain a random image from the image list
        fun getRandomImageID(): Int

        // Method to obtain random fact from fact list
        fun getRandomFact(): String
    }

    // Interface to
    interface Presenter {

        // Method to be called when button is clicked
        fun onButtonClick()

        // Method to destroy lifecycle of MainActivity
        fun onDestroy()
    }
}