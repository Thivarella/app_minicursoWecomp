package com.varella.classnotes;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thebluealliance.spectrum.SpectrumDialog;

import java.util.ArrayList;

/**
 * Created by Thiago- on 07/11/2017.
 */

public class NoteActivity extends AppCompatActivity{
    static ArrayList<Note> noteList = new ArrayList<>();
    Note note;
    int color = Color.parseColor("#B71C1C");

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        final EditText edtTextTitle = findViewById(R.id.edt_title);
        final EditText edtTextDescription = findViewById(R.id.edt_description);
        final View viewSelectColor = findViewById(R.id.viewColor);

        Button button = findViewById(R.id.button_save);

        viewSelectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SpectrumDialog.Builder(NoteActivity.this)
                        .setColors(R.array.card_colors)
                        .setSelectedColorRes(R.color.colorRed)
                        .setDismissOnColorSelected(true)
                        .setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() {
                            @Override public void onColorSelected(boolean positiveResult, @ColorInt int color) {
                                if (positiveResult) {
                                    viewSelectColor.setBackgroundColor(color);
                                    NoteActivity.this.color = color;
                                    Toast.makeText(NoteActivity.this, "Color selected: #" + Integer.toHexString(color).toUpperCase(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(NoteActivity.this, "Dialog cancelled", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).build().show(getSupportFragmentManager(), "dialog_demo_1");
            }
        });
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            note = (Note) extras.get("noteExtra");
            edtTextTitle.setText(note.getTitle());
            edtTextDescription.setText(note.getDescription());

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTextTitle.getText().toString();
                String description = edtTextDescription.getText().toString();
                if(note==null){
                    note = new Note();
                }
                note.setTitle(title);
                note.setDescription(description);
                note.setColor(color);
                noteList.add(note);

                Toast.makeText(
                        NoteActivity.this,
                        note.getTitle(),
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });




    }
}
