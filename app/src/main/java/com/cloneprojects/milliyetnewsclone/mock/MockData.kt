package com.cloneprojects.milliyetnewsclone.mock

import com.cloneprojects.milliyetnewsclone.NewsFragment
import com.cloneprojects.milliyetnewsclone.models.FragmentModel
import com.cloneprojects.milliyetnewsclone.models.NewsDetail
import com.cloneprojects.milliyetnewsclone.models.NewsImage
import com.cloneprojects.milliyetnewsclone.models.NewsModel

object MockData {

    fun getNewsCategoryFragment(): List<FragmentModel> {
        val fragmentList = ArrayList<FragmentModel>()

        repeat(getTitleList().size) { position ->
            val newsFragment = NewsFragment()

            val fragmentModel = FragmentModel(
                position,
                getTitleList()[position],
                newsFragment
            )

            fragmentList.add(fragmentModel)
        }

        return fragmentList
    }

    private fun getTitleList(): List<String> {
        val titleList = ArrayList<String>()
        titleList.add("ANASAYFA")
        titleList.add("YAZARLAR")
        titleList.add("GÜNDEM")
        titleList.add("EKONOMİ")
        titleList.add("SPOR")
        titleList.add("CADDE")
        titleList.add("EĞİTİM")
        titleList.add("TEKNOLOJİ")
        return titleList
    }

     fun getMockSmallNewsList(smallListSize: Int): ArrayList<NewsModel> {
         var smallNewsList = ArrayList<NewsModel>()
         var newsResultList = ArrayList<NewsDetail>()
         var newsImageArray = ArrayList<NewsImage>()
         val imageList =
             NewsImage("https://imgfinans.milliyet.com.tr/i/haber/f_dfdf_321421462285.jpg")
         newsImageArray.add(imageList)
         var result = NewsDetail("Title", "Body", newsImageArray)
         newsResultList.add(result)

         var smallNews1 = NewsModel(
             newsResultList
         )
         var smallNews2 = NewsModel(
             newsResultList
         )

         smallNewsList.add(smallNews1)
         smallNewsList.add(smallNews2)

         return smallNewsList



    }
}