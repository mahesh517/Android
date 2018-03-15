package com.app.Firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.Firebase.CustomClass.Customers;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    EditText first_name,last_name,mobile_no,country,state,city;
    TextView country_code;
    Button save_btn;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_name=(EditText)findViewById(R.id.first_name);
        last_name=(EditText)findViewById(R.id.last_name);
        mobile_no=(EditText)findViewById(R.id.mobile_no);
        country=(EditText)findViewById(R.id.country);
        state=(EditText)findViewById(R.id.state);
        city=(EditText)findViewById(R.id.city);
        country_code=(TextView) findViewById(R.id.country_code);
        save_btn=(Button)findViewById(R.id.save_btn);


        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        // store app title to 'app_title' node





        save_btn.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {

        addcustomer();

    }


    private void addcustomer() {
        //getting the values to save
        String first_naem_txt = first_name.getText().toString().trim();
        String last_naem_txt = last_name.getText().toString().trim();
        String mobil_no = mobile_no.getText().toString().trim();
        String country_text = country.getText().toString().trim();
        String state_txt = state.getText().toString().trim();
        String city_txt = city.getText().toString();
        String country_code_txt = country_code.getText().toString();


        //checking if the value is provided
        if (!TextUtils.isEmpty(first_naem_txt)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = mFirebaseDatabase.push().getKey();

            //creating an Artist Object
            Customers artist = new Customers(id, first_naem_txt, last_naem_txt,mobil_no,country_code_txt,state_txt,city_txt,country_code_txt);

            //Saving the Artist
            mFirebaseDatabase.child(id).setValue(artist);

            //setting edittext to blank again

            //displaying a success toast
            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }




}
