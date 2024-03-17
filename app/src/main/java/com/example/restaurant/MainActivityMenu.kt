package com.example.restaurant

import android.animation.ObjectAnimator
import android.app.Activity
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivityMenu : AppCompatActivity() {

    companion object{
        const val NAME=" "
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val btnOrder= findViewById<Button>(R.id.orderbtn)
        val menuChosen=findViewById<TextView>(R.id.ChosenMenu)
        val image1=findViewById<ImageButton>(R.id.image1)
        image1.setOnClickListener {

            val builder :AlertDialog.Builder=AlertDialog.Builder(this)
            builder.apply {
                setTitle(getString(R.string.vegetableNoodles))
                setMessage(
                    getString(R.string.egg_noodles_corn_carrot_strips_white_cabbage_and_mushrooms_in_soy_sauce_garlic_ginger_and_sesame_oil_chinese_sprouts_on_top) + "\n" +
                            getString(R.string.price_15)
                )
                setCancelable(false)
                setPositiveButton(getString(R.string.add_to_order)) { dialog, which ->
                    menuChosen.text=menuChosen.text.toString() + "\n" + getString(R.string.vegetableNoodles)
                    Toast.makeText(applicationContext, getString(R.string.added), Toast.LENGTH_SHORT).show()}
                setNegativeButton(getString(R.string.cancel)) { dialog, which -> }
            }
            val dialog=builder.create()
            dialog.show()
        }
        val image2= findViewById<ImageButton>(R.id.image2)
        image2.setOnClickListener{
            val builder :AlertDialog.Builder=AlertDialog.Builder(this)
            builder.apply {
                setTitle(getString(R.string.miyagiSushi))
                setMessage(
                    getString(R.string.fried_salmon_cucumber_and_fried_onion) +
                            getString(R.string.covered_with_avocado_and_sweet_potato_tempura_crispy_sweet_potato_chives_peanuts_teriyaki_spicy_mayonnaise_and_cilantro_vinaigrette_sauce) + "\n" +
                            getString(R.string.price14)
                )
                setCancelable(false)
                setPositiveButton(getString(R.string.add_to_order)) { dialog, which ->
                    menuChosen.text=menuChosen.text.toString() + "\n" + getString(R.string.miyagiSushi)
                    Toast.makeText(applicationContext, getString(R.string.added), Toast.LENGTH_SHORT).show()}
                setNegativeButton(getString(R.string.cancel)) { dialog, which -> }
            }
            val dialog=builder.create()
            dialog.show()
        }
        val image3= findViewById<ImageButton>(R.id.image3)
        image3.setOnClickListener{
            val builder :AlertDialog.Builder=AlertDialog.Builder(this)
            builder.apply {
                setTitle(getString(R.string.rioRoll))
                setMessage(
                    getString(R.string.salmon_baked_in_teriyaki_cucumber_tamago_and_canapes_in_a_chive_sauce_with_a_mixture_of_avocado_fresh_chili_green_onion_and_lemon) +
                            "\n" + getString(R.string.price_14)
                )
                setCancelable(false)
                setPositiveButton(getString(R.string.add_to_order)) { dialog, which ->
                    menuChosen.text=menuChosen.text.toString() + "\n" + getString(R.string.rioRoll)
                    Toast.makeText(applicationContext, getString(R.string.added), Toast.LENGTH_SHORT).show()}
                setNegativeButton(getString(R.string.cancel)) { dialog, which -> }
            }
            val dialog=builder.create()
            dialog.show()
        }

        val image4= findViewById<ImageButton>(R.id.image4)
        image4.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.apply {
                setTitle(getString(R.string.sanchaiSalad))
                setMessage(
                    getString(R.string.lettuce_carrot_hairs_white_and_purple_cabbage_peanuts_in_cilantro_vinaigrette_sauce_and_crispy_sweet_potato_on_top) +
                            "\n" + getString(R.string.price_13)
                )
                setCancelable(false)
                setPositiveButton(getString(R.string.add_to_order)) { dialog, which ->
                    menuChosen.text= menuChosen.text.toString() + "\n" + getString(R.string.sanchaiSalad)
                    Toast.makeText(applicationContext, getString(R.string.added), Toast.LENGTH_SHORT).show()}
                setNegativeButton(getString(R.string.cancel)) { dialog, which -> }
            }
            val dialog=builder.create()
            dialog.show()
        }

        val image5= findViewById<ImageButton>(R.id.cola)
        image5.setOnClickListener{
            val builder :AlertDialog.Builder=AlertDialog.Builder(this)
            builder.apply {
                setTitle(getString(R.string.cola))
                setMessage(getString(R.string.price_4))
                setCancelable(false)
                setPositiveButton(getString(R.string.add_to_order)) { dialog, which ->
                    menuChosen.text= menuChosen.text.toString() + "\n" + getString(R.string.cola)
                    Toast.makeText(applicationContext, getString(R.string.added), Toast.LENGTH_SHORT).show()}
                setNegativeButton(getString(R.string.cancel)) { dialog, which -> }
            }
            val dialog=builder.create()
            dialog.show()
        }
        val image6= findViewById<ImageButton>(R.id.fuzetea)
        image6.setOnClickListener{
            val builder :AlertDialog.Builder=AlertDialog.Builder(this)
            builder.apply {
                setTitle(getString(R.string.fusetea))
                setMessage(getString(R.string.price4))
                setCancelable(false)
                setPositiveButton(getString(R.string.add_to_order)) { dialog, which ->
                    menuChosen.text= menuChosen.text.toString() + "\n" + getString(R.string.fusetea)
                    Toast.makeText(applicationContext, getString(R.string.added), Toast.LENGTH_SHORT).show()}
                setNegativeButton(getString(R.string.cancel)) { dialog, which -> }
            }
            val dialog=builder.create()
            dialog.show()
        }

        btnOrder.setOnClickListener{
            val intent = Intent(this,MainActivityOrderDetails::class.java)
            intent.apply { putExtra(NAME, menuChosen.text) }
            startActivity(intent)
        }


        val alphaAnim=AnimationUtils.loadAnimation(applicationContext, R.anim.fade)
        btnOrder.startAnimation((alphaAnim))
        val foodItem=findViewById<TextView>(R.id.foodItem)
        val drinkItem=findViewById<TextView>(R.id.drinkItem)

        val rotate1=ObjectAnimator.ofFloat(foodItem,"rotationY", 0f,360f)
        rotate1.duration=5000
        rotate1.repeatCount = ObjectAnimator.INFINITE
        rotate1.repeatMode = ObjectAnimator.RESTART
        rotate1.start()

        val rotate2=ObjectAnimator.ofFloat(drinkItem,"rotationY", 0f,360f)
        rotate2.duration=5000
        rotate2.repeatCount = ObjectAnimator.INFINITE
        rotate2.repeatMode = ObjectAnimator.RESTART
        rotate2.start()

        val title=findViewById<TextView>(R.id.title)
        val subt=findViewById<TextView>(R.id.sabtitle)
        val subti=findViewById<TextView>(R.id.sabtitl)
        val slide=AnimationUtils.loadAnimation(this,R.anim.slideleft)
        title.startAnimation(slide)
        subt.startAnimation(slide)
        subti.startAnimation(slide)

    }
}