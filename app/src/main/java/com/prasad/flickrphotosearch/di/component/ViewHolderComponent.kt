package com.prasad.flickrphotosearch.di.component

import com.prasad.flickrphotosearch.di.ViewModelScope
import com.prasad.flickrphotosearch.di.module.ViewHolderModule
import com.prasad.flickrphotosearch.ui.flickr.FlickrItemViewHolder
import dagger.Component

/**
 * Created By Prasad on 7/4/20.
 */


@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: FlickrItemViewHolder)
}