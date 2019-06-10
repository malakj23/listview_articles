package com.example.user.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.test.config.ConfigRetrofit;
import com.example.user.test.models.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        final EditText mailEditText=(EditText) findViewById(R.id.mailEditText) ;
        final EditText mdpEditText=(EditText) findViewById(R.id.mdpEditText);
        Button signUpButton = (Button) findViewById(R.id.signUpButton);
        Button signInButton = (Button) findViewById(R.id.signInButton);




        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail=mailEditText.getText().toString();
                String mdp=mdpEditText.getText().toString();

                if(mail.equals("") || mdp.equals("")) {
                    Toast.makeText(getApplicationContext(), "remplir les champs", Toast.LENGTH_SHORT).show();
                }

                else{

                    final IClient iclient = ConfigRetrofit.retrofit.create(IClient.class);
                    Call<Client> call = iclient.getById(mail, mdp);
                    call.enqueue(new Callback<Client>() {
                        @Override
                        public void onResponse(Call<Client> call, Response<Client> response) {

                            Toast.makeText(getApplicationContext(), "Bienvenue.. ", Toast.LENGTH_SHORT).show();


                            Intent intent = new Intent(login.this, liste.class);
                            startActivity(intent);


                        }

                        @Override
                        public void onFailure(Call<Client> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "erreur d'authentification.. "+t.getMessage(), Toast.LENGTH_LONG).show();
                            Log.i("errrr", t.getMessage());

                        }


                });


                }
            }

        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
