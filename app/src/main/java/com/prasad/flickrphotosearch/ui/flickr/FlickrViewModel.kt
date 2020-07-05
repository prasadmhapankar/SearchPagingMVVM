package com.prasad.flickrphotosearch.ui.flickr

import androidx.lifecycle.MutableLiveData
import com.prasad.flickrphotosearch.data.model.FlickrPhotoItem
import com.prasad.flickrphotosearch.data.repository.FlickrRepository
import com.prasad.flickrphotosearch.ui.base.BaseViewModel
import com.prasad.flickrphotosearch.ui.flickr.FlickrFragment.Companion.page
import com.prasad.flickrphotosearch.ui.flickr.FlickrFragment.Companion.text
import com.prasad.flickrphotosearch.utils.common.Resource
import com.prasad.flickrphotosearch.utils.network.NetworkHelper
import com.prasad.flickrphotosearch.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers

/**
 * Created By Prasad on 7/2/20.
 */

class FlickrViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val flickrRepository: FlickrRepository,
    private var allFlickrList: ArrayList<FlickrPhotoItem>,
    private val paginator: PublishProcessor<Int>
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val flickrLiveData: MutableLiveData<Resource<List<FlickrPhotoItem>>> = MutableLiveData()

    init {
        compositeDisposable.add(
            paginator
                .onBackpressureDrop()
                .doOnNext {
                    loading.postValue(true)
                }
                .concatMapSingle {
                    return@concatMapSingle flickrRepository
                        .executeFlickrSearch(text, 5, page)
                        .subscribeOn(Schedulers.io())
                        .doOnError {
                        }
                }
                .subscribe(
                    {
                        allFlickrList.addAll(it)
                        loading.postValue(false)
                        if(page == 1) flickrLiveData.postValue(Resource.refresh(it))
                        else flickrLiveData.postValue(Resource.success(it))
                        page += 1
                    },
                    {
                    }
                )
        )
    }

    override fun onCreate() {
        if (flickrLiveData.value == null) loadMorePosts()
    }

    private fun loadMorePosts() {
        if (checkInternetConnectionWithMessage()) {
            paginator.onNext(page)
        }
    }

    fun onLoadMore() {
        if (loading.value !== null && loading.value == false) loadMorePosts()
    }

    fun reset(t : String) {
        // reset pageNumber
        text = t
        page = 1
    }

}
