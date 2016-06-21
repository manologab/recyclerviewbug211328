package com.bugs.recyclerviewbug211328;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private static final String TAG = GridAdapter.class.getName();

    private final GridFragment.Listener mListener;

    public GridAdapter(GridFragment.Listener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        mListener.onCreateViewHolderCalled();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder position=" + position);
        mListener.onBindViewHolderCalled();
        holder.mContentView.setText("Item "+position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
