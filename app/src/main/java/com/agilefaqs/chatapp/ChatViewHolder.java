package com.agilefaqs.chatapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.confengine.chatapp.R;

/**
 * Created by santosh.vaidyanathan on 18/11/16.
 */

public class ChatViewHolder extends RecyclerView.ViewHolder {
    private final TextView messageTextView;

    public TextView getMessageTextView() {
        return messageTextView;
    }

    public ChatViewHolder(View itemView) {

        super(itemView);
        messageTextView = (TextView) itemView.findViewById(R.id.message);
    }
}



