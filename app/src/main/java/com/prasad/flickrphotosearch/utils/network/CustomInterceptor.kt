package com.prasad.flickrphotosearch.utils.network

import com.prasad.flickrphotosearch.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created By Prasad on 7/4/20.
 */


class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url().newBuilder()
            .addQueryParameter(QueryParams.method.toString(), Constants.METHOD)
            .addQueryParameter(QueryParams.format.toString(), Constants.FORMAT)
            .addQueryParameter(QueryParams.api_key.toString(), Constants.API_KEY)
            .addQueryParameter(QueryParams.nojsoncallback.toString(), Constants.NOJSON_CALLBACK)
            .build()
        val request = chain.request().newBuilder()
            // .addHeader("Authorization", "Bearer token")
            .url(url)
            .build()
        return chain.proceed(request)
    }
}