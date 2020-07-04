package com.prasad.flickrphotosearch.utils.network

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Singleton

/**
 * Created By Prasad on 7/2/20.
 */

@Singleton
class NetworkHelper constructor(private val context: Context) {

    fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }
}