package com.example.sqlite_14s;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TorlesActivity extends AppCompatActivity {

    private EditText editTextIdTor;
    private Button buttonTorles;
    private Button buttonVisszaTor;
    private DBHelper adatabazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torles);
        init();
        buttonVisszaTor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        TorlesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonTorles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextIdTor.getText().toString().trim();
                if (id.isEmpty()){
                    Toast.makeText(TorlesActivity.this,
                            "Nem lehet üres mező", Toast.LENGTH_SHORT).show();
                } else {
                    if (adatabazis.torles(id) == 0) {
                        Toast.makeText(TorlesActivity.this,
                                "Sikertelen törlés", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(TorlesActivity.this,
                                "Sikeres törlés", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void init() {
        editTextIdTor = findViewById(R.id.editTextIdTor);
        buttonTorles = findViewById(R.id.buttonTorles);
        buttonVisszaTor = findViewById(R.id.buttonVisszaTor);
        adatabazis = new DBHelper(TorlesActivity.this);
    }
}