package com.cloneprojects.milliyetnewsclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloneprojects.milliyetnewsclone.databinding.FragmentNewsBinding
import com.cloneprojects.milliyetnewsclone.models.NewsModel
import com.cloneprojects.milliyetnewsclone.viewmodel.NewsFragmentViewModel
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_newsFragment.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = makeApiCall()
        setupBinding(container, viewModel)
        val view: View = setupBinding(container, viewModel).root
        return view

    }

    fun setupBinding(container: ViewGroup?, viewModel: NewsFragmentViewModel): FragmentNewsBinding {

        val fragmentbinding: FragmentNewsBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_news, container, false)
        fragmentbinding.setVariable(BR.newsFragmentViewModel, viewModel)
        fragmentbinding.executePendingBindings()
        return fragmentbinding
    }

    fun makeApiCall(): NewsFragmentViewModel {
        val viewModel = ViewModelProvider(this).get(NewsFragmentViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(viewLifecycleOwner, Observer<NewsModel> {
            if (it != null) {

                viewModel.setAdapterData(arrayListOf(it)[0].results, { newsDetail ->
                    Toast.makeText(context, "Clicked :  ${newsDetail.title} ", Toast.LENGTH_SHORT)
                        .show()
                })
            } else {
                Toast.makeText(activity?.applicationContext, "No DATA", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.getNewsFeed()
        return viewModel
    }
}