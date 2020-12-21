package com.example.for63rd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    var number : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView_number.text = "0"
        button_minus.setOnClickListener(this)
        button_plus.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_minus -> {
                number -= 1
                textView_number.text = number.toString()
                Log.i("INFORMATION","minus")
            }
            R.id.button_plus -> {
                number += 1
                textView_number.text = number.toString()
                Log.i("INFORMATION","plus")
            }
        }
    }
}
