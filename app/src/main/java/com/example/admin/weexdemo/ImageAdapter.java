package com.example.admin.weexdemo;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * Created by admin on 2016/11/3.
 */

public class ImageAdapter implements IWXImgLoaderAdapter {
    public ImageAdapter() {
    }
    @Override
    public void setImage(final String url, final ImageView view, WXImageQuality quality, WXImageStrategy strategy) {
        WXSDKManager.getInstance().postOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (view == null || view.getLayoutParams() == null)
                    return;
                if (TextUtils.isEmpty(url)){
                    view.setImageBitmap(null);
                    return;
                }
                String tempUrl = url;
                if (!url.startsWith("http")){
                    tempUrl = "file:///android_asset" + url;
                }
                if (view.getLayoutParams().width <=0 || view.getLayoutParams().height <= 0){
                    return;
                }
                Log.e("TAG",tempUrl);
               Picasso.with(WXEnvironment.getApplication()).load(tempUrl).into(view);
            }
        },0);
    }
}
