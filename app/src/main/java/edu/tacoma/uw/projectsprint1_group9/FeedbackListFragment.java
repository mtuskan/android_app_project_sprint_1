package edu.tacoma.uw.projectsprint1_group9;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentFeedbackListBinding;

/**
 * A fragment that displays a list of feedbacks.
 * This fragment observes changes in the feedback list and updates.
 *
 * @author Enrique Vargas
 */
public class FeedbackListFragment extends Fragment {

    /**
     * ViewModel instance to handle the business logic for retrieving and observing feedbacks.
     */
    private ReviewViewModel mModel;

    /**
     * Binding object instance corresponding to the fragment_feedback_list.xml layout.
     */
    private FragmentFeedbackListBinding mBinding;
    /**
     * Called to do initial creation of the fragment.
     * Initializes the ViewModel and fetches the list of reviews.
     *
     * @param savedInstanceState If the fragment is being re-created from a previous saved state, this is the state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize the ViewModel
        mModel = new ViewModelProvider(requireActivity()).get(ReviewViewModel.class);
        // Fetch the list of reviews
        mModel.getReviews();
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * Inflates the layout for this fragment using ViewBinding.
     *
     * @param inflater The LayoutInflater object views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return The View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using ViewBinding
        mBinding = FragmentFeedbackListBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
    /**
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned.
     * Sets up observers and click listeners for UI elements.
     *
     * @param view The View returned by onCreateView(LayoutInflater, ViewGroup, Bundle).
     * @param savedInstanceState This fragment is being re-constructed from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Observe the feedback list and update the RecyclerView adapter
        mModel.addFeedbackListObserver(getViewLifecycleOwner(), feedbackList -> {
            if (!feedbackList.isEmpty()) {
                mBinding.layoutRoot.setAdapter(
                        new FeedbackRecyclerViewAdapter(feedbackList)
                );
            }
        });

        // Set up the Home button to navigate back to the MainActivity
//        Button homeButton = view.findViewById(R.id.HomeButton);
//        homeButton.setOnClickListener(v -> {
//            Intent intent = new Intent(requireContext(), MainActivity.class);
//            startActivity(intent);
//        });
    }

    /**
     * Clears the binding object to avoid memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clear the binding object to avoid memory leaks
        mBinding = null;
    }
}

