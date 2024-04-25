package edu.tacoma.uw.projectsprint1_group9;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import edu.tacoma.uw.projectsprint1_group9.databinding.FragmentGeneralResourceBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralResourceFragment extends Fragment {

    private FragmentGeneralResourceBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Instantiate the Binding object and Inflate the layout for this fragment
        mBinding = FragmentGeneralResourceBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button backButton = view.findViewById(R.id.back_to_resource);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), resourcesActivity.class);
            startActivity(intent);

        });
    }


}