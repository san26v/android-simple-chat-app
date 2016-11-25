package com.agilefaqs.chatapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.confengine.chatapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static RecyclerView.Adapter<ChatViewHolder> messagesAdaptor;
    public static RecyclerView messagesList;
    public static List<String> messages;
    public static Utils utils = new Utils();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        messagesAdaptor = new MyRecyclerViewAdapter(MainActivity.this);
        try {

            super.onCreate(savedInstanceState);
            messages = new ArrayList<>();
            setContentView(R.layout.activity_main);
            messagesList = (RecyclerView) findViewById(R.id.messagesList);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            messagesList.setLayoutManager(layoutManager);
            messagesList.addItemDecoration(new DividerItemDecoration(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

        messagesList.setAdapter(messagesAdaptor);
        final EditText messageInput = (EditText) findViewById(R.id.messageInput);
        Button sendButton = (Button) findViewById(R.id.sendButton);
        utils.onClickListener(sendButton, messageInput, MainActivity.this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        utils.downloadMessages(MainActivity.this);
    }
}
