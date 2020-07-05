package com.prasad.flickrphotosearch.data.repository

import com.prasad.flickrphotosearch.data.model.FlickrPhotoItem
import com.prasad.flickrphotosearch.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created By Prasad on 7/3/20.
 */


class FlickrRepository @Inject constructor(private val networkService: NetworkService) {
    fun executeFlickrSearch(text : String, per_page : Int, page : Int) : Single<List<FlickrPhotoItem>> =
        networkService.getFlickrPhotos(text, per_page, page).map { it.data.photo }
}