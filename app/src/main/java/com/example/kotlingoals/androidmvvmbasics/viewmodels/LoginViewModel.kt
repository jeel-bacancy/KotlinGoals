package com.example.kotlingoals.androidmvvmbasics.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlingoals.androidmvvmbasics.model.LoginData

class LoginViewModel : ViewModel() {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean>
        get() = _loginSuccess

    var loginData = LoginData()

    fun onLoginButtonClick() {
        // Implement your login logic here
        val email = loginData.email
        val password = loginData.password

        if (isValidCredentials(email,password)) {
            if (isEmailValid(email) && isPasswordValid(password)) {
                // If login is successful, set loginSuccess LiveData to true
                _loginSuccess.value = true
            } else {
                // Show error message if login fails
                _loginSuccess.value = false
            }
        }else {
            // Show error message if login fails
            _loginSuccess.value = false
        }
    }

    private fun isEmailValid(email: String): Boolean {
        // Basic email validation
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        // Simple password validation
        return password.length >= 6 // Example: Minimum 6 characters
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        // Perform your actual login validation logic here
        // For demonstration purposes, we're just checking if email and password are not empty
        return email.isNotEmpty() && password.isNotEmpty()
    }
}