package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView details_name;
    private  TextView detail_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        detail_number = findViewById(R.id.details_number);
        details_name = findViewById(R.id.details_name);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String name = bundle.getString("name");
            String number = bundle.getString("number");

            details_name.setText(name);
            detail_number.setText(number);
        }
    }
}
