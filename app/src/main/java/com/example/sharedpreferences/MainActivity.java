package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameEdId,passwordEdId;
    private Button SaveId,LoadId;
    private TextView Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEdId = findViewById(R.id.usernameEdId);
        passwordEdId = findViewById(R.id.passwordEdId);
        SaveId = findViewById(R.id.SaveId);
        LoadId = findViewById(R.id.LoadId);
        Display = findViewById(R.id.DisplayId);

        Display.setVisibility(View.INVISIBLE);
        SaveId.setOnClickListener(this);
        LoadId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.SaveId){
            String username = usernameEdId.getText().toString();
            String password = passwordEdId.getText().toString();

            if (username.equals("") || password.equals("")){
                Toast.makeText(this, "Please enter some data", Toast.LENGTH_SHORT).show();
            }else {

                SharedPreferences sharedPreferences = getSharedPreferences("userDataBase", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey", username);
                editor.putString("passwordKey", password);
                editor.apply();
                Toast.makeText(this, "Save your data successfully ", Toast.LENGTH_SHORT).show();
                usernameEdId.setText("");
                passwordEdId.setText("");
            }




        } else if (v.getId()==R.id.LoadId) {

            SharedPreferences sharedPreferences = getSharedPreferences("userDataBase", Context.MODE_PRIVATE);
            if (sharedPreferences.contains("usernameKey") || sharedPreferences.contains("passwordKey")){

                Display.setVisibility(View.VISIBLE);
                String username = sharedPreferences.getString("usernameKey", "data not found");
                String password = sharedPreferences.getString("passwordKey", "data not found");
                Display.setText(username+"\n"+password);
            }
        }

    }



    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void example2Event(View view) {
        startActivity(new Intent(getApplicationContext(), Example2Activity.class));
    }

    public void example3Event(View view) {
        startActivity(new Intent(getApplicationContext(), Example3Activity.class));
    }
}