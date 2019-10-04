package com.example.feed.reader.presentantion

import android.net.Uri
import com.example.feed.reader.gateway.RssGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class RssPresenter(val rssGateway: RssGateway, val view: RssContract.View) : RssContract.Presenter {
    override fun onLoad() {
        runBlocking(Dispatchers.IO) {
            val listRss = rssGateway.readerRss()
            view.showItems(listRss)
        }
    }

    override fun onStart() {
        onLoad()
    }

    override fun onViewMoreClick(url: Uri) {
        view.openViewMoreItem(url)
    }

}