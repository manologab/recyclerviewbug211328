package com.bugs.recyclerviewbug211328;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements GridFragment.Listener {

    TextView createCallsView;
    TextView bindCallsView;

    int createCalls = 0;
    int bindCalls = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCallsView = (TextView)findViewById(R.id.main_create_calls);
        bindCallsView = (TextView)findViewById(R.id.main_bind_calls);
        GridFragment fragment = new GridFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        createCalls = 0;
        bindCalls = 0;
    }

    @Override
    public void onBindViewHolderCalled() {
        bindCalls++;
        bindCallsView.setText(getString(R.string.bind_calls, bindCalls));
    }

    @Override
    public void onCreateViewHolderCalled() {
        createCalls++;
        createCallsView.setText(getString(R.string.create_calls, createCalls));
    }
}
