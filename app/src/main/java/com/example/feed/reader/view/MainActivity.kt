package com.example.feed.reader.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.reader.R
import com.example.feed.reader.gateway.RssGatewayImpl
import com.example.feed.reader.model.RssDto
import com.example.feed.reader.presentantion.RssContract
import com.example.feed.reader.presentantion.RssPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RssContract.View {

    lateinit var presenter: RssPresenter
    lateinit var adapter: RecyclerView.Adapter<ItemViewHolder>
    val listItems = arrayListOf<RssDto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = RssPresenter(RssGatewayImpl(this), this)

        val layoutManager = LinearLayoutManager(this)
        recyclerViewFeedRss.layoutManager = layoutManager
        recyclerViewFeedRss.setHasFixedSize(true)
        recyclerViewFeedRss.setItemViewCacheSize(20)

        adapter = ItemAdapter(listItems, this, presenter)
        recyclerViewFeedRss.adapter = adapter

        refreshLayoutFeedRss.setOnRefreshListener {
            presenter.onLoad()
            refreshLayoutFeedRss.isRefreshing = false
        }

        presenter.onStart()

    }

    override fun showItems(items: List<RssDto>) {
        listItems.clear()
        listItems.addAll(items)
        adapter.notifyDataSetChanged()
    }

    override fun openViewMoreItem(url: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, url)
        startActivity(intent)
    }

}
