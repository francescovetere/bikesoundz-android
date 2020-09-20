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

public class HarleyDavidson extends AppCompatActivity {

    private static final byte dim = 12;
    private Button[] buttonsHarley;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harley_davidson);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Harley Davidson");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadHarleyButtons();
        addHarleyListeners();
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

    public void loadHarleyButtons(){
        buttonsHarley = new Button[dim];

        buttonsHarley[0] = (Button) findViewById(R.id._hdStreetbtn);
        buttonsHarley[1] = (Button) findViewById(R.id._hdStreetRodbtn);
        buttonsHarley[2] = (Button) findViewById(R.id._hdElectraGlidebtn);
        buttonsHarley[3] = (Button) findViewById(R.id._hdTriGlidebtn);
        buttonsHarley[4] = (Button) findViewById(R.id._hdRoadGlidebtn);
        buttonsHarley[5] = (Button) findViewById(R.id._hdRoadKingbtn);
        buttonsHarley[6] = (Button) findViewById(R.id._hdSportsterbtn);
        buttonsHarley[7] = (Button) findViewById(R.id._hdCVObtn);
        buttonsHarley[8] = (Button) findViewById(R.id._hdFortyEightbtn);
        buttonsHarley[9] = (Button) findViewById(R.id._hdDynabtn);
        buttonsHarley[10] = (Button) findViewById(R.id._hdSoftailbtn);
        buttonsHarley[11] = (Button) findViewById(R.id._hdVRodbtn);

        return;
    }

    public void addHarleyListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsHarley[i].setOnClickListener(bh);
            buttonsHarley[i].setOnLongClickListener(bh);
        }
    }

    public void hdPlay(int sound){
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

    public void hdPopup(int i) {
        pm = new PopupMenu(HarleyDavidson.this, buttonsHarley[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.harley_davidson_street; break;
            case 1: ButtonsHandler.idRaw = R.raw.harley_davidson_street_rod; break;
            case 2: ButtonsHandler.idRaw = R.raw.harley_davidson_electra_glide; break;
            case 3: ButtonsHandler.idRaw = R.raw.harley_davidson_tri_glide; break;
            case 4: ButtonsHandler.idRaw = R.raw.harley_davidson_road_glide; break;
            case 5: ButtonsHandler.idRaw = R.raw.harley_davidson_road_king; break;
            case 6: ButtonsHandler.idRaw = R.raw.harley_davidson_sportser; break;
            case 7: ButtonsHandler.idRaw = R.raw.harley_davidson_cvo; break;
            case 8: ButtonsHandler.idRaw = R.raw.harley_davidson_forty_eight; break;
            case 9: ButtonsHandler.idRaw = R.raw.harley_davidson_dyna; break;
            case 10: ButtonsHandler.idRaw = R.raw.harley_davidson_softail; break;
            case 11: ButtonsHandler.idRaw = R.raw.harley_davidson_v_rod; break;
        }
        ButtonsHandler.context = "HarleyDavidson";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean hdShare(String name, byte mode) {
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
