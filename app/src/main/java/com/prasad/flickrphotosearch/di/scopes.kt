package com.prasad.flickrphotosearch.di

import javax.inject.Scope

/**
 * Created By Prasad on 7/2/20.
 */


@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope


@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ViewModelScope