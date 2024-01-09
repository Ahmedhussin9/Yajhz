package com.example.data.contractImpl.signup

import com.example.data.api.WebServices
import com.example.domain.model.signup.SignUpResponse
import com.example.domain.contract.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    var webServices: WebServices
):SignUpRepository {
    override suspend fun signUp(name:String,email:String,password:String,phone:String): SignUpResponse {
       return webServices.signUp(name, email, password, phone)
    }
}