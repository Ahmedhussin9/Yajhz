package com.example.domain.contract

import com.example.domain.model.signin.SigninResponse
import com.example.domain.model.signup.SignUpResponse

interface SignInRepository {
    suspend fun signIn(email:String,password:String): SigninResponse
}