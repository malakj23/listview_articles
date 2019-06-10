package com.example.user.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.test.config.ConfigRetrofit;
import com.example.user.test.models.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

      final   Button register= (Button)findViewById(R.id.register);
        final  EditText surname= (EditText)findViewById(R.id.surname);
        final  EditText name= (EditText)findViewById(R.id.name);
        final  EditText mail= (EditText)findViewById(R.id.mail);
        final EditText mdp= (EditText)findViewById(R.id.mdp);
        final  EditText tel= (EditText)findViewById(R.id.tel);
        final EditText jour= (EditText)findViewById(R.id.jour);
        final EditText mois= (EditText)findViewById(R.id.mois);
        final  EditText annee= (EditText)findViewById(R.id.annee);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom= surname.getText().toString();
                String prenom= name.getText().toString();
                String pw= mdp.getText().toString();
                String phone=tel.getText().toString();
                String j= jour.getText().toString();
                String m= mois.getText().toString();
                String a= annee.getText().toString();
                String email=mail.getText().toString();
                final String dn= j+m+a;
                int t= Integer.parseInt(phone);

                if(email.equals("") || pw.equals("") || nom.equals("") || prenom.equals("") || phone.equals("") || dn.equals("")) {
                    Toast.makeText(getApplicationContext(),"SVP remplir tous les champs",Toast.LENGTH_LONG).show();

                }else{

                  IClient client = ConfigRetrofit.retrofit.create(IClient.class);
                    Call<String> call = client.add(nom, prenom, dn, email, pw, t);
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Toast.makeText(getApplicationContext(),"result"+response.body(),Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Erreur"+t.getMessage(),Toast.LENGTH_LONG).show();
                        }

                    });


                }
            }

        });

      }
    }