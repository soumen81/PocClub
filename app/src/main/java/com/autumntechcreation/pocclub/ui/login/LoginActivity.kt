package com.autumntechcreation.pocclub.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.autumntechcreation.pocclub.R
import com.autumntechcreation.pocclub.customdialog.LottieAlertDialog
import com.autumntechcreation.pocclub.ui.register.RegisterActivity
import com.autumntechcreation.pocclub.ui.register.RegisterModelFactory
import com.autumntechcreation.pocclub.ui.register.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class LoginActivity: AppCompatActivity()  {
    @Inject
    lateinit var mLoginModelFactory: LoginModelFactory
    private lateinit var mLoginViewModel: LoginViewModel
    lateinit var alertDialog : LottieAlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvSignUp.setOnClickListener(){
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}