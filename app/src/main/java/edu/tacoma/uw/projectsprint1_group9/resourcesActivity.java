package edu.tacoma.uw.projectsprint1_group9;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class resourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resources);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        findViewById(R.id.buttonStudentResources).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), MyInfo.class);
//                startActivity(intent);
//            }
//        });

//        findViewById(R.id.buttonStudentResources).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(getApplicationContext(), MyImage.class);
//                startActivity(intent2);
//            }
//        });

        findViewById(R.id.buttonLeetCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://leetcode.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }

        });

//        findViewById(R.id.buttonStudentClubs).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CharSequence text = "The image is my cat Anubis";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(view.getContext(), text, duration);
//                toast.show();
//            }
//        });

//        findViewById(R.id.buttonStudyTips).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CharSequence text = "The image is my cat Anubis";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(view.getContext(), text, duration);
//                toast.show();
//            }
//        });



    }



}