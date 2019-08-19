package com.example.harshpandey.ambulance_module_knit_utility;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class call_review_section extends AppCompatActivity {


    int max_ambulances_numbers=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_review_section);


        String ambulance_numbers[]= new String[max_ambulances_numbers];//take from database


        Button call_btn = (Button)findViewById(R.id.call_btn);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "8604831464"));// enter the number of ambulance
                startActivity(intent);
            }
        });


    }
}
