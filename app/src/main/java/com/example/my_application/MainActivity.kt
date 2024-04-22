package com.example.my_application

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.NonCancellable.message


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i("MYTAG","MainActivity: OnCreate")
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.tvName)
        val submitButton = findViewById<Button>(R.id.tvButton)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var name = ""
        submitButton.setOnClickListener{
           name = inputField.text.toString()
            if (name == ""){
                offersButton.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(this@MainActivity,
                    "Please, enter your name!",
                    Toast.LENGTH_SHORT)
                    .show()
            }else {
                val message = "Welcome $name"
                Log.i("MYTAG",message)
                greetingTextView.text = message
                Log.i("MYTAG","After display the message on the text")
                inputField.text.clear()
                offersButton.visibility = VISIBLE
            }
        }

        offersButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",name)
            startActivity(intent)

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}