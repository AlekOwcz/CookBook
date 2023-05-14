package com.example.cookbookapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DISH_ID = "id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag: CookbookDetailFragment =
            supportFragmentManager.findFragmentById(R.id.detail_frag) as CookbookDetailFragment

        val dishID = intent.extras?.getInt(DetailActivity.EXTRA_DISH_ID)
        if (dishID != null) {
            frag.setDish(dishID.toLong())
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}