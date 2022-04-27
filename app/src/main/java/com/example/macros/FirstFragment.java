package com.example.macros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.macros.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String grams = binding.grams.getText().toString(),
                        carbohydrates = binding.carbohydrates.getText().toString(),
                        proteins = binding.proteins.getText().toString(),
                        fats = binding.fats.getText().toString();

                float cbGrams = Float.parseFloat(carbohydrates) * Float.parseFloat(grams) / 100,
                        prGrams = Float.parseFloat(proteins) * Float.parseFloat(grams) / 100,
                        grGrams = Float.parseFloat(fats) * Float.parseFloat(grams) / 100;

                binding.result.setText(
                        "Carboidrati: " + cbGrams + "g\n"
                        + "Proteine: " + prGrams + " g\n"
                        + "Grassi: " + grGrams + " g"

                );
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}