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

public class Yamaha extends AppCompatActivity {

    private static final byte dim = 28;
    private Button[] buttonsYamaha;
    private ButtonsHandler bh;
    private MediaPlayer mp;

    private PopupMenu pm;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yamaha);

        toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Yamaha");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();

        loadYamahaButtons();
        addYamahaListeners();
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

    public void loadYamahaButtons(){
        buttonsYamaha = new Button[dim];

        buttonsYamaha[0] = (Button) findViewById(R.id._yamahaMT125btn);
        buttonsYamaha[1] = (Button) findViewById(R.id._yamahaMT03btn);
        buttonsYamaha[2] = (Button) findViewById(R.id._yamahaMT09btn);
        buttonsYamaha[3] = (Button) findViewById(R.id._yamahaMT10btn);
        buttonsYamaha[4] = (Button) findViewById(R.id._yamahaXSR700btn);
        buttonsYamaha[5] = (Button) findViewById(R.id._yamahaXSR900btn);
        buttonsYamaha[6] = (Button) findViewById(R.id._yamahaXSR900Abarthbtn);
        buttonsYamaha[7] = (Button) findViewById(R.id._yamahaYZFR125btn);
        buttonsYamaha[8] = (Button) findViewById(R.id._yamahaYZFR3btn);
        buttonsYamaha[9] = (Button) findViewById(R.id._yamahaYZFR6btn);
        buttonsYamaha[10] = (Button) findViewById(R.id._yamahaYZFR1btn);
        buttonsYamaha[11] = (Button) findViewById(R.id._yamahaFJR1600btn);
        buttonsYamaha[12] = (Button) findViewById(R.id._yamahaSCR950btn);
        buttonsYamaha[13] = (Button) findViewById(R.id._yamahaTracer700btn);
        buttonsYamaha[14] = (Button) findViewById(R.id._yamahaTracer900btn);
        buttonsYamaha[15] = (Button) findViewById(R.id._yamahaSR400btn);
        buttonsYamaha[16] = (Button) findViewById(R.id._yamahaVMAXbtn);
        buttonsYamaha[17] = (Button) findViewById(R.id._yamahaYS125btn);
        buttonsYamaha[18] = (Button) findViewById(R.id._yamahaXJR1300btn);
        buttonsYamaha[19] = (Button) findViewById(R.id._yamahaXJR1300Racerbtn);
        buttonsYamaha[20] = (Button) findViewById(R.id._yamahaXV950btn);
        buttonsYamaha[21] = (Button) findViewById(R.id._yamahaXV950Racerbtn);
        buttonsYamaha[22] = (Button) findViewById(R.id._yamahaTenerebtn);
        buttonsYamaha[23] = (Button) findViewById(R.id._yamahaSuperTenerebtn);
        buttonsYamaha[24] = (Button) findViewById(R.id._yamahaDT50btn);
        buttonsYamaha[25] = (Button) findViewById(R.id._yamahaWR125Xbtn);
        buttonsYamaha[26] = (Button) findViewById(R.id._yamahaWR250Fbtn);
        buttonsYamaha[27] = (Button) findViewById(R.id._yamahaWR450Fbtn);

        return;
    }

    public void addYamahaListeners(){
        bh = new ButtonsHandler(this);

        for(int i = 0; i < dim; i++) {
            buttonsYamaha[i].setOnClickListener(bh);
            buttonsYamaha[i].setOnLongClickListener(bh);
        }
    }

    public void yamahaPlay(int sound){
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

    public void yamahaPopup(int i) {
        pm = new PopupMenu(Yamaha.this, buttonsYamaha[i]);
        pm.getMenuInflater().inflate(R.menu.menu_buttons, pm.getMenu());

        switch(i) {
            case 0: ButtonsHandler.idRaw = R.raw.yamaha_mt_125; break;
            case 1: ButtonsHandler.idRaw = R.raw.yamaha_mt_03; break;
            case 2: ButtonsHandler.idRaw = R.raw.yamaha_mt_09; break;
            case 3: ButtonsHandler.idRaw = R.raw.yamaha_mt_10; break;
            case 4: ButtonsHandler.idRaw = R.raw.yamaha_xsr_700; break;
            case 5: ButtonsHandler.idRaw = R.raw.yamaha_xsr_900; break;
            case 6: ButtonsHandler.idRaw = R.raw.yamaha_xsr_900_abarth; break;
            case 7: ButtonsHandler.idRaw = R.raw.yamaha_yzf_r125; break;
            case 8: ButtonsHandler.idRaw = R.raw.yamaha_yzf_r3; break;
            case 9: ButtonsHandler.idRaw = R.raw.yamaha_yzf_r6; break;
            case 10: ButtonsHandler.idRaw = R.raw.yamaha_yzf_r1; break;
            case 11: ButtonsHandler.idRaw = R.raw.yamaha_fjr_1600; break;
            case 12: ButtonsHandler.idRaw = R.raw.yamaha_scr950; break;
            case 13: ButtonsHandler.idRaw = R.raw.yamaha_tracer_700; break;
            case 14: ButtonsHandler.idRaw = R.raw.yamaha_tracer_900; break;
            case 15: ButtonsHandler.idRaw = R.raw.yamaha_sr_400; break;
            case 16: ButtonsHandler.idRaw = R.raw.yamaha_vmax; break;
            case 17: ButtonsHandler.idRaw = R.raw.yamaha_ys_125; break;
            case 18: ButtonsHandler.idRaw = R.raw.yamaha_xjr_1300; break;
            case 19: ButtonsHandler.idRaw = R.raw.yamaha_xjr_1300_racer; break;
            case 20: ButtonsHandler.idRaw = R.raw.yamaha_xv_950; break;
            case 21: ButtonsHandler.idRaw = R.raw.yamaha_xv_950_racer; break;
            case 22: ButtonsHandler.idRaw = R.raw.yamaha_tenere; break;
            case 23: ButtonsHandler.idRaw = R.raw.yamaha_super_tenere; break;
            case 24: ButtonsHandler.idRaw = R.raw.yamaha_dt_50; break;
            case 25: ButtonsHandler.idRaw = R.raw.yamaha_wr_125_x; break;
            case 26: ButtonsHandler.idRaw = R.raw.yamaha_wr_250_f; break;
            case 27: ButtonsHandler.idRaw = R.raw.yamaha_wr_450_f; break;
        }
        ButtonsHandler.context = "Yamaha";
        ButtonsHandler.nameRaw = getResources().getResourceEntryName(ButtonsHandler.idRaw);

        pm.setOnMenuItemClickListener(bh);

        pm.show();
    }

    public boolean yamahaShare(String name, byte mode) {
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
