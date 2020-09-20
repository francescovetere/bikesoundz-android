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

public class KTM extends AppCompatActivity {

    private static final byte dim = 23;
    private Button[] buttonsKTM;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ktm);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("KTM");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadKTMButtons();
        addKTMListeners();
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

    public void loadKTMButtons(){
        buttonsKTM = new Button[dim];

        buttonsKTM[0] = (Button) findViewById(R.id._ktmDuke125btn);
        buttonsKTM[1] = (Button) findViewById(R.id._ktmDuke390btn);
        buttonsKTM[2] = (Button) findViewById(R.id._ktmDuke690btn);
        buttonsKTM[3] = (Button) findViewById(R.id._ktmSuperDukeR1290btn);
        buttonsKTM[4] = (Button) findViewById(R.id._ktmSuperDukeGT1290btn);
        buttonsKTM[5] = (Button) findViewById(R.id._ktmRC125btn);
        buttonsKTM[6] = (Button) findViewById(R.id._ktmRC390btn);
        buttonsKTM[7] = (Button) findViewById(R.id._ktmEnduro690btn);
        buttonsKTM[8] = (Button) findViewById(R.id._ktmExc125btn);
        buttonsKTM[9] = (Button) findViewById(R.id._ktmExc200btn);
        buttonsKTM[10] = (Button) findViewById(R.id._ktmExc250_ebtn);
        buttonsKTM[11] = (Button) findViewById(R.id._ktmExc300_ebtn);
        buttonsKTM[12] = (Button) findViewById(R.id._ktmExc_f250btn);
        buttonsKTM[13] = (Button) findViewById(R.id._ktmExc350btn);
        buttonsKTM[14] = (Button) findViewById(R.id._ktmExc450btn);
        buttonsKTM[15] = (Button) findViewById(R.id._ktmExc500btn);
        buttonsKTM[16] = (Button) findViewById(R.id._ktmFreeride250Rbtn);
        buttonsKTM[17] = (Button) findViewById(R.id._ktmFreeride350btn);
        buttonsKTM[18] = (Button) findViewById(R.id._ktmSMC_R690btn);
        buttonsKTM[19] = (Button) findViewById(R.id._ktmAdventure1050btn);
        buttonsKTM[20] = (Button) findViewById(R.id._ktmAdventure1090btn);
        buttonsKTM[21] = (Button) findViewById(R.id._ktmAdventure1190btn);
        buttonsKTM[22] = (Button) findViewById(R.id._ktmSuperAdventure1290btn);

        return;
    }

    public void addKTMListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsKTM[i].setOnClickListener(bh);
            buttonsKTM[i].setOnLongClickListener(bh);
        }
    }

    public void ktmPlay(int sound){
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

    public void ktmPopup(int i) {
        pm = new PopupMenu(KTM.this, buttonsKTM[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.ktm_duke_125; break;
            case 1: ButtonsHandler.idRaw = R.raw.ktm_duke_390; break;
            case 2: ButtonsHandler.idRaw = R.raw.ktm_duke_690; break;
            case 3: ButtonsHandler.idRaw = R.raw.ktm_super_duke_r_1290; break;
            case 4: ButtonsHandler.idRaw = R.raw.ktm_super_duke_gt_1290; break;
            case 5: ButtonsHandler.idRaw = R.raw.ktm_rc_125; break;
            case 6: ButtonsHandler.idRaw = R.raw.ktm_rc_390; break;
            case 7: ButtonsHandler.idRaw = R.raw.ktm_enduro_690; break;
            case 8: ButtonsHandler.idRaw = R.raw.ktm_exc_125; break;
            case 9: ButtonsHandler.idRaw = R.raw.ktm_exc_200; break;
            case 10: ButtonsHandler.idRaw = R.raw.ktm_exc_e_250; break;
            case 11: ButtonsHandler.idRaw = R.raw.ktm_exc_e_300; break;
            case 12: ButtonsHandler.idRaw = R.raw.ktm_exc_f_250; break;
            case 13: ButtonsHandler.idRaw = R.raw.ktm_exc_350; break;
            case 14: ButtonsHandler.idRaw = R.raw.ktm_exc_450; break;
            case 15: ButtonsHandler.idRaw = R.raw.ktm_exc_500; break;
            case 16: ButtonsHandler.idRaw = R.raw.ktm_freeride_250_r; break;
            case 17: ButtonsHandler.idRaw = R.raw.ktm_freeride_350; break;
            case 18: ButtonsHandler.idRaw = R.raw.ktm_smc_r_690; break;
            case 19: ButtonsHandler.idRaw = R.raw.ktm_adventure_1050; break;
            case 20: ButtonsHandler.idRaw = R.raw.ktm_adventure_1090; break;
            case 21: ButtonsHandler.idRaw = R.raw.ktm_adventure_1190; break;
            case 22: ButtonsHandler.idRaw = R.raw.ktm_super_adventure_1290; break;
        }
        ButtonsHandler.context = "KTM";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean ktmShare(String name, byte mode) {
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
