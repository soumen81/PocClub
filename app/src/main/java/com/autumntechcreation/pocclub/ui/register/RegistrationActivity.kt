package com.autumntechcreation.pocclub.ui.register

import androidx.lifecycle.LifecycleOwner
import com.autumntechcreation.pocclub.BaseActivity
import com.autumntechcreation.pocclub.R

class RegistrationActivity: BaseActivity(), LifecycleOwner {
    override fun defineLayoutResource(): Int {
        return R.layout.activity_register
    }

    override fun initializeComponents() {

    }
}