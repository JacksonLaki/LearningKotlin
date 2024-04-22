package com.example.my_application

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        Log.i("MYTAG", "SecondActivity: OnCreate")
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffer)
        val message = "$userName, You will get everything here!"
        textView.text = message




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    //This Demo code shows How application life-Cycle works
    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "SecondActivity: OnStart")

    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "SecondActivity: OnResume")

        fun onPause() {
            super.onPause()
            Log.i("MYTAG", "SecondActivity: OnPause")
        }

        fun onStop() {
            super.onStop()
            Log.i("MYTAG", "SecondActivity: OnStop")
        }

        fun onDestroy() {
            super.onDestroy()
            Log.i("MYTAG", "SecondActivity: OnDestroy")
        }

        fun onRestart() {
            super.onRestart()
            Log.i("MYTAG", "SecondActivity: OnRestart")
        }
    }
}
