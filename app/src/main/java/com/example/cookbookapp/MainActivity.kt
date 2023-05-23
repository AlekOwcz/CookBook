package com.example.cookbookapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.appcompat.widget.ShareActionProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private var shareActionProvider: ShareActionProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val viewPag: ViewPager2 = findViewById(R.id.pager)
        val adapter = CookbookPagerAdapter(this)

        val topFrag = TopFragment()
        val frag1 = CookbookListFragment(0)
        val frag2 = CookbookListFragment(1)

        adapter.addFragment(topFrag)
        adapter.addFragment(frag1)
        adapter.addFragment(frag2)
        adapter.setTitle(0, resources.getText(R.string.home_tab))
        adapter.setTitle(1, resources.getText(R.string.cat1_tab))
        adapter.setTitle(2, resources.getText(R.string.cat2_tab))
        viewPag.adapter = adapter

        val tabLayout: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabLayout, viewPag) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        val shareItem = menu.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(shareItem) as ShareActionProvider
        setShareActionIntent("Pien")

        return super.onCreateOptionsMenu(menu)
    }
    private fun setShareActionIntent(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        shareActionProvider!!.setShareIntent(intent)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_info -> {
                Toast.makeText(this, "Welcome to the greatest cooking book that has ever existed! Pick your favorite recipe and cook to your hearts desire!", Toast.LENGTH_LONG).show()
                MediaPlayer.create(this, R.raw.alarm3).start()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
    fun onClickDone(view: View) {
        val text = "Ingredients sent!"
        val duration = Snackbar.LENGTH_SHORT
        val snackbar = Snackbar.make(findViewById(R.id.fragment_container), text, duration)
        snackbar.setAction("WAIT NO!") {
            val toast = Toast.makeText(this, "Nevermind then!", Toast.LENGTH_SHORT)
            toast.show()
        }
        snackbar.show()
    }
}