package com.example.kotlingoals.androidmvvmbasics.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlingoals.R
import com.example.kotlingoals.androidmvvmbasics.viewmodels.LoginViewModel
import com.example.kotlingoals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.loginSuccess.observe(this, Observer { success ->
            if (success) {
                // Show a toast message indicating login success
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_SHORT).show()
            }
        })
    }
}