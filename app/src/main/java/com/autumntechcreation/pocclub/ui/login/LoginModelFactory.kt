package com.autumntechcreation.pocclub.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.autumntechcreation.pocclub.ui.register.RegisterViewModel
import javax.inject.Inject

class LoginModelFactory @Inject constructor(
        private val mLoginViewModel: LoginViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return mLoginViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}