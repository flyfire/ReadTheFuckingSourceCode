package com.solarexsoft.readcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.okhttp, R.id.retrofit, R.id.volley, R.id.glide, R.id.rxjava})
    public void click(View view) {
        int id = view.getId();
        Intent intent = null;
        if (id == R.id.okhttp) {
            intent = new Intent(this, ReadOkhttp.class);
        } else if (id == R.id.retrofit) {
            intent = new Intent(this, ReadRetrofit.class);
        } else if (id == R.id.volley) {
            intent = new Intent(this, ReadVolley.class);
        } else if (id == R.id.glide) {
            intent = new Intent(this, ReadGlide.class);
        } else if (id == R.id.rxjava) {
            intent = new Intent(this, ReadRxJava.class);
        }
        startActivity(intent);
    }
}
