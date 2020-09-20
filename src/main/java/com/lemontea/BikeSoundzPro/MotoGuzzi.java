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

public class MotoGuzzi extends AppCompatActivity {

    private static final byte dim = 9;
    private Button[] buttonsMG;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto_guzzi);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Moto Guzzi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadMGButtons();
        addMGListeners();
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

    public void loadMGButtons(){
        buttonsMG = new Button[dim];

        buttonsMG[0] = (Button) findViewById(R.id._mgAudacebtn);
        buttonsMG[1] = (Button) findViewById(R.id._mgCaliforniabtn);
        buttonsMG[2] = (Button) findViewById(R.id._mgEldoradobtn);
        buttonsMG[3] = (Button) findViewById(R.id._mgV7IIbtn);
        buttonsMG[4] = (Button) findViewById(R.id._mgV7IIRacerbtn);
        buttonsMG[5] = (Button) findViewById(R.id._mgV7IIIbtn);
        buttonsMG[6] = (Button) findViewById(R.id._mgV7IIIRacerbtn);
        buttonsMG[7] = (Button) findViewById(R.id._mgV9btn);
        buttonsMG[8] = (Button) findViewById(R.id._mgMGX21btn);

        return;
    }

    public void addMGListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsMG[i].setOnClickListener(bh);
            buttonsMG[i].setOnLongClickListener(bh);
        }
    }

    public void mgPlay(int sound){
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

    public void mgPopup(int i) {
        pm = new PopupMenu(MotoGuzzi.this, buttonsMG[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.moto_guzzi_audace; break;
            case 1: ButtonsHandler.idRaw = R.raw.moto_guzzi_california; break;
            case 2: ButtonsHandler.idRaw = R.raw.moto_guzzi_eldorado; break;
            case 3: ButtonsHandler.idRaw = R.raw.moto_guzzi_v7_ii; break;
            case 4: ButtonsHandler.idRaw = R.raw.moto_guzzi_v7_ii_racer; break;
            case 5: ButtonsHandler.idRaw = R.raw.moto_guzzi_v7_iii; break;
            case 6: ButtonsHandler.idRaw = R.raw.moto_guzzi_v7_iii_racer; break;
            case 7: ButtonsHandler.idRaw = R.raw.moto_guzzi_v9; break;
            case 8: ButtonsHandler.idRaw = R.raw.moto_guzzi_mgx_21; break;
        }
        ButtonsHandler.context = "MotoGuzzi";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean mgShare(String name, byte mode) {
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
