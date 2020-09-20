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

public class Kawasaki extends AppCompatActivity {

    private static final byte dim = 21;
    private Button[] buttonsKawasaki;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kawasaki);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Kawasaki");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadKawasakiButtons();
        addKawasakiListeners();
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

    public void loadKawasakiButtons(){
        buttonsKawasaki = new Button[dim];

        buttonsKawasaki[0] = (Button) findViewById(R.id._kawaz250btn);
        buttonsKawasaki[1] = (Button) findViewById(R.id._kawaz300btn);
        buttonsKawasaki[2] = (Button) findViewById(R.id._kawaz650btn);
        buttonsKawasaki[3] = (Button) findViewById(R.id._kawaz800btn);
        buttonsKawasaki[4] = (Button) findViewById(R.id._kawaz900btn);
        buttonsKawasaki[5] = (Button) findViewById(R.id._kawaz1000btn);
        buttonsKawasaki[6] = (Button) findViewById(R.id._kawaNinja650btn);
        buttonsKawasaki[7] = (Button) findViewById(R.id._kawaNinjaZX_10rbtn);
        buttonsKawasaki[8] = (Button) findViewById(R.id._kawaNinjaH2btn);
        buttonsKawasaki[9] = (Button) findViewById(R.id._kawaZZR1400btn);
        buttonsKawasaki[10] = (Button) findViewById(R.id._kawaGTR1400btn);
        buttonsKawasaki[11] = (Button) findViewById(R.id._kawaVersys_Xbtn);
        buttonsKawasaki[12] = (Button) findViewById(R.id._kawaVersys650btn);
        buttonsKawasaki[13] = (Button) findViewById(R.id._kawaVersys1000btn);
        buttonsKawasaki[14] = (Button) findViewById(R.id._kawaW800btn);
        buttonsKawasaki[15] = (Button) findViewById(R.id._kawaZ1000SXbtn);
        buttonsKawasaki[16] = (Button) findViewById(R.id._kawaVulcanSbtn);
        buttonsKawasaki[17] = (Button) findViewById(R.id._kawaVulcan900btn);
        buttonsKawasaki[18] = (Button) findViewById(R.id._kawaKLX125btn);
        buttonsKawasaki[19] = (Button) findViewById(R.id._kawaKLX250btn);
        buttonsKawasaki[20] = (Button) findViewById(R.id._kawaKLX450rbtn);

        return;
    }

    public void addKawasakiListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsKawasaki[i].setOnClickListener(bh);
            buttonsKawasaki[i].setOnLongClickListener(bh);
        }
    }

    public void kawaPlay(int sound){
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

    public void kawaPopup(int i) {
        pm = new PopupMenu(Kawasaki.this, buttonsKawasaki[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.kawasaki_z_250; break;
            case 1: ButtonsHandler.idRaw = R.raw.kawasaki_z_300; break;
            case 2: ButtonsHandler.idRaw = R.raw.kawasaki_z_650; break;
            case 3: ButtonsHandler.idRaw = R.raw.kawasaki_z_800; break;
            case 4: ButtonsHandler.idRaw = R.raw.kawasaki_z_900; break;
            case 5: ButtonsHandler.idRaw = R.raw.kawasaki_z_1000; break;
            case 6: ButtonsHandler.idRaw = R.raw.kawasaki_ninja_650; break;
            case 7: ButtonsHandler.idRaw = R.raw.kawasaki_ninja_zx_10r; break;
            case 8: ButtonsHandler.idRaw = R.raw.kawasaki_ninja_h2; break;
            case 9: ButtonsHandler.idRaw = R.raw.kawasaki_zzr_1400; break;
            case 10: ButtonsHandler.idRaw = R.raw.kawasaki_gtr_1400; break;
            case 11: ButtonsHandler.idRaw = R.raw.kawasaki_versys_x; break;
            case 12: ButtonsHandler.idRaw = R.raw.kawasaki_versys_650; break;
            case 13: ButtonsHandler.idRaw = R.raw.kawasaki_versys_1000; break;
            case 14: ButtonsHandler.idRaw = R.raw.kawasaki_w_800; break;
            case 15: ButtonsHandler.idRaw = R.raw.kawasaki_z_1000_sx; break;
            case 16: ButtonsHandler.idRaw = R.raw.kawasaki_vulcan_s; break;
            case 17: ButtonsHandler.idRaw = R.raw.kawasaki_vulcan_900; break;
            case 18: ButtonsHandler.idRaw = R.raw.kawasaki_klx_125; break;
            case 19: ButtonsHandler.idRaw = R.raw.kawasaki_klx_250; break;
            case 20: ButtonsHandler.idRaw = R.raw.kawasaki_klx_450_r; break;
        }
        ButtonsHandler.context = "Kawasaki";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean kawaShare(String name, byte mode) {
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
