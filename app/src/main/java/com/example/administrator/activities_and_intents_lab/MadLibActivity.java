package com.example.administrator.activities_and_intents_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MadLibActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_lib);

        Intent intent = getIntent();
        mTextView = (TextView) findViewById(R.id.mad_lib_text_view);
        mButton = (Button) findViewById(R.id.back_button);



        String[] answers = new String[6];
        String finalMadLib = "";
        for (int i = 0; i < answers.length; i++) {
            String key = WordEntryActivity.EXTRA_ENTRIES_KEY_BASE + i;
            answers[i] = intent.getStringExtra(key);
            Log.d("Mad Lib", key);
        }


        finalMadLib = String.format(getString(R.string.mad_lib1), answers[0], answers[1], answers[2], answers[3], answers[4], answers[5]);
        mTextView.setText(finalMadLib);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), WordEntryActivity.class));
            }
        });
    }
}
