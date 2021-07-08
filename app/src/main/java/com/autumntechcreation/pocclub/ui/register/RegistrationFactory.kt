package com.autumntechcreation.pocclub.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class RegistrationFactory @Inject constructor(
    private val mRegistrationViewModel: RegistrationViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
            return mRegistrationViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}