package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button lastimg;
    private Button nextimg;
    private Button randimg;
    private ImageView img;
    private TextView textView;
    private TextView textTitle;

    private int[] p = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
    };

    private String[] titles = {
            "Оренбург",
            "Казань",
            "Москва",
            "Екатеринбург",
            "Санкт-Петербург"
    };

    private int index = 0;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        updateUI();
    }

    private void initViews() {
        lastimg = findViewById(R.id.lastimg);
        nextimg = findViewById(R.id.nextimg);
        randimg = findViewById(R.id.randimg);
        img = findViewById(R.id.img);
        textView = findViewById(R.id.textView);
        textTitle = findViewById(R.id.textTitle);

        lastimg.setOnClickListener(this);
        nextimg.setOnClickListener(this);
        randimg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.lastimg) {
            if (index == 0) {
                index = p.length - 1;
            } else {
                index--;
            }
        } else if (id == R.id.nextimg) {
            if (index == p.length - 1) {
                index = 0;
            } else {
                index++;
            }
        } else if (id == R.id.randimg) {
            index = random.nextInt(p.length);
        }

        updateUI();
    }

    private void updateUI() {
        img.setImageResource(p[index]);
        textView.setText((index + 1) + "/" + p.length);
        textTitle.setText(titles[index]);
    }
}