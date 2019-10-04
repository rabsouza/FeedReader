package com.example.feed.reader.view

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.reader.R
import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String) = SimpleDateFormat(pattern, Locale("pt", "BR")).format(this)

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.findViewById(R.id.textViewItemTitle) as TextView
    val author = view.findViewById(R.id.textViewItemAuthor) as TextView
    val datePublished = view.findViewById(R.id.textViewItemDatePublished) as TextView
    val image = view.findViewById(R.id.imageItemImg) as ImageView
    val btnViewMore = view.findViewById(R.id.buttonItemViewMore) as Button
}