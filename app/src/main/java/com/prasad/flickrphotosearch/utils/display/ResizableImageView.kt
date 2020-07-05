package com.prasad.flickrphotosearch.utils.display

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.ceil

/**
 * Created By Prasad on 7/5/20.
 */


class ResizableImageView : AppCompatImageView {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context) : super(context)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val d = drawable

        if (d != null) {
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height =
                ceil((width.toFloat() * d.intrinsicHeight.toFloat() / d.intrinsicWidth.toFloat()).toDouble())
                    .toInt()
            setMeasuredDimension(width, height)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}