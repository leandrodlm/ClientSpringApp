package com.bhsoftworks.clientspringapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import entities.User;
import models.UserRestClient;
import static com.bhsoftworks.clientspringapp.R.id.edt_textId;

public class MainActivity extends AppCompatActivity {

    private Button btn_getUser;
    private EditText edit_textId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_textId = (EditText) findViewById(edt_textId);
        btn_getUser = (Button) findViewById(R.id.btn_findUser);
        btn_getUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(edit_textId.getText().toString());

                new HttpRequestAsk(id).execute();

            }
        });


    }

    private class HttpRequestAsk extends AsyncTask<Void, Void, User> {

        private int id;

        public HttpRequestAsk(int id) {
            this.id = id;
        }

        @Override
        protected User doInBackground(Void... params) {

            UserRestClient userRestClient = new UserRestClient();
            return userRestClient.getUser(id);
        }

        @Override
        protected void onPostExecute(User user) {

            TextView textViewCodigo = (TextView) findViewById(R.id.txt_codigo_response);
            textViewCodigo.setText(String.valueOf(user.getCodigo()));

            TextView textViewNome = (TextView) findViewById(R.id.txt_nome_response);
            textViewNome.setText(String.valueOf(user.getNome()));

            TextView textViewLogin = (TextView) findViewById(R.id.txt_login_response);
            textViewLogin.setText(String.valueOf(user.getLogin()));

            TextView textViewPerfil = (TextView) findViewById(R.id.txt_perfil_response);
            textViewPerfil.setText(String.valueOf(user.getPerfil()));

            TextView textViewSenha = (TextView) findViewById(R.id.txt_senha_response);
            textViewSenha.setText(String.valueOf(user.getSenha()));
        }
    }
}
