package com.prasad.flickrphotosearch.data.remote

import com.prasad.flickrphotosearch.data.remote.response.FlickrResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created By Prasad on 7/3/20.
 */

@Singleton
interface NetworkService {

    @GET(Endpoints.FLICKER_PHOTOS)
    fun getFlickrPhotos(@Query("text") text: String,
                        @Query("per_page") per_page : Int,
                        @Query("page") page : Int) : Single<FlickrResponse>

}