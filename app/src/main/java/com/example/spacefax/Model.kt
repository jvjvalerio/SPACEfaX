package com.example.spacefax

import java.util.*

class Model : Contract.Model {
    private val spacePhotos = arrayOf(R.drawable.spacexphoto1,
                              R.drawable.spacexphoto2,
                              R.drawable.spacexphoto3,
                              R.drawable.spacexphoto4,
                              R.drawable.spacexphoto5,
                              R.drawable.spacexphoto6,
                              R.drawable.spacexphoto7,
                              R.drawable.spacexphoto8,
                              R.drawable.spacexphoto9,
                              R.drawable.spacexphoto10,
                              R.drawable.spacexphoto11,
                              R.drawable.spacexphoto12,
                              R.drawable.spacexphoto13)

    private val randomFacts = arrayOf("RandomFact1",
                              "RandomFact2",
                              "RandomFact3",
                              "RandomFact4",
                              "RandomFact5",
                              "RandomFact6",
                              "RandomFact7",
                              "RandomFact8",
                              "RandomFact9",
                              "RandomFact10",
                              "RandomFact11",
                              "RandomFact12",
                              "RandomFact13")

    override fun getRandomImageID(): Int {
            val random = Random()
            val index = random.nextInt(spacePhotos.size)
            return spacePhotos[index]
    }

    override fun getRandomFact(): String {
        val random = Random()
        val index = random.nextInt(randomFacts.size)
        return randomFacts[index]
    }

}