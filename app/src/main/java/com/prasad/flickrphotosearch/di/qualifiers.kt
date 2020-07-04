package com.prasad.flickrphotosearch.di

import javax.inject.Qualifier

/**
 * Created By Prasad on 7/2/20.
 */


@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityContext