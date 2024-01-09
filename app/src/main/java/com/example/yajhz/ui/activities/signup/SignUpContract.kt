package com.example.yajhz.ui.activities.signup

import androidx.lifecycle.MutableLiveData
import com.example.domain.model.signup.SignUpResponse
import com.example.yajhz.common.SingleLiveEvent

class SignUpContract {
    interface ViewModel{
        val state:MutableLiveData<State>
        val event:SingleLiveEvent<Event>
        fun invokeAction(action: Action)
    }
    sealed class Action{
        class onSignUpButtonClicked():Action()
        class onGotoSignClicked():Action()
    }
    sealed class Event{
        class navigateToHome():Event()
        class navigateToSignIn():Event()
    }
    sealed class State{
        class Success(var signUpResponse: SignUpResponse):State()
    }
}