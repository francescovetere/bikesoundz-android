package com.lemontea.BikeSoundzPro;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Home extends AppCompatActivity {

    private static final int dim = 20;
    private Button[] buttonsHome;
    private ButtonsHandler bh;

    private Toolbar toolbar;

    private File file;
    private FileInputStream is = null;
    private FileOutputStream fos = null;
    private boolean checked = false;

    private void writeFile(File file, FileOutputStream fos, String s) {
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fos.write(s.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFile(File file, FileInputStream is) {
        String s = "";
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            s = reader.readLine();
        } catch (IOException e) {
        }

        return s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setIcon(R.mipmap.app_logo_icon);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        loadHomeButtons();
        addHomeListeners();

        //---------

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission())
            {
                //do your work
                checked = true;
            }
            else
            {
                requestPermission();
            }
        }
        else checked = true;

        if(checked){
            String path = StaticValues.defaultPath;

            boolean exists = (new File(path)).exists();
            if (!exists) {
                new File(path).mkdirs();
            }
            try {
                file = new File(path + ".config");
                if (!file.exists()) {
                    file.createNewFile();
                    writeFile(file, fos, StaticValues.defaultPath);
                }
            } catch (IOException e) {}

            StaticValues.actualPath = readFile(file, is);
        }

    }

    protected boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    protected void requestPermission() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //do your work
                    checked = true;
                    String path = StaticValues.defaultPath;

                    boolean exists = (new File(path)).exists();
                    if (!exists) {
                        new File(path).mkdirs();
                    }
                    try {
                        file = new File(path + ".config");
                        if (!file.exists()) {
                            file.createNewFile();
                            writeFile(file, fos, StaticValues.defaultPath);
                        }
                    } catch (IOException e) {}

                    StaticValues.actualPath = readFile(file, is);
                } else {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setTitle("Allow permission in App Settings");
                    alertDialogBuilder.setMessage("BikeSoundz Pro needs the permission to store audio files into your device, or the app won't work correctly.\n" +
                            "Please allow this permission in your App Settings.");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setNegativeButton("Close",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                break;
        }
        //---------

}

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit application?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                               android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        });
         alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {dialog.cancel();}
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id._settings) {
            if(checked){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Change audio saves directory");

                builder.setMessage("Default folder for audio saves is located in your primary storage directory.\n" +
                        "If you want to change this location, just type a new path in the field below.");
                // Set up the input
                final EditText input = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setHint(StaticValues.actualPath);
                //input.setText(StaticValues.actualPath);
                builder.setView(input);


                // Set up the buttons
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        writeFile(file, fos, input.getText().toString());
                        StaticValues.actualPath = input.getText().toString();
                        Toast.makeText(getApplicationContext(), "New audio saves path is: " + StaticValues.actualPath, Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setNeutralButton("Restore as default", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        writeFile(file, fos, StaticValues.defaultPath);
                        StaticValues.actualPath = StaticValues.defaultPath;
                        Toast.makeText(getApplicationContext(), "Audio saves path restored as default", Toast.LENGTH_LONG).show();
                    }
                });

                builder.show();
            }
            else{
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Allow permission in App Settings");
                alertDialogBuilder.setMessage("BikeSoundz Pro needs the permission to store audio files into your device, or the app won't work correctly.\n" +
                        "Please allow this permission in your App Settings.");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setNegativeButton("Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }

        else if(id == R.id._menu_help){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("How to use the app");

            builder.setMessage("- Select a brand from the home page, then scroll between the bike models and press a button to hear bike's sound\n" +
                    "- Hold down a bike's button to share the audio file with your friends or to save it in your device\n" +
                    "- Modify audio saves path by tapping on the Save Options icon");

            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
            return true;
        }

        else if(id == R.id._menu_about){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("About me");

            builder.setMessage("I'm a student of Computer Science with a great passion for motorcycles.\n" +
                    "If you liked this app and/or you have any suggestion to improve it, rate BikeSoundz on the Play Store and leave a comment, I really appreciate it :)");

            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.setNeutralButton("Rate BikeSoundz!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final String bsPro = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + bsPro)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + bsPro)));
                    }
                }
            });

            builder.show();
            return true;
        }

        return false;
    }

    private void loadHomeButtons(){
        buttonsHome = new Button[dim];

        buttonsHome[0] = (Button) findViewById(R.id._aprilia);
        buttonsHome[1] = (Button) findViewById(R.id._beta);
        buttonsHome[2] = (Button) findViewById(R.id._bmw);
        buttonsHome[3] = (Button) findViewById(R.id._derbi);
        buttonsHome[4] = (Button) findViewById(R.id._ducati);
        buttonsHome[5] = (Button) findViewById(R.id._fantic);
        buttonsHome[6] = (Button) findViewById(R.id._harley);
        buttonsHome[7] = (Button) findViewById(R.id._hm);
        buttonsHome[8] = (Button) findViewById(R.id._honda);
        buttonsHome[9] = (Button) findViewById(R.id._husaberg);
        buttonsHome[10] = (Button) findViewById(R.id._husqvarna);
        buttonsHome[11] = (Button) findViewById(R.id._kawasaki);
        buttonsHome[12] = (Button) findViewById(R.id._ktm);
        buttonsHome[13] = (Button) findViewById(R.id._moto_guzzi);
        buttonsHome[14] = (Button) findViewById(R.id._mv_agusta);
        buttonsHome[15] = (Button) findViewById(R.id._suzuki);
        buttonsHome[16] = (Button) findViewById(R.id._tm);
        buttonsHome[17] = (Button) findViewById(R.id._triumph);
        buttonsHome[18] = (Button) findViewById(R.id._valenti);
        buttonsHome[19] = (Button) findViewById(R.id._yamaha);
    }

    private void addHomeListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++)
            buttonsHome[i].setOnClickListener(bh);
    }

    public void apriliaPage(){
        Intent in = new Intent(getApplicationContext(), Aprilia.class);
        startActivity(in);
    }

    public void betaPage(){
        Intent in = new Intent(getApplicationContext(), Beta.class);
        startActivity(in);
    }

    public void bmwPage(){
        Intent in = new Intent(getApplicationContext(), BMW.class);
        startActivity(in);
    }

    public void derbiPage(){
        Intent in = new Intent(getApplicationContext(), Derbi.class);
        startActivity(in);
    }

    public void ducatiPage(){
        Intent in = new Intent(getApplicationContext(), Ducati.class);
        startActivity(in);
    }

    public void fanticPage(){
        Intent in = new Intent(getApplicationContext(), Fantic.class);
        startActivity(in);
    }

    public void harleyPage(){
        Intent in = new Intent(getApplicationContext(), HarleyDavidson.class);
        startActivity(in);
    }

    public void HMPage(){
        Intent in = new Intent(getApplicationContext(), HM.class);
        startActivity(in);
    }

    public void hondaPage(){
        Intent in = new Intent(getApplicationContext(), Honda.class);
        startActivity(in);
    }

    public void husabergPage(){
        Intent in = new Intent(getApplicationContext(), Husaberg.class);
        startActivity(in);
    }

    public void husqvarnaPage(){
        Intent in = new Intent(getApplicationContext(), Husqvarna.class);
        startActivity(in);
    }

    public void kawasakiPage(){
        Intent in = new Intent(getApplicationContext(), Kawasaki.class);
        startActivity(in);
    }

    public void KTMPage(){
        Intent in = new Intent(getApplicationContext(), KTM.class);
        startActivity(in);
    }

    public void motoGuzziPage(){
        Intent in = new Intent(getApplicationContext(), MotoGuzzi.class);
        startActivity(in);
    }

    public void MVAgustaPage(){
        Intent in = new Intent(getApplicationContext(), MVAgusta.class);
        startActivity(in);
    }

    public void suzukiPage(){
        Intent in = new Intent(getApplicationContext(), Suzuki.class);
        startActivity(in);
    }

    public void TMPage(){
        Intent in = new Intent(getApplicationContext(), TM.class);
        startActivity(in);
    }

    public void TriumphPage(){
        Intent in = new Intent(getApplicationContext(), Triumph.class);
        startActivity(in);
    }

    public void valentiPage(){
        Intent in = new Intent(getApplicationContext(), Valenti.class);
        startActivity(in);
    }
    public void yamahaPage(){
        Intent in = new Intent(getApplicationContext(), Yamaha.class);
        startActivity(in);
    }

}