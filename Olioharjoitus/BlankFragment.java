package com.example.activitytrill;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText textInput;
    private Bundle savedInstanceState;
    private View view;
    private String text;
    private TextView content;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);

        textInput = view.findViewById(R.id.editTextTextPersonName2);
        textInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = textInput.getText().toString();
                sendToActivity("text",text);
                //System.out.println(text);
                closeKeyBoard();
            }
        });

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        try {
            // lue p????ohjelmasta annettu uusi teksti ja kirjoita se n??yt??lle
            String arg = getArguments().getString("text");
            content = view.findViewById(R.id.editTextTextPersonName2);
            content.setText(arg);
            System.out.println(arg);
        } catch (Exception e) {
        }
    }
    // sulkee softa n??pp??imist??n kun teksti on sy??tetty
    private void closeKeyBoard(){
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void sendToActivity(String key, String value ) {
        Intent intent = new Intent(getActivity().getBaseContext(),MainActivity.class);
        intent.putExtra(key,value);
        startActivity(intent);
        System.out.println("key = " + key + "text = " + value);
    }

}
