package com.sunnyweather.android.ui.first

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.blankj.utilcode.util.ToastUtils
import com.sunnyweather.android.MainActivity
import com.sunnyweather.android.R
import com.sunnyweather.android.transform.PageTransformerFactory
import com.sunnyweather.android.transform.TransformerStyle
import com.sunnyweather.android.ui.adapter.CustomBean
import com.sunnyweather.android.ui.adapter.SimpleAdapter
import com.sunnyweather.android.utils.BaseDataActivity
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.utils.BannerUtils
import com.zhpan.indicator.enums.IndicatorSlideMode
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

class WelcomeActivity : BaseDataActivity() {

    private lateinit var mViewPager: BannerViewPager<CustomBean>

    private val des = arrayOf("老师\n这是我做的第一个 App", "做的不好\n请多指教", "所以\n麻烦您了！")

    private val transforms = intArrayOf(TransformerStyle.NONE, TransformerStyle.ACCORDION, TransformerStyle.DEPTH, TransformerStyle.ROTATE, TransformerStyle.SCALE_IN)

    private val data: List<CustomBean>
        get() {
            val list = ArrayList<CustomBean>()
            for (i in mDrawableList.indices) {
                val customBean = CustomBean()
                customBean.imageRes = mDrawableList[i]
                customBean.imageDescription = des[i]
                list.add(customBean)
            }
            return list
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setupViewPager()
        updateUI(0)
    }

    private fun setupViewPager() {
        mViewPager= findViewById(R.id.viewpager)
        mViewPager.apply {
            setCanLoop(false)
            setPageTransformer(PageTransformerFactory.createPageTransformer(transforms[Random().nextInt(5)]))
            setIndicatorMargin(0, 0, 0, resources.getDimension(R.dimen.dp_100).toInt())
            setIndicatorSliderGap(resources.getDimension(R.dimen.dp_10).toInt())
            setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorSliderRadius(resources.getDimension(R.dimen.dp_3).toInt(), resources.getDimension(R.dimen.dp_4_5).toInt())
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    BannerUtils.log("position:$position")
                    updateUI(position)
                }
            })
            adapter = SimpleAdapter().apply {
                mOnSubViewClickListener = object : SimpleAdapter.OnSubViewClickListener {
                    override fun onViewClick(view: View?, position: Int) {
                        ToastUtils.showShort("Logo Clicked,position:$position")
                    }
                }
            }
            setIndicatorSliderColor(ContextCompat.getColor(this@WelcomeActivity, R.color.white),
                ContextCompat.getColor(this@WelcomeActivity, R.color.white_alpha_75))
        }.create(data)
    }

    fun onClick(view: View) {
        MainActivity.startLogin(this)
        finish()
    }

    private fun updateUI(position: Int) {
        tv_describe?.text = des[position]
        val translationAnim = ObjectAnimator.ofFloat(tv_describe, "translationX", -120f, 0f)
        translationAnim.apply {
            duration = ANIMATION_DURATION.toLong()
            interpolator = DecelerateInterpolator()
        }
        val alphaAnimator = ObjectAnimator.ofFloat(tv_describe, "alpha", 0f, 1f)
        alphaAnimator.apply {
            duration = ANIMATION_DURATION.toLong()
        }
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(translationAnim, alphaAnimator)
        animatorSet.start()

        if (position == mViewPager.data.size - 1 && btn_start?.visibility == View.GONE) {
            btn_start?.visibility = View.VISIBLE
            tv_sorry?.visibility =View.VISIBLE
            ObjectAnimator
                    .ofFloat(btn_start, "alpha", 0f, 1f)
                    .setDuration(ANIMATION_DURATION.toLong()).start()
            ObjectAnimator
                .ofFloat(tv_sorry, "alpha", 0f, 1f)
                .setDuration(ANIMATION_DURATION.toLong()).start()
        } else {
            btn_start?.visibility = View.GONE
            tv_sorry?.visibility =View.GONE
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 1300
    }
}
