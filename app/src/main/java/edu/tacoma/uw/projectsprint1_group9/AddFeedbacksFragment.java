package edu.tacoma.uw.projectsprint1_group9;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentAddFeedbacksBinding;

/**
 * A fragment that allows users to add feedback for the app
 *
 * @author Enrique Vargas
 */
public class AddFeedbacksFragment extends Fragment {
    /**
     * Binding object instance corresponding to the fragment_add_feedbacks.xml layout.
     */
    private FragmentAddFeedbacksBinding mBinding;
    /**
     * ViewModel instance to handle the business logic for adding feedback.
     */
    private ReviewViewModel reviewViewModel;

    /**
     * Inflates the layout for this fragment and initializes the ViewModel.
     *
     * @param inflater           The LayoutInflater inflate any views in the fragment.
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return The root view for the fragment's UI.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        reviewViewModel = new ViewModelProvider(getActivity()).get(ReviewViewModel.class);

        mBinding = FragmentAddFeedbacksBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
    @Override

    /**
     * Called immediately after onCreateView has returned, but before any saved state has been restored in to the view.
     *
     * @param view               The View returned by onCreateView.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        reviewViewModel.addResponseObserver(getViewLifecycleOwner(), response -> {

            observeResponse(response);

        });

        mBinding.buttonAddFeedback.setOnClickListener(button -> processAddFeedback());

        Button homeButton = view.findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
        });

    }

    /**
     * Processes the addition of feedback by retrieving input data, validating it,
     * and calling the ViewModel to add the feedback.
     */
    private void processAddFeedback() {

        final String name = mBinding.editTextName.getText().toString();

        final String year = mBinding.editTextSchoolYear.getText().toString();

        final String feedback = mBinding.editTextFeedback.getText().toString();

        if (name.isEmpty() || year.isEmpty() || feedback.isEmpty()) {
            Toast.makeText(getContext(), "All fields must be filled out", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i(TAG, "Data is " + name + ", " + year + ", " + feedback);

        reviewViewModel.addReview(name, year, feedback);

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
     * Observes the response from adding feedback and shows appropriate messages to the user.
     *
     * @param response The JSON response from the ViewModel.
     */
    private void observeResponse(final JSONObject response) {

        if (response.length() > 0) {

            if (response.has("error")) {

                try {

                    Toast.makeText(this.getContext(),

                            "Error Adding Feedback: " +

                                    response.get("error"), Toast.LENGTH_LONG).show();

                } catch (JSONException e) {

                    Log.e("JSON Parse Error", e.getMessage());

                }

            } else {

                Toast.makeText(this.getContext(), "Feedback was added!", Toast.LENGTH_LONG).show();

            }

        } else {

            Log.d("JSON Response", "No Response");

        }

    }}