package com.iamdeveloper.recyclerviewaddremoverippleanimation;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by IamDeveloper on 8/16/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private OnItemClick itemClick;
    private ArrayList<String> list = new ArrayList<>();

    public MyAdapter(ArrayList<String> list, OnItemClick itemClick) {
        this.list = list;
        this.itemClick = itemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View firstview = inflater.inflate(R.layout.content_text, parent, false);

        return new ViewHolder(firstview);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onItemClick(view, holder.getAdapterPosition());
            }
        });
        Log.i("data",list.get(position));
        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
