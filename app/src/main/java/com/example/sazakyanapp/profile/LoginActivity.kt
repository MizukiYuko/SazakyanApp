package com.example.sazakyanapp.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sazakyanapp.CarsActivity
import com.example.sazakyanapp.HomeActivity
import com.example.sazakyanapp.MainHomeActivity
import com.example.sazakyanapp.R
import com.example.sazakyanapp.database.DBHelper
import com.example.sazakyanapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var dbHelper : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_login)

        dbHelper = DBHelper(this)

        binding.loginBtn.setOnClickListener {

            val loginUsername = binding.loginUsername.text.toString()
            val loginPassword = binding.loginPassword.text.toString()
            loginDatabase(loginUsername, loginPassword)

        }

        binding.signupRedirect.setOnClickListener {

            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            finish()

        }
    }

    private fun loginDatabase (username : String, password : String) {

        val userExists = dbHelper.readUser(username, password)
        if (userExists) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@LoginActivity, CarsActivity::class.java))

        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
        }
    }
}