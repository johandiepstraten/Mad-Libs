package com.example.johan.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddWords extends AppCompatActivity {

    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);
//  get chosen story and print total placeholders to fill in and type of the first placeholder
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("clicked_story");
        ((TextView) findViewById(R.id.placeholdercount)).setText(story.getPlaceholderRemainingCount()+" word(s) left");
        ((TextView) findViewById(R.id.placeholder)).setText("please type a/an "+(story.getNextPlaceholder().toLowerCase()));

    }
//  if OK button is pressed check if string is not empty, if so: place word in story and get info new placeholder
    public void NextWord(View view) {
        String word = ((EditText)findViewById(R.id.word)).getText().toString();
        if(word.length() > 0)  {
            story.fillInPlaceholder(word);
            ((TextView) findViewById(R.id.placeholdercount)).setText(story.getPlaceholderRemainingCount()+" word(s) left");
            ((TextView) findViewById(R.id.placeholder)).setText("please type a/an "+(story.getNextPlaceholder().toLowerCase()));
            ((EditText)findViewById(R.id.word)).setText("");
//   if story is full, sent user to last screen
            if(story.isFilledIn())   {
                Intent save = new Intent(AddWords.this, FinalStory.class);
                save.putExtra("final_story", story);
                startActivity(save);
            }
        }
    }
}
