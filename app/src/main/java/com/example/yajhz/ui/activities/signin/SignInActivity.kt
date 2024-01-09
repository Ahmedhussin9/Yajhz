package com.example.yajhz.ui.activities.signin

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
import com.example.yajhz.databinding.ActivitySignInBinding
import com.example.yajhz.ui.activities.home.HomeActivity
import com.example.yajhz.ui.activities.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivitySignInBinding
    lateinit var viewModel:SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in)
        makeStatusBarTransparentAndIconsClear()
        initViews()
        clickListeners()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.event.observe(this){
            when(it){
                is SignInContract.Event.NavigateToSignUp->navigateToSignUp()
                is SignInContract.Event.NavigateToHome->navigateToHome()
            }
        }
        viewModel.state.observe(this){
            when(it){
                is SignInContract.State.Success->saveToken(it.signInResponse.data?.token)
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

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun clickListeners() {
        viewBinding.SignInButton.setOnClickListener(){
            viewModel.invokeAction(SignInContract.Action.OnSignInButtonClicked)
        }
        viewBinding.signupText.setOnClickListener(){
            viewModel.invokeAction(SignInContract.Action.OnGotoSignUpClicked)
        }
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this)[SignInViewModel::class.java]
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
    }

    private fun makeStatusBarTransparentAndIconsClear() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        window.statusBarColor = Color.TRANSPARENT
    }

}