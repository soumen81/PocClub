package com.autumntechcreation.pocclub.di.component.module

import androidx.appcompat.app.AppCompatActivity
import com.autumntechcreation.pocclub.MainActivity
import com.autumntechcreation.pocclub.di.component.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityBuilderModule {
    @Binds
    @ActivityScope
    internal abstract fun bindActivity(mainActivity: MainActivity): AppCompatActivity

}