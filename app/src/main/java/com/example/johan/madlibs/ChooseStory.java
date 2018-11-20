package com.example.johan.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class ChooseStory extends AppCompatActivity {

    InputStream chosen_story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);
    }
//    go back to first screen if android back button is pressed
    public void onBackPressed() {
        startActivity(new Intent(ChooseStory.this, MainActivity.class));
    }
//    take text of chosen story as inputstream
    public void checkClicked(View view) {
        Button button = (Button) view;
        Log.d("story", "isClicked: " + String.valueOf(view.getId()));
        String story_name = button.getText().toString();
        switch (story_name)  {
            case "Simple":
                chosen_story = getResources().openRawResource(R.raw.madlib0_simple);
                break;
            case "Tarzan":
                chosen_story = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case "University":
                chosen_story = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case "Clothes":
                chosen_story = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case "Dance":
                chosen_story = getResources().openRawResource(R.raw.madlib4_dance);
                break;
        }
//        make class instance of chosen story and sent to third screen
        Story story = new Story(chosen_story);
        Intent intent = new Intent(ChooseStory.this, AddWords.class);
        intent.putExtra("clicked_story", story);
        startActivity(intent);
    }
}
