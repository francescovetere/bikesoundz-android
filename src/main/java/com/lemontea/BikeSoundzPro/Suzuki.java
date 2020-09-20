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

public class Suzuki extends AppCompatActivity {

    private static final byte dim = 17;
    private Button[] buttonsSuzuki;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suzuki);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Suzuki");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadSuzukiButtons();
        addSuzukiListeners();
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

    public void loadSuzukiButtons(){
        buttonsSuzuki = new Button[dim];

        buttonsSuzuki[0] = (Button) findViewById(R.id._suzukiGSR750btn);
        buttonsSuzuki[1] = (Button) findViewById(R.id._suzukiGSXS750btn);
        buttonsSuzuki[2] = (Button) findViewById(R.id._suzukiGSXS1000btn);
        buttonsSuzuki[3] = (Button) findViewById(R.id._suzukiSV500btn);
        buttonsSuzuki[4] = (Button) findViewById(R.id._suzukiGSX250Rbtn);
        buttonsSuzuki[5] = (Button) findViewById(R.id._suzukiGSX1300Rbtn);
        buttonsSuzuki[6] = (Button) findViewById(R.id._suzukiGSXR750btn);
        buttonsSuzuki[7] = (Button) findViewById(R.id._suzukiGSXR1000btn);
        buttonsSuzuki[8] = (Button) findViewById(R.id._suzukiBandit1250Sbtn);
        buttonsSuzuki[9] = (Button) findViewById(R.id._suzukiGSXS1000Fbtn);
        buttonsSuzuki[10] = (Button) findViewById(R.id._suzukiVStorm650btn);
        buttonsSuzuki[11] = (Button) findViewById(R.id._suzukiVStorm650XTbtn);
        buttonsSuzuki[12] = (Button) findViewById(R.id._suzukiVStorm1000btn);
        buttonsSuzuki[13] = (Button) findViewById(R.id._suzukiIntruderC800btn);
        buttonsSuzuki[14] = (Button) findViewById(R.id._suzukiIntruderMbtn);
        buttonsSuzuki[15] = (Button) findViewById(R.id._suzukiVanVan125btn);
        buttonsSuzuki[16] = (Button) findViewById(R.id._suzukiVanVan200btn);

        return;
    }

    public void addSuzukiListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsSuzuki[i].setOnClickListener(bh);
            buttonsSuzuki[i].setOnLongClickListener(bh);
        }
    }

    public void suzukiPlay(int sound){
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

    public void suzukiPopup(int i) {
        pm = new PopupMenu(Suzuki.this, buttonsSuzuki[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.suzuki_gsr_750; break;
            case 1: ButtonsHandler.idRaw = R.raw.suzuki_gsx_s_750; break;
            case 2: ButtonsHandler.idRaw = R.raw.suzuki_gsx_s_1000; break;
            case 3: ButtonsHandler.idRaw = R.raw.suzuki_sv_650; break;
            case 4: ButtonsHandler.idRaw = R.raw.suzuki_gsx_250_r; break;
            case 5: ButtonsHandler.idRaw = R.raw.suzuki_gsx_1300r_hayabusa; break;
            case 6: ButtonsHandler.idRaw = R.raw.suzuki_gsx_r_750; break;
            case 7: ButtonsHandler.idRaw = R.raw.suzuki_gsx_r_1000; break;
            case 8: ButtonsHandler.idRaw = R.raw.suzuki_bandit_1250_s; break;
            case 9: ButtonsHandler.idRaw = R.raw.suzuki_gsx_s_1000_f; break;
            case 10: ButtonsHandler.idRaw = R.raw.suzuki_v_strom_650; break;
            case 11: ButtonsHandler.idRaw = R.raw.suzuki_v_strom_650_xt; break;
            case 12: ButtonsHandler.idRaw = R.raw.suzuki_v_strom_1000; break;
            case 13: ButtonsHandler.idRaw = R.raw.suzuki_intruder_c_800; break;
            case 14: ButtonsHandler.idRaw = R.raw.suzuki_intruder_m; break;
            case 15: ButtonsHandler.idRaw = R.raw.suzuki_van_van_125; break;
            case 16: ButtonsHandler.idRaw = R.raw.suzuki_van_van_200; break;
        }
        ButtonsHandler.context = "Suzuki";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean suzukiShare(String name, byte mode) {
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
