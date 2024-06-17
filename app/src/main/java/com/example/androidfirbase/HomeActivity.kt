package com.example.androidfirbase

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email=intent.getStringExtra(MainActivity.KEY1)
        val name=intent.getStringExtra(MainActivity.KEY2)
        val id=intent.getStringExtra(MainActivity.KEY3)

        val welcometext:TextView = findViewById<TextView>(R.id.welcome)
        welcometext.text="Welcome"+name;
    }
}