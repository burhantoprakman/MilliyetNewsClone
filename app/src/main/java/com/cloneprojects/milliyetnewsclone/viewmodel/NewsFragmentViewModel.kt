package com.cloneprojects.milliyetnewsclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cloneprojects.milliyetnewsclone.adapter.NewsFragmentRecyclerViewAdapter
import com.cloneprojects.milliyetnewsclone.models.NewsDetail
import com.cloneprojects.milliyetnewsclone.models.NewsModel
import com.cloneprojects.milliyetnewsclone.retrofit.RetrofitInstance
import com.cloneprojects.milliyetnewsclone.retrofit.RetrofitService
import com.cloneprojects.milliyetnewsclone.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragmentViewModel() : ViewModel() {


    private var newsFeedData: MutableLiveData<NewsModel>
    private var recyclerViewAdapter: NewsFragmentRecyclerViewAdapter

    init {
        newsFeedData = MutableLiveData()
        recyclerViewAdapter = NewsFragmentRecyclerViewAdapter()

    }

    fun getAdapter(): NewsFragmentRecyclerViewAdapter {
        return recyclerViewAdapter
    }

    fun setAdapterData(data: ArrayList<NewsDetail>, onItemClickListener: (NewsDetail) -> Unit) {
        recyclerViewAdapter.setDataList(data, onItemClickListener)
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<NewsModel> {

//        //Sadece ilk seferde burasi bos gitmesin diye eklendi.Cnku bu olamyinca datayi almmadigi icin Mock data set etme islemini yapamiyor
////        newsFeedData.postValue(
////            NewsModel(
////                "Nothing",
////                "Nothing"
////            )
////        )
        return newsFeedData
    }

    fun getNewsFeed() {
        val retroInstance = RetrofitInstance.getRetroInstance().create(RetrofitService::class.java)
        val call = retroInstance.getDataFromAPI(Constants.api_key)
        call.enqueue(object : Callback<NewsModel> {
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                newsFeedData.postValue(null)
            }

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                if (response.isSuccessful) {
                    newsFeedData.postValue(response.body())
                } else {
                    newsFeedData.postValue(null)
                }
            }
        })
    }
}