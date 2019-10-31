package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username_EditText, password_EditText;
    private Button login_Button;
    private TextView attempts_TextView;
    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_EditText = findViewById(R.id.userName_id);
        password_EditText = findViewById(R.id.password_id);
        login_Button = findViewById(R.id. login_id);
        attempts_TextView = findViewById(R.id. attempts_id);
        attempts_TextView.setText("Number of attempts remaining : 3");

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String userName = username_EditText.getText().toString();
                    String password = password_EditText.getText().toString();

                    if (userName.equals("admin") && password.equals("1234")){
                        Intent intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);
                    }
                    else {
                        count --;
                        attempts_TextView.setText("Number of attempts remaining : " + count);
                        if (count == 0){
                            login_Button.setEnabled(false);
                        }
                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Exception : " + e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
