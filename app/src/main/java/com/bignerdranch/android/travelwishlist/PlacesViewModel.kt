package com.bignerdranch.android.travelwishlist

import androidx.lifecycle.ViewModel

class PlacesViewModel: ViewModel() {

//The data
    private val placeNames = mutableListOf<String>("Auckland", "Patagonia", "New Hope", "Crystal")

    //Function for immutable list
    fun getPlaces(): List<String> {
        return placeNames   // smartcast
    }

//Make addNewPlace function to add a place string that is nullable
        fun addNewPlace(place: String, position: Int? = null): Int {
//The addNewPlace function    avoid duplicates and implement add at position
    //Returns location in the list that the new item was added,  checks for duplicates
            if (placeNames.any { placeName -> placeName.uppercase() == placeName.uppercase() } ) {
                return -1
            }

//If we're not being provided a position, add it at the end
            return if (position == null) {
                placeNames.add(place)             //Adds at the end
                placeNames.lastIndex               //What was the last index, returns it
            } else {
                placeNames.add(position, place)
                position
            }
    }
}