package com.cloneprojects.milliyetnewsclone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cloneprojects.milliyetnewsclone.adapter.NewsFragmentRecyclerViewAdapter
import com.cloneprojects.milliyetnewsclone.mock.MockData
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(R.layout.fragment_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_newsFragment.adapter =
            NewsFragmentRecyclerViewAdapter(
                MockData.getMockSmallNewsList(10)
            ) { newsModel ->

            }

    }
}