package com.autumntechcreation.pocclub.di.component

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.autumntechcreation.pocclub.PocClubApp
import com.autumntechcreation.pocclub.di.component.module.AppModule
import com.autumntechcreation.pocclub.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection


object AppInjector {
    fun init(pocClubApp: PocClubApp) {
        DaggerAppComponent.builder().appModule(AppModule(pocClubApp)).build().inject(pocClubApp)

        pocClubApp.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }
            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }

            // Other methods are omitted for simplification …
        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasAndroidInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            (activity as FragmentActivity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(
                            object : FragmentManager.FragmentLifecycleCallbacks() {

                                override fun onFragmentCreated(fm: FragmentManager, fragment: Fragment,
                                                               savedInstanceState: Bundle?) {
                                    super.onFragmentCreated(fm, fragment, savedInstanceState)

                                    if (fragment is Injectable) {
                                        AndroidSupportInjection.inject(fragment)
                                    }
                                }
                            }, true
                    )
        }
    }
}
