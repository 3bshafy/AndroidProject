package com.apps.todonotepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button notepadBtn,toDoBtn,calendarBtn;
    FloatingActionButton fabSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notepadBtn = findViewById(R.id.btn_notepad_home);
        toDoBtn = findViewById(R.id.btn_todo_home);
        calendarBtn = findViewById(R.id.btn_calendar_home);
        fabSettings = findViewById(R.id.fabSettings);

        notepadBtn.setOnClickListener(this);
        toDoBtn.setOnClickListener(this);
        calendarBtn.setOnClickListener(this);
        fabSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_todo_home:
                Intent goToToDoActivity = new Intent(getApplicationContext(),ToDoScreenActivity.class);
                startActivity(goToToDoActivity);
                break;
            case R.id.btn_notepad_home:
                Intent goToNotepadActivity = new Intent(getApplicationContext(),NotepadScreenActivity.class);
                startActivity(goToNotepadActivity);
                break;
            case R.id.btn_calendar_home:
                Intent goToCalenderActivity = new Intent(getApplicationContext(),CalendarScreenActivity.class);
                startActivity(goToCalenderActivity);
                break;
            case R.id.fabSettings:
                Intent goToSettings = new Intent(getApplicationContext() , SettingsActivity.class);
                startActivity(goToSettings);
                break;
        }

    }
}