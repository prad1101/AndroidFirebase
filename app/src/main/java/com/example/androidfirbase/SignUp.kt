package com.example.androidfirbase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val emailtext: EditText =findViewById<EditText>(R.id.emailtext)
        val usertext: EditText =findViewById<EditText>(R.id.usernametext)
        val passwordtext: EditText =findViewById<EditText>(R.id.passwordtext)
        val uniqueid: EditText =findViewById<EditText>(R.id.uniqueid)
        val signbtn: Button =findViewById<Button>(R.id.signupbtn)
        val siginpage:TextView = findViewById<TextView>(R.id.signinpage)


        signbtn.setOnClickListener{
            val name=usertext.text.toString()
            val email=emailtext.text.toString()
            val pass=passwordtext.text.toString()
            val uniqueId=uniqueid.text.toString()

            var user=User(name,email,pass,uniqueId);

            database= FirebaseDatabase.getInstance().getReference("Users")

            database.child(uniqueId).setValue(user).addOnSuccessListener {

                usertext.text.clear()
                emailtext.text.clear()
                passwordtext.text.clear()
                uniqueid.text.clear()

                Toast.makeText(this,"User Registered", Toast.LENGTH_SHORT).show()

            }.addOnSuccessListener {
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }

        }

        siginpage.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}