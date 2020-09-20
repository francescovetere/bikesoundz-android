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

public class HM extends AppCompatActivity {

    private static final byte dim = 5;
    private Button[] buttonsHM;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hm);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("HM");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadHMButtons();
        addHMListeners();
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

    public void loadHMButtons(){
        buttonsHM = new Button[dim];

        buttonsHM[0] = (Button) findViewById(R.id._hmCRE50btn);
        buttonsHM[1] = (Button) findViewById(R.id._hmCRE1252Tbtn);
        buttonsHM[2] = (Button) findViewById(R.id._hmCRE1254tbtn);
        buttonsHM[3] = (Button) findViewById(R.id._hmCity125btn);
        buttonsHM[4] = (Button) findViewById(R.id._hmLocusta125btn);

        return;
    }

    public void addHMListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsHM[i].setOnClickListener(bh);
            buttonsHM[i].setOnLongClickListener(bh);
        }
    }

    public void hmPlay(int sound){
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

    public void hmPopup(int i) {
        pm = new PopupMenu(HM.this, buttonsHM[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.hm_cre_crm_50; break;
            case 1: ButtonsHandler.idRaw = R.raw.hm_cre_crm_125_2t; break;
            case 2: ButtonsHandler.idRaw = R.raw.hm_cre_crm_125_4t; break;
            case 3: ButtonsHandler.idRaw = R.raw.hm_city_200; break;
            case 4: ButtonsHandler.idRaw = R.raw.hm_locusta_200; break;
        }
        ButtonsHandler.context = "HM";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean hmShare(String name, byte mode) {
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
