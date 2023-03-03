package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lbutton:Button = findViewById(R.id.button)
        var rbutton:Button = findViewById(R.id.button2)
        var layout:ConstraintLayout = findViewById(R.id.background)

        fun shuff(){
            val lint=(0..10).shuffled().last()
            var rint=(0..10).shuffled().last()
            while(rint==lint){
                rint=(0..10).shuffled().last()
            }
            lbutton.text=lint.toString()
            rbutton.text=rint.toString()
        }

        fun isCorrect(leftPressed:Boolean){
            var lint:Int = lbutton.text.toString().toInt()
            var rint:Int = rbutton.text.toString().toInt()
            var message:String
            val isanscorrect:Boolean = if(leftPressed) lint>rint else rint>lint
            if(isanscorrect){
                layout.setBackgroundColor(Color.GREEN)
                message = "Correct"
            }
            else{
                layout.setBackgroundColor(Color.RED)
                message = "InCorrect"
            }
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        }

        lbutton.setOnClickListener {
            isCorrect(true)
            shuff()
        }

        rbutton.setOnClickListener {
            isCorrect(false)
            shuff()
        }
    }
}