package edu.tacoma.uw.projectsprint1_group9;




import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentFeedbackDetailBinding;

/**

 * create an instance of this fragment.
 */
public class FeedbackDetailFragment extends Fragment {

    private FragmentFeedbackDetailBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentFeedbackDetailBinding.inflate(inflater, container, false);
        return mBinding.getRoot();

    }

    //error with args
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Get a reference to the SafeArgs object
        FeedbackDetailFragmentArgs args = FeedbackDetailFragmentArgs.fromBundle(getArguments());
        Feedback feedback = (Feedback) args.getFeedback();
        mBinding.nameTextView.setText(feedback.getName());
        mBinding.yearTextView.setText(feedback.getYear());
        mBinding.feedbackTextView.setText(feedback.getFeedback());

    }
}