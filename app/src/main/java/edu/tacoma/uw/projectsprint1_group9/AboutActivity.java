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

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.ResourcesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResourcesActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.HomeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.FeedbackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideViews();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, new AddFeedbacksFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        findViewById(R.id.jamesEmailAddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("mailto:jjl336@uw.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        findViewById(R.id.enriqueEmailAddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("mailto:enriquev@uw.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        findViewById(R.id.michaelEmailAddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("mailto:mtuskan@uw.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
    }
    private void hideViews() {
        findViewById(R.id.michaelEmailAddress).setVisibility(View.GONE);
        findViewById(R.id.enriqueEmailAddress).setVisibility(View.GONE);
        findViewById(R.id.jamesEmailAddress).setVisibility(View.GONE);
        findViewById(R.id.ResourcesButton).setVisibility(View.GONE);
        findViewById(R.id.HomeButton).setVisibility(View.GONE);
        findViewById(R.id.DescriptionView).setVisibility(View.GONE);
        findViewById(R.id.EmailView).setVisibility(View.GONE);
        findViewById(R.id.studyTipsView).setVisibility(View.GONE);
        findViewById(R.id.namesView).setVisibility(View.GONE);
        findViewById(R.id.FeedbackButton).setVisibility(View.GONE);


    }



}