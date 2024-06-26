package edu.tacoma.uw.projectsprint1_group9;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentResourceHomeBinding;

/**
 * Resource Home Fragment Class {@link Fragment} subclass. Fragment for student resources
 */
public class ResourceHomeFragment extends Fragment {

    FragmentResourceHomeBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resource_home, container, false);

        view.findViewById(R.id.buttonCareer).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_navigation_resource_to_careerFragment);
        });

        view.findViewById(R.id.buttonStudentResources).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_navigation_resource_to_generalResourceFragment);
        });

        view.findViewById(R.id.buttonStudyTips).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_navigation_resource_to_studyFragment);
        });

        view.findViewById(R.id.buttonStudentClubs).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_navigation_resource_to_clubsFragment);
        });

        view.findViewById(R.id.buttonLeetCode).setOnClickListener(v -> {
            // Create an Intent to open a web browser
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://leetcode.com/"));

            // Start the activity
            view.getContext().startActivity(browserIntent);
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}