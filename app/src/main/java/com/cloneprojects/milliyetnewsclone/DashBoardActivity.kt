package com.cloneprojects.milliyetnewsclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cloneprojects.milliyetnewsclone.adapter.CategoryNewsAdapter
import com.cloneprojects.milliyetnewsclone.mock.MockData
import com.cloneprojects.milliyetnewsclone.util.extGetDrawable
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        init()
    }

    private  fun init(){
        vp_dashboard.adapter =
            CategoryNewsAdapter(
                supportFragmentManager,
                MockData.getNewsCategoryFragment()
            )

        tl_dashboard.setupWithViewPager(vp_dashboard)

        toolbar.logo = extGetDrawable(R.drawable.milliyet_logo_white)

    }


}