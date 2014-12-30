package com.hudomju.swipe;

import android.view.View;

/**
 * Interface definition for a callback to be invoked when an item in this collection view has been
 * clicked.
 */
public interface OnItemClickListener {

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getChildAt(position) if they need to access the data associated with
     * the selected item.
     *
     * @param view The view within the AdapterView that was clicked (this will be a view provided
     *             by the adapter)
     * @param position The position of the view in the adapter.
     */
    public void onItemClick(View view, int position);
}