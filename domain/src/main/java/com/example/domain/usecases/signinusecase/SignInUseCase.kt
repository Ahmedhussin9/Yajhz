package com.example.domain.usecases.signinusecase

import com.example.domain.contract.SignInRepository
import com.example.domain.model.signup.SignUpResponse
import com.example.domain.contract.SignUpRepository
import com.example.domain.model.signin.SigninResponse
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    var signInRepository: SignInRepository
) {
    suspend fun invoke(email:String,password:String): SigninResponse {
     return signInRepository.signIn(email,password)
    }
}