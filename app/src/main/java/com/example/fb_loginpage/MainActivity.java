package com.example.fb_loginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView languageOptn,forgotPass;
    private MaterialButton loginBtn;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        String[] languageList = {"English (US)", "Spanish", "French", "German", "Italian", "Portuguese", "Chinese (Simplified)", "Chinese (Traditional)",
                "Japanese", "Korean", "Russian", "Arabic", "Turkish", "Indonesian", "Thai", "Vietnamese", "Dutch", "Swedish", "Danish", "Norwegian", "Finnish",
                "Polish", "Romanian", "Hungarian", "Czech", "Slovak", "Greek", "Bulgarian", "Ukrainian", "Hebrew", "Hindi", "Bengali", "Tamil", "Telugu", "Marathi",
                "Gujarati", "Kannada", "Malayalam", "Punjabi", "Urdu", "Persian", "Swahili", "Amharic", "Filipino", "Malay", "Burmese", "Khmer", "Lao", "Sinhala", "Nepali",
                "Georgian", "Azerbaijani", "Kurdish", "Kazakh", "Mongolian", "Pashto", "Sindhi", "Tajik", "Uzbek", "Yoruba", "Zulu"};

        for (String itemArray : languageList) {
            arrayList.add(itemArray);

        }

        languageOptn = findViewById(R.id.languageOptn);
        forgotPass = findViewById(R.id.forgotPass);
        loginBtn = findViewById(R.id.loginBtn);

        languageOptn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, languageOptn);
                for (String item : languageList) {
                    popupMenu.getMenu().add(item);
                }
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle the item selection here
                        String selectedText = item.getTitle().toString();
                        languageOptn.setText(selectedText);
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();

    }
        });

    }

    public void openDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Forgot Password?")
                .setMessage("Sit back, relax and try to remember your password.")
                .setCancelable(false)
                .setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
}
