package com.example.cookbookapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var shareActionProvider: ShareActionProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.nav_open_drawer,
            R.string.nav_close_drawer
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)



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

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        when(item.itemId){
            R.id.drawer_alarm -> MediaPlayer.create(this, R.raw.alarm5).start()
            R.id.drawer_call -> {
                Toast.makeText(this, "Calling support...", Toast.LENGTH_SHORT).show()
                MediaPlayer.create(this, R.raw.skype).start()
            }
            R.id.drawer_more -> {
                val imageView = ImageView(this)
                imageView.setImageResource(R.drawable.fate)

                val params = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )

                params.addRule(RelativeLayout.CENTER_IN_PARENT)

                drawer.addView(imageView, params)

                val fadeIn = AlphaAnimation(0f, 1f)
                fadeIn.duration = 500

                val fadeOut = AlphaAnimation(1f, 0f)
                fadeOut.startOffset = 500
                fadeOut.duration = 500

                val animation = AnimationSet(false)
                animation.addAnimation(fadeIn)
                animation.addAnimation(fadeOut)

                imageView.startAnimation(animation)

                Handler().postDelayed({
                    drawer.removeView(imageView)
                }, 1000)
                MediaPlayer.create(this, R.raw.boom).start()
            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return false
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
                val toastMsg = "You're not ready for this... We wish you good luck in using this cookbook!\n"
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show()
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