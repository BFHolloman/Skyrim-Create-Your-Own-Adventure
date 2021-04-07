package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project02.model.User;

import static com.example.project02.HomeActivity.ACTIVE_USER_KEY;

public class GameScreen extends AppCompatActivity {

    ImageView image;
    TextView text;
    Button  button1, button2, button3;
    Story story ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        story = new Story(this);
        image = (ImageView)findViewById(R.id.gameImageView);
        text = (TextView)findViewById(R.id.gameTextView);
        button1 = (Button)findViewById(R.id.choiceButton1);
        button2 = (Button)findViewById(R.id.choiceButton2);
        button3 = (Button)findViewById(R.id.choiceButton3);

        story.startingScene();



//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                story.selectPosition(story.nextPosition1);   }
//        });
    }

    public void button1(View view){
        story.selectPosition(story.nextPosition1);
    }
    public void button2(View view){
        story.selectPosition(story.nextPosition2);
    }
    public void button3(View view){
        story.selectPosition(story.nextPosition3);
    }
    public void goTitleScreen(){
        Intent titleScreen = new Intent(this, HomeActivity.class);
        titleScreen.putExtra(ACTIVE_USER_KEY, getIntent().getSerializableExtra(ACTIVE_USER_KEY));
        titleScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(titleScreen);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu,menu);
        return true;
    }


    public void logoutUser(){
        Intent titleScreen = new Intent(this, MainActivity.class);
        titleScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(titleScreen);
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item){
        switch(item.getItemId()){
            case R.id.logoutUser:
                logoutUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}