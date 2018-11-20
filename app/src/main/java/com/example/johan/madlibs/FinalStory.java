package com.example.johan.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalStory extends AppCompatActivity {

    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_story);

//  get class instance from last screen and print filled in story
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("final_story");
        String Final_story = story.toString();
        ((TextView) findViewById(R.id.madlibstory)).setText(Final_story);
    }
//  send user back to choose story
    public void onBackPressed() {
        story.clear();
        startActivity(new Intent(FinalStory.this, ChooseStory.class));
    }
//  send user back to choose story
    public void Back(View view) {
        story.clear();
        startActivity(new Intent(FinalStory.this, ChooseStory.class));
    }
}
