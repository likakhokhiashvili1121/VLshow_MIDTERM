package com.example.vlshow_midterm.util

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.vlshow_midterm.R

class MyItemDecoration( var myContext : Context) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val itemPosition = parent.getChildAdapterPosition(view)

        if (itemPosition == 1) {
            outRect.top = myContext.resources.getDimensionPixelSize(R.dimen._100sdp)

        }
    }
}
