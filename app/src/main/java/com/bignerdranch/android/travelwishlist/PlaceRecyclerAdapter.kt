package com.bignerdranch.android.travelwishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//Constructor
class PlaceRecyclerAdapter(private val places: List<String>):

    //subclass of recyclerview
    RecyclerView.Adapter<PlaceRecyclerAdapter.ViewHolder>() {

//sublcass,  using superclass of all the view
        class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
            fun bind(place: String) {
                val placeNameTextView: TextView = view.findViewById(R.id.place_name)
                placeNameTextView.text = place
            }

    //How many items in list?

        }
//called by the recycler view to create as many view holders that are needed to display the list on screen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.place_list_item, parent, false)
        return ViewHolder(view)
    }

    //Bind the view holder with data for a specific position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)
    }
//Get the data that should be displayed in a specific position


    //how many items in list
    override fun getItemCount(): Int {
        return places.size
    }
}