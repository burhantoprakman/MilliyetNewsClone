package com.cloneprojects.milliyetnewsclone.models

data class NewsDetail(
    val title: String,
    val abstract: String,
    val multimedia: ArrayList<NewsImage>
)