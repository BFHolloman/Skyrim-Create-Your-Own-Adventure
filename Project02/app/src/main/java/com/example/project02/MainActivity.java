package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project02.data.UserDAO;
import com.example.project02.data.UserDatabase;
import com.example.project02.model.User;

import static com.example.project02.HomeActivity.ACTIVE_USER_KEY;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
   private UserDAO db;
    UserDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();


        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inputs from login screen
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                //predefined users
                User admin = new User("admin2","admin2","admin2");
                User testuser1 = new User("testuser1","testuser1","testuser1");
                db.insert(admin);
                db.insert(testuser1);
                //getting user from login
                User user = db.getUser(email, password);

                //checking if there is a user
                if (user != null) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    i.putExtra(ACTIVE_USER_KEY, user);
                    startActivity(i);
                    //finish();
                }else{
                    Toast.makeText(MainActivity.this, "Unregistered user, or incorrect password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
