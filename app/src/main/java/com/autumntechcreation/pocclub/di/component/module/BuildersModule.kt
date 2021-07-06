package com.autumntechcreation.pocclub.di.component.module

import com.autumntechcreation.pocclub.MainActivity
import com.autumntechcreation.pocclub.di.component.scope.ActivityScope
import com.autumntechcreation.pocclub.ui.splash.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashScreenActivity(): SplashScreenActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityBuilderModule::class, FragmentBuildersModule::class])
    internal abstract fun mainActivity(): MainActivity
}