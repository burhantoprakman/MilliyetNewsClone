package com.cloneprojects.milliyetnewsclone.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloneprojects.milliyetnewsclone.R
import com.cloneprojects.milliyetnewsclone.databinding.AdapterItemSmallNewsBinding
import com.cloneprojects.milliyetnewsclone.models.NewsModel


class SmallNewsViewHolder(val binding: AdapterItemSmallNewsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        newsModel: NewsModel,
        onItemClickListener: (NewsModel) -> Unit
    ) {
        binding.newsModel = newsModel
        itemView.setOnClickListener { onItemClickListener(newsModel) }
        binding.executePendingBindings()

    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thubmImage: ImageView, url: String) {
            Glide.with(thubmImage)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thubmImage)
        }

    }

}