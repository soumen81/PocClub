package com.autumntechcreation.pocclub.di.component.module

import com.autumntechcreation.pocclub.ui.register.RegistrationActivity
import com.autumntechcreation.pocclub.ui.splash.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashScreenActivity(): SplashScreenActivity

    @ContributesAndroidInjector
    abstract fun contributeRegistrationActivity(): RegistrationActivity

}