package com.autumntechcreation.pocclub.di.component.module

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.autumntechcreation.pocclub.network.Webservice
import com.autumntechcreation.pocclub.ui.login.LoginModelFactory
import com.autumntechcreation.pocclub.ui.register.RegisterModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    internal fun provideWebservice(retrofit: Retrofit): Webservice {
        return retrofit.create(Webservice::class.java)
    }

    @Provides
    @Singleton
    fun provideRegisterModelFactory(factory: RegisterModelFactory): ViewModelProvider.Factory = factory

    @Provides
    @Singleton
    fun provideLoginModelFactory(factory: LoginModelFactory): ViewModelProvider.Factory = factory
}