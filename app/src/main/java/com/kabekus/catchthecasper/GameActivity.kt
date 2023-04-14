package com.kabekus.catchthecasper

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.kabekus.catchthecasper.databinding.ActivityGameBinding
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {
    private lateinit var binding :ActivityGameBinding
    var score = 0
    var imageList = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable{ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        hideImages()


        var score = binding.scoreTxt.toString().toIntOrNull()
        if (score != null){
            binding.scoreTxt.text = " Score = "+ score

        }

        //Count Down
        object : CountDownTimer(30500,1000){
            override fun onTick(p0: Long) {
                binding.timerTxt.text = "Time : " + p0/1000
            }
            override fun onFinish() {
                binding.timerTxt.text = "Time : 0"
                handler.removeCallbacks(runnable)
                for (image in imageList){
                    image.visibility = View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@GameActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart The Game ? ")
                alert.setPositiveButton("Yes"){dialog, which ->
                    //Restart
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){dialog, which ->
                    Toast.makeText(this@GameActivity,"Game Over", Toast.LENGTH_LONG).show()
                    intent.putExtra("score",binding.scoreTxt.text.toString())
                }
                alert.show()
            }
        }.start()

    }
    fun increaseScore (view : View){
        score += 1
        binding.scoreTxt.text = "Score : " + score
    }

    fun hideImages(){
        imageList.add(binding.imageView)
        imageList.add(binding.imageView2)
        imageList.add(binding.imageView3)
        imageList.add(binding.imageView4)
        imageList.add(binding.imageView5)
        imageList.add(binding.imageView6)
        imageList.add(binding.imageView7)
        imageList.add(binding.imageView8)
        imageList.add(binding.imageView9)
        imageList.add(binding.imageView10)
        imageList.add(binding.imageView11)
        imageList.add(binding.imageView12)
        imageList.add(binding.imageView13)
        imageList.add(binding.imageView14)
        imageList.add(binding.imageView15)
        imageList.add(binding.imageView16)

        runnable = object : Runnable{
            override fun run() {
                for (image in imageList){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(16)
                imageList[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,200)
            }
        }
        handler.post(runnable)
    }
}