package com.prasad.flickrphotosearch.ui.main

import android.os.Bundle
import com.prasad.flickrphotosearch.R
import com.prasad.flickrphotosearch.di.component.ActivityComponent
import com.prasad.flickrphotosearch.ui.base.BaseActivity
import com.prasad.flickrphotosearch.ui.flickr.FlickrFragment

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) = addFlickrFragment()

    private fun addFlickrFragment() {
        supportFragmentManager.findFragmentByTag(FlickrFragment.TAG) ?: supportFragmentManager
            .beginTransaction()
            .add(R.id.container_fragment, FlickrFragment.newInstance(), FlickrFragment.TAG)
            .commitAllowingStateLoss()
    }
}