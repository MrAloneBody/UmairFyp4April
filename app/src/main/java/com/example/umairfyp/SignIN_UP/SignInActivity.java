package com.example.umairfyp.SignIN_UP;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.umairfyp.MainActivity;
import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.Utilities.PREFRENCEmanager;
import com.example.umairfyp.Utilities.PrefrenceManager1;
import com.example.umairfyp.databinding.ActivitySignInBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignInActivity extends AppCompatActivity {


    private ActivitySignInBinding binding;
    private PREFRENCEmanager preferenceManager;
    private PrefrenceManager1 prefrenceManager1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefrenceManager1 = new PrefrenceManager1(getApplicationContext());
     //   preferenceManager = new PreferenceManager(getApplicationContext());
     //if already login dont show login page
           if(prefrenceManager1.getBoolean(Constants.KEY_IS_SIGNED_IN)){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }

        setListeners();
    }

    private void setListeners(){
        binding.newUser.setOnClickListener( v ->
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class)));

        binding.LoginBtn.setOnClickListener(v -> {
            if(isValidSignInDetails()){
                signIn();
            }
        });
    }
    private void signIn(){

        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL,binding.etMail.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD,binding.txtPassword.getText().toString())
                .get()
                .addOnCompleteListener(task ->{
                    if(task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0){

                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        prefrenceManager1.putBoolean(Constants.KEY_IS_SIGNED_IN,true);
                        prefrenceManager1.putString(Constants.KEY_USER_ID,documentSnapshot.getId());
                        prefrenceManager1.putString(Constants.KEY_EMAIL,documentSnapshot.getString(Constants.KEY_EMAIL));
                        prefrenceManager1.putString(Constants.KEY_NAME,documentSnapshot.getString(Constants.KEY_NAME));
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                    else {
                        loading(false);
                        showToast("Unable to SignIn.");
                    }
                });

    }

    private void loading(Boolean isLoading){
        if(isLoading){
            binding.LoginBtn.setVisibility(View.INVISIBLE);
            binding.progressbar.setVisibility(View.VISIBLE);
        }else{
            binding.progressbar.setVisibility(View.INVISIBLE);
            binding.LoginBtn.setVisibility(View.VISIBLE);
        }
    }


    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isValidSignInDetails(){
        if(binding.etMail.getText().toString().trim().isEmpty()){
            showToast("Enter Email");
            return false;
        }
//        else if(!Pattern.EMAIL_ADDRESS.matcher(binding.etMail.getText().toString().matches())){
 //           showToast("Enter Valid Email");
   //         return false;
    //    }
        else if(binding.txtPassword.getText().toString().trim().isEmpty()){
            showToast("Enter Password");
            return false;
        }else{
            return true;
        }


    }

}
