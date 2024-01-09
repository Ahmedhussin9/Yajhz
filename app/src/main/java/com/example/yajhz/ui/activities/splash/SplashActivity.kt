package com.example.yajhz.ui.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.yajhz.R
import com.example.yajhz.databinding.ActivitySplashBinding
import com.example.yajhz.ui.activities.signin.SignInActivity
import com.example.yajhz.ui.activities.signup.SignUpActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        navigateToSignUp()
    }

    private fun navigateToSignUp() {
        Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this,SignInActivity::class.java)
        startActivity(intent)
            finish()
        },2000)
    }

}