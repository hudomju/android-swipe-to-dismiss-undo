android-swipe-to-dismiss-undo
=============================

Library to make the items in a `ListView` or `RecyclerView` dismissable with the possibility to undo it, using your own view to provide this functionality like the Gmail app for Android does.


Usage
==============

With a `ListView`:

<pre><code>
final SwipeToDismissTouchListener<ListViewAdapter> touchListener =
                new SwipeToDismissTouchListener<>(
                        new ListViewAdapter(listView),
                        new SwipeToDismissTouchListener.DismissCallbacks<ListViewAdapter>() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListViewAdapter view, int position) {
                                adapter.remove(position);
                            }
                        });
        listView.setOnTouchListener(touchListener);
        listView.setOnScrollListener((AbsListView.OnScrollListener) touchListener.makeScrollListener());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (touchListener.existPendingDismisses()) {
                    touchListener.undoPendingDismiss();
                } else {
                    Toast.makeText(ListViewActivity.this, "Position " + position, LENGTH_SHORT).show();
                }
            }
        });
</code></pre>

With a `RecyclerView`:

<pre><code>
final SwipeToDismissTouchListener<RecyclerViewAdapter> touchListener =
                new SwipeToDismissTouchListener<>(
                        new RecyclerViewAdapter(recyclerView),
                        new SwipeToDismissTouchListener.DismissCallbacks<RecyclerViewAdapter>() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(RecyclerViewAdapter view, int position) {
                                adapter.remove(position);
                            }
                        });

        recyclerView.setOnTouchListener(touchListener);
        recyclerView.setOnScrollListener((RecyclerView.OnScrollListener) touchListener.makeScrollListener());
        recyclerView.addOnItemTouchListener(new SwipeableItemClickListener(this,
                new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (view.getId() == R.id.txt_delete) {
                            touchListener.processPendingDismisses();
                        } else if (view.getId() == R.id.txt_undo) {
                            touchListener.undoPendingDismiss();
                        } else { // R.id.txt_data
                            Toast.makeText(RecyclerViewActivity.this, "Position " + position, LENGTH_SHORT).show();
                        }
                    }
                }));
</code></pre>


Special Thanks
==============

Romman Nurik for the initial contribution with [swipe to dismiss](https://github.com/romannurik/Android-SwipeToDismiss) for `ListView`

See the original [Google+ post](https://plus.google.com/+RomanNurik/posts/Fgo1p5uWZLu) for discussion.

See also [Jake Wharton's port](https://github.com/JakeWharton/SwipeToDismissNOA) of this sample code to old versions of Android using the [NineOldAndroids](http://nineoldandroids.com/) compatibility library.

<img src="https://lh4.googleusercontent.com/-b0pxPcJBF1o/T-ZWx9NZSRI/AAAAAAAAe_Q/PAKmNzGSbzs/w635-h688-no/foo.png" width="300">
