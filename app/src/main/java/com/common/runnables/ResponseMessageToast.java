package com.common.runnables;

import android.content.Context;

import com.common.pojo.BaseResultResponse;
import com.common.utils.ToastUtil;

/**
 * Created by linlipin on 18/3/1.
 */

public class ResponseMessageToast<T> implements Runnable {
    private BaseResultResponse<T> resultResponse;
    private Context ct;

    public ResponseMessageToast(BaseResultResponse<T> resultResponse, Context ct) {
        this.resultResponse = resultResponse;
        this.ct = ct;
    }

    @Override
    public void run() {
        ToastUtil.showLong(ct, resultResponse.getMessage());
    }
}
