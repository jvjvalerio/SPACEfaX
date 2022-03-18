package com.example.spacefax

interface Contract {

    interface View {
        fun changeAppearance(image: Int, randomFact: String)
    }

    interface Model {
        fun getRandomImageID(): Int
        fun getRandomFact(): String
    }

    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}