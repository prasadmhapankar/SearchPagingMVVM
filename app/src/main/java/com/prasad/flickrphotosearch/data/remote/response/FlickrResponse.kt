package com.prasad.flickrphotosearch.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.prasad.flickrphotosearch.data.model.FlickrPhotos

/**
 * Created By Prasad on 7/3/20.
 */


data class FlickrResponse (
    @Expose
    @SerializedName("photos")
    val data: FlickrPhotos,

    @Expose
    @SerializedName("stat")
    var statusCode: String
)