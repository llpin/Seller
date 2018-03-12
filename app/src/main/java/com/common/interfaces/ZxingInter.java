package com.common.interfaces;


import android.app.Activity;
import android.content.Intent;

/**
 * Created by linlipin on 18/1/3.
 */

public interface ZxingInter {
//    void zxingInit();
    void startCaptureActivity(Activity activity, Long contractId);
    void startCaptureActivityRunnable(Activity activity, Long contractId);
//    void onCaptureActivityResult(int requestCode, int resultCode, Intent data);
//    void resultSuccess(final String result);
//    void resultError();
}
