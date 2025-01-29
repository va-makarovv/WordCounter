package com.example.wordcounter.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.wordcounter.R;

public class
SignInFragment extends Fragment {
    private EditText etTitle;
    private AppCompatButton btCont;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in,container,false);
        etTitle = view.findViewById(R.id.et_signin);
        btCont = view.findViewById(R.id.bt_signIn);


        btCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                Log.e("TITLE", bundle.getString("title"));
                NavHostFragment.findNavController(SignInFragment.this)
                        .navigate(R.id.action_signInFragment_to_counterFragment, bundle);
            }
        });

        return view;
    }
}