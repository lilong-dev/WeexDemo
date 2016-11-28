package com.example.admin.weexdemo.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import com.example.admin.weexdemo.R;

public class MainActivity extends AbstractWeexActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContainer((ViewGroup) findViewById(R.id.linearLayout));
        renderPageByURL("dist/template/main.js","http://192.168.1.44:8081/");
    }
}
