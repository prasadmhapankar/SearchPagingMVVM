package com.prasad.flickrphotosearch.ui.flickr

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.prasad.flickrphotosearch.R
import com.prasad.flickrphotosearch.data.model.FlickrPhotoItem
import com.prasad.flickrphotosearch.di.component.ViewHolderComponent
import com.prasad.flickrphotosearch.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_flickr.view.*

/**
 * Created By Prasad on 7/4/20.
 */


class FlickrItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<FlickrPhotoItem, FlickrItemViewModel>(R.layout.item_view_flickr, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.photoItem?.observe(this, Observer {
            itemView.txtTitle.text = it.title
            Glide.with(itemView.context).load(makeFlickrPhotoUrl(it)).into(itemView.iv_flickr)
        })
    }

    private fun makeFlickrPhotoUrl(it: FlickrPhotoItem?): String? {
        return it?.let {
            "https://farm${it.farm}.staticflickr.com/${it.server}/${it.id}_${it.secret}_m.jpg"
        }
    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }
}