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
 * Feedback List Fragment Class - List of Feedback objects
 *
 */
public class FeedbackListFragment extends Fragment {

    private ReviewViewModel mModel;
    private FragmentFeedbackListBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new ViewModelProvider(requireActivity()).get(ReviewViewModel.class);
        mModel.getReviews();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentFeedbackListBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

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

        Button homeButton = view.findViewById(R.id.HomeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}
