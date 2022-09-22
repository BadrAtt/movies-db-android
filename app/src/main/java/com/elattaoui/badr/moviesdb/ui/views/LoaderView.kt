package com.elattaoui.badr.moviesdb.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.elattaoui.badr.moviesdb.databinding.LoaderViewBinding

class LoaderView : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding: LoaderViewBinding =
        LoaderViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        gravity = Gravity.CENTER_HORIZONTAL
    }

    fun setIndeterminate(isIndeterminate: Boolean) {
        binding.loader.isIndeterminate = isIndeterminate
    }
}
