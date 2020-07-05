package com.prasad.flickrphotosearch.ui.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.prasad.flickrphotosearch.MainApplication
import com.prasad.flickrphotosearch.di.component.ActivityComponent
import com.prasad.flickrphotosearch.di.component.DaggerActivityComponent
import com.prasad.flickrphotosearch.di.module.ActivityModule
import com.prasad.flickrphotosearch.utils.display.Toaster
import javax.inject.Inject

/**
 * Created By Prasad on 7/2/20.
 */

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    protected open fun setupObservers() {

        viewModel.messageString.observe(this, Observer {
            it.data?.run {
                showMessage(this)
            }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
}