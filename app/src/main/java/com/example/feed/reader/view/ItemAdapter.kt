package com.example.feed.reader.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feed.reader.R
import com.example.feed.reader.model.RssDto
import com.example.feed.reader.presentantion.RssContract

class ItemAdapter(
    val listRss: List<RssDto>,
    val context: Context,
    val presenter: RssContract.Presenter
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rss, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val rssDto = listRss[position]

        holder.title.text = rssDto.title
        holder.author.text = rssDto.author
        holder.datePublished.text = rssDto.datePublished.format("dd/MM/yyyy")
        holder.btnViewMore.setOnClickListener {
            presenter.onViewMoreClick(rssDto.link)
        }

        Glide.with(context)
            .load(rssDto.image)
            .into(holder.image)
    }

    override fun getItemCount() = listRss.size
}