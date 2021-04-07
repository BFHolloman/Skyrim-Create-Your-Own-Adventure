package com.example.project02.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project02.R;
import com.example.project02.data.UserDAO;
import com.example.project02.data.UserDatabase;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private TextView showUsers;

    private EditText userToDelete;
    private TextView adminHint;
    private Button deleteElement;
    private Button deleteAllButton;
    private Button backBtn;

    private UserDAO mUserDAO;
    private List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        showUsers = findViewById(R.id.usersView);
        showUsers.setMovementMethod(new ScrollingMovementMethod());
        userToDelete = findViewById(R.id.valueToDelete);
        deleteElement = findViewById(R.id.deleteSpecificUser);
        deleteAllButton = findViewById(R.id.deleteAllUsers);
        adminHint = findViewById(R.id.endingHint);
        adminHint.setText("Ending Hints:\n\n Intimidate Ending: Must go to the MOUNTAINS and INTIMIDATE Skeever to be able to intimidate Riften guard.\n\n Bribe Ending: Must go to the PAVED PATH and HELP the man with his wagon to be able to bribe the Riften Guard");

        backBtn = findViewById(R.id.back);
        mUserDAO = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();
        refreshDisplay();
        deleteElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userToDelete.getText().toString();
//                if (username.equals("admin")){
//                    Toast.makeText(getApplicationContext(), "Cannot delete admin", Toast.LENGTH_SHORT).show();
//                }else{
                    users = mUserDAO.getAllUsers();
                    for (User user : users) {
                        if (username.equals(user.getUserName())){
                            mUserDAO.delete(user);
                            refreshDisplay();
                            return;
//                        }
                    }
                    Toast.makeText(getApplicationContext(), "There is no player with username: " + username, Toast.LENGTH_SHORT).show();
                }
            }
        });
        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users = mUserDAO.getAllUsers();
                for (User user : users) {
                    mUserDAO.delete(user);
                }
                refreshDisplay();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void refreshDisplay(){
        users = mUserDAO.getAllUsers();
        StringBuilder sd = new StringBuilder();
        for (User user : users) {
            sd.append(user.toString());
            sd.append("\n");
            sd.append("=-=-=-=-=-=-=-=-=");
            sd.append("\n");
        }
        showUsers.setText(sd.toString());
    }
}