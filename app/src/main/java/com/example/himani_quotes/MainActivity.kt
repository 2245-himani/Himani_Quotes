package com.example.himani_quotes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.himani_quotes.databinding.ActivityMainBinding
import com.example.soulscript.Fragment.Home_Fragment
import com.example.soulscript.Fragment.LikeAdd_Fragment
import com.example.soulscript.Fragment.ProfileFragment

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

// Save Dark mode to Refresh app in sharedPreferences
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("settings", Context.MODE_PRIVATE)
        val darkModeState = sharedPreferences.getBoolean("dark_mode", false)
        if (darkModeState) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(Home_Fragment())
                    true
                }

                R.id.AddCategory -> {

                    loadFragment(LikeAdd_Fragment())
                    true
                }

                R.id.Profile -> {
                    loadFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }

        loadFragment(Home_Fragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()

    }
}
