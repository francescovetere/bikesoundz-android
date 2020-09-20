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

public class Husqvarna extends AppCompatActivity {

    private static final byte dim = 8;
    private Button[] buttonsHsq;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_husqvarna);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Husqvarna");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadHsqButtons();
        addHsqListeners();
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

    public void loadHsqButtons(){
        buttonsHsq = new Button[dim];

        buttonsHsq[0] = (Button) findViewById(R.id._hsqTE125btn);
        buttonsHsq[1] = (Button) findViewById(R.id._hsqTE250btn);
        buttonsHsq[2] = (Button) findViewById(R.id._hsqTE300btn);
        buttonsHsq[3] = (Button) findViewById(R.id._hsqFE250btn);
        buttonsHsq[4] = (Button) findViewById(R.id._hsqFE350btn);
        buttonsHsq[5] = (Button) findViewById(R.id._hsqFE450btn);
        buttonsHsq[6] = (Button) findViewById(R.id._hsqFE501btn);
        buttonsHsq[7] = (Button) findViewById(R.id._hsq701btn);

        return;
    }

    public void addHsqListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsHsq[i].setOnClickListener(bh);
            buttonsHsq[i].setOnLongClickListener(bh);
        }
    }

    public void hsqPlay(int sound){
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

    public void hsqPopup(int i) {
        pm = new PopupMenu(Husqvarna.this, buttonsHsq[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.husqvarna_te_125; break;
            case 1: ButtonsHandler.idRaw = R.raw.husqvarna_te_250; break;
            case 2: ButtonsHandler.idRaw = R.raw.husqvarna_te_300; break;
            case 3: ButtonsHandler.idRaw = R.raw.husqvarna_fe_250; break;
            case 4: ButtonsHandler.idRaw = R.raw.husqvarna_fe_350; break;
            case 5: ButtonsHandler.idRaw = R.raw.husqvarna_fe_450; break;
            case 6: ButtonsHandler.idRaw = R.raw.husqvarna_fe_501; break;
            case 7: ButtonsHandler.idRaw = R.raw.husqvarna_701; break;
        }
        ButtonsHandler.context = "Husqvarna";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean hsqShare(String name, byte mode) {
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

        String path = StaticValues.actualPath;
        String filename = name + ".mp3";

        if(mode == 1) //save mode
            path = path + getResources().getString(R.string.savePath);
        else if(mode == 2)
            path = path + getResources().getString(R.string.sharedPath);

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

        File k = new File(path, filename);

        if(mode == 1) { //save mode
            Toast.makeText(getApplicationContext(), "Saved to folder " + path, Toast.LENGTH_LONG).show();
            return true;
        }
        else if(mode == 2) { //share mode
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("audio/mp3");

            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(k));
            startActivity(Intent.createChooser(shareIntent, "Share this audio"));

            return true;
        }

        return false;
    }
}
