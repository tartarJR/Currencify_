package com.tatar.currencify.dagger.app.component

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.tatar.currencify.dagger.app.module.RxSchedulerModule
import com.tatar.currencify.dagger.app.scope.AppScope
import com.tatar.currencify.data.dagger.DataModule
import com.tatar.currencify.presentation.dagger.ViewModelModule
import com.tatar.currencify.remote.dagger.ApiModule
import com.tatar.currencify.remote.dagger.MoshiModule
import com.tatar.currencify.remote.dagger.NetworkModule
import com.tatar.currencify.remote.dagger.RemoteModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class,
        RemoteModule::class,
        ApiModule::class,
        NetworkModule::class,
        MoshiModule::class,
        RxSchedulerModule::class
    ]
)
interface AppComponent {

    fun viewModelProviderFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}
