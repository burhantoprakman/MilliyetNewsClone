package com.cloneprojects.milliyetnewsclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloneprojects.milliyetnewsclone.databinding.AdapterItemSmallNewsBinding
import com.cloneprojects.milliyetnewsclone.models.NewsDetail

class NewsFragmentRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var newsList = ArrayList<NewsDetail>()
    private lateinit var onItemClickListener: (NewsDetail) -> Unit

    fun setDataList(data: ArrayList<NewsDetail>, onItemClickListener: (NewsDetail) -> Unit) {
        this.newsList = data
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AdapterItemSmallNewsBinding.inflate(layoutInflater)
        return SmallNewsViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as SmallNewsViewHolder).bind(newsList[position], onItemClickListener)






}