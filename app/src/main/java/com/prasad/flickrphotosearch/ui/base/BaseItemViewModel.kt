package com.prasad.flickrphotosearch.ui.base

import androidx.lifecycle.MutableLiveData
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created By Prasad on 7/4/20.
 */


abstract class BaseItemViewModel<T : Any>(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val data: MutableLiveData<T> = MutableLiveData()

    fun onManualCleared() = onCleared()

    fun updateData(data: T) {
        this.data.postValue(data)
    }
}