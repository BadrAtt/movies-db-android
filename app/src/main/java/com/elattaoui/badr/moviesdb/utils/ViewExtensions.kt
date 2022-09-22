package com.elattaoui.badr.moviesdb.utils

import android.view.View

fun View.visibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}
