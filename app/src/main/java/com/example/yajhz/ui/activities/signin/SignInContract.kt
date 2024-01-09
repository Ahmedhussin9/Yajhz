package com.example.yajhz.ui.activities.signin

import androidx.lifecycle.MutableLiveData
import com.example.domain.model.signin.SigninResponse
import com.example.yajhz.common.SingleLiveEvent

class SignInContract {
    interface ViewModel{
        val state:MutableLiveData<State>
        val event:SingleLiveEvent<Event>
        fun invokeAction(action: Action)
    }
    sealed class Action{
        object OnSignInButtonClicked : Action()
        object OnGotoSignUpClicked : Action()
    }
    sealed class Event{
        object NavigateToHome : Event()
        object NavigateToSignUp : Event()
    }
    sealed class State{
        class Success(var signInResponse: SigninResponse):State()
    }
}