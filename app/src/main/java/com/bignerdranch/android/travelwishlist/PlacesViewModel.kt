package com.bignerdranch.android.travelwishlist

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
const val TAG = "PLACES_VIEW_MODEL"
class PlacesViewModel: ViewModel() {

//The data
    private val places = mutableListOf<Place>(Place("Auckland, NZ"),
    Place("Patagonia, Chile"))

    //Function for immutable list
    fun getPlaces(): List<Place> {
        return places   // smartcast
    }

//Make addNewPlace function to add a place string that is nullable
        fun addNewPlace(place: Place, position: Int? = null): Int {
//The addNewPlace function    avoid duplicates and implement add at position
    //Returns location in the list that the new item was added,  checks for duplicates
            if (places.any { placeName -> placeName.name.uppercase() == place.name.uppercase() } ) {
                return -1
            }

//If we're not being provided a position, add it at the end
            return if (position == null) {
                places.add(place)             //Adds at the end
                places.lastIndex               //What was the last index, returns it
            } else {
                places.add(position, place)
                position
            }
    }

        fun movePlace(from: Int, to: Int) {
            val place = places.removeAt(from)
            places.add(to, place)
            Log.d(TAG, places.toString())
        }

    fun deletePlace(position: Int): Place {
        return places.removeAt(position)
    }
}