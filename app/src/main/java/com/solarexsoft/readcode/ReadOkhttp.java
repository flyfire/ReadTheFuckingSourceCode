package com.solarexsoft.readcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.concurrent.Executors;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class ReadOkhttp extends AppCompatActivity {
    public static final String TAG = ReadOkhttp.class.getSimpleName();
    OkHttpClient mOkHttpClient;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
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
        Executors.newFixedThreadPool(1).submit(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder().url("http://www.baidu.com").get().build();
                Call call = mOkHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    String body = response.body().string();
                    Log.d(TAG, body);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void asyncget() {
        Request request = new Request.Builder().url("http://www.baidu.com").get().build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d(TAG, e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, body);
            }
        });
    }

    private void interceptor() {
    }
}
