package com.example.domain.usecases.signupusecase

import com.example.domain.model.signup.SignUpResponse
import com.example.domain.contract.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    var signUpRepository: SignUpRepository
) {
    suspend fun invoke(name:String,email:String,password:String,phone:String): SignUpResponse {
     return signUpRepository.signUp(name,email,password,phone)
    }
}