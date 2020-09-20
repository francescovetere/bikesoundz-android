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

public class Ducati extends AppCompatActivity {

    private static final byte dim = 14;
    private Button[] buttonsDucati;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ducati);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Ducati");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadDucatiButtons();
        addDucatiListeners();
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

    public void loadDucatiButtons(){
        buttonsDucati = new Button[dim];

        buttonsDucati[0] = (Button) findViewById(R.id._ducatiMonster797btn);
        buttonsDucati[1] = (Button) findViewById(R.id._ducatiMonster821btn);
        buttonsDucati[2] = (Button) findViewById(R.id._ducatiMonster1200btn);
        buttonsDucati[3] = (Button) findViewById(R.id._ducati959Panigalebtn);
        buttonsDucati[4] = (Button) findViewById(R.id._ducati1299Panigalebtn);
        buttonsDucati[5] = (Button) findViewById(R.id._ducatiSupersportbtn);
        buttonsDucati[6] = (Button) findViewById(R.id._ducatiDiavelbtn);
        buttonsDucati[7] = (Button) findViewById(R.id._ducatiMultistrada950btn);
        buttonsDucati[8] = (Button) findViewById(R.id._ducatiMultistrada1200btn);
        buttonsDucati[9] = (Button) findViewById(R.id._ducatiScramblerbtn);
        buttonsDucati[10] = (Button) findViewById(R.id._ducatiScramblerCRbtn);
        buttonsDucati[11] = (Button) findViewById(R.id._ducatiScramblerDSbtn);
        buttonsDucati[12] = (Button) findViewById(R.id._ducatiXDiavelbtn);
        buttonsDucati[13] = (Button) findViewById(R.id._ducatiHypermotardbtn);

        return;
    }

    public void addDucatiListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsDucati[i].setOnClickListener(bh);
            buttonsDucati[i].setOnLongClickListener(bh);
        }
    }

    public void ducatiPlay(int sound){
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

    public void ducatiPopup(int i) {
        pm = new PopupMenu(Ducati.this, buttonsDucati[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.ducati_monster_797; break;
            case 1: ButtonsHandler.idRaw = R.raw.ducati_monster_821; break;
            case 2: ButtonsHandler.idRaw = R.raw.ducati_monster_1200; break;
            case 3: ButtonsHandler.idRaw = R.raw.ducati_959_panigale; break;
            case 4: ButtonsHandler.idRaw = R.raw.ducati_1299_panigale; break;
            case 5: ButtonsHandler.idRaw = R.raw.ducati_supersport; break;
            case 6: ButtonsHandler.idRaw = R.raw.ducati_diavel; break;
            case 7: ButtonsHandler.idRaw = R.raw.ducati_multistrada_950; break;
            case 8: ButtonsHandler.idRaw = R.raw.ducati_multistrada_1200; break;
            case 9: ButtonsHandler.idRaw = R.raw.ducati_scrambler; break;
            case 10: ButtonsHandler.idRaw = R.raw.ducati_scrambler_cafe_racer; break;
            case 11: ButtonsHandler.idRaw = R.raw.ducati_scrambler_desert_sled; break;
            case 12: ButtonsHandler.idRaw = R.raw.ducati_xdiavel; break;
            case 13: ButtonsHandler.idRaw = R.raw.ducati_hypermotard; break;
        }
        ButtonsHandler.context = "Ducati";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean ducatiShare(String name, byte mode) {
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
