package com.example.sazakyanapp.walkthrough

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.sazakyanapp.HomeActivity
import com.example.sazakyanapp.R

class VeryFirstWT : AppCompatActivity() {

    private lateinit var nextBtn : Button
    private lateinit var skipBtn : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_very_first_wt)

        nextBtn = findViewById(R.id.btnNext)
        skipBtn = findViewById(R.id.skipButton)

        nextBtn.setOnClickListener {

            startActivity(Intent(this@VeryFirstWT, SecondWT::class.java))

        }

        skipBtn.setOnClickListener {

            startActivity(Intent(this@VeryFirstWT, HomeActivity::class.java))

        }

    }
}