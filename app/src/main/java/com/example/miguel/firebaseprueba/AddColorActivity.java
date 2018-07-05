package com.example.miguel.firebaseprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddColorActivity extends AppCompatActivity {

    private Button mBtnColorSave;
    private EditText mInputColorName;
    private EditText mInputColorHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_color);

        mBtnColorSave = findViewById(R.id.btn_save);
        mInputColorName = findViewById(R.id.input_name);
        mInputColorHex = findViewById(R.id.input_hex);

        mBtnColorSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colorName = mInputColorName.getText().toString().trim();
                String colorHex = mInputColorHex.getText().toString().trim();

            }
        });
    }
}
