package edu.tacoma.uw.projectsprint1_group9;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentResourceHomeBinding;
import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentStudyBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    FragmentStudyBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        view.findViewById(R.id.communalStudyButton).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_StudyFragment_to_communalStudyFragment);
        });

        view.findViewById(R.id.quietStudyButton).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_StudyFragment_to_quietStudyFragment);
        });

        view.findViewById(R.id.personalFavoritesButton).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_StudyFragment_to_personalStudyFragment);
        });

        view.findViewById(R.id.studyViewButton).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_StudyFragment_to_viewStudyFragment);
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}