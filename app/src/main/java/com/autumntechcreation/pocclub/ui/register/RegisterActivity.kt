package com.autumntechcreation.pocclub.ui.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.autumntechcreation.pocclub.R
import com.autumntechcreation.pocclub.customdialog.LottieAlertDialog
import com.autumntechcreation.pocclub.ui.BaseActivity
import com.bumptech.glide.Glide
import dagger.android.AndroidInjection
import javax.inject.Inject

class RegisterActivity: BaseActivity(), LifecycleOwner {
    @Inject
    lateinit var mRegisterModelFactory: RegisterModelFactory
    private lateinit var mRegisterViewModel: RegisterViewModel
    lateinit var alertDialog : LottieAlertDialog
    override fun defineLayoutResource(): Int {
        return R.layout.activity_register

    }
    override fun initializeComponents() {
        AndroidInjection.inject(this)
        mRegisterViewModel = ViewModelProviders.of(this, mRegisterModelFactory).get(
            RegisterViewModel::class.java
        )
    }
}