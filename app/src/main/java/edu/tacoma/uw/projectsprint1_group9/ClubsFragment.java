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


import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentClubsBinding;

/**
 * A simple {@link Fragment} subclass.
 * This class holds the info for the Clubs resources for the student in a fragment
 *
 * @author Enrique Vargas
 */
public class ClubsFragment extends Fragment {

    /**
     * Binding object instance corresponding to the fragment_clubs.xml layout.
     */
    private FragmentClubsBinding mBinding;

    /**
     * Inflates the layout for this fragment using data binding.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return The root view for the fragment's UI.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Instantiate the Binding object and Inflate the layout for this fragment
        mBinding = FragmentClubsBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
    /**
     * Cleans up resources associated with the view.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
    /**
     * Called immediately after onCreateView has returned, but before any saved state has been restored into the view.
     *
     * @param view               The View returned by onCreateView.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button backButton = view.findViewById(R.id.back_to_resource);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ResourcesActivity.class);
            startActivity(intent);
        });

        Button homeButton = view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
        });
    }


}