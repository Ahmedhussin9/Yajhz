package com.example.data.contractImpl.signin

import com.example.data.api.WebServices
import com.example.domain.contract.SignInRepository

import com.example.domain.model.signin.SigninResponse
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    var webServices: WebServices
): SignInRepository {
    override suspend fun signIn(email:String,password:String): SigninResponse {
       return webServices.signIn( email, password ) }
}