package com.ara.myapplication1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity4 extends AppCompatActivity {
private Button frangment1,frangment2;
private FirstFrangment firstFrangment = new FirstFrangment();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        frangment1 = findViewById(R.id.frangment1);
        frangment2 = findViewById(R.id.frangment2);
        setnewFrangment(firstFrangment);
        frangment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnewFrangment(firstFrangment);
            }
        });
        frangment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFrangment secondFrangment = new SecondFrangment();
                setnewFrangment(secondFrangment);
            }
        });

    }
    private void setnewFrangment(Fragment frangment){
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout,frangment);
        ft.addToBackStack(null);
        ft.commit();

    }
}