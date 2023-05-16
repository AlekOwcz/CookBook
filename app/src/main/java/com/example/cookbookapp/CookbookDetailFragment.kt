package com.example.cookbookapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class CookbookDetailFragment : Fragment() {
    private var dishID: Long = 0
    private var dishType: Int = 0

    fun setDish(id: Long, type: Int) {
        this.dishID = id
        this.dishType = type
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
            val title = requireActivity().findViewById<Toolbar>(R.id.toolbar)
            val dish: Dish?
            if(dishType == 0) dish = Dish.pastaDishes[dishID.toInt()]
            else dish = Dish.nonPasta[dishID.toInt()]
            title.title = dish.getName().toString()
            val description = view.findViewById<TextView>(R.id.textDescription)
            description.text = dish.getRecipe()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("dishId", dishID)
    }

}