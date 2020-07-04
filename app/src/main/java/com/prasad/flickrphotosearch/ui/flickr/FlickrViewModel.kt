package com.prasad.flickrphotosearch.ui.flickr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.prasad.flickrphotosearch.data.remote.response.FlickrResponse
import com.prasad.flickrphotosearch.data.repository.FlickrRepository
import com.prasad.flickrphotosearch.ui.base.BaseViewModel
import com.prasad.flickrphotosearch.utils.common.Resource
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created By Prasad on 7/2/20.
 */

class FlickrViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val flickrRepository: FlickrRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val flickrLiveData: MutableLiveData<Resource<FlickrResponse>> = MutableLiveData()

    fun getFlickrPhotos(): LiveData<FlickrResponse> =
        Transformations.map(flickrLiveData) { it.data }

    override fun onCreate() {
        if(checkInternetConnectionWithMessage()){
            flickrLiveData.postValue(Resource.loading())
            compositeDisposable.add(
                flickrRepository.executeFlickrSearch("flowers", 20, 1)
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { flickrLiveData.postValue(Resource.success(it)) },
                        {
                            //handleNetworkError(it)
                            flickrLiveData.postValue(Resource.error())
                        })
            )
        }
    }

}
