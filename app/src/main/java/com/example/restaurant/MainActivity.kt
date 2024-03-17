package com.example.restaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.menubtn)
        val ttb=AnimationUtils.loadAnimation(this,R.anim.btnmoving)
        val res=findViewById<TextView>(R.id.resTitle)
        val stb=AnimationUtils.loadAnimation(this,R.anim.scaletb)
        buttonClick.startAnimation((stb))
        res.startAnimation(ttb)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivityMenu::class.java)
            startActivity(intent)
        }


    }
}