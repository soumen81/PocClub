package com.autumntechcreation.pocclub

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDex
import com.autumntechcreation.pocclub.di.component.DaggerAppComponent
import com.facebook.stetho.Stetho
import com.autumntechcreation.pocclub.di.component.AppInjector
import com.autumntechcreation.pocclub.di.component.module.AppModule
import com.autumntechcreation.pocclub.network.ConnectivityReceiver

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
/*import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector*/
import timber.log.Timber
import javax.inject.Inject

class PocClubApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {

        super.onCreate()

        Stetho.initializeWithDefaults(this);

        MultiDex.install(this)

        @Suppress("DEPRECATION")
        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)

        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        AppInjector.init(this)

    }

    fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    fun setConnectivityListener(listener: ConnectivityReceiver.ConnectivityReceiverListener) {
        ConnectivityReceiver.connectivityReceiverListener = listener
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this) // this is the key code
    }


    companion object {
        lateinit var instance: PocClubApp
    }

    override fun androidInjector(): AndroidInjector<Any> {
        TODO("Not yet implemented")
    }

}