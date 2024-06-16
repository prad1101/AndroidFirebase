package com.example.androidfirbase

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.util.Log
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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY1="com.example.day16database.MainActivity.email"
        const val KEY2="com.example.day16database.MainActivity.name"
        const val KEY3="com.example.day16database.MainActivity.id"
    }
    private lateinit var _databaserefrence:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usertxt:EditText= findViewById<EditText>(R.id.txtusername)
        val userpass:EditText =findViewById<EditText>(R.id.txtpassword)

        val login:Button= findViewById<Button>(R.id.loginbtn)
        val linktoregister:TextView= findViewById<TextView>(R.id.signuplink)


        linktoregister.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent);
        }

        login.setOnClickListener {
            val username=usertxt.text.toString();
            val userpassword=userpass.text.toString();

            Log.d("data",username);
            Log.d("data",userpassword);


            if(username.isNotEmpty() && userpassword.isNotEmpty()){
                    readData(username,userpassword)
            }else{
                Toast.makeText(applicationContext,"User Not Found ",Toast.LENGTH_SHORT).show();
            }
        }

    }// onCreate Method Over


    private fun readData(username:String, userpassword:String){
        Toast.makeText(this,username,Toast.LENGTH_SHORT).show()
        _databaserefrence=FirebaseDatabase.getInstance().getReference("Users")
        _databaserefrence.child(username).get().addOnSuccessListener {
            // if user exist or not
            if(it.exists()){

                val dbpassword=it.child("password").value.toString();
                if(userpassword==dbpassword){

                    // welcome user in your app, with intent and data
                    val username = it.child("name").value;
                    val email    = it.child("email").value;
                    val userid   = it.child("uniqueid").value;


                    val intentWelcome = Intent(this, HomeActivity::class.java)

                    intentWelcome.putExtra(KEY1, email.toString())
                    intentWelcome.putExtra(KEY2, username.toString())
                    intentWelcome.putExtra(KEY3, userid.toString())

                    startActivity(intentWelcome)
                }else{
                    Toast.makeText(this,"Password not matched",Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(applicationContext,"User does not exist",Toast.LENGTH_SHORT).show();
            }

        }.addOnFailureListener {
            Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show();
        }
    }


}