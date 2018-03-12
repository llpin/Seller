package com.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.IndividualEntityRequest;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TelephoneActivity extends BaseActivity implements BaseInter, View.OnClickListener {
    private final static String TAG = "TelephoneActivity";
    TextInputEditText mTelephone;
    TextInputEditText mVerifyCode;

    private IndividualEntityRequest mIndividualRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);

        mIndividualRequest =
                (IndividualEntityRequest) getIntent().getSerializableExtra(
                        getResources().getString(R.string.individual_extra)
                );
    }

    @Override
    public void initForm() {
        mTelephone = (TextInputEditText)findViewById(R.id.telephone);
        mVerifyCode = (TextInputEditText)findViewById(R.id.verifyCode);
        ((Button)findViewById(R.id.verifyButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.submitButton)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.verifyButton:{
                String telephone = mTelephone.getText().toString();
                HttpApiUtil.getVerifyCode(telephone, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        L.d(TAG, response.body().toString());
                    }
                });
            }
                break;
            case R.id.submitButton: {
                String telephone = mTelephone.getText().toString();
                String verifyCode = mVerifyCode.getText().toString();
                HttpApiUtil.verifyCode(telephone, verifyCode, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        L.d(TAG, response.body().toString());
                    }
                });
            }
                break;
            default:
                break;
        }
    }
}
