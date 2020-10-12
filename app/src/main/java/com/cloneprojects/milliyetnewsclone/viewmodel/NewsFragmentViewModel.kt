package com.cloneprojects.milliyetnewsclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cloneprojects.milliyetnewsclone.adapter.NewsFragmentRecyclerViewAdapter
import com.cloneprojects.milliyetnewsclone.models.NewsModel

class NewsFragmentViewModel() : ViewModel() {


    private var recyclerListData: MutableLiveData<NewsModel>
    private var recyclerViewAdapter: NewsFragmentRecyclerViewAdapter

    init {
        recyclerListData = MutableLiveData()
        recyclerViewAdapter = NewsFragmentRecyclerViewAdapter()

    }

    fun getAdapter(): NewsFragmentRecyclerViewAdapter {
        return recyclerViewAdapter
    }

    fun setAdapterData(data: ArrayList<NewsModel>, onItemClickListener: (NewsModel) -> Unit) {
        recyclerViewAdapter.setDataList(data, onItemClickListener)
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<NewsModel> {

        //Sadece ilk seferde burasi bos gitmesin diye eklendi.Cnku bu olamyinca datayi almmadigi icin Mock data set etme islemini yapamiyor
        recyclerListData.postValue(
            NewsModel(
                "Nothing",
                "Nothing"
            )
        )
        return recyclerListData
    }


}
//    fun makeAPICall() {
//        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
//        val call = retroInstance.getDataFromAPI(input)
//        call.enqueue(object : Callback<RecyclerList>{
//            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
//                recyclerListData.postValue(null)
//            }
//
//            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
//                if(response.isSuccessful){
//                    recyclerListData.postValue(response.body())
//                } else {
//                    recyclerListData.postValue(null)
//                }
//            }
//        })
//    }
//}