package com.prasad.flickrphotosearch

import android.app.Application
import com.prasad.flickrphotosearch.di.component.ApplicationComponent
import com.prasad.flickrphotosearch.di.component.DaggerApplicationComponent
import com.prasad.flickrphotosearch.di.module.ApplicationModule

/**
 * Created By Prasad on 7/2/20.
 */


class MainApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}