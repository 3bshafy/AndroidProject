package com.apps.todonotepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.apps.todonotepad.Adapters.ToDoAdapter;
import com.apps.todonotepad.Utils.DatabaseHandler;

public class CalendarScreenActivity extends AppCompatActivity {

    CalendarView cal;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_screen);

        cal = findViewById(R.id.calendarView);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
                long selectedDate = view.getDate();
                //Toast.makeText(getApplicationContext(), "Task Added at "+dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
            }
        });
    }
}