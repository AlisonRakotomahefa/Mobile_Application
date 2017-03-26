package com.example.aliso.finalproject_alisonrakotomahefa.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.aliso.finalproject_alisonrakotomahefa.R;
import com.example.aliso.finalproject_alisonrakotomahefa.interfaces.OnVideoSelectedListener;
import com.example.aliso.finalproject_alisonrakotomahefa.models.Item;
import com.example.aliso.finalproject_alisonrakotomahefa.viewholders.VideoViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by aliso on 22/03/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private final List<Item> example;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideoAdapter(List<Item> example) {
        this.example = example;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(example.get(position));
    }

    @Override
    public int getItemCount() {
        return example != null ? example.size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}

