package com.example.feed.reader.gateway

import com.example.feed.reader.model.RssDto

interface RssGateway {

    suspend fun readerRss(): List<RssDto>

}