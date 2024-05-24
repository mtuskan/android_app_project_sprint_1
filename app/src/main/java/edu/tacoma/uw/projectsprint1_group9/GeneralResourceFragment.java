package edu.tacoma.uw.projectsprint1_group9;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentGeneralResourceBinding;

/**
 * A simple {@link Fragment} subclass representing the general resources section.
 */
public class GeneralResourceFragment extends Fragment {

    /**
     * Binding object to access the views in the layout for this fragment.
     */
    private FragmentGeneralResourceBinding mBinding;

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Instantiate the Binding object and Inflate the layout for this fragment
        mBinding = FragmentGeneralResourceBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    /**
     * Called when the view previously created by onCreateView has been detached from the fragment.
     * Here we nullify the binding to avoid memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    /**
     * Called immediately after onCreateView has returned, but before any saved state has been restored into the view.
     * This gives subclasses a chance to initialize themselves once they know their view hierarchy has been completely created.
     *
     * @param view The View returned by onCreateView.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the back button to navigate back to ResourcesActivity
//        Button backButton = view.findViewById(R.id.back_to_resource);
//        backButton.setOnClickListener(v -> {
//            Intent intent = new Intent(requireContext(), ResourcesActivity.class);
//            startActivity(intent);
//        });
//
//        // Set up the home button to navigate back to MainActivity
//        Button homeButton = view.findViewById(R.id.home_button);
//        homeButton.setOnClickListener(v -> {
//            Intent intent = new Intent(requireContext(), MainActivity.class);
//            startActivity(intent);
//        });
    }
}
