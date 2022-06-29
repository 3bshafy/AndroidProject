package com.apps.todonotepad;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotepadScreenActivity extends AppCompatActivity{
    Toolbar toolbar;
    RecyclerView recyclerView;
    Adapter adapter;
    TextView noItemText;
    SimpleDatabase simpleDatabase;
    private FloatingActionButton fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad_screen);
        toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitleTextColor(getResources().getColor(R.color.pastelblue));
        setSupportActionBar(toolbar);
        fab_add = findViewById(R.id.fab_addNote);
        noItemText = findViewById(R.id.noItemText);
        simpleDatabase = new SimpleDatabase(this);
        List<Note> allNotes = simpleDatabase.getAllNotes();
        recyclerView = findViewById(R.id.recyclerView_note);

        if(allNotes.isEmpty()){
            noItemText.setVisibility(View.VISIBLE);

        }else {
            noItemText.setVisibility(View.GONE);
            displayList(allNotes);
        }

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotepadScreenActivity.this, "Add New Note", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),AddNote.class);
                startActivity(i);
            }
        });

    }

    private void displayList(List<Note> allNotes) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,allNotes);
        recyclerView.setAdapter(adapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.add_menu , menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.add_note){
//            Toast.makeText(this, "Add New Note", Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(getApplicationContext(),AddNote.class);
//            startActivity(i);
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Note> getAllNotes = simpleDatabase.getAllNotes();
        if(getAllNotes.isEmpty()){
            noItemText.setVisibility(View.VISIBLE);
        }else {
            noItemText.setVisibility(View.GONE);
            displayList(getAllNotes);
        }


    }

}