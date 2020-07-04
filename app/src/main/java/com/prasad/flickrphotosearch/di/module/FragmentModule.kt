package com.prasad.flickrphotosearch.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.prasad.flickrphotosearch.data.repository.FlickrRepository
import com.prasad.flickrphotosearch.ui.base.BaseFragment
import com.prasad.flickrphotosearch.ui.flickr.FlickrAdapter
import com.prasad.flickrphotosearch.ui.flickr.FlickrViewModel
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
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun providesFlickrViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        flickrRepository: FlickrRepository
    ): FlickrViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(FlickrViewModel::class) {
                FlickrViewModel(schedulerProvider, compositeDisposable, networkHelper, flickrRepository)
            }
        ).get(FlickrViewModel::class.java)

    @Provides
    fun provideFlickrAdapter() = FlickrAdapter(fragment.lifecycle, ArrayList())
}