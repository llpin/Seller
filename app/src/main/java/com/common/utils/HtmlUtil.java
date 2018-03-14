package com.common.utils;

import android.text.Html;

/**
 * Created by linlipin on 18/3/14.
 */

public class HtmlUtil {
    public static CharSequence fromHtml(String content){
        CharSequence charSequence;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            charSequence = Html.fromHtml(content,Html.FROM_HTML_MODE_LEGACY);
        } else {
            charSequence = Html.fromHtml(content);
        }
        return charSequence;
    }
}
