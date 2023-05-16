package com.example.cookbookapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment


class CookbookListFragment(val dishType: Int = 0) : ListFragment() {
    interface Listener {
        fun itemClicked(id: Long, type: Int)
    }

    private var listener: Listener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? Listener
    }

    override fun onListItemClick(listView: ListView, itemView: View, position: Int, id: Long) {
        listener?.itemClicked(id, dishType)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedinstanceState: Bundle?
    ): View? {
        if (dishType == 0){
            val names = arrayOfNulls<String>(Dish.pastaDishes.size)
            for (i in names.indices) {
                names[i] = Dish.pastaDishes[i].getName()
            }

            val adapter = ArrayAdapter<String?>(
                inflater.context, android.R.layout.simple_list_item_1, names
            )
            listAdapter = adapter
        } else {
            val names = arrayOfNulls<String>(Dish.nonPasta.size)
            for (i in names.indices) {
                names[i] = Dish.nonPasta[i].getName()
            }

            val adapter = ArrayAdapter<String?>(
                inflater.context, android.R.layout.simple_list_item_1, names
            )
            listAdapter = adapter
        }

        return super.onCreateView(inflater, container, savedinstanceState)
    }

}
