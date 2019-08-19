package com.example.harshpandey.ambulance_module_knit_utility;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {

    int max_students_allowed=3;
    EditText[] student_name_view = new EditText[max_students_allowed];
    EditText[] student_roll_view = new EditText[max_students_allowed];
    EditText[] student_phone_view = new EditText[max_students_allowed];
    int num_students =1;
    //String[] names = new String[max_students_allowed];
    //String[] phone_no = new String[max_students_allowed];
    //String[] roll_no = new String[max_students_allowed];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num_students=1;
        final LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ViewGroup parent = (ViewGroup)findViewById(R.id.students_add_space);

        student_name_view[0] = (EditText) findViewById(R.id.student_name);
        student_roll_view[0] = (EditText) findViewById(R.id.student_roll_number);
        student_phone_view[0] = (EditText) findViewById(R.id.student_phone_number);
        //FirebaseFirestore db = FirebaseFirestore.getInstance();


        ImageButton btn = (ImageButton) findViewById(R.id.button_add_student);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_students<max_students_allowed)
                {
                   View new_student =  inflater.inflate(R.layout.add_student, parent);
                   student_name_view[num_students] = new_student.findViewById(R.id.student_name);
                   student_roll_view[num_students] = new_student.findViewById(R.id.student_roll_number);
                   student_phone_view[num_students] = new_student.findViewById(R.id.student_phone_number);
                   num_students++;
                }
                else
                {
                    Log.v("Main Act->on btn click","max_students reached");
                }

            }
        });

        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stu=0;
                for(stu=0 ; stu < num_students; stu++)
                {
                    Map<String,Object> student = new HashMap<>();
                    student.put("name",student_name_view[stu].getText().toString());
                    //names[stu] = student_name_view[stu].getText().toString();
                    student.put("roll_number",student_roll_view[stu].getText().toString());
                    //roll_no[stu] = student_roll_view[stu].getText().toString();
                    student.put("phone_no",student_phone_view[stu].getText().toString());
                    //phone_no[stu] = student_phone_view[stu].getText().toString();


//                    db.collection("ambulanceEntries").document("Trips")
//                            .set(student)
//                            .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    Log.d(TAG, "DocumentSnapshot successfully written!");
//                                }
//                            })
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.w(TAG, "Error writing document", e);
//                                }
//                            });






                    Log.d("Main Activity","completed for student "+(stu+1)+ " "+student.get("name"));
                }
                Log.d("Main Activity","details entered to variables");
                //add the data to database

                //moving to call_ambulance and review section
                Log.d("Main Acitvity","Starting intent");

                Intent intent = new Intent(getApplicationContext(), call_review_section.class);
                startActivity(intent);
                Log.d("Main Activity","Intent Success");

            }
        });


    }



}
