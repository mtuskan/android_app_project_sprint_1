package edu.tacoma.uw.projectsprint1_group9;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

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

            findViewById(R.id.buttonCareer).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Hide the views
                    findViewById(R.id.textViewResource).setVisibility(View.GONE);
                    findViewById(R.id.buttonStudentResources).setVisibility(View.GONE);
                    findViewById(R.id.buttonStudentClubs).setVisibility(View.GONE);
                    findViewById(R.id.buttonStudyTips).setVisibility(View.GONE);
                    findViewById(R.id.buttonLeetCode).setVisibility(View.GONE);
                    findViewById(R.id.buttonCareer).setVisibility(View.GONE);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main, new CareerFragment())
                            .addToBackStack(null)
                            .commit();
                }
            });


        findViewById(R.id.buttonStudentResources).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide the views
                    findViewById(R.id.textViewResource).setVisibility(View.GONE);
                    findViewById(R.id.buttonStudentResources).setVisibility(View.GONE);
                    findViewById(R.id.buttonStudentClubs).setVisibility(View.GONE);
                    findViewById(R.id.buttonStudyTips).setVisibility(View.GONE);
                    findViewById(R.id.buttonLeetCode).setVisibility(View.GONE);
                    findViewById(R.id.buttonCareer).setVisibility(View.GONE);


                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, new GeneralResourceFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });



        findViewById(R.id.buttonLeetCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://leetcode.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }

        });

    }
}