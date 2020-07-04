package com.prasad.flickrphotosearch.ui.flickr

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.prasad.flickrphotosearch.data.model.FlickrPhotoItem
import com.prasad.flickrphotosearch.ui.base.BaseItemViewModel
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created By Prasad on 7/4/20.
 */


class FlickrItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<FlickrPhotoItem>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "FlickrItemViewModel"
    }

    val photoItem: LiveData<FlickrPhotoItem>? = Transformations.map(data) { it }

    fun onItemClick(position: Int) {
        //messageString.postValue(Resource.success("onItemClick at $position of ${data.value?.name}"))
        Log.d(TAG, "onItemClick at $position - ${data.value}" )
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate called")
    }
}