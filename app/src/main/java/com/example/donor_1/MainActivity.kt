package com.example.donor_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize bottom navigation view
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // set listener on bottom navigation view items
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_add_food -> {
                    val addFoodIntent = Intent(this, Food_entry::class.java)
                    startActivity(addFoodIntent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_view_about -> {
                    val viewAboutIntent = Intent(this, About_Us::class.java)
                    startActivity(viewAboutIntent)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }


}
