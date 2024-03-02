package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class Example3Activity extends AppCompatActivity {

    private LinearLayout linearLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Background Setting");
        setContentView(R.layout.activity_example3);
        linearLayoutId = findViewById(R.id.linearLayoutId);


        if (colorLoad()!=getResources().getColor(R.color.white)){
            linearLayoutId.setBackgroundColor(colorLoad());
        }


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.redColorId){
            linearLayoutId.setBackgroundColor(getResources().getColor(R.color.red));
            colorSave(getResources().getColor(R.color.red));

        } else if (item.getItemId()==R.id.greenColorId) {
            linearLayoutId.setBackgroundColor(getResources().getColor(R.color.green));
            colorSave(getResources().getColor(R.color.green));

        } else if (item.getItemId()==R.id.yellowColorId) {
            linearLayoutId.setBackgroundColor(getResources().getColor(R.color.yellow));
            colorSave(getResources().getColor(R.color.yellow));

        }
        return super.onOptionsItemSelected(item);
    }





    private void colorSave(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("backgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color", color);
        editor.apply();
    }

    private int colorLoad(){
        SharedPreferences sharedPreferences = getSharedPreferences("backgroundColor", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("color",getResources().getColor(R.color.white));
    }




}