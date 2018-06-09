package com.solarexsoft.readcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;

public class ReadOkhttp extends AppCompatActivity {
    OkHttpClient mOkHttpClient;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mOkHttpClient = new OkHttpClient();
    }

    @OnClick({R.id.syncget, R.id.asyncget, R.id.interceptor})
    public void click(View view) {
        int id = view.getId();
        if (id == R.id.syncget) {
            syncget();
        } else if (id == R.id.asyncget) {
            asyncget();
        } else if (id == R.id.interceptor) {
            interceptor();
        }
    }

    private void syncget() {
    }

    private void asyncget() {
    }

    private void interceptor() {
    }
}
