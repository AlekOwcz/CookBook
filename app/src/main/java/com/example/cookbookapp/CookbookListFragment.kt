package com.example.cookbookapp

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment


class CookbookListFragment : ListFragment() {
    interface Listener {
        fun itemClicked(id: Long)
    }

    private var listener: Listener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? Listener
    }

    override fun onListItemClick(listView: ListView, itemView: View, position: Int, id: Long) {
        listener?.itemClicked(id)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedinstanceState: Bundle?
    ): View? {
        val names = arrayOfNulls<String>(Dish.dishes.size)
        for (i in names.indices) {
            names[i] = Dish.dishes.get(i).getName()
        }
        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
            inflater.context, R.layout.simple_list_item_1, names
        )
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedinstanceState)
    }

}
