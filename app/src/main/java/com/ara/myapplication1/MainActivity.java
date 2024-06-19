package com.ara.myapplication1;

import static android.graphics.Color.*;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Button frang,welcome;
    private FrameLayout ankap_fl;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button2);
        frang = findViewById(R.id.Dizayn);
        ankap_fl = findViewById(R.id.ankap_fram_layout);
        welcome = findViewById(R.id.Welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertShow("Duq uzum eq pakel cragir@");
            }
        });
        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ankap ankap = new ankap();
                goWelcomeFrame(ankap);
            }
        });

    }
    private void goWelcomeFrame(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.ankap_fram_layout,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
    public  void ssecondactiviti(View v){
        Intent a = new Intent(this,MainActivity4.class);
        startActivity(a);
    }
    public void DizaynAct(View v){
        Intent M5 = new Intent(this, MainActivity5.class);
        startActivity(M5);
    }

    public void btn_clic(View v){
    showtext(((Button) v).getText().toString(),(Button) v);
    }
    public  void secondactiviti(View v){
        Intent a = new Intent(this,MainActivity2.class);
        startActivity(a);
    }
public void AlertShow(String str){
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Karevor harc")
            .setMessage(str)
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();
                }
            });
    AlertDialog fin = builder.create();
    fin.show();

}
    private  void showtext(String text,Button b){
      Intent intent = new Intent(this,MainActivity3.class);
        Toast.makeText(this,
                text,
                Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

}