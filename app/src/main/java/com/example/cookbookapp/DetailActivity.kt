package com.example.cookbookapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar


class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DISH_ID = "id"
        const val EXTRA_DISH_TYPE = "type"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val frag: CookbookDetailFragment =
            supportFragmentManager.findFragmentById(R.id.detail_frag) as CookbookDetailFragment

        val dishID = intent.extras?.getInt(EXTRA_DISH_ID)
        val dishType = intent.extras?.getInt(EXTRA_DISH_TYPE)

        if (dishID != null && dishType != null) {
            frag.setDish(dishID.toLong(), dishType)
        }


    }

    fun onClickDone(view: View) {
        val text = "Ingredients sent!"
        val duration = Snackbar.LENGTH_SHORT
        val snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration)
        snackbar.setAction("WAIT NO!") {
            val toast = Toast.makeText(this, "Nevermind then!", Toast.LENGTH_SHORT)
            toast.show()
        }
        snackbar.show()
    }
}