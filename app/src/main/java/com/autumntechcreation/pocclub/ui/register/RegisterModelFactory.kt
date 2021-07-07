package com.autumntechcreation.pocclub.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class RegisterModelFactory @Inject constructor(
        private val mRegisterViewModel: RegisterViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return mRegisterViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}