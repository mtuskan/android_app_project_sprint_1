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
 * create an instance of this fragment.
 */
public class AddFeedbacksFragment extends Fragment {

    private FragmentAddFeedbacksBinding mBinding;

    private ReviewViewModel reviewViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        reviewViewModel = new ViewModelProvider(getActivity()).get(ReviewViewModel.class);

        mBinding = FragmentAddFeedbacksBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        reviewViewModel.addResponseObserver(getViewLifecycleOwner(), response -> {

            observeResponse(response);

        });

        mBinding.buttonAddFeedback.setOnClickListener(button -> processAddAnimal());

        Button homeButton = view.findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
        });



    }

    private void processAddAnimal() {

        final String name = mBinding.editTextName.getText().toString();

        final String year = mBinding.editTextSchoolYear.getText().toString();

        final String feedback = mBinding.editTextFeedback.getText().toString();



        Log.i(TAG, "Data is " + name + ", " + year + ", " + feedback);

        reviewViewModel.addReview(name, year, feedback);



    }

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