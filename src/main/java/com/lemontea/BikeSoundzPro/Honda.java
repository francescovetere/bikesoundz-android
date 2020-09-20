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

public class Honda extends AppCompatActivity {

    private static final byte dim = 27;
    private Button[] buttonsHonda;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honda);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Honda");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadHondaButtons();
        addHondaListeners();
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

    public void loadHondaButtons(){
        buttonsHonda = new Button[dim];

        buttonsHonda[0] = (Button) findViewById(R.id._hondaCB125Fbtn);
        buttonsHonda[1] = (Button) findViewById(R.id._hondaCB500Fbtn);
        buttonsHonda[2] = (Button) findViewById(R.id._hondaCB650Fbtn);
        buttonsHonda[3] = (Button) findViewById(R.id._hondaCB1000Rbtn);
        buttonsHonda[4] = (Button) findViewById(R.id._hondaCBR125Rbtn);
        buttonsHonda[5] = (Button) findViewById(R.id._hondaCBR300Rbtn);
        buttonsHonda[6] = (Button) findViewById(R.id._hondaCBR500Rbtn);
        buttonsHonda[7] = (Button) findViewById(R.id._hondaCBR1000RRbtn);
        buttonsHonda[8] = (Button) findViewById(R.id._hondaCB500Xbtn);
        buttonsHonda[9] = (Button) findViewById(R.id._hondaCBR650Fbtn);
        buttonsHonda[10] = (Button) findViewById(R.id._hondaCB1100btn);
        buttonsHonda[11] = (Button) findViewById(R.id._hondaCrossrunnerbtn);
        buttonsHonda[12] = (Button) findViewById(R.id._hondaGoldWingbtn);
        buttonsHonda[13] = (Button) findViewById(R.id._hondaMSXbtn);
        buttonsHonda[14] = (Button) findViewById(R.id._hondaNC750Sbtn);
        buttonsHonda[15] = (Button) findViewById(R.id._hondaNC750Xbtn);
        buttonsHonda[16] = (Button) findViewById(R.id._hondaVFR800Fbtn);
        buttonsHonda[17] = (Button) findViewById(R.id._hondaAfricaTwinbtn);
        buttonsHonda[18] = (Button) findViewById(R.id._hondaCrossTourerbtn);
        buttonsHonda[19] = (Button) findViewById(R.id._hondaCMX500Rebelbtn);
        buttonsHonda[20] = (Button) findViewById(R.id._hondaCRF250Scramblerbtn);
        buttonsHonda[21] = (Button) findViewById(R.id._hondaCRF250btn);
        buttonsHonda[22] = (Button) findViewById(R.id._hondaCRF300btn);
        buttonsHonda[23] = (Button) findViewById(R.id._hondaCRF450btn);
        buttonsHonda[24] = (Button) findViewById(R.id._hondaCRF500btn);
        buttonsHonda[25] = (Button) findViewById(R.id._hondaCRF450SMbtn);
        buttonsHonda[26] = (Button) findViewById(R.id._hondaCRF500SMbtn);

        return;
    }

    public void addHondaListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsHonda[i].setOnClickListener(bh);
            buttonsHonda[i].setOnLongClickListener(bh);
        }
    }

    public void hondaPlay(int sound){
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

    public void hondaPopup(int i) {
        pm = new PopupMenu(Honda.this, buttonsHonda[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.honda_cb_125_f; break;
            case 1: ButtonsHandler.idRaw = R.raw.honda_cb_500_f; break;
            case 2: ButtonsHandler.idRaw = R.raw.honda_cb_650_f; break;
            case 3: ButtonsHandler.idRaw = R.raw.honda_cb_1000_r; break;
            case 4: ButtonsHandler.idRaw = R.raw.honda_cbr_125_r; break;
            case 5: ButtonsHandler.idRaw = R.raw.honda_cbr_300_r; break;
            case 6: ButtonsHandler.idRaw = R.raw.honda_cbr_500_r; break;
            case 7: ButtonsHandler.idRaw = R.raw.honda_cbr_1000_rr_fireblade; break;
            case 8: ButtonsHandler.idRaw = R.raw.honda_cb_500_x; break;
            case 9: ButtonsHandler.idRaw = R.raw.honda_cbr_650_f; break;
            case 10: ButtonsHandler.idRaw = R.raw.honda_cb_1100; break;
            case 11: ButtonsHandler.idRaw = R.raw.honda_crossrunner; break;
            case 12: ButtonsHandler.idRaw = R.raw.honda_gold_wing; break;
            case 13: ButtonsHandler.idRaw = R.raw.honda_msx; break;
            case 14: ButtonsHandler.idRaw = R.raw.honda_nc_750_s; break;
            case 15: ButtonsHandler.idRaw = R.raw.honda_nc_750_x; break;
            case 16: ButtonsHandler.idRaw = R.raw.honda_vfr_800; break;
            case 17: ButtonsHandler.idRaw = R.raw.honda_crf_250; break;
            case 18: ButtonsHandler.idRaw = R.raw.honda_africa_twin; break;
            case 19: ButtonsHandler.idRaw = R.raw.honda_crosstourer; break;
            case 20: ButtonsHandler.idRaw = R.raw.honda_cmx_500_rebel; break;
            case 21: ButtonsHandler.idRaw = R.raw.honda_crf_enduro_250; break;
            case 22: ButtonsHandler.idRaw = R.raw.honda_crf_enduro_300; break;
            case 23: ButtonsHandler.idRaw = R.raw.honda_crf_enduro_450; break;
            case 24: ButtonsHandler.idRaw = R.raw.honda_crf_enduro_500; break;
            case 25: ButtonsHandler.idRaw = R.raw.honda_crf_supermoto_450; break;
            case 26: ButtonsHandler.idRaw = R.raw.honda_crf_supermoto_500; break;
        }
        ButtonsHandler.context = "Honda";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean hondaShare(String name, byte mode) {
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