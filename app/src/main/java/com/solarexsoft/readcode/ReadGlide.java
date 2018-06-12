package com.solarexsoft.readcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReadGlide extends AppCompatActivity {
    @BindView(R.id.iv)
    ImageView mImageView;
    private String url = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2258376971," +
            "795754138&fm=27&gp=0.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.simpleuse)
    public void click(View view) {
        int id = view.getId();
        if (id == R.id.simpleuse) {
            Glide.with(this).load(url).into(mImageView);
        }
    }
}
