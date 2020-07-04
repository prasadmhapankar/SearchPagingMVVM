package com.prasad.flickrphotosearch.di.component

import com.prasad.flickrphotosearch.di.ActivityScope
import com.prasad.flickrphotosearch.di.module.ActivityModule
import com.prasad.flickrphotosearch.ui.main.MainActivity
import dagger.Component

/**
 * Created By Prasad on 7/2/20.
 */


@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)

}