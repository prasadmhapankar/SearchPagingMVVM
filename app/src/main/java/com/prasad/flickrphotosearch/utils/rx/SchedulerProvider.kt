package com.prasad.flickrphotosearch.utils.rx

import io.reactivex.Scheduler
import javax.inject.Singleton

/**
 * Created By Prasad on 7/2/20.
 */


@Singleton
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}