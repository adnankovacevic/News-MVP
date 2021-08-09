package com.example.newsapii.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RVItemDecoration(
        private val spaceInPixels: Int,
        private val orientation: Int? = RecyclerView.VERTICAL) :
        RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        if (orientation == null) {
            outRect.top = spaceInPixels
            outRect.bottom = spaceInPixels
        } else if (orientation == RecyclerView.VERTICAL) {
            outRect.bottom = spaceInPixels
            outRect.top = spaceInPixels
        }
    }
}