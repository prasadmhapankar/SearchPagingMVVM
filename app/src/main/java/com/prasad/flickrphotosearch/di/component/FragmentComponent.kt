package com.prasad.flickrphotosearch.di.component

import com.prasad.flickrphotosearch.di.FragmentScope
import com.prasad.flickrphotosearch.di.module.FragmentModule
import com.prasad.flickrphotosearch.ui.flickr.FlickrFragment
import dagger.Component

/**
 * Created By Prasad on 7/2/20.
 */


@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: FlickrFragment)
}