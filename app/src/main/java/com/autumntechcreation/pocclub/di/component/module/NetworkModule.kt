package com.autumntechcreation.pocclub.di.component.module

import com.autumntechcreation.pocclub.BuildConfig
import com.autumntechcreation.pocclub.network.LiveDataCallAdapterFactory
import com.autumntechcreation.pocclub.util.AppConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttpInterceptors(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    /**
     * Configure OkHttpClient. This helps us override some of the default configuration. Like the
     * connection timeout.
     *
     * @return OkHttpClient
     */
    @Provides
    @Singleton
    internal fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(AppConstants.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(AppConstants.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(AppConstants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    internal fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()) // Serialize Objects
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Set call to return {@link Observable}
            .build()
    }
}