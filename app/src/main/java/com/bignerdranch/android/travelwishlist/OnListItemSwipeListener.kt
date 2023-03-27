package com.bignerdranch.android.travelwishlist

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

interface OnDataChangedListener {
    fun onListItemMoved(from: Int, to: Int)                     // move up and down in list
    fun onListItemDeleted(position: Int)
}


class OnListItemSwipeListener(private val onDataChangedListener: OnDataChangedListener):
    ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN,       //to reorder
    ItemTouchHelper.RIGHT      //to delete
) {

    override fun onMove(                                    //moving up and down
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,                //Reference to the viewholder
        target: RecyclerView.ViewHolder
    ): Boolean {
        val fromPosition = viewHolder.adapterPosition    //where in the list?
        val toPosition = target.adapterPosition     //where was it moved to?
        onDataChangedListener.onListItemMoved(fromPosition, toPosition)
        return true     // is the move permitted?
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        TODO("Not yet implemented")                     //swipe left and right
    }


}