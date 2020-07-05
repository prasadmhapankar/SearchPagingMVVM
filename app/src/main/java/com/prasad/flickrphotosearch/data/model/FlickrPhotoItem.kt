package com.prasad.flickrphotosearch.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created By Prasad on 7/3/20.
 */


data class FlickrPhotoItem (

    @Expose
    @SerializedName("id")
    val id: String,

    @Expose
    @SerializedName("owner")
    val owner: String,

    @Expose
    @SerializedName("secret")
    val secret: String,

    @Expose
    @SerializedName("server")
    val server: String,

    @Expose
    @SerializedName("farm")
    val farm: Int,

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("ispublic")
    val ispublic: Int,

    @Expose
    @SerializedName("isfriend")
    val isfriend: Int,

    @Expose
    @SerializedName("isfamily")
    val isfamily: Int

)
