package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

import android.widget.SpinnerAdapter
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var spinnerAdapter: ArrayAdapter<String>
        lateinit var operation: String


        val spinner = findViewById<Spinner>(R.id.spinner)

        spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter
        spinnerAdapter.addAll(" ","+", "-", "*", "/")

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                operation = spinnerAdapter.getItem(position)!!
                updateViews(operation)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }
    private fun updateViews(operation:String){
        when(operation){
            " " -> {
                findViewById<EditText>(R.id.et_a).visibility = View.GONE
                findViewById<EditText>(R.id.et_b).visibility = View.GONE
                findViewById<TextView>(R.id.tv_equals).visibility = View.GONE
                findViewById<Button>(R.id.btn_calculate).visibility = View.GONE

            }
            "+" ->{
                findViewById<EditText>(R.id.et_a).visibility = View.VISIBLE
                findViewById<EditText>(R.id.et_b).visibility = View.VISIBLE
                findViewById<TextView>(R.id.tv_equals).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_calculate).visibility = View.VISIBLE
                val input1 = findViewById<EditText>(R.id.et_a).toString().toInt()
                val input2 = findViewById<EditText>(R.id.et_b).toString().toInt()
                val result = input1 + input2
                findViewById<Button>(R.id.btn_calculate).setOnClickListener{
                    findViewById<TextView>(R.id.tv_equals).text = result.toString()
                }
            }

        }
    }

}