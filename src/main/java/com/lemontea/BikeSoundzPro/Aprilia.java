package com.lemontea.BikeSoundzPro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Aprilia extends AppCompatActivity {

    private static final byte dim = 9;
    private Button[] buttonsAprilia;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprilia);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Aprilia");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadApriliaButtons();
        addApriliaListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_bikes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home) {
            finish();
            return true;
        }

        return false;
    }


    public void loadApriliaButtons(){
        buttonsAprilia = new Button[dim];

        buttonsAprilia[0] = (Button) findViewById(R.id._apriliaShiver900btn);
        buttonsAprilia[1] = (Button) findViewById(R.id._apriliaTuono125btn);
        buttonsAprilia[2] = (Button) findViewById(R.id._apriliaTuonoV4btn);
        buttonsAprilia[3] = (Button) findViewById(R.id._apriliaRS450btn);
        buttonsAprilia[4] = (Button) findViewById(R.id._apriliaRS4125btn);
        buttonsAprilia[5] = (Button) findViewById(R.id._apriliaRSV4btn);
        buttonsAprilia[6] = (Button) findViewById(R.id._apriliaDorsoduro900btn);
        buttonsAprilia[7] = (Button) findViewById(R.id._apriliaCaponord1200btn);
        buttonsAprilia[8] = (Button) findViewById(R.id._apriliaRx50btn);

        return;
    }

    public void addApriliaListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsAprilia[i].setOnClickListener(bh);
            buttonsAprilia[i].setOnLongClickListener(bh);
        }
    }

    public void apriliaPlay(int sound){
        if(mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        mp = MediaPlayer.create(getApplicationContext(), sound);
        mp.start();
    }

    @Override
    public void finish() {
        super.finish();
        mp.stop();
    }

    public void apriliaPopup(int i) {
        pm = new PopupMenu(Aprilia.this, buttonsAprilia[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.aprilia_shiver_900; break;
            case 1: ButtonsHandler.idRaw = R.raw.aprilia_tuono_125; break;
            case 2: ButtonsHandler.idRaw = R.raw.aprilia_tuono_v4; break;
            case 3: ButtonsHandler.idRaw = R.raw.aprilia_rs4_50; break;
            case 4: ButtonsHandler.idRaw = R.raw.aprilia_rs4_125; break;
            case 5: ButtonsHandler.idRaw = R.raw.aprilia_rsv4; break;
            case 6: ButtonsHandler.idRaw = R.raw.aprilia_dorsoduro_900; break;
            case 7: ButtonsHandler.idRaw = R.raw.aprilia_caponord_1200; break;
            case 8: ButtonsHandler.idRaw = R.raw.aprilia_rx_50; break;
        }
        ButtonsHandler.context = "Aprilia";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }


    public boolean apriliaShare(String name, byte mode) {
        byte[] buffer = null;
        InputStream fIn = getBaseContext().getResources().openRawResource(ButtonsHandler.idRaw);
        int size = 0;

        try {
            size = fIn.available();
            buffer = new byte[size];
            fIn.read(buffer);
            fIn.close();
        } catch (IOException e) {
            return false;
        }

        //Uri alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/raw/aprilia_rs4_50");
        
        String path = StaticValues.actualPath;
        String filename = name + ".mp3";

        if(mode == 1) //save mode
            path = path + getResources().getString(R.string.savePath);
        else if(mode == 2)
            path = path + getResources().getString(R.string.sharedPath);
        else if (mode == 3)
            path = path + "Ringtones/";

        boolean exists = (new File(path)).exists();
        if (!exists) {
            new File(path).mkdirs();
        }

        FileOutputStream save;
        try {
            save = new FileOutputStream(path + filename);
            save.write(buffer);
            save.flush();
            save.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }

        //sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://"+path+filename)));

        File k = new File(path, filename);

        /*
        ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
        values.put(MediaStore.MediaColumns.TITLE, "culo");
        values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/ogg");
        values.put(MediaStore.Audio.Media.ARTIST, "cssounds ");
        values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
        values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
        values.put(MediaStore.Audio.Media.IS_ALARM, false);
        values.put(MediaStore.Audio.Media.IS_MUSIC, false);

        //Insert it into the database
        getContentResolver().insert(MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath()), values);

        Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());
        Uri newUri = getContentResolver().insert(uri, values);


        try {
            RingtoneManager.setActualDefaultRingtoneUri(getApplicationContext(), RingtoneManager.TYPE_NOTIFICATION, newUri);
        }catch(Throwable t){

        }
        */
        if(mode == 1) { //save mode
            Toast.makeText(getApplicationContext(), "Saved to folder " + path, Toast.LENGTH_LONG).show();
            return true;
        }
        else if(mode == 2) { //share mode

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("audio/mp3");

            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(k));
            startActivity(Intent.createChooser(shareIntent, getResources().getString(R.string.shareMsg)));


            return true;
        }

        else if(mode == 3) {
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkPermission())
                {
                    Toast.makeText(getApplicationContext(), "fatto", Toast.LENGTH_LONG).show();
                    //do your work
                    checked = true;
                }
                else
                {
                    requestPermission();
                }
            }
            else checked = true;

            if(true) {
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path + filename)));

                ContentValues values = new ContentValues();
                values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
                values.put(MediaStore.MediaColumns.TITLE, filename);
                values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/ogg");
                values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
                values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
                values.put(MediaStore.Audio.Media.IS_ALARM, false);
                values.put(MediaStore.Audio.Media.IS_MUSIC, false);


                //Insert it into the database
                getContentResolver().insert(MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath()), values);

                Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());
                Uri newUri = getContentResolver().insert(uri, values);

                getContentResolver().delete(uri,
                        MediaStore.MediaColumns.DATA + "=\""
                                + k.getAbsolutePath() + "\"", null);

                try {
                    RingtoneManager.setActualDefaultRingtoneUri(getApplicationContext(), RingtoneManager.TYPE_RINGTONE, newUri);
                    Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();

                } catch (Throwable t) {}

                */
            return true;
            }

        return false;
    }

}
