package com.hudomju.swipe.adapter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/**
 * Adapter the given View due to non-compatible interfaces but similar functionality.
 */
public interface ViewAdapter {
    Context getContext();
    int getWidth();
    int getChildCount();
    void getLocationOnScreen(int[] locations);
    View getChildAt(int index);
    int getChildPosition(View position);
    void requestDisallowInterceptTouchEvent(boolean disallowIntercept);
    void onTouchEvent(MotionEvent e);
}
