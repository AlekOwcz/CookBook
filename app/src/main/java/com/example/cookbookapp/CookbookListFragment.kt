package com.example.cookbookapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CookbookListFragment(val dishType: Int = 0) : Fragment() {
    interface Listener {
        fun itemClicked(id: Long, type: Int)
    }

    private var listener: Listener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? Listener
    }

//    override fun onListItemClick(listView: ListView, itemView: View, position: Int, id: Long) {
//        listener?.itemClicked(id, dishType)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedinstanceState: Bundle?
    ): View? {
        var dishRecycler: RecyclerView? = null
        var adapter: CaptionedImagesAdapter? = null
        if (dishType == 0){
//            val names = arrayOfNulls<String>(Dish.pastaDishes.size)
//            for (i in names.indices) {
//                names[i] = Dish.pastaDishes[i].getName()
//            }
            dishRecycler = inflater.inflate(R.layout.fragment_cookbook_list, container, false) as RecyclerView
            val dishNames: Array<String> = Array(DishCard.dishesPasta.size) { i -> DishCard.dishesPasta[i].getName() }
            val dishImages = IntArray(DishCard.dishesPasta.size) { i -> DishCard.dishesPasta[i].getImageResourceId() }
            adapter = CaptionedImagesAdapter(dishNames, dishImages)
            dishRecycler.adapter = adapter
            val layoutMng = GridLayoutManager(activity, 2)
            dishRecycler.layoutManager = layoutMng
            adapter.setListener(object : CaptionedImagesAdapter.Listener {
                override fun onClick(position: Int) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DISH_ID, position)
                    intent.putExtra(DetailActivity.EXTRA_DISH_TYPE, 0)

                    activity?.startActivity(intent)
                }
            })
        } else {
            val names = arrayOfNulls<String>(Dish.nonPasta.size)
            for (i in names.indices) {
                names[i] = Dish.nonPasta[i].getName()
            }
            dishRecycler = inflater.inflate(R.layout.fragment_cookbook_list, container, false) as RecyclerView
            val dishNames: Array<String> = Array(DishCard.dishesNonPasta.size) { i -> DishCard.dishesNonPasta[i].getName() }
            val dishImages: IntArray = IntArray(DishCard.dishesNonPasta.size) { i -> DishCard.dishesNonPasta[i].getImageResourceId() }
            adapter = CaptionedImagesAdapter(dishNames, dishImages)
            dishRecycler.adapter = adapter
            val layoutMng: GridLayoutManager = GridLayoutManager(activity, 2)
            dishRecycler.layoutManager = layoutMng
            adapter.setListener(object : CaptionedImagesAdapter.Listener {
                override fun onClick(position: Int) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DISH_ID, position)
                    intent.putExtra(DetailActivity.EXTRA_DISH_TYPE, 1)

                    activity?.startActivity(intent)
                }
            })
        }



        return dishRecycler
    }

}
