package com.example.data.contractImpl.signin

import com.example.domain.contract.SignInRepository
import com.example.domain.contract.SignUpRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class Di {
    @Provides
     fun provideSignUpRepository(signInRepositoryImpl: SignInRepositoryImpl):SignInRepository{
        return signInRepositoryImpl
       }
}