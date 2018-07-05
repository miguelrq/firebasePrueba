package com.example.miguel.firebaseprueba;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddColorActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private Button mBtnColorSave;
    private EditText mInputColorName;
    private EditText mInputColorHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_color);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Colors");

        mBtnColorSave = findViewById(R.id.btn_save);
        mInputColorName = findViewById(R.id.input_name);
        mInputColorHex = findViewById(R.id.input_hex);

        mBtnColorSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colorName = mInputColorName.getText().toString().trim();
                String colorHex = mInputColorHex.getText().toString().trim();
                Color color = new Color(colorName,colorHex);
                mDatabase.push().setValue(color).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AddColorActivity.this, "Stored",
                                    Toast.LENGTH_LONG);
                            finish();
                        } else
                            Toast.makeText(AddColorActivity.this,"Error",
                                    Toast.LENGTH_LONG);
                    }
                });
            }
        });
    }
}
