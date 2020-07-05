package com.prasad.flickrphotosearch.ui.flickr

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasad.flickrphotosearch.R
import com.prasad.flickrphotosearch.di.component.FragmentComponent
import com.prasad.flickrphotosearch.ui.base.BaseFragment
import com.prasad.flickrphotosearch.utils.common.Status
import kotlinx.android.synthetic.main.fragment_flickr.*
import javax.inject.Inject

/**
 * Created By Prasad on 7/2/20.
 */


class FlickrFragment : BaseFragment<FlickrViewModel>() {

    companion object {

        const val TAG = "FlickrFragment"

        var text : String = "nature"

        var page : Int = 1

        fun newInstance(): FlickrFragment {
            val args = Bundle()
            val fragment = FlickrFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearch()
    }

    private fun initSearch() {
        input.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                hideKeyboard()
                updatedPhotosFromInput()
                true
            } else {
                false
            }
        }
        input.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                hideKeyboard()
                updatedPhotosFromInput()
                true
            } else {
                false
            }
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_flickr

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var flickrAdapter: FlickrAdapter

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupObservers() {

        viewModel.loading.observe(this, Observer {
            if (it) pb_loading.visibility = View.VISIBLE else pb_loading.visibility = View.GONE
        })

        viewModel.flickrLiveData.observe(this, Observer {
            it.data?.run {
                if (it.status == Status.REFRESH) flickrAdapter.replaceList(this)
                else flickrAdapter.appendData(this, page)
            }
        })
    }

    override fun setupView(view: View) {
        rv_flickr.apply {
            rv_flickr.layoutManager = linearLayoutManager
            rv_flickr.adapter = flickrAdapter

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    layoutManager?.run {
                        if (this is LinearLayoutManager
                            && itemCount > 0
                            && itemCount == findLastVisibleItemPosition() + 1
                        ) viewModel.onLoadMore()
                    }
                }
            })
        }
    }

    private fun updatedPhotosFromInput() {
        input.text.trim().toString().let {
            if (it.isNotBlank()) {
                viewModel.reset(it)
                viewModel.onLoadMore()
            }
        }
    }

}