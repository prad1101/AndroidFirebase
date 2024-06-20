package com.example.androidfirbase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
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
        val listview:ListView =findViewById<ListView>(R.id.tasklist)
        welcometext.text="Welcome"+name;

        var listofdata= arrayListOf<String>();
        listofdata.add("Play Cricket");
        listofdata.add("Eat Dal Chawal");
        listofdata.add("drink chai");
        listofdata.add("Sleep lonely");

        listofdata.add("Play Cricket");
        listofdata.add("Eat Dal Chawal");
        listofdata.add("drink chai");
        listofdata.add("Sleep lonely");
        listofdata.add("Play Cricket");
        listofdata.add("Eat Dal Chawal");
        listofdata.add("drink chai");
        listofdata.add("Sleep lonely");
        listofdata.add("Play Cricket");
        listofdata.add("Eat Dal Chawal");
        listofdata.add("drink chai");
        listofdata.add("Sleep lonely");
        listofdata.add("Play Cricket");
        listofdata.add("Eat Dal Chawal");
        listofdata.add("drink chai");
        listofdata.add("Sleep lonely"); listofdata.add("Play Cricket");
        listofdata.add("Eat Dal Chawal");
        listofdata.add("drink chai");
        listofdata.add("Sleep lonely"); listofdata.add("Play Cricket");
        listofdata.add("Eat Dal Chawal");
        listofdata.add("drink chai");
        listofdata.add("Sleep lonely");




        // adapter is use for give data to listview
        val adapterformylist=ArrayAdapter(this,android.R.layout.simple_list_item_1,listofdata );
        listview.adapter=adapterformylist;

        listview.setOnItemClickListener { parent, view, position, id ->
            val text="Clicked on item : "+(view as TextView).text.toString();
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
        }




    }
}