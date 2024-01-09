package com.example.yajhz.ui.activities.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.signupusecase.SignUpUseCase
import com.example.yajhz.common.SingleLiveEvent
import com.example.yajhz.ui.activities.signin.SignInContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
 var useCase: SignUpUseCase
):ViewModel(),SignUpContract.ViewModel {
    var nameLiveData = MutableLiveData<String>()
    var emailLiveData = MutableLiveData<String>()
    var phoneNumberLiveData = MutableLiveData<String>()
    var passwrodLiveData = MutableLiveData<String>()
    var confirmPasswrodLiveData = MutableLiveData<String>()
    var nameErrorLiveData = MutableLiveData<String?>()
    var emailErrorLiveData = MutableLiveData<String?>()
    var phoneNumberErrorLiveData = MutableLiveData<String?>()
    var passwrodErrorLiveData = MutableLiveData<String?>()
    var confirmPasswrodErrorLiveData = MutableLiveData<String?>()
    var errorrLiveData = MutableLiveData<String?>()

    private val _state = MutableLiveData<SignUpContract.State>()
    override val state: MutableLiveData<SignUpContract.State> = _state
    private val _event = SingleLiveEvent<SignUpContract.Event>()
    override val event: SingleLiveEvent<SignUpContract.Event> = _event

    override fun invokeAction(action: SignUpContract.Action) {
        when(action){
            is SignUpContract.Action.onSignUpButtonClicked->signUp()
            is SignUpContract.Action.onGotoSignClicked->navigateSignIn()
        }
    }
    private fun navigateSignIn(){
        _event.postValue(SignUpContract.Event.navigateToSignIn())
    }

    private fun signUp(){
        if(!isValidForm()){
            return
        }
        viewModelScope.launch {
            try {
                val data =useCase.invoke(nameLiveData.value!!,emailLiveData.value!!, password = passwrodLiveData.value!!, phone = phoneNumberLiveData.value!!)
                if (data.responseCode == 200){
                    _event.postValue(SignUpContract.Event.navigateToHome())
                    _state.postValue(SignUpContract.State.Success(data))
                }else{
                    errorrLiveData.postValue(data.message)
                }
            }catch (e:Exception){
                if (e.message=="Chain validation failed"){
                    signUp()
                }else{
                    errorrLiveData.postValue(e.message)
                }
            }
        }
    }
    private fun isValidForm(): Boolean {
        var isValid= true
        if (nameLiveData.value.isNullOrBlank()){
            isValid = false
            nameErrorLiveData.postValue("Enter A Password")

        }else{
            nameErrorLiveData.postValue(null)
        }
        if (emailLiveData.value.isNullOrBlank()){
            isValid = false
            emailErrorLiveData.postValue("Enter An Email")
        }else{
            emailErrorLiveData.postValue(null)
        }
        if (phoneNumberLiveData.value.isNullOrBlank()){
            isValid = false
            phoneNumberErrorLiveData.postValue("Enter A Password")

        }else{
            phoneNumberErrorLiveData.postValue(null)
        }
        if (passwrodLiveData.value.isNullOrBlank()){
            isValid = false
            passwrodErrorLiveData.postValue("Enter A Password")

        }else{
            passwrodErrorLiveData.postValue(null)
        }
        if (confirmPasswrodLiveData.value.isNullOrBlank()||confirmPasswrodLiveData.value!=passwrodLiveData.value){
            isValid = false
            confirmPasswrodErrorLiveData.postValue("Enter A Password")

        }else{
            confirmPasswrodErrorLiveData.postValue(null)
        }
        return isValid
    }


}