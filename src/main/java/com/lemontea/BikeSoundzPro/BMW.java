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

public class BMW extends AppCompatActivity {

    private static final byte dim = 17;
    private Button[] buttonsBMW;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmw);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("BMW");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadBMWButtons();
        addBMWListeners();
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

    public void loadBMWButtons(){
        buttonsBMW = new Button[dim];

        buttonsBMW[0] = (Button) findViewById(R.id._bmwf800rbtn);
        buttonsBMW[1] = (Button) findViewById(R.id._bmwg310rbtn);
        buttonsBMW[2] = (Button) findViewById(R.id._bmwr1200rbtn);
        buttonsBMW[3] = (Button) findViewById(R.id._bmwrninetbtn);
        buttonsBMW[4] = (Button) findViewById(R.id._bmws1000rbtn);
        buttonsBMW[5] = (Button) findViewById(R.id._bmws1000rrbtn);
        buttonsBMW[6] = (Button) findViewById(R.id._bmwf800gtbtn);
        buttonsBMW[7] = (Button) findViewById(R.id._bmwk1600gtbtn);
        buttonsBMW[8] = (Button) findViewById(R.id._bmwr1200rsbtn);
        buttonsBMW[9] = (Button) findViewById(R.id._bmwr1200rtbtn);
        buttonsBMW[10] = (Button) findViewById(R.id._bmwrninetracerbtn);
        buttonsBMW[11] = (Button) findViewById(R.id._bmws1000xrbtn);
        buttonsBMW[12] = (Button) findViewById(R.id._bmwf700gsbtn);
        buttonsBMW[13] = (Button) findViewById(R.id._bmwf800gsbtn);
        buttonsBMW[14] = (Button) findViewById(R.id._bmwr1200gsbtn);
        buttonsBMW[15] = (Button) findViewById(R.id._bmwrninetscramblerbtn);
        buttonsBMW[16] = (Button) findViewById(R.id._bmwrnineturbangsbtn);

        return;
    }

    public void addBMWListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsBMW[i].setOnClickListener(bh);
            buttonsBMW[i].setOnLongClickListener(bh);
        }
    }

    public void bmwPlay(int sound){
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

    public void bmwPopup(int i) {
        pm = new PopupMenu(BMW.this, buttonsBMW[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.bmw_f_800_r; break;
            case 1: ButtonsHandler.idRaw = R.raw.bmw_g_310_r; break;
            case 2: ButtonsHandler.idRaw = R.raw.bmw_r_1200_r; break;
            case 3: ButtonsHandler.idRaw = R.raw.bmw_r_nine_t; break;
            case 4: ButtonsHandler.idRaw = R.raw.bmw_s_1000_r; break;
            case 5: ButtonsHandler.idRaw = R.raw.bmw_s_1000_rr; break;
            case 6: ButtonsHandler.idRaw = R.raw.bmw_f_800_gt; break;
            case 7: ButtonsHandler.idRaw = R.raw.bmw_k_1600_gt; break;
            case 8: ButtonsHandler.idRaw = R.raw.bmw_r_1200_rs; break;
            case 9: ButtonsHandler.idRaw = R.raw.bmw_r_1200_rt; break;
            case 10: ButtonsHandler.idRaw = R.raw.bmw_r_nine_t_racer; break;
            case 11: ButtonsHandler.idRaw = R.raw.bmw_s_1000_xr; break;
            case 12: ButtonsHandler.idRaw = R.raw.bmw_f_700_gs; break;
            case 13: ButtonsHandler.idRaw = R.raw.bmw_f_800_gs; break;
            case 14: ButtonsHandler.idRaw = R.raw.bmw_r_1200_gs; break;
            case 15: ButtonsHandler.idRaw = R.raw.bmw_r_nine_t_scrambler; break;
            case 16: ButtonsHandler.idRaw = R.raw.bmw_r_nine_t_urban_g_s; break;
        }
        ButtonsHandler.context = "BMW";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean bmwShare(String name, byte mode) {
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
