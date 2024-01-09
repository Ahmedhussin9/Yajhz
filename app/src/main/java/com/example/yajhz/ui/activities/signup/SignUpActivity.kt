package com.example.yajhz.ui.activities.signup

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.data.api.Constants
import com.example.yajhz.R
import com.example.yajhz.databinding.ActivitySignUpBinding
import com.example.yajhz.ui.activities.home.HomeActivity
import com.example.yajhz.ui.activities.signin.SignInActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivitySignUpBinding
    lateinit var viewModel:SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        makeStatusBarTransparentAndIconsClear()
        initViews()
        clickListeners()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.event.observe(this){
            when(it){
                is SignUpContract.Event.navigateToHome->navigateToHome()
                is SignUpContract.Event.navigateToSignIn->navigateToSignin()
            }
        }
        viewModel.state.observe(this){
            when(it){
                is SignUpContract.State.Success->saveToken(it.signUpResponse.data?.token)
            }
        }
        viewModel.errorrLiveData.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
    private fun saveToken(token: String?) {
        val sharedPreferences =this.getSharedPreferences(Constants.SharedPreferences, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.apply {
            putString("token",token)
        }?.apply()
    }
    fun navigateToHome(){
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun navigateToSignin(){
        val intent = Intent(this,SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun clickListeners() {
        viewBinding.SignUpButton.setOnClickListener(){
            viewModel.invokeAction(SignUpContract.Action.onSignUpButtonClicked())
        }
        viewBinding.logInText.setOnClickListener(){
            viewModel.invokeAction(SignUpContract.Action.onGotoSignClicked())
        }
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
    }

    private fun makeStatusBarTransparentAndIconsClear() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        window.statusBarColor = Color.TRANSPARENT
    }
}