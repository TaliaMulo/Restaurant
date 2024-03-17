package com.example.restaurant

import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivityFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_final)

        val src=findViewById<ImageView>(R.id.src)
        val thanks=findViewById<TextView>(R.id.tanks)
        val apetit=findViewById<TextView>(R.id.apetit)
        val exit= findViewById<Button>(R.id.exit)
        val suc=findViewById<TextView>(R.id.success)
        val rate=findViewById<RatingBar>(R.id.ratingbar)
        val btnrate=findViewById<Button>(R.id.btnRate)
        val txtRate=findViewById<TextView>(R.id.textRate)

        val ttb= AnimationUtils.loadAnimation(this,R.anim.btnmoving)
        src.startAnimation(ttb)
        thanks.startAnimation(ttb)
        apetit.startAnimation(ttb)
        exit.startAnimation(ttb)
        suc.startAnimation(ttb)
        btnrate.startAnimation(ttb)
        txtRate.startAnimation(ttb)
        rate.startAnimation(ttb)

        exit.setOnClickListener {
            val builder : AlertDialog.Builder= AlertDialog.Builder(this)
            builder.apply {
                setTitle(getString(R.string.exit))
                setMessage(getString(R.string.are_you_sure_you_want_to_exit))
                setCancelable(false)
                setPositiveButton(getString(R.string.yes)) { dialog, which -> finishAffinity()}
                setNegativeButton(getString(R.string.no)) { dialog, which -> }
            }
            val dialog=builder.create()
            dialog.show()
        }

        btnrate.setOnClickListener{
            val getRatingValue =rate.rating

            Toast.makeText(this,
                getString(R.string.your_rating) +" "+getRatingValue + " "+ getString(R.string.thankyou),Toast.LENGTH_SHORT).show()
        }





    }
}