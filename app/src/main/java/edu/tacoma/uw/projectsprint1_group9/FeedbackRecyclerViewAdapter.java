package edu.tacoma.uw.projectsprint1_group9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentFeedbackBinding;

public class FeedbackRecyclerViewAdapter extends RecyclerView.Adapter<FeedbackRecyclerViewAdapter.ViewHolder> {
    private final List<Feedback> mValues;

    public FeedbackRecyclerViewAdapter(List<Feedback> feedbackList) {
        mValues = feedbackList;
    }

    @NonNull
    @Override
    public FeedbackRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fragment_feedback, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setItem(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FragmentFeedbackBinding binding;
        public Feedback mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            binding = FragmentFeedbackBinding.bind(view);
        }

        public void setItem(final Feedback item) {
            mItem = item;
            binding.feedbackName.setText(item.getName());
            binding.feedbackYear.setText(item.getName());
            binding.feedbackYear.setOnClickListener(view ->
            {
                FeedbackListFragmentDirections.ActionFeedbackListFragmentToFeedbackDetailFragment directions =
                        FeedbackListFragmentDirections.actionFeedbackListFragmentToFeedbackDetailFragment(item);

                Navigation.findNavController(mView)
                        .navigate(directions);
            });

        }
    }


}
