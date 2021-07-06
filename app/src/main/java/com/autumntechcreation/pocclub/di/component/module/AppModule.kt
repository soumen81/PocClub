package com.autumntechcreation.pocclub.di.component.module

import android.app.Application
import com.autumntechcreation.pocclub.network.Webservice
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
}