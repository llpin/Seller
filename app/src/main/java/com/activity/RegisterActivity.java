package com.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.common.interfaces.BaseInter;
import com.common.pojo.IndividualEntityRequest;
import com.common.pojo.UserEntityRequest;

public class RegisterActivity extends AppCompatActivity implements BaseInter,View.OnClickListener {
    private TextInputEditText mUserNameInput;
    private TextInputEditText mPasswordInput;
    private TextInputEditText mDoPasswordInput;
    private TextView nextTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initForm();
    }


    @Override
    public void initForm() {
        mUserNameInput = (TextInputEditText) findViewById(R.id.username);
        mPasswordInput = (TextInputEditText) findViewById(R.id.password);
        mDoPasswordInput = (TextInputEditText) findViewById(R.id.doPassword);
        nextTextView = (TextView) findViewById(R.id.nextTextView);

        nextTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.nextTextView: {
                UserEntityRequest userEntityRequest = new UserEntityRequest();
                userEntityRequest.setUsername(
                        mUserNameInput.getText().toString()
                );
                userEntityRequest.setPassword(
                        mPasswordInput.getText().toString()
                );
                userEntityRequest.setDoPassword(
                        mDoPasswordInput.getText().toString()
                );

                IndividualEntityRequest individualRequest = new IndividualEntityRequest();
                individualRequest.setUser(userEntityRequest);
                Intent intent = new Intent(RegisterActivity.this, IndividualActivity.class);
                intent.putExtra(
                        getResources().getString(R.string.individual_extra) ,
                        individualRequest);
                startActivity(intent);
            }

                break;
            default:
                break;
        }
    }
}
