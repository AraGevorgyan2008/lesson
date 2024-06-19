package com.ara.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity5 extends AppCompatActivity {
private EditText user_name_field,user_bio_field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        user_name_field = findViewById(R.id.user_name);
        user_bio_field = findViewById(R.id.user_bio);
    }
        public void goContacts(View view){
        Intent intet = new Intent(this, ContactsActivity.class);
        startActivity(intet);
        }
    public void saveData(View view){
        String username = user_name_field.getText().toString();
        String userbio = user_bio_field.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("example.txt",MODE_PRIVATE);
            fileOutputStream.write((username + ". " + userbio).getBytes());
            fileOutputStream.close();

user_name_field.setText("");
            user_bio_field.setText("");
            Toast.makeText(this, "Text Save", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void getData(View view) throws IOException {
    FileInputStream fileInputStream = openFileInput("example.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader BR = new BufferedReader(inputStreamReader);

        StringBuilder SB = new StringBuilder();
        String lines = "" ;

        while ((lines = BR.readLine()) != null){
            SB.append(lines).append("\n");
        }
        Toast.makeText(this, SB, Toast.LENGTH_SHORT).show();
    }
    public void goWeb(View V){
        Intent web = new Intent(this,WEB.class);
        startActivity(web);
    }
}