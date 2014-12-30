package com.hudomju.swipe.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    /** Called from xml */
    public void onGoToListViewClicked(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    /** Called from xml */
    public void onGoToRecyclerViewClicked(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
