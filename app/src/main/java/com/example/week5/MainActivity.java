package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText user_name,pass_word;
    Button log_in,re_set;
    int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = findViewById(R.id.u_name);
        pass_word = findViewById(R.id.passw);
        log_in = findViewById(R.id.but_login);
        re_set = findViewById(R.id.but_clear);


        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_name.getText().toString();
                String password = pass_word.getText().toString();
                if(username.equals("admin") && password.equals("123456")){
                    Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    counter = counter + 1;
                        if(counter == 3){
                            Toast.makeText(MainActivity.this,"You Login Failed 3 times",Toast.LENGTH_SHORT).show();
                        }
                        if (counter == 4){
                            Toast.makeText(MainActivity.this,"You Login Failed 4 times",Toast.LENGTH_SHORT).show();
                        }
                        if (counter == 5){
                            Toast.makeText(MainActivity.this,"You Login Failed 5 times Account is LOCKED",Toast.LENGTH_SHORT).show();
                            log_in.setEnabled(false);
                        }
                }
            }
        });


        re_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name.setText("");
                pass_word.setText("");
                //log_in.setEnabled(true);
            }
        });




    }
}