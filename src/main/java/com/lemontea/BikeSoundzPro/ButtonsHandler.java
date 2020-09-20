package com.lemontea.BikeSoundzPro;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class ButtonsHandler implements OnClickListener, OnLongClickListener, PopupMenu.OnMenuItemClickListener {
    private AppCompatActivity aca; //principio di sostituibilità

    //3 campi utilissimi per lo sharing
    public static int idRaw;
    public static String nameRaw;
    public static String context;

    public ButtonsHandler() {}

    public ButtonsHandler(AppCompatActivity w) {
        this.aca = w;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /* --- Home buttons ---*/
            case R.id._aprilia:
                ((Home) aca).apriliaPage(); //downcasting esplicito
                break;

            case R.id._beta:
                ((Home) aca).betaPage();
                break;

            case R.id._bmw:
                ((Home) aca).bmwPage();
                break;

            case R.id._derbi:
                ((Home) aca).derbiPage();
                break;

            case R.id._ducati:
                ((Home) aca).ducatiPage();
                break;

            case R.id._fantic:
                ((Home) aca).fanticPage();
                break;

            case R.id._harley:
                ((Home) aca).harleyPage();
                break;

            case R.id._hm:
                ((Home) aca).HMPage();
                break;

            case R.id._honda:
                ((Home) aca).hondaPage();
                break;

            case R.id._husaberg:
                ((Home) aca).husabergPage();
                break;

            case R.id._husqvarna:
                ((Home) aca).husqvarnaPage();
                break;

            case R.id._kawasaki:
                ((Home) aca).kawasakiPage();
                break;

            case R.id._ktm:
                ((Home) aca).KTMPage();
                break;

            case R.id._moto_guzzi:
                ((Home) aca).motoGuzziPage();
                break;

            case R.id._mv_agusta:
                ((Home) aca).MVAgustaPage();
                break;

            case R.id._suzuki:
                ((Home) aca).suzukiPage();
                break;

            case R.id._tm:
                ((Home) aca).TMPage();
                break;

            case R.id._triumph:
                ((Home) aca).TriumphPage();
                break;

            case R.id._valenti:
                ((Home) aca).valentiPage();
                break;

            case R.id._yamaha:
                ((Home) aca).yamahaPage();
                break;

            /*--- Aprilia buttons ---*/
            case R.id._apriliaShiver900btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_shiver_900);
                break;

            case R.id._apriliaTuono125btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_tuono_125);
                break;

            case R.id._apriliaTuonoV4btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_tuono_v4);
                break;

            case R.id._apriliaRS450btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_rs4_50);
                break;

            case R.id._apriliaRS4125btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_rs4_125);
                break;

            case R.id._apriliaRSV4btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_rsv4);
                break;

            case R.id._apriliaDorsoduro900btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_dorsoduro_900);
                break;

            case R.id._apriliaCaponord1200btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_caponord_1200);
                break;

            case R.id._apriliaRx50btn:
                ((Aprilia) aca).apriliaPlay(R.raw.aprilia_rx_50);
                break;

            /*--- Beta buttons ---*/
            case R.id._betaAlp200btn:
                ((Beta) aca).betaPlay(R.raw.beta_alp_200);
                break;

            case R.id._betaAlp4_0btn:
                ((Beta) aca).betaPlay(R.raw.beta_alp_4_0);
                break;

            case R.id._betaRRMotard125LCbtn:
                ((Beta) aca).betaPlay(R.raw.beta_rr_125_lc);
                break;

            case R.id._betaRREnduro50btn:
                ((Beta) aca).betaPlay(R.raw.beta_rr_50);
                break;

            case R.id._betaREEnduro125btn:
                ((Beta) aca).betaPlay(R.raw.beta_re_125);
                break;

            case R.id._betaRREnduro250btn:
                ((Beta) aca).betaPlay(R.raw.beta_rr_300);
                break;

            case R.id._betaRREnduro350btn:
                ((Beta) aca).betaPlay(R.raw.beta_rr_430);
                break;

            case R.id._betaXTrainerbtn:
                ((Beta) aca).betaPlay(R.raw.beta_xtrainer);
                break;

            case R.id._betaEvo125btn:
                ((Beta) aca).betaPlay(R.raw.beta_evo_125);
                break;

            case R.id._betaEvo300btn:
                ((Beta) aca).betaPlay(R.raw.beta_evo_300);
                break;

        /*--- BMW Buttons ---*/
            case R.id._bmwf800rbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_f_800_r);
                break;

            case R.id._bmwg310rbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_g_310_r);
                break;

            case R.id._bmwr1200rbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_1200_r);
                break;

            case R.id._bmwrninetbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_nine_t);
                break;

            case R.id._bmws1000rbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_s_1000_r);
                break;

            case R.id._bmws1000rrbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_s_1000_rr);
                break;

            case R.id._bmwf800gtbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_f_800_gt);
                break;

            case R.id._bmwk1600gtbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_k_1600_gt);
                break;

            case R.id._bmwr1200rsbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_1200_rs);
                break;

            case R.id._bmwr1200rtbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_1200_rt);
                break;

            case R.id._bmwrninetracerbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_nine_t_racer);
                break;

            case R.id._bmws1000xrbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_s_1000_xr);
                break;

            case R.id._bmwf700gsbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_f_700_gs);
                break;

            case R.id._bmwf800gsbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_f_800_gs);
                break;

            case R.id._bmwr1200gsbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_1200_gs);
                break;

            case R.id._bmwrninetscramblerbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_nine_t_scrambler);
                break;

            case R.id._bmwrnineturbangsbtn:
                ((BMW) aca).bmwPlay(R.raw.bmw_r_nine_t_urban_g_s);
                break;

            /*--- Derbi Buttons ---*/
            case R.id._derbiGpr50btn:
                ((Derbi) aca).derbiPlay(R.raw.derbi_gpr_50);
                break;

            case R.id._derbiGpr125btn:
                ((Derbi) aca).derbiPlay(R.raw.derbi_gpr_125);
                break;

            case R.id._derbiSenda50btn:
                ((Derbi) aca).derbiPlay(R.raw.derbi_senda_50);
                break;

            case R.id._derbiSenda125btn:
                ((Derbi) aca).derbiPlay(R.raw.derbi_senda_125);
                break;

            /*--- Ducati Buttons ---*/
            case R.id._ducatiMonster797btn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_monster_797);
                break;

            case R.id._ducatiMonster821btn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_monster_821);
                break;

            case R.id._ducatiMonster1200btn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_monster_1200);
                break;

            case R.id._ducati959Panigalebtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_959_panigale);
                break;

            case R.id._ducati1299Panigalebtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_1299_panigale);
                break;

            case R.id._ducatiSupersportbtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_supersport);
                break;

            case R.id._ducatiDiavelbtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_diavel);
                break;

            case R.id._ducatiMultistrada950btn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_multistrada_950);
                break;

            case R.id._ducatiMultistrada1200btn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_multistrada_1200);
                break;

            case R.id._ducatiScramblerbtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_scrambler);
                break;

            case R.id._ducatiScramblerCRbtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_scrambler_cafe_racer);
                break;

            case R.id._ducatiScramblerDSbtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_scrambler_desert_sled);
                break;

            case R.id._ducatiXDiavelbtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_xdiavel);
                break;

            case R.id._ducatiHypermotardbtn:
                ((Ducati) aca).ducatiPlay(R.raw.ducati_hypermotard);
                break;

            /*--- Fantic Buttons ---*/
            case R.id._fanticCaballero50btn:
                ((Fantic) aca).fanticPlay(R.raw.fantic_caballero_50);
                break;

            case R.id._fanticCaballero1252Tbtn:
                ((Fantic) aca).fanticPlay(R.raw.fantic_caballero_125_2t);
                break;

            case R.id._fanticCaballero1254Tbtn:
                ((Fantic) aca).fanticPlay(R.raw.fantic_caballero_125_4t);
                break;

            case R.id._fanticCaballero250btn:
                ((Fantic) aca).fanticPlay(R.raw.fantic_caballero_250);
                break;

            /*--- Harley Buttons ---*/
            case R.id._hdStreetbtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_street);
                break;

            case R.id._hdStreetRodbtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_street_rod);
                break;

            case R.id._hdElectraGlidebtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_electra_glide);
                break;

            case R.id._hdTriGlidebtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_tri_glide);
                break;

            case R.id._hdRoadGlidebtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_road_glide);
                break;

            case R.id._hdRoadKingbtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_road_king);
                break;

            case R.id._hdSportsterbtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_sportser);
                break;

            case R.id._hdCVObtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_cvo);
                break;

            case R.id._hdFortyEightbtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_forty_eight);
                break;

            case R.id._hdDynabtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_dyna);
                break;

            case R.id._hdSoftailbtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_softail);
                break;

            case R.id._hdVRodbtn:
                ((HarleyDavidson) aca).hdPlay(R.raw.harley_davidson_v_rod);
                break;

            /*--- HM Buttons ---*/
            case R.id._hmCRE50btn:
                ((HM) aca).hmPlay(R.raw.hm_cre_crm_50);
                break;

            case R.id._hmCRE1252Tbtn:
                ((HM) aca).hmPlay(R.raw.hm_cre_crm_125_2t);
                break;

            case R.id._hmCRE1254tbtn:
                ((HM) aca).hmPlay(R.raw.hm_cre_crm_125_4t);
                break;

            case R.id._hmCity125btn:
                ((HM) aca).hmPlay(R.raw.hm_city_200);
                break;

            case R.id._hmLocusta125btn:
                ((HM) aca).hmPlay(R.raw.hm_locusta_200);
                break;

            /*--- Honda Buttons ---*/
            case R.id._hondaCB125Fbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cb_125_f);
                break;

            case R.id._hondaCB500Fbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cb_500_f);
                break;

            case R.id._hondaCB650Fbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cb_650_f);
                break;

            case R.id._hondaCB1000Rbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cb_1000_r);
                break;

            case R.id._hondaCBR125Rbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cbr_125_r);
                break;

            case R.id._hondaCBR300Rbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cbr_300_r);
                break;

            case R.id._hondaCBR500Rbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cbr_500_r);
                break;

            case R.id._hondaCBR1000RRbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cbr_1000_rr_fireblade);
                break;

            case R.id._hondaCB500Xbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cb_500_x);
                break;

            case R.id._hondaCBR650Fbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cbr_650_f);
                break;

            case R.id._hondaCB1100btn:
                ((Honda) aca).hondaPlay(R.raw.honda_cb_1100);
                break;

            case R.id._hondaCrossrunnerbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_crossrunner);
                break;

            case R.id._hondaGoldWingbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_gold_wing);
                break;

            case R.id._hondaMSXbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_msx);
                break;

            case R.id._hondaNC750Sbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_nc_750_s);
                break;

            case R.id._hondaNC750Xbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_nc_750_x);
                break;

            case R.id._hondaVFR800Fbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_vfr_800);
                break;

            case R.id._hondaAfricaTwinbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_africa_twin);
                break;

            case R.id._hondaCrossTourerbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_crosstourer);
                break;

            case R.id._hondaCMX500Rebelbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_cmx_500_rebel);
                break;

            case R.id._hondaCRF250Scramblerbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_crf_250);
                break;

            case R.id._hondaCRF250btn:
                ((Honda) aca).hondaPlay(R.raw.honda_crf_enduro_250);
                break;

            case R.id._hondaCRF300btn:
                ((Honda) aca).hondaPlay(R.raw.honda_crf_enduro_300);
                break;

            case R.id._hondaCRF450btn:
                ((Honda) aca).hondaPlay(R.raw.honda_crf_enduro_450);
                break;

            case R.id._hondaCRF500btn:
                ((Honda) aca).hondaPlay(R.raw.honda_crf_enduro_500);
                break;

            case R.id._hondaCRF450SMbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_crf_supermoto_450);
                break;

            case R.id._hondaCRF500SMbtn:
                ((Honda) aca).hondaPlay(R.raw.honda_crf_supermoto_500);
                break;

            /*--- Husaberg Buttons ---*/
            case R.id._husaTE125btn:
                ((Husaberg) aca).husaPlay(R.raw.husaberg_te_125);
                break;

            case R.id._husaTE250btn:
                ((Husaberg) aca).husaPlay(R.raw.husaberg_te_250);
                break;

            case R.id._husaTE300btn:
                ((Husaberg) aca).husaPlay(R.raw.husaberg_te_300);
                break;

            case R.id._husaFE250btn:
                ((Husaberg) aca).husaPlay(R.raw.husaberg_fe_250);
                break;

            case R.id._husaFE350btn:
                ((Husaberg) aca).husaPlay(R.raw.husaberg_fe_350);
                break;

            case R.id._husaFE450btn:
                ((Husaberg) aca).husaPlay(R.raw.husaberg_fe_450);
                break;

            /*--- Husqvarna Buttons ---*/
            case R.id._hsqTE125btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_te_125);
                break;

            case R.id._hsqTE250btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_te_250);
                break;

            case R.id._hsqTE300btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_te_300);
                break;

            case R.id._hsqFE250btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_fe_250);
                break;

            case R.id._hsqFE350btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_fe_350);
                break;

            case R.id._hsqFE450btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_fe_450);
                break;

            case R.id._hsqFE501btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_fe_501);
                break;

            case R.id._hsq701btn:
                ((Husqvarna) aca).hsqPlay(R.raw.husqvarna_701);
                break;

            /*--- Kawasaki Buttons ---*/
            case R.id._kawaz250btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_z_250);
                break;

            case R.id._kawaz300btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_z_300);
                break;

            case R.id._kawaz650btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_z_650);
                break;

            case R.id._kawaz800btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_z_800);
                break;

            case R.id._kawaz900btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_z_900);
                break;

            case R.id._kawaz1000btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_z_1000);
                break;

            case R.id._kawaNinja650btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_ninja_650);
                break;

            case R.id._kawaNinjaZX_10rbtn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_ninja_zx_10r);
                break;

            case R.id._kawaNinjaH2btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_ninja_h2);
                break;

            case R.id._kawaZZR1400btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_zzr_1400);
                break;

            case R.id._kawaGTR1400btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_gtr_1400);
                break;

            case R.id._kawaVersys_Xbtn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_versys_x);
                break;

            case R.id._kawaVersys650btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_versys_650);
                break;

            case R.id._kawaVersys1000btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_versys_1000);
                break;

            case R.id._kawaW800btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_w_800);
                break;

            case R.id._kawaZ1000SXbtn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_z_1000_sx);
                break;

            case R.id._kawaVulcanSbtn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_vulcan_s);
                break;

            case R.id._kawaVulcan900btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_vulcan_900);
                break;

            case R.id._kawaKLX125btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_klx_125);
                break;

            case R.id._kawaKLX250btn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_klx_250);
                break;

            case R.id._kawaKLX450rbtn:
                ((Kawasaki) aca).kawaPlay(R.raw.kawasaki_klx_450_r);
                break;

            /*--- KTM Buttons ---*/
            case R.id._ktmDuke125btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_duke_125);
                break;

            case R.id._ktmDuke390btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_duke_390);
                break;

            case R.id._ktmDuke690btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_duke_690);
                break;

            case R.id._ktmSuperDukeGT1290btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_super_duke_gt_1290);
                break;

            case R.id._ktmSuperDukeR1290btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_super_duke_r_1290);
                break;

            case R.id._ktmRC125btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_rc_125);
                break;

            case R.id._ktmRC390btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_rc_390);
                break;

            case R.id._ktmEnduro690btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_enduro_690);
                break;

            case R.id._ktmExc125btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_125);
                break;

            case R.id._ktmExc200btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_200);
                break;

            case R.id._ktmExc250_ebtn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_e_250);
                break;

            case R.id._ktmExc300_ebtn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_e_300);
                break;

            case R.id._ktmExc_f250btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_f_250);
                break;

            case R.id._ktmExc350btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_350);
                break;

            case R.id._ktmExc450btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_450);
                break;

            case R.id._ktmExc500btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_exc_500);
                break;

            case R.id._ktmFreeride250Rbtn:
                ((KTM) aca).ktmPlay(R.raw.ktm_freeride_250_r);
                break;

            case R.id._ktmFreeride350btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_freeride_350);
                break;

            case R.id._ktmSMC_R690btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_smc_r_690);
                break;

            case R.id._ktmAdventure1050btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_adventure_1050);
                break;

            case R.id._ktmAdventure1090btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_adventure_1090);
                break;

            case R.id._ktmAdventure1190btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_adventure_1190);
                break;

            case R.id._ktmSuperAdventure1290btn:
                ((KTM) aca).ktmPlay(R.raw.ktm_super_adventure_1290);
                break;

            /*--- Moto Guzzi Buttons ---*/
            case R.id._mgAudacebtn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_audace);
                break;

            case R.id._mgCaliforniabtn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_california);
                break;

            case R.id._mgEldoradobtn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_eldorado);
                break;

            case R.id._mgV7IIbtn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_v7_ii);
                break;

            case R.id._mgV7IIRacerbtn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_v7_ii_racer);
                break;

            case R.id._mgV7IIIbtn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_v7_iii);
                break;

            case R.id._mgV7IIIRacerbtn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_v7_iii_racer);
                break;

            case R.id._mgV9btn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_v9);
                break;

            case R.id._mgMGX21btn:
                ((MotoGuzzi) aca).mgPlay(R.raw.moto_guzzi_mgx_21);
                break;

            /*--- MV Agusta Buttons ---*/
            case R.id._mvBrutale675btn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_brutale_675);
                break;

            case R.id._mvBrutale800btn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_brutale_800);
                break;

            case R.id._mvBrutale1090btn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_brutale_1090);
                break;

            case R.id._mvBrutaleDragsterbtn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_brutale_dragster);
                break;

            case R.id._mvRivalebtn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_rivale);
                break;

            case R.id._mvStradalebtn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_stradale);
                break;

            case R.id._mvTurismoVelocebtn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_turismo_veloce);
                break;

            case R.id._mvF3_675btn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_f3_675);
                break;

            case R.id._mvF3_800btn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_f3_800);
                break;

            case R.id._mvF4btn:
                ((MVAgusta) aca).mvPlay(R.raw.mv_agusta_f4);
                break;

            /*--- Suzuki Buttons ---*/
            case R.id._suzukiGSR750btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsr_750);
                break;

            case R.id._suzukiGSXS750btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsx_s_750);
                break;

            case R.id._suzukiGSXS1000btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsx_s_1000);
                break;

            case R.id._suzukiSV500btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_sv_650);
                break;

            case R.id._suzukiGSX250Rbtn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsx_250_r);
                break;

            case R.id._suzukiGSX1300Rbtn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsx_1300r_hayabusa);
                break;

            case R.id._suzukiGSXR750btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsx_r_750);
                break;

            case R.id._suzukiGSXR1000btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsx_r_1000);
                break;

            case R.id._suzukiBandit1250Sbtn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_bandit_1250_s);
                break;

            case R.id._suzukiGSXS1000Fbtn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_gsx_s_1000_f);
                break;

            case R.id._suzukiVStorm650btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_v_strom_650);
                break;

            case R.id._suzukiVStorm650XTbtn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_v_strom_650_xt);
                break;

            case R.id._suzukiVStorm1000btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_v_strom_1000);
                break;

            case R.id._suzukiIntruderC800btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_intruder_c_800);
                break;

            case R.id._suzukiIntruderMbtn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_intruder_m);
                break;

            case R.id._suzukiVanVan125btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_van_van_125);
                break;

            case R.id._suzukiVanVan200btn:
                ((Suzuki) aca).suzukiPlay(R.raw.suzuki_van_van_200);
                break;
            /*--- TM Buttons ---*/
            case R.id._tm125btn:
                ((TM) aca).tmPlay(R.raw.tm_en_125);
                break;

            case R.id._tm2502Tbtn:
                ((TM) aca).tmPlay(R.raw.tm_en_250_2t);
                break;

            case R.id._tm300btn:
                ((TM) aca).tmPlay(R.raw.tm_en_300);
                break;

            case R.id._tm2504Tbtn:
                ((TM) aca).tmPlay(R.raw.tm_en_250_4t);
                break;

            case R.id._tm450btn:
                ((TM) aca).tmPlay(R.raw.tm_en_450);
                break;

            case R.id._tm530btn:
                ((TM) aca).tmPlay(R.raw.tm_en_530);
                break;
            /*--- Triumph Buttons ---*/

            case R.id._triumphStreetTriple:
                ((Triumph) aca).triumphPlay(R.raw.triumph_street_triple);
                break;

            case R.id._triumphSpeedTriplebtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_speed_triple);
                break;

            case R.id._triumphBonnevilleT100btn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_bonneville_t100);
                break;

            case R.id._triumphBonnevilleT120btn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_bonneville_t120);
                break;

            case R.id._triumphStreetCupbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_stree_cup);
                break;

            case R.id._triumphStreetTwinbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_street_twin);
                break;

            case R.id._triumphTigerSportbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_tiger_sport);
                break;

            case R.id._triumphTigerExplorerbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_tiger_explorer);
                break;

            case R.id._triumphTiger800XRbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_tiger_800_xr);
                break;

            case R.id._triumphThruxton1200btn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_thruxton_1200);
                break;

            case R.id._triumphBonnevilleBobberbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_bonneville_bobber);
                break;

            case R.id._triumphSpeedmasterbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_speedmaster);
                break;

            case R.id._triumphRocketIIIbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_rocket_iii);
                break;

            case R.id._triumphThunderbirdbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_thunderbird);
                break;

            case R.id._triumphScramblerbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_scrambler);
                break;

            case R.id._triumphStreetScramblerbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_street_scrambler);
                break;

            case R.id._triumphTiger800XCbtn:
                ((Triumph) aca).triumphPlay(R.raw.triumph_tiger_800_xc);
                break;

            /*--- Valenti Buttons ---*/
            case R.id._valentiRME50btn:
                ((Valenti) aca).valentiPlay(R.raw.valenti_rme_50);
                break;

            case R.id._valentiRMZ250Ebtn:
                ((Valenti) aca).valentiPlay(R.raw.valenti_rmz_250);
                break;

            case R.id._valentiRMZ450Ebtn:
                ((Valenti) aca).valentiPlay(R.raw.valenti_rmz_450);
                break;

            /*--- Yamaha Buttons ---*/
            case R.id._yamahaMT125btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_mt_125);
                break;

            case R.id._yamahaMT03btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_mt_03);
                break;

            case R.id._yamahaMT09btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_mt_09);
                break;

            case R.id._yamahaMT10btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_mt_10);
                break;

            case R.id._yamahaXSR700btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_xsr_700);
                break;

            case R.id._yamahaXSR900btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_xsr_900);
                break;

            case R.id._yamahaXSR900Abarthbtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_xsr_900_abarth);
                break;

            case R.id._yamahaYZFR125btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_yzf_r125);
                break;

            case R.id._yamahaYZFR3btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_yzf_r3);
                break;

            case R.id._yamahaYZFR6btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_yzf_r6);
                break;

            case R.id._yamahaYZFR1btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_yzf_r1);
                break;

            case R.id._yamahaFJR1600btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_fjr_1600);
                break;

            case R.id._yamahaSCR950btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_scr950);
                break;

            case R.id._yamahaTracer700btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_tracer_700);
                break;

            case R.id._yamahaTracer900btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_tracer_900);
                break;

            case R.id._yamahaSR400btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_sr_400);
                break;

            case R.id._yamahaVMAXbtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_vmax);
                break;

            case R.id._yamahaYS125btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_ys_125);
                break;

            case R.id._yamahaXJR1300btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_xjr_1300);
                break;

            case R.id._yamahaXJR1300Racerbtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_xjr_1300_racer);
                break;

            case R.id._yamahaXV950btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_xv_950);
                break;

            case R.id._yamahaXV950Racerbtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_xv_950_racer);
                break;

            case R.id._yamahaTenerebtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_tenere);
                break;

            case R.id._yamahaSuperTenerebtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_super_tenere);
                break;

            case R.id._yamahaDT50btn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_dt_50);
                break;

            case R.id._yamahaWR125Xbtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_wr_125_x);
                break;

            case R.id._yamahaWR250Fbtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_wr_250_f);
                break;

            case R.id._yamahaWR450Fbtn:
                ((Yamaha) aca).yamahaPlay(R.raw.yamaha_wr_450_f);
                break;
        }
    }




    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            /*---Aprilia buttons---*/
            case R.id._apriliaShiver900btn:
                ((Aprilia) aca).apriliaPopup(0);
                return true;
            case R.id._apriliaTuono125btn:
                ((Aprilia) aca).apriliaPopup(1);
                return true;
            case R.id._apriliaTuonoV4btn:
                ((Aprilia) aca).apriliaPopup(2);
                return true;
            case R.id._apriliaRS450btn:
                ((Aprilia) aca).apriliaPopup(3);
                return true;
            case R.id._apriliaRS4125btn:
                ((Aprilia) aca).apriliaPopup(4);
                return true;
            case R.id._apriliaRSV4btn:
                ((Aprilia) aca).apriliaPopup(5);
                return true;
            case R.id._apriliaDorsoduro900btn:
                ((Aprilia) aca).apriliaPopup(6);
                return true;
            case R.id._apriliaCaponord1200btn:
                ((Aprilia) aca).apriliaPopup(7);
                return true;
            case R.id._apriliaRx50btn:
                ((Aprilia) aca).apriliaPopup(8);
                return true;

            /*--- Beta buttons ---*/
            case R.id._betaAlp200btn:
                ((Beta) aca).betaPopup(0);
                break;

            case R.id._betaAlp4_0btn:
                ((Beta) aca).betaPopup(1);
                break;

            case R.id._betaRRMotard125LCbtn:
                ((Beta) aca).betaPopup(2);
                break;

            case R.id._betaRREnduro50btn:
                ((Beta) aca).betaPopup(3);
                break;

            case R.id._betaREEnduro125btn:
                ((Beta) aca).betaPopup(4);
                break;

            case R.id._betaRREnduro250btn:
                ((Beta) aca).betaPopup(5);
                break;

            case R.id._betaRREnduro350btn:
                ((Beta) aca).betaPopup(6);
                break;

            case R.id._betaXTrainerbtn:
                ((Beta) aca).betaPopup(7);
                break;

            case R.id._betaEvo125btn:
                ((Beta) aca).betaPopup(8);
                break;

            case R.id._betaEvo300btn:
                ((Beta) aca).betaPopup(9);
                break;

        /*--- BMW Buttons ---*/
            case R.id._bmwf800rbtn:
                ((BMW) aca).bmwPopup(0);
                break;

            case R.id._bmwg310rbtn:
                ((BMW) aca).bmwPopup(1);
                break;

            case R.id._bmwr1200rbtn:
                ((BMW) aca).bmwPopup(2);
                break;

            case R.id._bmwrninetbtn:
                ((BMW) aca).bmwPopup(3);
                break;

            case R.id._bmws1000rbtn:
                ((BMW) aca).bmwPopup(4);
                break;

            case R.id._bmws1000rrbtn:
                ((BMW) aca).bmwPopup(5);
                break;

            case R.id._bmwf800gtbtn:
                ((BMW) aca).bmwPopup(6);
                break;

            case R.id._bmwk1600gtbtn:
                ((BMW) aca).bmwPopup(7);
                break;

            case R.id._bmwr1200rsbtn:
                ((BMW) aca).bmwPopup(8);
                break;

            case R.id._bmwr1200rtbtn:
                ((BMW) aca).bmwPopup(9);
                break;

            case R.id._bmwrninetracerbtn:
                ((BMW) aca).bmwPopup(10);
                break;

            case R.id._bmws1000xrbtn:
                ((BMW) aca).bmwPopup(11);
                break;

            case R.id._bmwf700gsbtn:
                ((BMW) aca).bmwPopup(12);
                break;

            case R.id._bmwf800gsbtn:
                ((BMW) aca).bmwPopup(13);
                break;

            case R.id._bmwr1200gsbtn:
                ((BMW) aca).bmwPopup(14);
                break;

            case R.id._bmwrninetscramblerbtn:
                ((BMW) aca).bmwPopup(15);
                break;

            case R.id._bmwrnineturbangsbtn:
                ((BMW) aca).bmwPopup(16);
                break;

            /*--- Derbi Buttons ---*/
            case R.id._derbiGpr50btn:
                ((Derbi) aca).derbiPopup(0);
                break;

            case R.id._derbiGpr125btn:
                ((Derbi) aca).derbiPopup(1);
                break;

            case R.id._derbiSenda50btn:
                ((Derbi) aca).derbiPopup(2);
                break;

            case R.id._derbiSenda125btn:
                ((Derbi) aca).derbiPopup(3);
                break;

            /*--- Ducati Buttons ---*/
            case R.id._ducatiMonster797btn:
                ((Ducati) aca).ducatiPopup(0);
                break;

            case R.id._ducatiMonster821btn:
                ((Ducati) aca).ducatiPopup(1);
                break;

            case R.id._ducatiMonster1200btn:
                ((Ducati) aca).ducatiPopup(2);
                break;

            case R.id._ducati959Panigalebtn:
                ((Ducati) aca).ducatiPopup(3);
                break;

            case R.id._ducati1299Panigalebtn:
                ((Ducati) aca).ducatiPopup(4);
                break;

            case R.id._ducatiSupersportbtn:
                ((Ducati) aca).ducatiPopup(5);
                break;

            case R.id._ducatiDiavelbtn:
                ((Ducati) aca).ducatiPopup(6);
                break;

            case R.id._ducatiMultistrada950btn:
                ((Ducati) aca).ducatiPopup(7);
                break;

            case R.id._ducatiMultistrada1200btn:
                ((Ducati) aca).ducatiPopup(8);
                break;

            case R.id._ducatiScramblerbtn:
                ((Ducati) aca).ducatiPopup(9);
                break;

            case R.id._ducatiScramblerCRbtn:
                ((Ducati) aca).ducatiPopup(10);
                break;

            case R.id._ducatiScramblerDSbtn:
                ((Ducati) aca).ducatiPopup(11);
                break;

            case R.id._ducatiXDiavelbtn:
                ((Ducati) aca).ducatiPopup(12);
                break;

            case R.id._ducatiHypermotardbtn:
                ((Ducati) aca).ducatiPopup(13);
                break;

            /*--- Fantic Buttons ---*/
            case R.id._fanticCaballero50btn:
                ((Fantic) aca).fanticPopup(0);
                break;

            case R.id._fanticCaballero1252Tbtn:
                ((Fantic) aca).fanticPopup(1);
                break;

            case R.id._fanticCaballero1254Tbtn:
                ((Fantic) aca).fanticPopup(2);
                break;

            case R.id._fanticCaballero250btn:
                ((Fantic) aca).fanticPopup(3);
                break;

            /*--- Harley Buttons ---*/
            case R.id._hdStreetbtn:
                ((HarleyDavidson) aca).hdPopup(0);
                break;

            case R.id._hdStreetRodbtn:
                ((HarleyDavidson) aca).hdPopup(1);
                break;

            case R.id._hdElectraGlidebtn:
                ((HarleyDavidson) aca).hdPopup(2);
                break;

            case R.id._hdTriGlidebtn:
                ((HarleyDavidson) aca).hdPopup(3);
                break;

            case R.id._hdRoadGlidebtn:
                ((HarleyDavidson) aca).hdPopup(4);
                break;

            case R.id._hdRoadKingbtn:
                ((HarleyDavidson) aca).hdPopup(5);
                break;

            case R.id._hdSportsterbtn:
                ((HarleyDavidson) aca).hdPopup(6);
                break;

            case R.id._hdCVObtn:
                ((HarleyDavidson) aca).hdPopup(7);
                break;

            case R.id._hdFortyEightbtn:
                ((HarleyDavidson) aca).hdPopup(8);
                break;

            case R.id._hdDynabtn:
                ((HarleyDavidson) aca).hdPopup(9);
                break;

            case R.id._hdSoftailbtn:
                ((HarleyDavidson) aca).hdPopup(10);
                break;

            case R.id._hdVRodbtn:
                ((HarleyDavidson) aca).hdPopup(11);
                break;

            /*--- HM Buttons ---*/
            case R.id._hmCRE50btn:
                ((HM) aca).hmPopup(0);
                break;

            case R.id._hmCRE1252Tbtn:
                ((HM) aca).hmPopup(1);
                break;

            case R.id._hmCRE1254tbtn:
                ((HM) aca).hmPopup(2);
                break;

            case R.id._hmCity125btn:
                ((HM) aca).hmPopup(3);
                break;

            case R.id._hmLocusta125btn:
                ((HM) aca).hmPopup(4);
                break;

            /*--- Honda Buttons ---*/
            case R.id._hondaCB125Fbtn:
                ((Honda) aca).hondaPopup(0);
                break;

            case R.id._hondaCB500Fbtn:
                ((Honda) aca).hondaPopup(1);
                break;

            case R.id._hondaCB650Fbtn:
                ((Honda) aca).hondaPopup(2);
                break;

            case R.id._hondaCB1000Rbtn:
                ((Honda) aca).hondaPopup(3);
                break;

            case R.id._hondaCBR125Rbtn:
                ((Honda) aca).hondaPopup(4);
                break;

            case R.id._hondaCBR300Rbtn:
                ((Honda) aca).hondaPopup(5);
                break;

            case R.id._hondaCBR500Rbtn:
                ((Honda) aca).hondaPopup(6);
                break;

            case R.id._hondaCBR1000RRbtn:
                ((Honda) aca).hondaPopup(7);
                break;

            case R.id._hondaCB500Xbtn:
                ((Honda) aca).hondaPopup(8);
                break;

            case R.id._hondaCBR650Fbtn:
                ((Honda) aca).hondaPopup(9);
                break;

            case R.id._hondaCB1100btn:
                ((Honda) aca).hondaPopup(10);
                break;

            case R.id._hondaCrossrunnerbtn:
                ((Honda) aca).hondaPopup(11);
                break;

            case R.id._hondaGoldWingbtn:
                ((Honda) aca).hondaPopup(12);
                break;

            case R.id._hondaMSXbtn:
                ((Honda) aca).hondaPopup(13);
                break;

            case R.id._hondaNC750Sbtn:
                ((Honda) aca).hondaPopup(14);
                break;

            case R.id._hondaNC750Xbtn:
                ((Honda) aca).hondaPopup(15);
                break;

            case R.id._hondaVFR800Fbtn:
                ((Honda) aca).hondaPopup(16);
                break;

            case R.id._hondaAfricaTwinbtn:
                ((Honda) aca).hondaPopup(17);
                break;

            case R.id._hondaCrossTourerbtn:
                ((Honda) aca).hondaPopup(18);
                break;

            case R.id._hondaCMX500Rebelbtn:
                ((Honda) aca).hondaPopup(19);
                break;

            case R.id._hondaCRF250Scramblerbtn:
                ((Honda) aca).hondaPopup(20);
                break;

            case R.id._hondaCRF250btn:
                ((Honda) aca).hondaPopup(21);
                break;

            case R.id._hondaCRF300btn:
                ((Honda) aca).hondaPopup(22);
                break;

            case R.id._hondaCRF450btn:
                ((Honda) aca).hondaPopup(23);
                break;

            case R.id._hondaCRF500btn:
                ((Honda) aca).hondaPopup(24);
                break;

            case R.id._hondaCRF450SMbtn:
                ((Honda) aca).hondaPopup(25);
                break;

            case R.id._hondaCRF500SMbtn:
                ((Honda) aca).hondaPopup(26);
                break;

            /*--- Husaberg Buttons ---*/
            case R.id._husaTE125btn:
                ((Husaberg) aca).husaPopup(0);
                break;

            case R.id._husaTE250btn:
                ((Husaberg) aca).husaPopup(1);
                break;

            case R.id._husaTE300btn:
                ((Husaberg) aca).husaPopup(2);
                break;

            case R.id._husaFE250btn:
                ((Husaberg) aca).husaPopup(3);
                break;

            case R.id._husaFE350btn:
                ((Husaberg) aca).husaPopup(4);
                break;

            case R.id._husaFE450btn:
                ((Husaberg) aca).husaPopup(5);
                break;

            /*--- Husqvarna Buttons ---*/
            case R.id._hsqTE125btn:
                ((Husqvarna) aca).hsqPopup(0);
                break;

            case R.id._hsqTE250btn:
                ((Husqvarna) aca).hsqPopup(1);
                break;

            case R.id._hsqTE300btn:
                ((Husqvarna) aca).hsqPopup(2);
                break;

            case R.id._hsqFE250btn:
                ((Husqvarna) aca).hsqPopup(3);
                break;

            case R.id._hsqFE350btn:
                ((Husqvarna) aca).hsqPopup(4);
                break;

            case R.id._hsqFE450btn:
                ((Husqvarna) aca).hsqPopup(5);
                break;

            case R.id._hsqFE501btn:
                ((Husqvarna) aca).hsqPopup(6);
                break;

            case R.id._hsq701btn:
                ((Husqvarna) aca).hsqPopup(7);
                break;

            /*--- Kawasaki Buttons ---*/
            case R.id._kawaz250btn:
                ((Kawasaki) aca).kawaPopup(0);
                break;

            case R.id._kawaz300btn:
                ((Kawasaki) aca).kawaPopup(1);
                break;

            case R.id._kawaz650btn:
                ((Kawasaki) aca).kawaPopup(2);
                break;

            case R.id._kawaz800btn:
                ((Kawasaki) aca).kawaPopup(3);
                break;

            case R.id._kawaz900btn:
                ((Kawasaki) aca).kawaPopup(4);
                break;

            case R.id._kawaz1000btn:
                ((Kawasaki) aca).kawaPopup(5);
                break;

            case R.id._kawaNinja650btn:
                ((Kawasaki) aca).kawaPopup(6);
                break;

            case R.id._kawaNinjaZX_10rbtn:
                ((Kawasaki) aca).kawaPopup(7);
                break;

            case R.id._kawaNinjaH2btn:
                ((Kawasaki) aca).kawaPopup(8);
                break;

            case R.id._kawaZZR1400btn:
                ((Kawasaki) aca).kawaPopup(9);
                break;

            case R.id._kawaGTR1400btn:
                ((Kawasaki) aca).kawaPopup(10);
                break;

            case R.id._kawaVersys_Xbtn:
                ((Kawasaki) aca).kawaPopup(11);
                break;

            case R.id._kawaVersys650btn:
                ((Kawasaki) aca).kawaPopup(12);
                break;

            case R.id._kawaVersys1000btn:
                ((Kawasaki) aca).kawaPopup(13);
                break;

            case R.id._kawaW800btn:
                ((Kawasaki) aca).kawaPopup(14);
                break;

            case R.id._kawaZ1000SXbtn:
                ((Kawasaki) aca).kawaPopup(15);
                break;

            case R.id._kawaVulcanSbtn:
                ((Kawasaki) aca).kawaPopup(16);
                break;

            case R.id._kawaVulcan900btn:
                ((Kawasaki) aca).kawaPopup(17);
                break;

            case R.id._kawaKLX125btn:
                ((Kawasaki) aca).kawaPopup(18);
                break;

            case R.id._kawaKLX250btn:
                ((Kawasaki) aca).kawaPopup(19);
                break;

            case R.id._kawaKLX450rbtn:
                ((Kawasaki) aca).kawaPopup(20);
                break;

            /*--- KTM Buttons ---*/
            case R.id._ktmDuke125btn:
                ((KTM) aca).ktmPopup(0);
                break;

            case R.id._ktmDuke390btn:
                ((KTM) aca).ktmPopup(1);
                break;

            case R.id._ktmDuke690btn:
                ((KTM) aca).ktmPopup(2);
                break;

            case R.id._ktmSuperDukeGT1290btn:
                ((KTM) aca).ktmPopup(3);
                break;

            case R.id._ktmSuperDukeR1290btn:
                ((KTM) aca).ktmPopup(4);
                break;

            case R.id._ktmRC125btn:
                ((KTM) aca).ktmPopup(5);
                break;

            case R.id._ktmRC390btn:
                ((KTM) aca).ktmPopup(6);
                break;

            case R.id._ktmEnduro690btn:
                ((KTM) aca).ktmPopup(7);
                break;

            case R.id._ktmExc125btn:
                ((KTM) aca).ktmPopup(8);
                break;

            case R.id._ktmExc200btn:
                ((KTM) aca).ktmPopup(9);
                break;

            case R.id._ktmExc250_ebtn:
                ((KTM) aca).ktmPopup(10);
                break;

            case R.id._ktmExc300_ebtn:
                ((KTM) aca).ktmPopup(11);
                break;

            case R.id._ktmExc_f250btn:
                ((KTM) aca).ktmPopup(12);
                break;

            case R.id._ktmExc350btn:
                ((KTM) aca).ktmPopup(13);
                break;

            case R.id._ktmExc450btn:
                ((KTM) aca).ktmPopup(14);
                break;

            case R.id._ktmExc500btn:
                ((KTM) aca).ktmPopup(15);
                break;

            case R.id._ktmFreeride250Rbtn:
                ((KTM) aca).ktmPopup(16);
                break;

            case R.id._ktmFreeride350btn:
                ((KTM) aca).ktmPopup(17);
                break;

            case R.id._ktmSMC_R690btn:
                ((KTM) aca).ktmPopup(18);
                break;

            case R.id._ktmAdventure1050btn:
                ((KTM) aca).ktmPopup(19);
                break;

            case R.id._ktmAdventure1090btn:
                ((KTM) aca).ktmPopup(20);
                break;

            case R.id._ktmAdventure1190btn:
                ((KTM) aca).ktmPopup(21);
                break;

            case R.id._ktmSuperAdventure1290btn:
                ((KTM) aca).ktmPopup(22);
                break;

            /*--- Moto Guzzi Buttons ---*/
            case R.id._mgAudacebtn:
                ((MotoGuzzi) aca).mgPopup(0);
                break;

            case R.id._mgCaliforniabtn:
                ((MotoGuzzi) aca).mgPopup(1);
                break;

            case R.id._mgEldoradobtn:
                ((MotoGuzzi) aca).mgPopup(2);
                break;

            case R.id._mgV7IIbtn:
                ((MotoGuzzi) aca).mgPopup(3);
                break;

            case R.id._mgV7IIRacerbtn:
                ((MotoGuzzi) aca).mgPopup(4);
                break;

            case R.id._mgV7IIIbtn:
                ((MotoGuzzi) aca).mgPopup(5);
                break;

            case R.id._mgV7IIIRacerbtn:
                ((MotoGuzzi) aca).mgPopup(6);
                break;

            case R.id._mgV9btn:
                ((MotoGuzzi) aca).mgPopup(7);
                break;

            case R.id._mgMGX21btn:
                ((MotoGuzzi) aca).mgPopup(8);
                break;

            /*--- MV Agusta Buttons ---*/
            case R.id._mvBrutale675btn:
                ((MVAgusta) aca).mvPopup(0);
                break;

            case R.id._mvBrutale800btn:
                ((MVAgusta) aca).mvPopup(1);
                break;

            case R.id._mvBrutale1090btn:
                ((MVAgusta) aca).mvPopup(2);
                break;

            case R.id._mvBrutaleDragsterbtn:
                ((MVAgusta) aca).mvPopup(3);
                break;

            case R.id._mvRivalebtn:
                ((MVAgusta) aca).mvPopup(4);
                break;

            case R.id._mvStradalebtn:
                ((MVAgusta) aca).mvPopup(5);
                break;

            case R.id._mvTurismoVelocebtn:
                ((MVAgusta) aca).mvPopup(6);
                break;

            case R.id._mvF3_675btn:
                ((MVAgusta) aca).mvPopup(7);
                break;

            case R.id._mvF3_800btn:
                ((MVAgusta) aca).mvPopup(8);
                break;

            case R.id._mvF4btn:
                ((MVAgusta) aca).mvPopup(9);
                break;

            /*--- Suzuki Buttons ---*/
            case R.id._suzukiGSR750btn:
                ((Suzuki) aca).suzukiPopup(0);
                break;

            case R.id._suzukiGSXS750btn:
                ((Suzuki) aca).suzukiPopup(1);
                break;

            case R.id._suzukiGSXS1000btn:
                ((Suzuki) aca).suzukiPopup(2);
                break;

            case R.id._suzukiSV500btn:
                ((Suzuki) aca).suzukiPopup(3);
                break;

            case R.id._suzukiGSX250Rbtn:
                ((Suzuki) aca).suzukiPopup(4);
                break;

            case R.id._suzukiGSX1300Rbtn:
                ((Suzuki) aca).suzukiPopup(5);
                break;

            case R.id._suzukiGSXR750btn:
                ((Suzuki) aca).suzukiPopup(6);
                break;

            case R.id._suzukiGSXR1000btn:
                ((Suzuki) aca).suzukiPopup(7);
                break;

            case R.id._suzukiBandit1250Sbtn:
                ((Suzuki) aca).suzukiPopup(8);
                break;

            case R.id._suzukiGSXS1000Fbtn:
                ((Suzuki) aca).suzukiPopup(9);
                break;

            case R.id._suzukiVStorm650btn:
                ((Suzuki) aca).suzukiPopup(10);
                break;

            case R.id._suzukiVStorm650XTbtn:
                ((Suzuki) aca).suzukiPopup(11);
                break;

            case R.id._suzukiVStorm1000btn:
                ((Suzuki) aca).suzukiPopup(12);
                break;

            case R.id._suzukiIntruderC800btn:
                ((Suzuki) aca).suzukiPopup(13);
                break;

            case R.id._suzukiIntruderMbtn:
                ((Suzuki) aca).suzukiPopup(13);
                break;

            case R.id._suzukiVanVan125btn:
                ((Suzuki) aca).suzukiPopup(14);
                break;

            case R.id._suzukiVanVan200btn:
                ((Suzuki) aca).suzukiPopup(15);
                break;
            /*--- TM Buttons ---*/
            case R.id._tm125btn:
                ((TM) aca).tmPopup(0);
                break;

            case R.id._tm2502Tbtn:
                ((TM) aca).tmPopup(1);
                break;

            case R.id._tm300btn:
                ((TM) aca).tmPopup(2);
                break;

            case R.id._tm2504Tbtn:
                ((TM) aca).tmPopup(3);
                break;

            case R.id._tm450btn:
                ((TM) aca).tmPopup(4);
                break;

            case R.id._tm530btn:
                ((TM) aca).tmPopup(5);
                break;
            /*--- Triumph Buttons ---*/

            case R.id._triumphStreetTriple:
                ((Triumph) aca).triumphPopup(0);
                break;

            case R.id._triumphSpeedTriplebtn:
                ((Triumph) aca).triumphPopup(1);
                break;

            case R.id._triumphBonnevilleT100btn:
                ((Triumph) aca).triumphPopup(2);
                break;

            case R.id._triumphBonnevilleT120btn:
                ((Triumph) aca).triumphPopup(3);
                break;

            case R.id._triumphStreetCupbtn:
                ((Triumph) aca).triumphPopup(4);
                break;

            case R.id._triumphStreetTwinbtn:
                ((Triumph) aca).triumphPopup(5);
                break;

            case R.id._triumphTigerSportbtn:
                ((Triumph) aca).triumphPopup(6);
                break;

            case R.id._triumphTigerExplorerbtn:
                ((Triumph) aca).triumphPopup(7);
                break;

            case R.id._triumphTiger800XRbtn:
                ((Triumph) aca).triumphPopup(8);
                break;

            case R.id._triumphThruxton1200btn:
                ((Triumph) aca).triumphPopup(9);
                break;

            case R.id._triumphBonnevilleBobberbtn:
                ((Triumph) aca).triumphPopup(10);
                break;

            case R.id._triumphSpeedmasterbtn:
                ((Triumph) aca).triumphPopup(11);
                break;

            case R.id._triumphRocketIIIbtn:
                ((Triumph) aca).triumphPopup(12);
                break;

            case R.id._triumphThunderbirdbtn:
                ((Triumph) aca).triumphPopup(13);
                break;

            case R.id._triumphScramblerbtn:
                ((Triumph) aca).triumphPopup(14);
                break;

            case R.id._triumphStreetScramblerbtn:
                ((Triumph) aca).triumphPopup(15);
                break;

            case R.id._triumphTiger800XCbtn:
                ((Triumph) aca).triumphPopup(16);
                break;

            /*--- Valenti Buttons ---*/
            case R.id._valentiRME50btn:
                ((Valenti) aca).valentiPopup(0);
                break;

            case R.id._valentiRMZ250Ebtn:
                ((Valenti) aca).valentiPopup(1);
                break;

            case R.id._valentiRMZ450Ebtn:
                ((Valenti) aca).valentiPopup(2);
                break;

            /*--- Yamaha Buttons ---*/
            case R.id._yamahaMT125btn:
                ((Yamaha) aca).yamahaPopup(0);
                break;

            case R.id._yamahaMT03btn:
                ((Yamaha) aca).yamahaPopup(1);
                break;

            case R.id._yamahaMT09btn:
                ((Yamaha) aca).yamahaPopup(2);
                break;

            case R.id._yamahaMT10btn:
                ((Yamaha) aca).yamahaPopup(3);
                break;

            case R.id._yamahaXSR700btn:
                ((Yamaha) aca).yamahaPopup(4);
                break;

            case R.id._yamahaXSR900btn:
                ((Yamaha) aca).yamahaPopup(5);
                break;

            case R.id._yamahaXSR900Abarthbtn:
                ((Yamaha) aca).yamahaPopup(6);
                break;

            case R.id._yamahaYZFR125btn:
                ((Yamaha) aca).yamahaPopup(7);
                break;

            case R.id._yamahaYZFR3btn:
                ((Yamaha) aca).yamahaPopup(8);
                break;

            case R.id._yamahaYZFR6btn:
                ((Yamaha) aca).yamahaPopup(9);
                break;

            case R.id._yamahaYZFR1btn:
                ((Yamaha) aca).yamahaPopup(10);
                break;

            case R.id._yamahaFJR1600btn:
                ((Yamaha) aca).yamahaPopup(11);
                break;

            case R.id._yamahaSCR950btn:
                ((Yamaha) aca).yamahaPopup(12);
                break;

            case R.id._yamahaTracer700btn:
                ((Yamaha) aca).yamahaPopup(13);
                break;

            case R.id._yamahaTracer900btn:
                ((Yamaha) aca).yamahaPopup(14);
                break;

            case R.id._yamahaSR400btn:
                ((Yamaha) aca).yamahaPopup(15);
                break;

            case R.id._yamahaVMAXbtn:
                ((Yamaha) aca).yamahaPopup(16);
                break;

            case R.id._yamahaYS125btn:
                ((Yamaha) aca).yamahaPopup(17);
                break;

            case R.id._yamahaXJR1300btn:
                ((Yamaha) aca).yamahaPopup(18);
                break;

            case R.id._yamahaXJR1300Racerbtn:
                ((Yamaha) aca).yamahaPopup(19);
                break;

            case R.id._yamahaXV950btn:
                ((Yamaha) aca).yamahaPopup(20);
                break;

            case R.id._yamahaXV950Racerbtn:
                ((Yamaha) aca).yamahaPopup(21);
                break;

            case R.id._yamahaTenerebtn:
                ((Yamaha) aca).yamahaPopup(22);
                break;

            case R.id._yamahaSuperTenerebtn:
                ((Yamaha) aca).yamahaPopup(23);
                break;

            case R.id._yamahaDT50btn:
                ((Yamaha) aca).yamahaPopup(24);
                break;

            case R.id._yamahaWR125Xbtn:
                ((Yamaha) aca).yamahaPopup(25);
                break;

            case R.id._yamahaWR250Fbtn:
                ((Yamaha) aca).yamahaPopup(26);
                break;

            case R.id._yamahaWR450Fbtn:
                ((Yamaha) aca).yamahaPopup(27);
                break;
        }

        return false;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int i = item.getItemId();
        byte mode = 0;

        if (i == R.id._menuButtonsSave) mode = 1; //save mode
        else if (i == R.id._menuButtonsShare) mode = 2; //share mode

        if (context.equalsIgnoreCase("Aprilia")) {
            ((Aprilia) aca).apriliaShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Beta")) {
            ((Beta) aca).betaShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("BMW")) {
            ((BMW) aca).bmwShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Derbi")) {
            ((Derbi) aca).derbiShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Ducati")) {
            ((Ducati) aca).ducatiShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Fantic")) {
            ((Fantic) aca).fanticShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("HarleyDavidson")) {
            ((HarleyDavidson) aca).hdShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("HM")) {
            ((HM) aca).hmShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Honda")) {
            ((Honda) aca).hondaShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Husaberg")) {
            ((Husaberg) aca).husaShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Husqvarna")) {
            ((Husqvarna) aca).hsqShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Kawasaki")) {
            ((Kawasaki) aca).kawaShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("KTM")) {
            ((KTM) aca).ktmShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("MotoGuzzi")) {
            ((MotoGuzzi) aca).mgShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("MVAgusta")) {
            ((MVAgusta) aca).mvShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Suzuki")) {
            ((Suzuki) aca).suzukiShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("TM")) {
            ((TM) aca).tmShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Triumph")) {
            ((Triumph) aca).triumphShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Valenti")) {
            ((Valenti) aca).valentiShare(nameRaw, mode);
            return true;
        }

        if (context.equalsIgnoreCase("Yamaha")) {
            ((Yamaha) aca).yamahaShare(nameRaw, mode);
            return true;
        }

        return false;
    }

}