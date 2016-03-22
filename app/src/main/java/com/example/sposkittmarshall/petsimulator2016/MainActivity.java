package com.example.sposkittmarshall.petsimulator2016;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sposkittmarshall.petsimulator2016.Player.PlayerInfo;
import com.example.sposkittmarshall.petsimulator2016.Views.SquareImageView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    // SharedPreferences.Editor prefsEditor;

    PlayerInfo player;
    TextView test, test2;
    SquareImageView myPetView;

    // Buttons
    ImageButton foodButton, fightButton, toiletButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefs = getSharedPreferences("AppPrefs", getApplicationContext().MODE_PRIVATE);


        foodButton = (ImageButton)findViewById(R.id.foodButton);
        fightButton = (ImageButton)findViewById(R.id.fightButton);
        toiletButton = (ImageButton)findViewById(R.id.toiletButton);

        myPetView = (SquareImageView)findViewById(R.id.petView);
        boolean startCheck = false;
        prefs.getBoolean("Started", startCheck);

        if(!startCheck) {
            // If it's the player's first time playing, ask the player for a name
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            final EditText editText = new EditText(this);

            alertDialogBuilder.setView(editText);

            alertDialogBuilder.setCancelable(false).setMessage("What is your name?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = prefs.edit();

                    player = new PlayerInfo(editText.getText().toString(), getApplicationContext());

                    test = (TextView) findViewById(R.id.textView);
                    test.setText("Player's name is " + player.playerName);

                    test2 = (TextView) findViewById(R.id.textView2);
                    test2.setText("Player's pet is " + player.currentPet.getSpeciesName());

                    myPetView.setImageBitmap(player.currentPet.getPetImage());

                    // Say that player has played at least once
                    editor.putBoolean("Started", true);
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();

            alertDialog.show();

        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                SmsManager smsManager = SmsManager.getDefault();
                                smsManager.sendTextMessage("07462128328", null, "Hey, have I ever told you about my pet " + player.currentPet.getSpeciesName() + "? It's name is " + player.currentPet.getPetName() + " and it's better than your pet. Wanna prove me wrong? Get Pet Simulator 2016.", null, null);

                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("The Pet Simualtor 2016 team feels obilagated to tell you that sending SMS costs money, and you may not have money. Are you sure you wannant to send an SMS?").setPositiveButton("Yes", dialogClickListener).setNegativeButton("No", dialogClickListener).show();

                /*
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());
                final EditText editText = new EditText(getApplicationContext());

                alertDialogBuilder.setView(editText);

                alertDialogBuilder.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage("", null, "Hey, have I ever told you about my pet " + player.currentPet.getSpeciesName() + "? It's name is " + player.currentPet.getPetName() + " and it's better than your pet. Wanna prove me wrong? Get Pet Simulator 2016.", null, null);
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();
                */

                Snackbar.make(view, "Wanna brag to a friend about your great pet?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
