package com.prasad.flickrphotosearch.ui.flickr

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.prasad.flickrphotosearch.R
import com.prasad.flickrphotosearch.di.component.FragmentComponent
import com.prasad.flickrphotosearch.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_flickr.*
import javax.inject.Inject

/**
 * Created By Prasad on 7/2/20.
 */


class FlickrFragment : BaseFragment<FlickrViewModel>() {

    companion object {

        const val TAG = "FlickrFragment"

        fun newInstance(): FlickrFragment {
            val args = Bundle()
            val fragment = FlickrFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_flickr

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var flickrAdapter: FlickrAdapter

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupObservers() {
        viewModel.getFlickrPhotos().observe(this, Observer {
            it?.run {
                flickrAdapter.appendData(this.data.photo)
            }
        })
    }

    override fun setupView(view: View) {
        rv_flickr.layoutManager = linearLayoutManager
        rv_flickr.adapter = flickrAdapter
    }

}