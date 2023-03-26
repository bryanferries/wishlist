package com.bignerdranch.android.travelwishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newPlaceEditText: EditText
    private lateinit var addNewPlaceButton: Button
    private lateinit var placeListRecyclerView: RecyclerView

    //reference to the adapter
    private lateinit var placesRecyclerAdapter: PlaceRecyclerAdapter

//reference to the view model
    private val placesViewModel: PlacesViewModel by lazy {
        ViewModelProvider(this).get(PlacesViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        placeListRecyclerView = findViewById(R.id.place_list)
        addNewPlaceButton = findViewById(R.id.add_new_place_button)
        newPlaceEditText = findViewById(R.id.new_place_name)

//Ask the view model for list of places, will return default data we had
        val places = placesViewModel.getPlaces()

//Initialize the places recycler adapter,  need a list of places, data will be provided to the adapter
        placesRecyclerAdapter = PlaceRecyclerAdapter(places)

//Give it a linear layout        //Then reference the activity that hosts the recycler view
        placeListRecyclerView.layoutManager = LinearLayoutManager(this)

//Set the adapter property
        placeListRecyclerView.adapter = placesRecyclerAdapter

//Connecting the button to the addNewPlace function
        addNewPlaceButton.setOnClickListener {
            addNewPlace()
        }
    }

//Called by the onClickListener addNewPlaceFUnction
    private fun addNewPlace() {

//Get rid of white space
        val name = newPlaceEditText.text.toString().trim()

//If it's empty ask them to enter a place name and modify the places view model
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter a place name", Toast.LENGTH_SHORT).show()
        } else {

//Tells that something was changed
            val positionAdded = placesViewModel.addNewPlace(name)

//If the positionAdded is -1 alert that it's a duplicate
            if (positionAdded == -1) {
                Toast.makeText(this, "You already added that place", Toast.LENGTH_SHORT).show()
            } else {

//Else notify that it was added
                placesRecyclerAdapter.notifyItemInserted(positionAdded)

//Clear the form and hide the keyboard so you can see the whole list
                clearForm()
                hideKeyboard()
            }
            placesRecyclerAdapter.notifyItemInserted(positionAdded)
        }
    }

//Fun to clear the edit text
    private fun clearForm() {
        newPlaceEditText.text.clear()
    }

//Fun to hide the keyboard
    private fun hideKeyboard() {
        this.currentFocus?.let { view ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}