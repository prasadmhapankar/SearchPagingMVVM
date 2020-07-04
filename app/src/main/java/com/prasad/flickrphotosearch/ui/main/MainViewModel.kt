package com.prasad.flickrphotosearch.ui.main

import com.prasad.flickrphotosearch.ui.base.BaseViewModel
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created By Prasad on 7/2/20.
 */


class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper){

    override fun onCreate() {

    }
}