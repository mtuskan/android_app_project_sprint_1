package edu.tacoma.uw.projectsprint1_group9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentStudySpotBinding;

public class StudySpotRecyclerAdapter extends RecyclerView.Adapter<StudySpotRecyclerAdapter.ViewHolder> {
    private final List<StudySpot> mValues;

    public StudySpotRecyclerAdapter(List<StudySpot> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_study_spot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FragmentStudySpotBinding binding;
        public final TextView mName;
        public final ImageView mImageView;
        public final TextView mKind;
        public StudySpot mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mName = view.findViewById(R.id.spotName);
            mImageView = view.findViewById(R.id.spotImage);
            mKind = view.findViewById(R.id.spotKind);
            binding = FragmentStudySpotBinding.bind(view);
        }
    }
}
