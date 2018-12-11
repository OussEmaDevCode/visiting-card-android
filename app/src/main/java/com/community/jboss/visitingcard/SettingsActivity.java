package com.community.jboss.visitingcard;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceActivity;

import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;



/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Button edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editViews();
            }
        });


    }
    private void editViews() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit information")
                .setCancelable(true)
                .setIcon(R.drawable.ic_edit_black_24dp);

        View view = getLayoutInflater().inflate( R.layout.dialogbox, null);


        final EditText NameBox = view.findViewById(R.id.name);
        final EditText PhoneBox = view.findViewById(R.id.phoneNumber);
        final EditText EmailBox = view.findViewById(R.id.email);
        final EditText Twitter = view.findViewById(R.id.twitter);
        final EditText git = view.findViewById(R.id.github);
        final EditText linked = view.findViewById(R.id.linkedin);
        builder.setView(view);
        builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
                editor.putString("card_name", NameBox.getText().toString());
                editor.putString("card_phone",PhoneBox.getText().toString());
                editor.putString("card_email",EmailBox.getText().toString());
                editor.putString("card_twitter",Twitter.getText().toString());
                editor.putString("card_git",git.getText().toString());
                editor.putString("card_linked",linked.getText().toString());
                editor.apply();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
