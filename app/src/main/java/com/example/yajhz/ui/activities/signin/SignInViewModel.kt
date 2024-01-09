package com.example.yajhz.ui.activities.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.signinusecase.SignInUseCase
import com.example.yajhz.common.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
private val useCase: SignInUseCase
):ViewModel(),SignInContract.ViewModel{
    var emailLiveData = MutableLiveData<String>()
    var passwrodLiveData = MutableLiveData<String>()
    var emailErrorLiveData = MutableLiveData<String?>()
    var passwrodErrorLiveData = MutableLiveData<String?>()
    var errorrLiveData = MutableLiveData<String?>()

    private val _state = MutableLiveData<SignInContract.State>()
    override val state: MutableLiveData<SignInContract.State> = _state
    private val _event = SingleLiveEvent<SignInContract.Event>()
    override val event: SingleLiveEvent<SignInContract.Event> = _event

    override fun invokeAction(action: SignInContract.Action) {
        when(action){
            is SignInContract.Action.OnSignInButtonClicked->signIn()
            is SignInContract.Action.OnGotoSignUpClicked->navigateSignUp()
        }
    }
    private fun navigateSignUp(){
        _event.postValue(SignInContract.Event.NavigateToSignUp)
    }

    private fun signIn(){
        if(!isValidForm()){
            return
        }
        viewModelScope.launch {
            try {
               val data =useCase.invoke(emailLiveData.value!!,passwrodLiveData.value!!)
               if (data.responseCode == 200){
                    _event.postValue(SignInContract.Event.NavigateToHome)
                   _state.postValue(SignInContract.State.Success(data))
                }else{
                    errorrLiveData.postValue(data.message)
                }
            }catch (e:Exception){
                    if (e.message=="Chain validation failed"){
                        signIn()
                    }
            }

        }
    }
    private fun isValidForm(): Boolean {
        var isValid= true
        if (emailLiveData.value.isNullOrBlank()){
            isValid = false
            emailErrorLiveData.postValue("Enter An Email")
        }else{
            emailErrorLiveData.postValue(null)
        }
        if (passwrodLiveData.value.isNullOrBlank()){
            isValid = false
            passwrodErrorLiveData.postValue("Enter A Password")

        }else{
            passwrodErrorLiveData.postValue(null)
        }
        return isValid
    }


}