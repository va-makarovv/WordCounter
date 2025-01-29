package com.example.wordcounter.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.wordcounter.R;
import com.example.wordcounter.WordCounter;

public class CounterFragment extends Fragment {
    private TextView tvTitle;
    private EditText etText;
    private AppCompatButton btBack;
    private int count;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter,container,false);
        Log.e("Title", getArguments().getString("title"));
        String name = getArguments().getString("title");
        tvTitle = view.findViewById(R.id.tv_counter);
        etText = view.findViewById(R.id.et_counter);
        btBack = view.findViewById(R.id.bt_back);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_counterFragment_to_signInFragment);
            }
        });


        etText.addTextChangedListener(new TextWatcher() {

            @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        private void updateWordCount(String text) {
                int wordCount = WordCounter.countWords(text);
                tvTitle.setText("Word count: " + String.valueOf(wordCount));
        }

            @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateWordCount(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {}
        });


        return view;

    }


    @Override
    public void onStop() {

        super.onStop();
    }
}