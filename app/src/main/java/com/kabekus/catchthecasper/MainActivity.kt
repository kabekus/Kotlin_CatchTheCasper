 package com.kabekus.catchthecasper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kabekus.catchthecasper.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
     private lateinit var binding : ActivityMainBinding
     var score = 0
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         val view = binding.root
         setContentView(view)

     }

     fun game(view: View){
         val intent = Intent(applicationContext,GameActivity::class.java)
         startActivity(intent)

         var name = binding.nameTxt.text.toString()
         Toast.makeText(this@MainActivity,"Welcome "+name, Toast.LENGTH_LONG).show()
     }

}