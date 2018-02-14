package com.example.david.androidlabs18w;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.i(ACTIVITY_NAME, "In onCreate()");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");
    }
    @Override
    protected void onStart(){

        Button buttonLogin = (Button)findViewById(R.id.button2);
        EditText txtUserName = (EditText)findViewById(R.id.textEmailAddress);

        super.onStart();
        SharedPreferences prefs =
                getApplicationContext().getSharedPreferences("DefaultEmail", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        String restoredEmail = prefs.getString("DefaultEmail",null);
        txtUserName.setText(restoredEmail);

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v){

                editor.putString("DefaultEmail", "email@domain.com");
                editor.commit();
                Log.i(ACTIVITY_NAME, "In onStart()");
                Intent intent = new Intent(LoginActivity.this, ListItemsActivity.class);
                startActivity(intent);
            }
        });//fgfgfg
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");
    }
}
