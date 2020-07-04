package com.prasad.flickrphotosearch.di.component

import android.app.Application
import android.content.Context
import com.prasad.flickrphotosearch.MainApplication
import com.prasad.flickrphotosearch.data.remote.NetworkService
import com.prasad.flickrphotosearch.di.ApplicationContext
import com.prasad.flickrphotosearch.di.module.ApplicationModule
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created By Prasad on 7/2/20.
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app : MainApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable
}