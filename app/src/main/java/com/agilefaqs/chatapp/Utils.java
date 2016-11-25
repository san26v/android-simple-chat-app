package com.agilefaqs.chatapp;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.confengine.chatapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by santosh.vaidyanathan on 17/11/16.
 */

public class Utils {


    public static void downloadMessages(final MainActivity mainActivity) {

        HttpURLConnection urlConnection = null;

        try {

            URL url = new URL("http://10.14.122.214:4567/fetchAllMessages");
            urlConnection = (HttpURLConnection) url.openConnection();

            new AsyncTask<HttpURLConnection, Object, List<String>>() {
                @Override
                protected List<String> doInBackground(HttpURLConnection... params) {

                    //  List<String> messages = null;
                    try {
                        InputStream in = params[0].getInputStream();
                        InputStreamReader isw = new InputStreamReader(in);
                        StringBuilder buffer = new StringBuilder();
                        int data;
                        data = isw.read();
                        while (data != -1) {
                            char c = (char) data;
                            buffer.append(c);
                            System.out.print(c);
                            data = isw.read();
                        }
                        Type type = new TypeToken<List<String>>() {
                        }.getType();
                        MainActivity.messages = new Gson().fromJson(buffer.toString(), type);
                    } catch (Exception e) {
                        Log.e("", e.getMessage(), e);
                    }
                    return MainActivity.messages;
                }

                @Override
                protected void onPostExecute(List<String> m) {
                    if (MainActivity.messages != null) {
                        MainActivity.messages = m;
                        MainActivity.messagesAdaptor.notifyDataSetChanged();
                        MainActivity.messagesList.scrollToPosition(MainActivity.messagesAdaptor.getItemCount() - 1);
                    } else {
                        Toast.makeText(mainActivity, "Could not fetch messages", Toast.LENGTH_SHORT).show();
                    }
                }
            }.execute(urlConnection);
        } catch (Exception e) {
            Log.e("", e.getMessage(), e);
        } finally {
            urlConnection.disconnect();
        }
    }

    public void onClickListener(Button sendButton , final EditText messageInput, final MainActivity mainActivity) {

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpURLConnection urlConnection = null;
                try {

                    String msg = messageInput.getText().toString();
                    MainActivity.messages.add(msg);
                    MainActivity.messagesAdaptor.notifyDataSetChanged();
                    MainActivity.messagesList.scrollToPosition(MainActivity.messagesAdaptor.getItemCount() - 1);
                    URL url = new URL("http://10.14.122.214:4567/send?message=" + msg);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    new AsyncTask<HttpURLConnection, Object, Boolean>() {
                        @Override
                        protected Boolean doInBackground(HttpURLConnection... params) {

                            try {
                                InputStream in = params[0].getInputStream();
                                InputStreamReader isw = new InputStreamReader(in);
                                StringBuffer buffer = new StringBuffer();
                                int data;
                                data = isw.read();
                                while (data != -1) {
                                    char c = (char) data;
                                    buffer.append(c);
                                    System.out.print(c);
                                    data = isw.read();
                                }
                                Log.d("", buffer.toString());
                            } catch (Exception e) {
                                Log.e("", e.getMessage(), e);
                                return false;
                            }
                            return true;
                        }

                        @Override
                        protected void onPostExecute(Boolean status) {
                            if (status) {
                                MainActivity.messages.add(messageInput.getText().toString());
                                MainActivity.messagesAdaptor.notifyDataSetChanged();
                                MainActivity.messagesList.scrollToPosition(MainActivity.messagesAdaptor.getItemCount() - 1);
                                Utils.downloadMessages(mainActivity);
                                messageInput.setText("");
                                Toast.makeText(mainActivity, "Message sent", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(mainActivity, "Message send failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }.execute(urlConnection);
                } catch (Exception e) {
                    Log.e("", e.getMessage(), e);
                } finally {
                    urlConnection.disconnect();
                }
            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Utils.downloadMessages(mainActivity);
            }
        }, SECONDS.toMillis(1), SECONDS.toMillis(10));
    }


//    public static void toastMessagePrinter(MainActivity mainActivity , String messageToPrint, int timePeriod){
//        Toast.makeText(mainActivity, "Could not fetch messages", timePeriod).show();
//
//    }
}

