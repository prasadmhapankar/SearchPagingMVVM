package com.prasad.flickrphotosearch.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created By Prasad on 7/3/20.
 */

/**
    {
    "id": "50074773647",
    "owner": "135847684@N06",
    "secret": "2421778572",
    "server": "65535",
    "farm": 66,
    "title": "Reinstein Woods Nature Preserve",
    "ispublic": 1,
    "isfriend": 0,
    "isfamily": 0
    }
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
