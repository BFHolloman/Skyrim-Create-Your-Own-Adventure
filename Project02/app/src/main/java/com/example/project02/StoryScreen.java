package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import static com.example.project02.HomeActivity.ACTIVE_USER_KEY;

public class StoryScreen extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_screen);

        text = (TextView)findViewById(R.id.storyTextView);
        text.setMovementMethod(new ScrollingMovementMethod());
    }

    public void goGameScreen(View v){

        Intent i = new Intent(this,GameScreen.class);
        i.putExtra(ACTIVE_USER_KEY, getIntent().getSerializableExtra(ACTIVE_USER_KEY));


                startActivity(i);


    }
}