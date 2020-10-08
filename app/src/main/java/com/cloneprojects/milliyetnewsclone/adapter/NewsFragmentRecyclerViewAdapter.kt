package com.cloneprojects.milliyetnewsclone.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloneprojects.milliyetnewsclone.adapter.SmallNewsViewHolder
import com.cloneprojects.milliyetnewsclone.models.NewsModel

class NewsFragmentRecyclerViewAdapter(
    private val newsList: List<NewsModel>,
    private val onItemClickListener : (NewsModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = SmallNewsViewHolder(parent)

    override fun getItemCount(): Int = newsList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as SmallNewsViewHolder).bind(newsList[position], onItemClickListener)




}