package com.cloneprojects.milliyetnewsclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloneprojects.milliyetnewsclone.models.NewsModel
import com.cloneprojects.milliyetnewsclone.R
import kotlinx.android.synthetic.main.adapter_item_small_news.view.*

class SmallNewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.adapter_item_small_news,
        parent,
        false
    )
) {

    fun bind(
        newsModel: NewsModel,
        onItemClickListener: (NewsModel) -> Unit
    ) {

        itemView.txtNewsTitle.text = newsModel.newsTitle
        Glide.with(itemView.context)
            .load((newsModel as NewsModel).newsImage)
            .centerCrop()
            .into(itemView.imgNews)
        itemView.setOnClickListener{onItemClickListener(newsModel)}

    }


}