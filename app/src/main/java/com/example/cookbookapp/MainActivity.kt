package com.example.cookbookapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE


class MainActivity : AppCompatActivity(), CookbookListFragment.Listener   {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun itemClicked(id: Long) {
        val fragmentContainer : View? = findViewById(R.id.fragment_container)
        if(fragmentContainer != null){
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            val details: CookbookDetailFragment = CookbookDetailFragment()
            details.setDish(id)
            transaction.replace(R.id.fragment_container, details)
            transaction.setTransition(TRANSIT_FRAGMENT_FADE)
            transaction.addToBackStack(null)
            transaction.commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DISH_ID, id.toInt())
            startActivity(intent)
        }
    }
}