package com.prasad.flickrphotosearch.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created By Prasad on 7/4/20.
 */

data class FlickrPhotos(

    @Expose
    @SerializedName("page")
    val page: Int,

    @Expose
    @SerializedName("pages")
    val pages: Int,

    @Expose
    @SerializedName("perpage")
    val perpage: Int,

    @Expose
    @SerializedName("total")
    val total: Int,

    @Expose
    @SerializedName("photo")
    val photo: List<FlickrPhotoItem>
)