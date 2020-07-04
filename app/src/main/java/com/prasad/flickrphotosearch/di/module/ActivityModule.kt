package com.prasad.flickrphotosearch.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.prasad.flickrphotosearch.ui.base.BaseActivity
import com.prasad.flickrphotosearch.ui.main.MainViewModel
import com.prasad.flickrphotosearch.utils.ViewModelProviderFactory
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created By Prasad on 7/2/20.
 */

@Module
class ActivityModule(private val activity: BaseActivity<*>) {
    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return SplashViewModel
        }).get(MainViewModel::class.java)
}