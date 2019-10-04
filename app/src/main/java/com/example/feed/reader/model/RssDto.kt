package com.example.feed.reader.model

import android.net.Uri
import java.util.*

data class RssDto(
    val title: String,
    val author: String,
    val datePublished: Date,
    val link: Uri,
    val image: String
)
