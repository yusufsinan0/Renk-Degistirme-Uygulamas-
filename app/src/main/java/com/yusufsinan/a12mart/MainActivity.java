package com.yusufsinan.a12mart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int enDusuk,enYuksek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar);
       SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
       TextView textView = findViewById(R.id.textView);
       Button button = (Button) findViewById(R.id.button);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            textView.setText(String.valueOf(enDusuk)+"ile" +String.valueOf(enYuksek));

            Intent intent = new Intent(getApplicationContext() , DigerSayfa.class);
            intent.putExtra("enDusuk",enDusuk);
            intent.putExtra("enYuksek",enYuksek);
            startActivity(intent);


           }
       });

       seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               enYuksek = progress;
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

       seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               enDusuk = progress;
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });









    }
}