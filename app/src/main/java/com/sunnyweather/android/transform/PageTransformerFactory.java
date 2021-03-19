package com.sunnyweather.android.transform;


import static com.sunnyweather.android.transform.TransformerStyle.ACCORDION;
import static com.sunnyweather.android.transform.TransformerStyle.DEPTH;
import static com.sunnyweather.android.transform.TransformerStyle.ROTATE;
import static com.sunnyweather.android.transform.TransformerStyle.SCALE_IN;
import static com.sunnyweather.android.transform.TransformerStyle.STACK;

import androidx.viewpager2.widget.ViewPager2;

import com.zhpan.bannerview.transform.ScaleInTransformer;

public class PageTransformerFactory {

    public static ViewPager2.PageTransformer createPageTransformer(int transformerStyle) {
        ViewPager2.PageTransformer transformer = null;
        switch (transformerStyle) {
            case DEPTH:
                transformer = new DepthPageTransformer();
                break;
            case ROTATE:
                transformer = new RotateUpTransformer();
                break;
            case STACK:
                transformer = new StackTransformer();
                break;
            case ACCORDION:
                transformer = new AccordionTransformer();
                break;
            case SCALE_IN:
                transformer = new ScaleInTransformer(ScaleInTransformer.DEFAULT_MIN_SCALE);
                break;
        }
        return transformer;
    }
}
