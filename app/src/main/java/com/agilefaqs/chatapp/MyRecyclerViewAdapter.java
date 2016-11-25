package com.agilefaqs.chatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.confengine.chatapp.R;

import java.util.List;

/**
 * Created by santosh.vaidyanathan on 22/11/16.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<ChatViewHolder> {
    private Context context =null;

    public MyRecyclerViewAdapter(MainActivity mainActivity) {
        this.context = mainActivity.getApplicationContext();
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item_message, parent, false);
        return new ChatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        holder.getMessageTextView().setText(MainActivity.messages.get(position));

    }

    @Override
    public int getItemCount() {
        return MainActivity.messages.size();
    }
}
