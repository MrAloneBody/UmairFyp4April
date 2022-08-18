package com.example.umairfyp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.umairfyp.Utilities.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Feedback_fragment extends Fragment {


    View view;
    FirebaseFirestore database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        database = FirebaseFirestore.getInstance();

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feedback_fragment, container, false);
        ImageView send_feedback = view.findViewById(R.id.send_feedback);
        EditText write_feedback = view.findViewById(R.id.WriteFeedback);

        send_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(write_feedback.getText().toString().isEmpty() )//if feeback is NULL
                {
                    Toast.makeText(getActivity(),"Write Feedback !",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String written_feedback = write_feedback.getText().toString();
                    Map<String,Object> user = new HashMap<>();
                    user.put("Feedback",written_feedback);
                    user.put("Email : ", user.get(Constants.KEY_EMAIL));

                    database.collection("Feedbacks")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getActivity(),"Feedback Submitted",Toast.LENGTH_LONG).show();
                                    write_feedback.setText("");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(),"Feedback Failed",Toast.LENGTH_LONG).show();

                        }
                    });

                    Toast.makeText(getActivity(),"Feedback Submitted",Toast.LENGTH_LONG).show();

                }

            }
        });

        return view;
    }

}