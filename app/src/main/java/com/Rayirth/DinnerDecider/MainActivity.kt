@file:Suppress("DEPRECATION")

package com.Rayirth.DinnerDecider

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.Rayirth.DinnerDecider.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val foodList = arrayListOf("Chinese","Hamburger","Pizza","Mc Donald's","Idli Dosa","Nan Kulcha","Dahi Paratha","Palak Paneer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.decideBtn.setOnClickListener {

            val random = Random()
            val randomFood = random.nextInt(foodList.count()) //RandomIndex
            binding.selectedFoodTxt.text = foodList[randomFood]
        }

        binding.addFoodBtn.setOnClickListener{
            val newFood = binding.addFoodTxt.text.toString()
            foodList.add(newFood)
            binding.addFoodTxt.text.clear()

        }
    }
}