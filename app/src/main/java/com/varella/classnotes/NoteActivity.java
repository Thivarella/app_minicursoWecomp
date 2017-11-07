package com.varella.classnotes;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Thiago- on 07/11/2017.
 */

public class NoteActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_note);

        final EditText edtTextTitle = findViewById(R.id.edt_title);
        EditText edtTextDescription = findViewById(R.id.edt_description);
        Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NoteActivity.this, edtTextTitle.getText() + " Salvo", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
