package com.sunnyweather.android.ui.first

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ToastUtils
import com.sunnyweather.android.R
import com.sunnyweather.android.ui.adapter.CustomBean
import com.sunnyweather.android.ui.adapter.SimpleAdapter

import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.BannerViewPager.OnPageClickListener
import com.zhpan.bannerview.utils.BannerUtils
import com.zhpan.indicator.enums.IndicatorSlideMode
import java.util.ArrayList


class HomeActivity : AppCompatActivity() {


    private lateinit var mViewPager: BannerViewPager<CustomBean>

    private fun setupViewPager() {
        mViewPager = findViewById(R.id.banner_view)
        mViewPager.apply {
            adapter = SimpleAdapter()
            setLifecycleRegistry(lifecycle)
        }.create()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT

        setContentView(R.layout.activity_home)

        setupViewPager()



    }
    private fun pageClick(view: View, position: Int) {
        if (position != mViewPager.currentItem) {
            mViewPager.setCurrentItem(position, true)
        }
        ToastUtils.showShort("position:$position")
    }
  }