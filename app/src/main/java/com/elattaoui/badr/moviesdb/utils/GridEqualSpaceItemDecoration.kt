package com.elattaoui.badr.moviesdb.utils

import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

class GridEqualSpaceItemDecoration(@Px private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(spacing, spacing, spacing, spacing)
    }
}
