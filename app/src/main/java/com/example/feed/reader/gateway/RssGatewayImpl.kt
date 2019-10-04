package com.example.feed.reader.gateway

import android.content.Context
import com.example.feed.reader.infrastructure.AppConstant
import com.example.feed.reader.model.RssDto
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS
import java.util.*

class RssGatewayImpl(val context: Context) : RssGateway {

    override suspend fun readerRss(): List<RssDto> {
        val listItems = arrayListOf<RssDto>()

        val newArticles =
            PkRSS.with(context).load(AppConstant.FEED_RSS_URL).callback(RssCallback()).get()
        newArticles?.mapTo(listItems) {
            RssDto(it.title, it.author, Date(it.date), it.source, it.enclosure.url)
        }
        return listItems
    }

    class RssCallback : Callback {
        override fun onLoadFailed() {
        }

        override fun onPreload() {
        }

        override fun onLoaded(newArticles: MutableList<Article>?) {
        }

    }
}