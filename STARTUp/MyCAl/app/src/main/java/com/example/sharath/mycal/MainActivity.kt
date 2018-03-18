package com.example.sharath.mycal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     val result = findViewById<View>(R.id.result_text) as TextView

        val button_add = findViewById<View>(R.id.button_add) as Button
        val button_minus = findViewById<View>(R.id.button_minus) as Button
        val button_multi = findViewById<View>(R.id.button_multi) as Button
        val button_divi = findViewById<View>(R.id.button_divi) as Button

        button_add.setOnClickListener(View.OnClickListener {
            view -> result.text = (getInputNum1() + getInputNum2()).toString()
        })

        button_minus.setOnClickListener(View.OnClickListener {
            view -> result.text = (getInputNum1() - getInputNum2()).toString()
        })

        button_multi.setOnClickListener(View.OnClickListener {
            view -> result.text = (getInputNum1() * getInputNum2()).toString()
        })

        button_divi.setOnClickListener(View.OnClickListener {
            view -> result.text = (getInputNum1() / getInputNum2()).toString()
        })

    }

    fun getInputNum1(): Int {
        val num1 = findViewById<View>(R.id.editText_num1) as EditText
        return Integer.parseInt(num1.text.toString())
    }
    fun getInputNum2(): Int {
        val num1 = findViewById<View>(R.id.editText_num2) as EditText
        return Integer.parseInt(num1.text.toString())
    }

}
