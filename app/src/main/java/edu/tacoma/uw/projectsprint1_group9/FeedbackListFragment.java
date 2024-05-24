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

 * create an instance of this fragment.
 */
public class FeedbackListFragment extends Fragment {


    private ReviewViewModel mModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new ViewModelProvider(getActivity()).get(ReviewViewModel.class);
        mModel.getReviews();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feedback_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        @NonNull FragmentFeedbackListBinding binding = FragmentFeedbackListBinding.bind(getView());

        mModel.addFeedbackListObserver(getViewLifecycleOwner(), feedbackList -> {
            if (!feedbackList.isEmpty()) {
                binding.layoutRoot.setAdapter(
                        new FeedbackRecyclerViewAdapter(feedbackList)
                );
            }

        });

        Button homeButton = view.findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}