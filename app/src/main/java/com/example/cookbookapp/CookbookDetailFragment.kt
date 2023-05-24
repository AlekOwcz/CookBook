package com.example.cookbookapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar


class CookbookDetailFragment : Fragment() {
    private var dishID: Long = 0
    private var dishType: Int = 0
    private var toolbar: Toolbar? = null
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar!!.title = ""
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onStart() {
        super.onStart()
        setUpData()
    }
    fun setUpData(){
        val view = view
        if (view != null) {
            val dish: Dish?
            if(dishType == 0) dish = Dish.pastaDishes[dishID.toInt()]
            else dish = Dish.nonPasta[dishID.toInt()]
            toolbar!!.title = dish.getName()
            val img_name = dish.getName().lowercase().replace(' ','_')
            val imgsrc = view.findViewById<ImageView>(R.id.dish_image)
            imgsrc.setImageResource(0)
            val drawable = resources.getIdentifier(img_name,"drawable", requireContext().packageName)
            if (drawable != 0) imgsrc.setImageResource(drawable)

            val description = view.findViewById<TextView>(R.id.textDescription)
            description.text = dish.getRecipe()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("dishId", dishID)
    }

}