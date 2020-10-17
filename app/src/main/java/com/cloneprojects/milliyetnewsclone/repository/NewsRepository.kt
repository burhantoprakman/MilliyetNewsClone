package com.cloneprojects.milliyetnewsclone.repository

import com.cloneprojects.milliyetnewsclone.models.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRepository {

    @GET("world.json")
    fun getDataFromAPI(@Query("api-key") content_type: String): Call<NewsModel>
}
