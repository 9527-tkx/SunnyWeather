package com.example.zhpan.banner.net

import androidx.annotation.DrawableRes
import com.sunnyweather.android.R

/**
 * <pre>
 * Created by zhangpan on 2019-08-14.
 * Description:
</pre> *
 */
class BannerData {
    var desc: String? = null
    var id = 0
    var imagePath: String? = null
    var isVisible = 0
    var order = 0
    var title: String? = null
    var type = 0
    var url: String? = null
    var drawable = 0

    @get:DrawableRes
    @DrawableRes
    val placeHolder: Int = R.drawable.placeholder

    companion object {
        /**
         * desc :
         * id : 20
         * imagePath : https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png
         * isVisible : 1
         * order : 2
         * title : flutter 中文社区
         * type : 1
         * url : https://flutter.cn/
         */
        const val TYPE_NEW = 10000
    }
}
