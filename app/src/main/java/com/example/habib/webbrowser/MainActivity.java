package com.example.habib.webbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etxURL;
    Button btnGo, btnGoogle, btnFacebook,btnOfflinepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxURL = findViewById(R.id.edtxt_url);
        btnOfflinepage = findViewById(R.id.btn_offline);
        btnGo = findViewById(R.id.btn_go);
        btnGoogle = findViewById(R.id.btn_google);
        btnFacebook = findViewById(R.id.btn_fb);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etxURL.getText().toString();
                if (url.isEmpty()) {
                    etxURL.setError("Please Enter Url");
                    etxURL.requestFocus();
                } else {
                    Intent intent = new Intent(MainActivity.this, WebActivity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);
                }
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url", "www.google.com");
                startActivity(intent);

            }
        });
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url", "www.facebook.com");
                startActivity(intent);
            }
        });
        btnOfflinepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url", "offline");
                startActivity(intent);
            }
        });
    }

}
