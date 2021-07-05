package com.autumntechcreation.fvstore.di.component


import com.autumntechcreation.pocclub.PocClubApp
import com.autumntechcreation.pocclub.di.component.module.AppModule
import com.autumntechcreation.pocclub.di.component.module.BuildersModule
import com.autumntechcreation.pocclub.di.component.module.NetworkModule
import com.autumntechcreation.pocclub.di.component.module.RoomModule

import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class,
        AppModule::class, RoomModule::class, NetworkModule::class)
)
interface AppComponent {

    fun inject(app: PocClubApp)

//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: FvStoreApp): Builder
//
//        fun build(): AppComponent
//    }



}