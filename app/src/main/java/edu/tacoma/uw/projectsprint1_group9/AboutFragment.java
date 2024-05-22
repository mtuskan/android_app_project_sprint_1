package edu.tacoma.uw.projectsprint1_group9;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentAboutBinding;
import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentGeneralResourceBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private FragmentAboutBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Instantiate the Binding object and Inflate the layout for this fragment
        mBinding = FragmentAboutBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView jamesEmailAddress = view.findViewById(R.id.jamesEmailAddress);
        jamesEmailAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("mailto:jjl336@uw.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        TextView enriqueEmailAddress = view.findViewById(R.id.enriqueEmailAddress);
        enriqueEmailAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("mailto:enriquev@uw.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        TextView michaelEmailAddress = view.findViewById(R.id.michaelEmailAddress);
        michaelEmailAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("mailto:mtuskan@uw.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
    }
}