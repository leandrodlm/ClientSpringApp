package com.bhsoftworks.clientspringapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
import adapters.UserListAdapter;
import entities.User;
import models.UserRestClient;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        new HttpRequestAsk().execute();
    }


    private class HttpRequestAsk extends AsyncTask<Void, Void, List<User>> {


        @Override
        protected List<User> doInBackground(Void... params) {
            UserRestClient userRestClient = new UserRestClient();
            return userRestClient.getAll();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            ListView listViewUser = (ListView) findViewById(R.id.listViewUser);
            listViewUser.setAdapter(new UserListAdapter(getApplicationContext(), users));
        }
    }
}
