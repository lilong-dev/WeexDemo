package com.example.admin.weexdemo;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.WXTextView;

import static android.R.attr.name;

/**
 * Created by admin on 2016/11/16.
 */

public class RichText extends WXComponent{
    private String mLink;
    public RichText(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, boolean isLazy) {
        super(instance, dom, parent, isLazy);
    }

    @Override
    protected void initView() {
        mHost=new TextView(mContext);
    }


    @WXComponentProp(name = "content")
    public void setContent(String content){
        SpannableStringBuilder builder = new SpannableStringBuilder();
        if(mLink != null){
            SpannableString link = new SpannableString(mLink);
            link.setSpan(new ForegroundColorSpan(Color.rgb(0, 207, 199)),
                    0, link.length(),
                    SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.append(link).append("  ");
        }
        if(content != null){
            SpannableString topicContent = new SpannableString(
                    content);
            builder.append(topicContent);
        }
        ((TextView)mHost).setText(builder);
    }
    @WXComponentProp(name = "link")
    public void setLink(String link){
        this.mLink = link;
    }
}
