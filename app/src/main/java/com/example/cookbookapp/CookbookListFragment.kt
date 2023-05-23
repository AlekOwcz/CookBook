package com.example.cookbookapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CookbookListFragment(val dishType: Int = 0) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedinstanceState: Bundle?
    ): View {
        var dishRecycler: RecyclerView? = null
        var adapter: CaptionedImagesAdapter? = null
        if (dishType == 0){
            dishRecycler = inflater.inflate(R.layout.fragment_cookbook_list, container, false) as RecyclerView
            val dishNames: Array<String> = Array(DishCard.dishesPasta.size) { i -> DishCard.dishesPasta[i].getName() }
            val dishImages = IntArray(DishCard.dishesPasta.size) { i -> DishCard.dishesPasta[i].getImageResourceId() }
            adapter = CaptionedImagesAdapter(dishNames, dishImages)
            dishRecycler.adapter = adapter
            val layoutMng = GridLayoutManager(activity, 2)
            dishRecycler.layoutManager = layoutMng
            adapter.setListener(object : CaptionedImagesAdapter.Listener {
                override fun onClick(position: Int) {
                    val fragmentContainer : View? = requireActivity().findViewById(R.id.fragment_container)
                    if(fragmentContainer != null){
                        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                        val details = CookbookDetailFragment()
                        details.setDish(position.toLong(), 0)
                        details.setUpData()
                        transaction.replace(R.id.fragment_container, details)
                        transaction.setTransition(TRANSIT_FRAGMENT_FADE)
                        transaction.addToBackStack(null)
                        transaction.commit()
                        details.setUpData()
                    } else {
                        val intent = Intent(activity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_DISH_ID, position)
                        intent.putExtra(DetailActivity.EXTRA_DISH_TYPE, 0)
                        activity?.startActivity(intent)
                    }
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
                    val fragmentContainer : View? = requireActivity().findViewById(R.id.fragment_container)
                    if(fragmentContainer != null){
                        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                        val details = CookbookDetailFragment()
                        details.setDish(position.toLong(), 1)
                        details.setUpData()
                        transaction.replace(R.id.fragment_container, details)
                        transaction.setTransition(TRANSIT_FRAGMENT_FADE)
                        transaction.addToBackStack(null)
                        transaction.commit()
                    } else {
                        val intent = Intent(activity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_DISH_ID, position)
                        intent.putExtra(DetailActivity.EXTRA_DISH_TYPE, 1)

                        activity?.startActivity(intent)
                    }
                }
            })
        }
        return dishRecycler
    }

}
