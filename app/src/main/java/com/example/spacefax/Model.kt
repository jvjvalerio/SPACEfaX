package com.example.spacefax

import android.content.Context
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList

class Model(context: Context?) : Contract.Model {

    // ArrayList initialization for acquired facts from the SpaceX API Query
    private val fact = ArrayList<String>()

    // Upon initialization automatically run the block of code below
    init {

        // Initialization of variables to store queried information
        val sharedPreference = context?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val jsonString = sharedPreference?.getString(PREF_KEY_DATA,"")
        val data = Gson().fromJson(jsonString,SpacefaxQuery.Data::class.java)

        // Initialization of variables for specific facts
        val ceo = data.company?.ceo
        val coo = data.company?.coo
        val cto = data.company?.cto
        val numOfEmployees = data.company?.employees
        val companyFounded = data.company?.founded
        val companySummary = data.company?.summary

        // Adds each fact to the fact ArrayList
        fact.add("Did you know? The CEO of SpaceX is $ceo")
        fact.add("Did you know? The COO of SpaceX is $coo")
        fact.add("Did you know? The CTO of SpaceX is $cto")
        fact.add("Did you know? The current number of employees at SpaceX is $numOfEmployees")
        fact.add("Did you know? SpaceX was founded on $companyFounded")
        fact.add("$companySummary")

        // Iterates through the launchesPast query for nested information
        data.launchesPast?.forEach { item->

            // Initialize a stringbuilder object to construct our string from different query variables
            val builder = StringBuilder()
            val date = item?.launch_date_local
            val rocket = item?.rocket
            val launchSite = item?.launch_site
            builder.append("Did you know? on ${date.toString().slice(0..9)} ${rocket.toString().slice(19..24)} was successfully launched from ${launchSite.toString().slice(27..48)}")
            fact.add(builder.toString())
        }

    }

    // Initialize and populate the spacePhotos array with drawables to be used in the fragment
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


    // Method to obtain a drawable from the spacePhoto array at random
    override fun getRandomImageID(): Int {
            val random = Random()
            val index = random.nextInt(spacePhotos.size)
            return spacePhotos[index]
    }

    // Method to obtain a random fact from the fact array list at random
    override fun getRandomFact(): String {
        val random = Random()
        val index = random.nextInt(fact.size)
        return fact[index]
    }
}