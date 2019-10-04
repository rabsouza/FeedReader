package com.example.feed.reader.presentantion

import android.net.Uri
import com.example.feed.reader.model.RssDto

class RssContract {
    interface View {
        fun showItems(items: List<RssDto>)
        fun openViewMoreItem(url: Uri)
    }

    interface Presenter {
        fun onStart()
        fun onLoad()
        fun onViewMoreClick(url: Uri)
    }
}