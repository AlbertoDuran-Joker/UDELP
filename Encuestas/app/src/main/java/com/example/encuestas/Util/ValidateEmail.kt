package com.example.encuestas.Util

class ValidateEmail {
    companion object{
        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }
}