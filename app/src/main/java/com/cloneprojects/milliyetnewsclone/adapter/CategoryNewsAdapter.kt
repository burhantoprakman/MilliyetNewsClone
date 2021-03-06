package com.cloneprojects.milliyetnewsclone.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cloneprojects.milliyetnewsclone.models.FragmentModel

class CategoryNewsAdapter(
    fragmentManager: FragmentManager,
    private val newsFragmentList: List<FragmentModel>
) : FragmentStatePagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getCount(): Int = newsFragmentList.size

    override fun getItem(position: Int): Fragment = newsFragmentList[position].fragment

    override fun getPageTitle(position: Int): CharSequence? =
        newsFragmentList[position].fragmentTitle
}