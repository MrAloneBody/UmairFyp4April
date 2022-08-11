package com.example.umairfyp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback_fragment extends Fragment {


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feedback_fragment, container, false);
        TextView send_feedback = view.findViewById(R.id.send_feedback);
        EditText write_feedback = view.findViewById(R.id.WriteFeedback);

        send_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( )//if feedback is Null
                {


                }
                else
                {
                    Toast.makeText(getActivity(),"Write Feedback !",Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }

}