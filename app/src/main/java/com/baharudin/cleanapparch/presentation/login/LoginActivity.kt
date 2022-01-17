package com.baharudin.cleanapparch.presentation.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.baharudin.cleanapparch.R
import com.baharudin.cleanapparch.data.common.util.WrapperResponse
import com.baharudin.cleanapparch.data.login.remote.data.LoginResponse
import com.baharudin.cleanapparch.databinding.ActivityLoginBinding
import com.baharudin.cleanapparch.domain.login.entity.LoginEntity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    private fun login() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            if (validate(email, password)) {

            }
        }
    }
    private fun setErrorEmail( error : String?) {
        binding.emailInput.error = error
    }
    private fun setPassword(error : String?) {
        binding.passwordInput.error = error
    }
    private fun resetAllError() {
        setErrorEmail(null)
        setPassword(null)
    }
    private fun validate(email : String, password : String) : Boolean {
        resetAllError()
        if (!email.isEmpty()) {
            setErrorEmail(getString(R.string.error_email_not_valid))
            return false
        }
        if (password.length < 8) {
            setPassword(getString(R.string.error_password_not_valid))
            return false
        }
        return true
    }
}
