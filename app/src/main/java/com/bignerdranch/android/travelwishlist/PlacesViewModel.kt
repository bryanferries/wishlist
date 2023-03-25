package com.bignerdranch.android.travelwishlist

import androidx.lifecycle.ViewModel

class PlacesViewModel: ViewModel() {

    private val placeNames = mutableListOf<String>("Auckland", "Patagonia", "New Hope", "Crystal")

    fun getPlaces(): List<String> {
        return placeNames   // smartcast
    }
        fun addNewPlace(place: String, position: Int? = null): Int {

            if (placeNames.any { placeName -> placeName.uppercase() == placeName.uppercase() } ) {
                return -1
            }

            return if (position == null) {
                placeNames.add(place)
                placeNames.lastIndex
            } else {
                placeNames.add(position, place)
                position
            }
    }
}