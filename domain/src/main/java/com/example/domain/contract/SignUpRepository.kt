package com.example.domain.contract

import com.example.domain.model.signup.SignUpResponse

interface SignUpRepository {
    suspend fun signUp(name:String,email:String,password:String,phone:String): SignUpResponse
}