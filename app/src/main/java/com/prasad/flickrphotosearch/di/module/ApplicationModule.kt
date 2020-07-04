package com.prasad.flickrphotosearch.di.module

import android.app.Application
import android.content.Context
import com.prasad.flickrphotosearch.BuildConfig
import com.prasad.flickrphotosearch.MainApplication
import com.prasad.flickrphotosearch.data.remote.NetworkService
import com.prasad.flickrphotosearch.data.remote.Networking
import com.prasad.flickrphotosearch.di.ApplicationContext
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.RxSchedulerProvider
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created By Prasad on 7/2/20.
 */

@Module
class ApplicationModule (private val application: MainApplication){

    @Provides
    @Singleton
    fun provideApplication() : Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.BASE_URL
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}