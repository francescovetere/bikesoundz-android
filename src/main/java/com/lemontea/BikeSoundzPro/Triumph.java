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

public class Triumph extends AppCompatActivity {

    private static final byte dim = 17;
    private Button[] buttonsTriumph;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triumph);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Triumph");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadTriumphButtons();
        addTriumphListeners();
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

    public void loadTriumphButtons(){
        buttonsTriumph = new Button[dim];

        buttonsTriumph[0] = (Button) findViewById(R.id._triumphStreetTriple);
        buttonsTriumph[1] = (Button) findViewById(R.id._triumphSpeedTriplebtn);
        buttonsTriumph[2] = (Button) findViewById(R.id._triumphBonnevilleT100btn);
        buttonsTriumph[3] = (Button) findViewById(R.id._triumphBonnevilleT120btn);
        buttonsTriumph[4] = (Button) findViewById(R.id._triumphStreetCupbtn);
        buttonsTriumph[5] = (Button) findViewById(R.id._triumphStreetTwinbtn);
        buttonsTriumph[6] = (Button) findViewById(R.id._triumphTigerSportbtn);
        buttonsTriumph[7] = (Button) findViewById(R.id._triumphTigerExplorerbtn);
        buttonsTriumph[8] = (Button) findViewById(R.id._triumphTiger800XRbtn);
        buttonsTriumph[9] = (Button) findViewById(R.id._triumphThruxton1200btn);
        buttonsTriumph[10] = (Button) findViewById(R.id._triumphBonnevilleBobberbtn);
        buttonsTriumph[11] = (Button) findViewById(R.id._triumphSpeedmasterbtn);
        buttonsTriumph[12] = (Button) findViewById(R.id._triumphRocketIIIbtn);
        buttonsTriumph[13] = (Button) findViewById(R.id._triumphThunderbirdbtn);
        buttonsTriumph[14] = (Button) findViewById(R.id._triumphScramblerbtn);
        buttonsTriumph[15] = (Button) findViewById(R.id._triumphStreetScramblerbtn);
        buttonsTriumph[16] = (Button) findViewById(R.id._triumphTiger800XCbtn);

        return;
    }

    public void addTriumphListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsTriumph[i].setOnClickListener(bh);
            buttonsTriumph[i].setOnLongClickListener(bh);
        }
    }

    public void triumphPlay(int sound){
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

    public void triumphPopup(int i) {
        pm = new PopupMenu(Triumph.this, buttonsTriumph[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.triumph_street_triple; break;
            case 1: ButtonsHandler.idRaw = R.raw.triumph_speed_triple; break;
            case 2: ButtonsHandler.idRaw = R.raw.triumph_bonneville_t100; break;
            case 3: ButtonsHandler.idRaw = R.raw.triumph_bonneville_t120; break;
            case 4: ButtonsHandler.idRaw = R.raw.triumph_stree_cup; break;
            case 5: ButtonsHandler.idRaw = R.raw.triumph_street_twin; break;
            case 6: ButtonsHandler.idRaw = R.raw.triumph_tiger_sport; break;
            case 7: ButtonsHandler.idRaw = R.raw.triumph_tiger_explorer; break;
            case 8: ButtonsHandler.idRaw = R.raw.triumph_tiger_800_xr; break;
            case 9: ButtonsHandler.idRaw = R.raw.triumph_thruxton_1200; break;
            case 10: ButtonsHandler.idRaw = R.raw.triumph_bonneville_bobber; break;
            case 11: ButtonsHandler.idRaw = R.raw.triumph_speedmaster; break;
            case 12: ButtonsHandler.idRaw = R.raw.triumph_rocket_iii; break;
            case 13: ButtonsHandler.idRaw = R.raw.triumph_thunderbird; break;
            case 14: ButtonsHandler.idRaw = R.raw.triumph_scrambler; break;
            case 15: ButtonsHandler.idRaw = R.raw.triumph_street_scrambler; break;
            case 16: ButtonsHandler.idRaw = R.raw.triumph_tiger_800_xc; break;
        }
        ButtonsHandler.context = "Triumph";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean triumphShare(String name, byte mode) {
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
