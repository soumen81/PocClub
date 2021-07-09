package com.autumntechcreation.pocclub.ui.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.autumntechcreation.pocclub.R
import com.autumntechcreation.pocclub.customdialog.LottieAlertDialog
import com.autumntechcreation.pocclub.ui.BaseActivity
import com.autumntechcreation.pocclub.ui.login.LoginActivity
import com.bumptech.glide.Glide
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity: AppCompatActivity() {
    @Inject
    lateinit var mRegisterModelFactory: RegisterModelFactory
    private lateinit var mRegisterViewModel: RegisterViewModel
    lateinit var alertDialog : LottieAlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        AndroidInjection.inject(this)
       /* tvLogin.setOnClickListener{
          val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }*/
    }

}