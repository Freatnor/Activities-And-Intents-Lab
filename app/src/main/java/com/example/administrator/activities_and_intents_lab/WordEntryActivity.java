package com.example.administrator.activities_and_intents_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class WordEntryActivity extends AppCompatActivity {

    public static final String EXTRA_ENTRIES_KEY_BASE = "EXTRA_ENTRIES_KEY_BASE";

    private List<EditText> entries;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_entry);

        entries = new ArrayList<>();
        entries.add((EditText) findViewById(R.id.edit_text_insert1));
        entries.add((EditText) findViewById(R.id.edit_text_insert2));
        entries.add((EditText) findViewById(R.id.edit_text_insert3));
        entries.add((EditText) findViewById(R.id.edit_text_insert4));
        entries.add((EditText) findViewById(R.id.edit_text_insert5));
        entries.add((EditText) findViewById(R.id.edit_text_insert6));

        submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MadLibActivity.class);

                boolean allFilled = true;

                int i = 0;
                for (EditText entry : entries) {
                    if(!checkInput(entry)){
                        allFilled = false;
                        continue;
                    }
                    String key = EXTRA_ENTRIES_KEY_BASE + i;
                    intent.putExtra(key, entry.getText().toString());
                    i++;
                }
                if(allFilled) {
                    startActivity(intent);
                }
            }
        });
    }

    private boolean checkInput(EditText editText){
        if(editText.length() <= 0){
            editText.setError("Please enter text");
            return false;
        }
        if(!editText.getHint().toString().equals("Game") && !editText.getText().toString().matches("^[a-zA-Z]+$")){
            editText.setError("No more than one word permitted");
            return false;
        }
        return true;
    }
}
