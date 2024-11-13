package com.example.myapplicationniggers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isOn = false;
    private boolean isColdMode = true;
    private int temperature = 20;

    private TextView textView;
    private TextView tvMode;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        tvMode = findViewById(R.id.tvMode);
        Button btnOnOff = findViewById(R.id.btnOnOff);
        Button btnMode = findViewById(R.id.btnMode);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        Button btnDecrease = findViewById(R.id.btnDecrease);

        btnOnOff.setOnClickListener(v -> {
            isOn = !isOn;
            if (isOn) {
                tvMode.setText("Mode: Cold");
                textView.setText("Temperature: " + temperature + "°C");
            } else {
                tvMode.setText("Mode: Off");
                textView.setText("System is Off");
            }
        });

        btnMode.setOnClickListener(v -> {
            if (isOn) {
                isColdMode = !isColdMode;
                String mode = isColdMode ? "Cold" : "Hot";
                tvMode.setText("Mode: " + mode);
            }
        });

        btnIncrease.setOnClickListener(v -> {
            if (isOn) {
                temperature++;
                textView.setText("Temperature: " + temperature + "°C");
            }
        });

        btnDecrease.setOnClickListener(v -> {
            if (isOn) {
                temperature--;
                textView.setText("Temperature: " + temperature + "°C");
            }
        });
    }
}
