//package com.agilefaqs.chatapp;
//
//import android.os.AsyncTask;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.lang.reflect.Type;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//
///**
// * Created by santosh.vaidyanathan on 22/11/16.
// */
//
//public class DownloadTest extends AsyncTask<HttpURLConnection, Object, List<String>> {
//
////    private List<String> messages;
////    private RecyclerView.Adapter<ChatViewHolder> messagesAdaptor;
////    private RecyclerView messagesList;
////    private MainActivity mainActivity;
//
////    @Override
////    protected Object doInBackground(Object[] params) {
////        return null;
////    }
//
//
//    @Override
//    protected List<String> doInBackground(HttpUR//package com.agilefaqs.chatapp;
//
//import android.os.AsyncTask;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.lang.reflect.Type;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//
///**
// * Created by santosh.vaidyanathan on 22/11/16.
// */
//
//public class DownloadTest extends AsyncTask<HttpURLConnection, Object, List<String>> {
//
////    private List<String> messages;
////    private RecyclerView.Adapter<ChatViewHolder> messagesAdaptor;
////    private RecyclerView messagesList;
////    private MainActivity mainActivity;
//
////    @Override
////    protected Object doInBackground(Object[] params) {
////        return null;
////    }
//
//
//    @Override
//    protected List<String> doInBackground(HttpURLConnection... params) {
//
//        //  List<String> messages = null;
//
//        try {
//            InputStream in = params[0].getInputStream();
//            InputStreamReader isw = new InputStreamReader(in);
//            StringBuilder buffer = new StringBuilder();
//            int data;
//            data = isw.read();
//            while (data != -1) {
//                char c = (char) data;
//                buffer.append(c);
//                System.out.print(c);
//                data = isw.read();
//            }
//            Type type = new TypeToken<List<String>>() {
//            }.getType();
//            MainActivity.messages = new Gson().fromJson(buffer.toString(), type);
//        } catch (Exception e) {
//            Log.e("", e.getMessage(), e);
//        }
//        return MainActivity.messages;
//    }
//
//    @Override
//    protected void onPostExecute(List<String> m) {
//        if (Main != null) {
//            MainActivity.messages = m;
//            MainActivity.messagesAdaptor.notifyDataSetChanged();
//            MainActivity.messagesList.scrollToPosition(MainActivity.messagesAdaptor.getItemCount() - 1);
//        } else {
//            Utils.toastMessagePrinter(MainActivity., "Could not fetch messages", Toast.LENGTH_SHORT);
//            //Toast.makeText(MainActivity.this, , Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//}
//LConnection... params) {
//
//        //  List<String> messages = null;
//
//        try {
//            InputStream in = params[0].getInputStream();
//            InputStreamReader isw = new InputStreamReader(in);
//            StringBuilder buffer = new StringBuilder();
//            int data;
//            data = isw.read();
//            while (data != -1) {
//                char c = (char) data;
//                buffer.append(c);
//                System.out.print(c);
//                data = isw.read();
//            }
//            Type type = new TypeToken<List<String>>() {
//            }.getType();
//            MainActivity.messages = new Gson().fromJson(buffer.toString(), type);
//        } catch (Exception e) {
//            Log.e("", e.getMessage(), e);
//        }
//        return MainActivity.messages;
//    }
//
//    @Override
//    protected void onPostExecute(List<String> m) {
//        if (Main != null) {
//            MainActivity.messages = m;
//            MainActivity.messagesAdaptor.notifyDataSetChanged();
//            MainActivity.messagesList.scrollToPosition(MainActivity.messagesAdaptor.getItemCount() - 1);
//        } else {
//            Utils.toastMessagePrinter(MainActivity., "Could not fetch messages", Toast.LENGTH_SHORT);
//            //Toast.makeText(MainActivity.this, , Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//}
