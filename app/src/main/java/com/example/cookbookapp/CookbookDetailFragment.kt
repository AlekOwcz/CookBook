package com.example.cookbookapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class CookbookDetailFragment : Fragment() {
    private var dishID: Long = 0
    fun setDish(id: Long) {
        this.dishID = id
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null){
            dishID = savedInstanceState.getLong("dishId")
        }else{
            val stopper = StopperFragment()
            val ft = childFragmentManager.beginTransaction()
            ft.add(R.id.stopper_container, stopper)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cookbook_detail, container, false)
    }
    override fun onStart() {
        super.onStart()
        val view = view
        if (view != null) {
            val title = view.findViewById<TextView>(R.id.textTitle)
            val dish: Dish = Dish.dishes[dishID.toInt()]
            title.text = dish.getName()
            val description = view.findViewById<TextView>(R.id.textDescription)
            description.text = dish.getRecipe()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("dishId", dishID)
    }

}