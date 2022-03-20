# SPACEfaX

## ABOUT
SPACEfaX provides you with the most up to date facts on the SpaceX company, always querying the SpaceX API upon start up!

## Architecture Components
For this application we used the MVP (Model-View-Presenter) architecture:

  -A **Contract module** was created to call on the methods used to update views and retrieve necessary data.

  -Our **Presenter module** is used to update the MainActivity view.

  -The **Model module** is used to store and organize our data onto two separate arrays. One for random SpaceX photos and one for random SpaceX facts.

## Satisfaction of Architectural Requirements:

-**2 Activities**: IntroductionActivity.kt and MainActivity.kt.

-**Usage of MVP architectural pattern**: *please refer to Architecture Components section above*

-**Use of GraphQL API**: The SpaceX API was used [SpaceX API](https://api.spacex.land/graphql/).

-**Usage of at least 5 UI Components from the Android Material Design Component Library**": Multiple buttons and text fields were used.

-**The usage of SharedPreferences**": The sharedpreferences file was used to store our queried API data.

## Screenshots
<img width="382" alt="Intro ScreenShot" src="https://user-images.githubusercontent.com/3419415/159167702-1a6eaee2-0796-4004-8b8b-6fa60f8eb891.png"> <img width="381" alt="Facts Screenshot" src="https://user-images.githubusercontent.com/3419415/159167716-5f4b4206-e9b5-4321-bf11-561f6c2a317b.png">

