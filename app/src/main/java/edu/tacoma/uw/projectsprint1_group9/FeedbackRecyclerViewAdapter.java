package edu.tacoma.uw.projectsprint1_group9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentFeedbackBinding;

/**
 * RecyclerView Adapter for displaying a list of Feedback items.
 * This adapter binds the feedback data to the views in the RecyclerView.
 *
 * @author Enrique Vargas
 */
public class FeedbackRecyclerViewAdapter extends RecyclerView.Adapter<FeedbackRecyclerViewAdapter.ViewHolder> {

    /**
     * List of feedback items to be displayed.
     */
    private final List<Feedback> mValues;

    /**
     * Constructor for the adapter.
     *
     * @param feedbackList List of feedback items to be displayed.
     */
    public FeedbackRecyclerViewAdapter(List<Feedback> feedbackList) {
        mValues = feedbackList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public FeedbackRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fragment_feedback, parent, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method updates the contents of the {@link ViewHolder#itemView} to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull FeedbackRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setItem(mValues.get(position));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * ViewHolder class that represents each item in the RecyclerView.
     * This class holds references to the views in each item's layout and binds the data to these views.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * The root view of the item layout.
         */
        public final View mView;

        /**
         * Binding object for the item layout.
         */
        public FragmentFeedbackBinding binding;

        /**
         * The feedback item represented by this ViewHolder.
         */
        public Feedback mItem;

        /**
         * Constructor for the ViewHolder.
         *
         * @param view The root view of the item layout.
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            binding = FragmentFeedbackBinding.bind(view);
        }

        /**
         * Binds the feedback data to the views in the item layout.
         *
         * @param item The feedback item to be displayed.
         */
        public void setItem(final Feedback item) {
            mItem = item;
            binding.feedbackName.setText(item.getName());
            binding.feedbackYear.setText(item.getYear());
            binding.feedbackReply.setText(item.getFeedback());
        }
    }
}

