package com.example.practiceandroidarchitecturetutorialone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    private EditText edTitle;
    private EditText edDescription;
    private NumberPicker nmPriority;

    static final String EXTRA_TITLE = "com.example.action.TITLE_EXTRA";
    static final String EXTRA_DESCRIPTION = "com.example.action.DESCRIPTION_EXTRA";
    static final String EXTRA_PRIORITY = "com.example.action.PRIORITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        edTitle =  findViewById(R.id.ed_title);
        edDescription =  findViewById(R.id.ed_description);
        nmPriority = findViewById(R.id.nm_priority);

        nmPriority.setMaxValue(10);
        nmPriority.setMinValue(1);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);     //need more attention to understand it
        setTitle("Add Note");
    }

    private void saveNote(){
        String title = edTitle.getText().toString();
        String description = edDescription.getText().toString();
        int priority = nmPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this,"Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent(this, MainActivity.class  );
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);
        setResult(RESULT_OK, data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}