package com.mzulsept.zulrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mzulsept.zulrestapi.fragment.EventFragment
import com.mzulsept.zulrestapi.fragment.KategoriFragment
import com.mzulsept.zulrestapi.fragment.PostsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView  // Mengganti import ini

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fragment awal
        val postFragment = PostsFragment()
        val kategoriFragment = KategoriFragment()
        val eventFragment = EventFragment()

        makeCurrentFragment(postFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)  // Mengganti ini
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuPost -> makeCurrentFragment(postFragment)
                R.id.menuKategori -> makeCurrentFragment(kategoriFragment)
                R.id.menuEvent -> makeCurrentFragment(eventFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }
}

