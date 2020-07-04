package com.prasad.flickrphotosearch.ui.flickr

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.prasad.flickrphotosearch.data.model.FlickrPhotoItem
import com.prasad.flickrphotosearch.ui.base.BaseAdapter

/**
 * Created By Prasad on 7/4/20.
 */


class FlickrAdapter(
    parentLifecycle: Lifecycle,
    private val flickrPhotos: ArrayList<FlickrPhotoItem>
) : BaseAdapter<FlickrPhotoItem, FlickrItemViewHolder>(parentLifecycle, flickrPhotos) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FlickrItemViewHolder(parent)
}