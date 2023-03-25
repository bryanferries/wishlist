package com.bignerdranch.android.travelwishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceRecyclerAdapter(private val places: List<String>):
    RecyclerView.Adapter<PlaceRecyclerAdapter.ViewHolder>() {

        class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
            fun bind(place: String) {
                val placeNameTextView: TextView = view.findViewById(R.id.place_name)
                placeNameTextView.text = place
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.place_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)

    }

    //how many items in list
    override fun getItemCount(): Int {
        return places.size
    }
}