package com.prasad.flickrphotosearch.di.module

import androidx.lifecycle.LifecycleRegistry
import com.prasad.flickrphotosearch.di.ViewModelScope
import com.prasad.flickrphotosearch.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

/**
 * Created By Prasad on 7/4/20.
 */


@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}