package com.color_analysis_in_xinjiangtimes.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.color_analysis_in_xinjiangtimes.R;

/**
 * author 万强
 * date 16/6/12 下午2:11
 * desc ${TODO}
 */
public class GlideUtils {

    /**
     * 加载网络图片，没有图片的情况下 显示本地默认图片
     * @param activity
     * @param url
     * @param imageView
     */
    public static void loadImage(Activity activity, String url, ImageView imageView) {
        Glide.with(activity).load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }
}
