package com.autumntechcreation.pocclub.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.autumntechcreation.pocclub.R
import com.autumntechcreation.pocclub.ui.BaseActivity
import com.autumntechcreation.pocclub.ui.register.RegisterActivity
import com.bumptech.glide.Glide
import dagger.android.AndroidInjection

class SplashScreenActivity: BaseActivity() {
    private var handler: Handler? = null
    private val runnable = Runnable {


            val homeIntent: Intent

            homeIntent = Intent(this@SplashScreenActivity, RegisterActivity::class.java)
            startActivity(homeIntent)
            finish()


    }

    /**
     * This method will prevent multiple instances of an activity when it is launched with different intents
     */
    private val isDuplicateInstance: Boolean
        get() {
            if (!isTaskRoot) {
                val intent = intent
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN == intent.action) {
                    finish()
                    return true
                }
            }
            return false
        }

    private fun executeHandler() {
        handler = android.os.Handler()
        val INTERVAL: Long = 2000
        handler!!.postDelayed(runnable, INTERVAL)
    }

    override fun initializeComponents() {
    }

    override fun defineLayoutResource(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState?: Bundle())
        AndroidInjection.inject(this)


        if (isDuplicateInstance) {//return if this is duplicate instance of same category and instance
            return
        }
        executeHandler()


    }


    override fun onDestroy() {
        super.onDestroy()
        if (handler != null) {
            handler!!.removeCallbacks(runnable)
            finish()
        }
    }

}