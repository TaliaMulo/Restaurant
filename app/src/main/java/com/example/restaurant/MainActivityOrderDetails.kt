package com.example.restaurant

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.size
import java.text.SimpleDateFormat
import java.util.Calendar


class MainActivityOrderDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_order_details)

        val timeBtn = findViewById<Button>(R.id.time_dialog_btn)
        val textView = findViewById<TextView>(R.id.timeTv)
        val menu=findViewById<TextView>(R.id.menu)

       menu.text=intent.getStringExtra(MainActivityMenu.NAME).toString()

        timeBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    cal.set(Calendar.MINUTE, minute)
                    textView.text = SimpleDateFormat("hh:mm").format(cal.time)
                }

            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
        val name=findViewById<EditText>(R.id.name)
        val note=findViewById<EditText>(R.id.note)


        val r1=findViewById<RadioButton>(R.id.r1)
        val r2=findViewById<RadioButton>(R.id.r2)
        val r3=findViewById<RadioButton>(R.id.r3)
        var method= getString(R.string.not_chosen)

        r1.setOnClickListener {
            method= getString(R.string.creditcard)
            Toast.makeText(this, getString(R.string.credit_cardd),Toast.LENGTH_SHORT).show()}
        r2.setOnClickListener { method= getString(R.string.debitcard)
            Toast.makeText(this, getString(R.string.debit_cardd),Toast.LENGTH_SHORT).show() }
        r3.setOnClickListener { method= getString(R.string.cashh)
            Toast.makeText(this, getString(R.string.cassh),Toast.LENGTH_SHORT).show() }


        val amount=arrayOf(getString(R.string._1),
            getString(R.string._2), getString(R.string._3),
            getString(R.string._4), getString(R.string._5), getString(R.string._6),
            getString(R.string._7), getString(R.string._8), getString(R.string._9),
            getString(R.string._10))
        var diners=getString(R.string._1)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter= ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,amount)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                diners= amount[position]
                Toast.makeText(applicationContext,
                    getString(R.string.selected) +" " + amount[position] + " "+ getString(R.string.diners), Toast.LENGTH_SHORT).show()

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val intent = Intent(this,MainActivityFinal::class.java)


        val btnDetailsOrder=findViewById<Button>(R.id.detailsOrder)
        btnDetailsOrder.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.dialog_details, null)
            val textName = dialogView.findViewById<TextView>(R.id.nam)
            val details=dialogView.findViewById<TextView>(R.id.items)
            val orderTime=dialogView.findViewById<TextView>(R.id.timeOrder)
            val diner=dialogView.findViewById<TextView>(R.id.diners)
            val payment=dialogView.findViewById<TextView>(R.id.payment)
            val notes=dialogView.findViewById<TextView>(R.id.notes)
            val btnorder=dialogView.findViewById<Button>(R.id.btnOrder)
            val btnback=dialogView.findViewById<Button>(R.id.btnBack)

            builder.setView(dialogView)
            val dialog=builder.create()

            textName.text=name.text.toString()
            details.text=menu.text.toString()
            orderTime.text=textView.text.toString()
            diner.text=diners.toString()
            payment.text=method.toString()
            notes.text=note.text.toString()

            btnback.setOnClickListener{dialog.dismiss() }
            btnorder.setOnClickListener{ startActivity(intent)}
            dialog.show()
        }


        val res=findViewById<TextView>(R.id.reservaionOp)
        val slide=AnimationUtils.loadAnimation(this,R.anim.slideleft)
        res.startAnimation(slide)
        val fade=AnimationUtils.loadAnimation(this, R.anim.fade)
        btnDetailsOrder.startAnimation(fade)











    }
}