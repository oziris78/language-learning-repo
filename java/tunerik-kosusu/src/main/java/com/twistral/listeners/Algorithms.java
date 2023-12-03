package com.twistral.listeners;

import com.twistral.consts.Strings;
import com.twistral.utils.*;
import com.twistral.consts.Images;
import com.twistral.consts.Colors;
import com.twistral.consts.Sounds;
import com.twistral.entities.AbstractMonster;
import com.twistral.entities.MonsterCounters;
import com.twistral.entities.Player;
import com.twistral.entities.normal.*;
import com.twistral.entities.bosses.*;
import com.twistral.main.Application;
import com.twistral.utils.TKUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class Algorithms {

    public static int yeniYaratikOlasiligi = 40; // (0,100] arasi bir sayi, yuzde kac olasilikla 3 kez oldurme sonrasi yeniden yaratik gelecegini belirtir

    public static int kazanilanDeneyim = 0;
    private static int oldDefenseValue = 1000; // oylesine bir deger, 0 disinda her sey olur
    private static int oldEvadeValueForSlowness2 = 1000; // oylesine bir deger, 0 disinda her sey olur
    private static int oldMeleeDamage = 1000;
    private static int oldRangedDamage = 1000;
    private static boolean damageIsIncreased = false;
    public static ArrayList<Integer> oldEvadeValueForSlowness1; // oylesine bir deger, 0 disinda her sey olur

    static{
        oldEvadeValueForSlowness1 = new ArrayList<>();
    }

    // DOVUSME BUTONLARI (MELEE, RANGED, DEFENSE, ITEMS)

    public static void meleeButton(){
        SwingWorker<Void, Void> w = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                Random ran = new Random();
                boolean isCritical = false;
                Player player = Application.getPlayer();
                AbstractMonster monster = Application.getCurrentMonster();
                efekteGoreIslemYap(player.getCurrentEffects()); // getOyuncu() seyini degistirir
                player = Application.getPlayer();

                // oyuncu vuracak
                // ran.nextInt(101) = [0,100] arasi rastgele sayi
                if( ran.nextInt(101) > monster.getEvade() || monster.getEvade() != 0 || monster.getHealth() > 0){ // eger yaratik savusturamaz ise
                    float hit = 0;

                    // oyuncu monster a vurur ----
                    if( ran.nextInt(101) > player.getMeleeCrit() || player.getMeleeCrit() != 0){ // crit atilamadi
                        hit = player.getMeleeDamage() * monster.getMeleeRes();
                        isCritical = false;
                    }
                    else{ // crit atildi, her crit 1.5 diye belirtiliyor gelecekte degisebilir?
                        hit = player.getMeleeDamage() * monster.getMeleeRes() * (1.5f);
                        isCritical = true;
                    }

                    Application.dovusButonlariniKapa();
                    monster.setHealth( monster.getHealth() -  (int) Math.ceil(hit));
                    Application.updateAllBars();
                    Application.lbHit.setVisible(true);
                    Application.lbHit.setText(String.valueOf((int) Math.ceil(hit)));
                    Sounds.oyuncuVurduSesi(isCritical, "melee");
                    TKUtils.sleepMilisecs(300);
                    Sounds.yaratikVurulduSesi(monster);
                    TKUtils.sleepSecs(2);
                    Application.lbHit.setVisible(false);
                    Application.dovusButonlariniAc();

                    // ---------------------------

                    if(monster.getHealth() > 0){ // monster yasiyor
                        yaratiginSirasiOyuncuVurduktanSonra(ran, player, monster);
                    }
                    else { // monster olmus
                        Sounds.yaratikOlduSesi(monster);
                        int curLevel = player.getLevel();
                        deneyimKatVeDuzeyYokla(player, monster);
                        int newLevel = player.getLevel();
                        boolean duzeyAtlandi = (newLevel-curLevel == 0) ? false : true;
                        zorlugaGoreOdulVer(player, monster); // oyuncuya lootu gecirme
                        int odul = zorlugaGoreOdulDon(player, monster); // yazma amacli alma

                        Application.dovusButonlariniKapa();

                        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
                        String post = "</pre></html>";
                        String[] dizi;

                        dizi = Strings.diziyeGecir(pre, Strings.odulVermeYazisi(odul), post);
                        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
                        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
                        Application.lbDown.setText("");

                        dizi = Strings.diziyeGecir(pre, Strings.deneyimVermeYazisi(kazanilanDeneyim), post);
                        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
                        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
                        Application.lbDown.setText("");

                        if(duzeyAtlandi){
                            dizi = Strings.diziyeGecir(pre, Strings.duzeyAtlamaYazisi(), post);
                            TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
                            TKUtils.sleepMilisecs(1500 + dizi.length * 250);
                            Application.lbDown.setText("");
                        }

                        Application.dovusButonlariniAc();
                        Application.updateStats();
                        Application.updateAllBars();

                        yeniYaratigaGoreIlerle();

                    }
                }
                else{
                    // yaratik savusturdu ise
                    Sounds.vurusKacirildiSesi();
                    TKUtils.sleepMilisecs(300);
                    yaratiginSirasiOyuncuVuramadiktanSonra(ran, player, monster);
                }

                Application.updateAllBars();
                Application.updateStats();

                efekteGoreIslemYapSonIcin(Application.getPlayer().getCurrentEffects());
                return null;
            }
        };
        w.execute();
    } // bitti

    public static void rangedButton(){
        SwingWorker<Void, Void> w = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                Random ran = new Random();
                boolean isCritical = false;
                Player player = Application.getPlayer();
                AbstractMonster monster = Application.getCurrentMonster();
                efekteGoreIslemYap(player.getCurrentEffects()); // getOyuncu() seyini degistirir
                player = Application.getPlayer();

                // oyuncu vuracak
                // ran.nextInt(101) = [0,100] arasi rastgele sayi
                if( ran.nextInt(101) > monster.getEvade() || monster.getEvade() != 0 || monster.getHealth() > 0){ // eger yaratik savusturamaz ise
                    float hit = 0;

                    // oyuncu monster a vurur ----
                    if( ran.nextInt(101) > player.getRangedCrit() || player.getRangedCrit() != 0){ // crit atilamadi
                        hit = player.getRangedDamage() * monster.getRangedRes();
                        isCritical = false;
                    }
                    else{ // crit atildi, her crit 1.5 diye belirtiliyor gelecekte degisebilir?
                        hit = player.getRangedDamage() * monster.getRangedRes() * (1.5f);
                        isCritical = true;
                    }

                    Application.dovusButonlariniKapa();
                    monster.setHealth( monster.getHealth() -  (int) Math.ceil(hit));
                    Application.updateAllBars();
                    Application.lbHit.setVisible(true);
                    Application.lbHit.setText(String.valueOf((int) Math.ceil(hit)));
                    Sounds.oyuncuVurduSesi(isCritical, "ranged");
                    TKUtils.sleepMilisecs(300);
                    Sounds.yaratikVurulduSesi(monster);
                    TKUtils.sleepSecs(2);
                    Application.lbHit.setVisible(false);
                    Application.dovusButonlariniAc();

                    // ---------------------------

                    if(monster.getHealth() > 0){ // monster yasiyor
                        yaratiginSirasiOyuncuVurduktanSonra(ran, player, monster);
                    }
                    else { // monster olmus
                        Sounds.yaratikOlduSesi(monster);
                        int curLevel = player.getLevel();
                        deneyimKatVeDuzeyYokla(player, monster);
                        int newLevel = player.getLevel();
                        boolean duzeyAtlandi = (newLevel-curLevel == 0) ? false : true;
                        zorlugaGoreOdulVer(player, monster); // oyuncuya lootu gecirme
                        int odul = zorlugaGoreOdulDon(player, monster); // yazma amacli alma

                        Application.dovusButonlariniKapa();

                        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
                        String post = "</pre></html>";
                        String[] dizi;

                        dizi = Strings.diziyeGecir(pre, Strings.odulVermeYazisi(odul), post);
                        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
                        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
                        Application.lbDown.setText("");

                        dizi = Strings.diziyeGecir(pre, Strings.deneyimVermeYazisi(kazanilanDeneyim), post);
                        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
                        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
                        Application.lbDown.setText("");

                        if(duzeyAtlandi){
                            dizi = Strings.diziyeGecir(pre, Strings.duzeyAtlamaYazisi(), post);
                            TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
                            TKUtils.sleepMilisecs(1500 + dizi.length * 250);
                            Application.lbDown.setText("");
                        }

                        Application.dovusButonlariniAc();
                        Application.updateStats();
                        Application.updateAllBars();

                        yeniYaratigaGoreIlerle();

                    }
                }
                else{
                    // yaratik savusturdu ise
                    Sounds.vurusKacirildiSesi();
                    TKUtils.sleepMilisecs(300);
                    yaratiginSirasiOyuncuVuramadiktanSonra(ran, player, monster);
                }

                Application.updateAllBars();
                Application.updateStats();

                efekteGoreIslemYapSonIcin(Application.getPlayer().getCurrentEffects());
                return null;
            }
        };
        w.execute();
    } // bitti

    public static void itemsButton(){
        ClipUtils.playClip(Sounds.clipMenuClick2);
        Application.panGame.setVisible(false);
        Application.panInventoryFromGame.setVisible(true);
    } // bitti

    public static void defenseButton(){
            SwingWorker<Void, Void> w = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() {
                    Random ran = new Random();
                    Player player = Application.getPlayer();
                    AbstractMonster monster = Application.getCurrentMonster();
                    efekteGoreIslemYap(player.getCurrentEffects()); // getOyuncu() seyini degistirir
                    player = Application.getPlayer();
                    int eskiDefense = player.getDefense();
                    player.setDefense(eskiDefense * 2);
                    asagiSiraylaYaz(Strings.defenseYap);
                    TKUtils.sleepMilisecs(300);
                    yaratiginSirasiOyuncuVuramadiktanSonra(ran, player, monster);
                    TKUtils.sleepMilisecs(300);
                    Application.updateAllBars();
                    Application.updateStats();
                    TKUtils.sleepMilisecs(300);
                    efekteGoreIslemYapSonIcin(Application.getPlayer().getCurrentEffects());
                    TKUtils.sleepMilisecs(300);
                    player.setDefense(eskiDefense);
                    if(player.getCurHealth() > player.getMaxHealth()) player.setCurHealth(player.getMaxHealth());
                    Application.updateAllBars();
                    Application.updateStats();
                    return null;
                }
            };
            w.execute();
        } // bitti


    // Helper Functions

    public static void efekteGoreIslemYap(HashMap<String, Integer> effects){

        if(effects.get("bleeding1") > 0){
            ClipUtils.playClip(Sounds.clipBleedingUyg);
            int hasar = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 5) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() - hasar);
            asagiSiraylaYaz(Strings.bleeding1);
            effects.put("bleeding1", effects.get("bleeding1")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("bleeding2") > 0){
            ClipUtils.playClip(Sounds.clipBleedingUyg);
            int hasar = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 25) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() - hasar);
            asagiSiraylaYaz(Strings.bleeding2);
            effects.put("bleeding2", effects.get("bleeding2")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("burning1") > 0){
            ClipUtils.playClip(Sounds.clipBurningUyg);
            int hasar = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 15) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() - hasar);
            asagiSiraylaYaz(Strings.burning1);
            effects.put("burning1", effects.get("burning1")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("burning2") > 0){
            ClipUtils.playClip(Sounds.clipBurningUyg);
            int hasar = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 10) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() - hasar);
            asagiSiraylaYaz(Strings.burning2);
            effects.put("burning2", effects.get("burning2")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("burning3") > 0){
            ClipUtils.playClip(Sounds.clipBurningUyg);
            int hasar = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 30) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() - hasar);
            asagiSiraylaYaz(Strings.burning3);
            effects.put("burning3", effects.get("burning3")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("regen1") > 0){
            ClipUtils.playClip(Sounds.clipRegenUyg);
            int canArtmasi = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 5) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() + canArtmasi);
            if(Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()){
                Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
            }
            asagiSiraylaYaz(Strings.regen1);
            effects.put("regen1", effects.get("regen1")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("regen2") > 0){
            ClipUtils.playClip(Sounds.clipRegenUyg);
            int canArtmasi = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 10) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() + canArtmasi);
            if(Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()){
                Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
            }
            asagiSiraylaYaz(Strings.regen2);
            effects.put("regen2", effects.get("regen2")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("regen3") > 0){
            ClipUtils.playClip(Sounds.clipRegenUyg);
            int canArtmasi = (int) Math.ceil( (Application.getPlayer().getMaxHealth() * 20) / 100);
            Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() + canArtmasi);
            if(Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()){
                Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
            }
            asagiSiraylaYaz(Strings.regen3);
            effects.put("regen3", effects.get("regen3")-1);
        } else{ /* burasi bos olacak */ }   // bitti

        if(effects.get("slowness2") > 0){
            ClipUtils.playClip(Sounds.clipSlownessUyg);
            if(oldEvadeValueForSlowness2 != 0){ oldEvadeValueForSlowness2 = Application.getPlayer().getEvade(); }
            Application.getPlayer().setEvade(0);
            asagiSiraylaYaz(Strings.slowness2);
            effects.put("slowness2", effects.get("slowness2")-1);
        } else{
            if(oldEvadeValueForSlowness2 != 1000){ // basta hata vermesin diye
                Application.getPlayer().setDefense(oldEvadeValueForSlowness2);
                oldEvadeValueForSlowness2 = 1000;
            }
        }    // bitti

        if(effects.get("noDefense") > 0){
            ClipUtils.playClip(Sounds.clipNoDefenseUyg);
            if(oldDefenseValue != 0){ oldDefenseValue = Application.getPlayer().getDefense(); }
            Application.getPlayer().setDefense(0);
            asagiSiraylaYaz(Strings.noDefense);
            effects.put("noDefense", effects.get("noDefense")-1);
        } else{
            if(oldDefenseValue != 1000){
                Application.getPlayer().setDefense(oldDefenseValue);
                oldDefenseValue = 1000;
            }
        }    // bitti

        if(effects.get("slowness1") > 0){
            ClipUtils.playClip(Sounds.clipSlownessUyg);
            oldEvadeValueForSlowness1.add(Application.getPlayer().getEvade());
            int azaltma = (int) Math.ceil((Application.getPlayer().getEvade() * 15) / 100);
            Application.getPlayer().setEvade(Application.getPlayer().getEvade() - azaltma);
            asagiSiraylaYaz(Strings.slowness1);
            effects.put("slowness1", effects.get("slowness1")-1);
        } else{
            if(!oldEvadeValueForSlowness1.isEmpty()){
                int maxEvade = Collections.max(oldEvadeValueForSlowness1);
                Application.getPlayer().setEvade(maxEvade);
                oldEvadeValueForSlowness1.clear();
            }
        }    // bitti

        if(effects.get("strength") > 0){
            ClipUtils.playClip(Sounds.clipStrengthUyg);
            if(!damageIsIncreased){
                oldMeleeDamage  = Application.getPlayer().getMeleeDamage();
                oldRangedDamage = Application.getPlayer().getRangedDamage();
                Application.getPlayer().setMeleeDamage (oldMeleeDamage * 2);
                Application.getPlayer().setRangedDamage(oldRangedDamage * 2);
                damageIsIncreased = true;
            }
            asagiSiraylaYaz(Strings.strengthEffect);
            effects.put("strength", effects.get("strength")-1);
        } else{
            if(oldMeleeDamage!=1000 && oldRangedDamage!=1000){
                damageIsIncreased = false;
                Application.getPlayer().setMeleeDamage (oldMeleeDamage);
                Application.getPlayer().setRangedDamage(oldRangedDamage);
                oldMeleeDamage = 1000;
                oldRangedDamage = 1000;
            }
        }    // bitti


        // GUNCELLEME SEYLERI
        Application.invGuncelle();
        Application.updateStats();
        Application.updateAllBars();

    }

    public static void efekteGoreIslemYapSonIcin(HashMap<String, Integer> effects){

        if(effects.get("slowness2") > 0){} else{
            if(oldEvadeValueForSlowness2 != 1000){ // basta hata vermesin diye
                Application.getPlayer().setDefense(oldEvadeValueForSlowness2);
                oldEvadeValueForSlowness2 = 1000;
            }
        }

        if(effects.get("noDefense") > 0){} else{
            if(oldDefenseValue != 1000){
                Application.getPlayer().setDefense(oldDefenseValue);
                oldDefenseValue = 1000;
            }
        }

        if(effects.get("slowness1") > 0){} else{
            if(!oldEvadeValueForSlowness1.isEmpty()){
                int maxEvade = Collections.max(oldEvadeValueForSlowness1);
                Application.getPlayer().setEvade(maxEvade);
                oldEvadeValueForSlowness1.clear();
            }
        }

        if(effects.get("strength") > 0){} else{
            if(oldMeleeDamage!=1000 && oldRangedDamage!=1000){
                damageIsIncreased = false;
                Application.getPlayer().setMeleeDamage (oldMeleeDamage);
                Application.getPlayer().setRangedDamage(oldRangedDamage);
                oldMeleeDamage = 1000;
                oldRangedDamage = 1000;
            }
        }

        // GUNCELLEME SEYLERI
        Application.invGuncelle();
        Application.updateStats();
        Application.updateAllBars();

    }

    public static void yaratiginSirasiItemdanSonra(String id){
        new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                TKUtils.sleepMilisecs(150 + itemKullanmayaGoreUzunluk(id) * 250); // iki saat zamanlamayi ayarlama yaptim sonunda burasi old anladim
                TKUtils.sleepMilisecs(2500);
                yaratiginSirasiOyuncuVurduktanSonra(new Random(), Application.getPlayer(), Application.getCurrentMonster());
                return null;
            }
        }.execute();
        Application.updateAllBars();
        Application.updateStats();
    }

    public static void yaratiginSirasiOyuncuVuramadiktanSonra(Random ran, Player player, AbstractMonster monster){
        if(monster.getClass() == TheTenebrosity.class || monster.getClass() == TheTenebrosity.class){
            if(ran.nextInt(101) <= 8){
                // canini fulleyecek
                asagiSiraylaYaz(Strings.tenebEfekti);
                ClipUtils.playClip(Sounds.clipTenebCanBasma);
                monster.setHealth(monster.getMaxHealth());
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == IceOrb.class){
            if(ran.nextInt(101) <= 20){
                // noDefense => 1 el, defense -%100, olma olasılığı %20
                asagiSiraylaYaz(Strings.iceOrbEfekti);
                ClipUtils.playClip(Sounds.clipNoDefenseVerilme);
                player.getCurrentEffects().put("noDefense", player.getCurrentEffects().get("noDefense") + 1 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == DarkOrb.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.darkOrbEfekti);
                ClipUtils.playClip(Sounds.clipSlownessVerilme);
                player.getCurrentEffects().put("slowness2", player.getCurrentEffects().get("slowness2") + 1 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == FireOrb.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.fireOrbEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Yek.class){
            if(ran.nextInt(101) <= 10){
                asagiSiraylaYaz(Strings.yekEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning3", player.getCurrentEffects().get("burning3") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == HellSpider.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.hellSpiderEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Cerberus.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.cerberusEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Phoenix.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.phoenixEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == TheraphoseBlondi.class){
            if(ran.nextInt(101) <= 15){
                asagiSiraylaYaz(Strings.theraphoseEfekti);
                ClipUtils.playClip(Sounds.clipBleedingVerilme);
                player.getCurrentEffects().put("bleeding2", player.getCurrentEffects().get("bleeding2") + 2);

            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == ParilisAranea.class){
            if(ran.nextInt(101) <= 15){
                asagiSiraylaYaz(Strings.parilisEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning1", player.getCurrentEffects().get("burning1") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == VeneficusAranea.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.veneficusEfekti);
                ClipUtils.playClip(Sounds.clipSlownessVerilme);
                player.getCurrentEffects().put("slowness1", player.getCurrentEffects().get("slowness1") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Eunectes.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.eunectesEfekti);
                ClipUtils.playClip(Sounds.clipBleedingVerilme);
                player.getCurrentEffects().put("bleeding2", player.getCurrentEffects().get("bleeding2") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == BlueSlime.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.blueSlimeEfekti);
                ClipUtils.playClip(Sounds.clipSlownessVerilme);
                player.getCurrentEffects().put("slowness1", player.getCurrentEffects().get("slowness1") + 2 );

            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
            }
        }

        else{ // efekt ekleme yok o yuzden duz vur
            yaratiginSirasiOyuncuVuramadiktanSonraIci(ran, player, monster);
        }
    }

    public static void yaratiginSirasiOyuncuVurduktanSonra(Random ran, Player player, AbstractMonster monster) {
        if(monster.getClass() == TheTenebrosity.class || monster.getClass() == TheTenebrosity.class){
            if(ran.nextInt(101) <= 8){
                // canini fulleyecek
                asagiSiraylaYaz(Strings.tenebEfekti);
                ClipUtils.playClip(Sounds.clipTenebCanBasma);
                monster.setHealth(monster.getMaxHealth());
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == IceOrb.class){
            if(ran.nextInt(101) <= 20){
                // noDefense => 1 el, defense -%100, olma olasılığı %20
                asagiSiraylaYaz(Strings.iceOrbEfekti);
                ClipUtils.playClip(Sounds.clipNoDefenseVerilme);
                player.getCurrentEffects().put("noDefense", player.getCurrentEffects().get("noDefense") + 1 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == DarkOrb.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.darkOrbEfekti);
                ClipUtils.playClip(Sounds.clipSlownessVerilme);
                player.getCurrentEffects().put("slowness2", player.getCurrentEffects().get("slowness2") + 1 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == FireOrb.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.fireOrbEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Yek.class){
            if(ran.nextInt(101) <= 10){
                asagiSiraylaYaz(Strings.yekEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning3", player.getCurrentEffects().get("burning3") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == HellSpider.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.hellSpiderEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Cerberus.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.cerberusEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Phoenix.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.phoenixEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning2", player.getCurrentEffects().get("burning2") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == TheraphoseBlondi.class){
            if(ran.nextInt(101) <= 15){
                asagiSiraylaYaz(Strings.theraphoseEfekti);
                ClipUtils.playClip(Sounds.clipBleedingVerilme);
                player.getCurrentEffects().put("bleeding2", player.getCurrentEffects().get("bleeding2") + 2);

            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == ParilisAranea.class){
            if(ran.nextInt(101) <= 15){
                asagiSiraylaYaz(Strings.parilisEfekti);
                ClipUtils.playClip(Sounds.clipBurningVerilme);
                player.getCurrentEffects().put("burning1", player.getCurrentEffects().get("burning1") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == VeneficusAranea.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.veneficusEfekti);
                ClipUtils.playClip(Sounds.clipSlownessVerilme);
                player.getCurrentEffects().put("slowness1", player.getCurrentEffects().get("slowness1") + 2);
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == Eunectes.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.eunectesEfekti);
                ClipUtils.playClip(Sounds.clipBleedingVerilme);
                player.getCurrentEffects().put("bleeding2", player.getCurrentEffects().get("bleeding2") + 2 );
            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else if(monster.getClass() == BlueSlime.class){
            if(ran.nextInt(101) <= 20){
                asagiSiraylaYaz(Strings.blueSlimeEfekti);
                ClipUtils.playClip(Sounds.clipSlownessVerilme);
                player.getCurrentEffects().put("slowness1", player.getCurrentEffects().get("slowness1") + 2 );

            }
            else{
                // ozellik yok duz saldiri
                yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
            }
        }

        else{ // efekt ekleme yok o yuzden duz vur
            yaratiginSirasiOyuncuVurduktanSonraIci(ran, player, monster);
        }

    }

    public static void yaratiginSirasiOyuncuVuramadiktanSonraIci(Random ran, Player player, AbstractMonster monster){
        // monster oyuncuya vurur ----
        float hit = 0;
        if( ran.nextInt(101) > player.getEvade() ){ // oyuncu savusturamadi, hit olacak
            // monster vurdu
            hit = monster.getDamage() - player.getDefense();
            player.setCurHealth(player.getCurHealth() - (int) Math.ceil(hit));

            if( !(player.getCurHealth() > 0) ) { // oyuncu yasamiyor

                Sounds.oyuncuOlmeSesiVeGameOver();

                String pre = "<html><pre style='padding-left:160px; padding-top:10px;'>";
                String post = "</pre></html>";
                String[] dizi = Strings.diziyeGecir(pre, Strings.youHaveDied(), post);
                Application.dovusButonlariniKapa();
                Application.lbDown.setFont(Application.lbDown.getFont().deriveFont(50f));
                Application.lbDown.setForeground(Colors.red);
                TKUtils.animas_TK(dizi, Application.lbDown, 400, 200).execute();
                TKUtils.sleepMilisecs(2000 + dizi.length * 400);
                Application.lbDown.setText("");
                Application.lbDown.setFont(Application.lbDown.getFont().deriveFont(25f));
                Application.lbDown.setForeground(Colors.white);

                for(Component com : Application.panGame.getComponents()){ com.setVisible(false); }
                Application.panGame.setVisible(false);

                Application.setOyuncu(new Player()); // degerlerin sifirlanmasi

                Application.panGameOver.setVisible(true);
                Application.btnDeadToMain.setVisible(true);

                Application.lbRight.setVisible(false);
                Application.lbLeft.setVisible(false);
                Application.statSakla();

                Application.setCurrentMonster(new Slime());
            }

        }
        else{ // oyuncu savusturdu, hit yok

            Sounds.vurusKacirildiSesi();
            TKUtils.sleepMilisecs(300);
            Application.dovusButonlariniKapa();
            Application.updateAllBars();
            Application.lbHit.setVisible(true);
            Application.lbHit.setText("0");
            TKUtils.sleepSecs(2);
            Application.lbHit.setVisible(false);
            Application.dovusButonlariniAc();
        }
        // --------------------
    }

    public static void yaratiginSirasiOyuncuVurduktanSonraIci(Random ran, Player player, AbstractMonster monster){
        // sira monster da ----
        if( ran.nextInt(101) > player.getEvade() ){ // oyuncu savusturamadi, hit olacak
            // monster vurdu
            float hit = monster.getDamage() - player.getDefense();
            Application.dovusButonlariniKapa();
            player.setCurHealth(player.getCurHealth() -  (int) Math.ceil(hit));
            Application.updateAllBars();
            Application.lbHit.setVisible(true);
            Application.lbHit.setText(String.valueOf((int) Math.ceil(hit)));
            Sounds.yaratikVurduSesi(monster);
            TKUtils.sleepMilisecs(300);
            Sounds.oyuncuVurulduSesi();
            TKUtils.sleepSecs(2);
            Application.lbHit.setVisible(false);
            Application.dovusButonlariniAc();

            if( !(player.getCurHealth() > 0) ) { // oyuncu yasamiyor

                Sounds.oyuncuOlmeSesiVeGameOver();

                String pre = "<html><pre style='padding-left:160px; padding-top:10px;'>";
                String post = "</pre></html>";
                String[] dizi = Strings.diziyeGecir(pre, Strings.youHaveDied(), post);
                Application.dovusButonlariniKapa();
                Application.lbDown.setFont(Application.lbDown.getFont().deriveFont(50f));
                Application.lbDown.setForeground(Colors.red);
                TKUtils.animas_TK(dizi, Application.lbDown, 400, 200).execute();
                TKUtils.sleepMilisecs(2000 + dizi.length * 400);
                Application.lbDown.setText("");
                Application.lbDown.setFont(Application.lbDown.getFont().deriveFont(25f));
                Application.lbDown.setForeground(Colors.white);

                for(Component com : Application.panGame.getComponents()){ com.setVisible(false); }
                Application.panGame.setVisible(false);

                Application.setOyuncu(new Player()); // degerlerin sifirlanmasi

                Application.panGameOver.setVisible(true);
                Application.btnDeadToMain.setVisible(true);

                Application.lbRight.setVisible(false);
                Application.lbLeft.setVisible(false);
                Application.statSakla();

                Application.setCurrentMonster(new Slime());

            }
        }
        else{ // oyuncu savusturdu, hit yok

            Application.dovusButonlariniKapa();
            Application.updateAllBars();
            Application.lbHit.setVisible(true);
            Application.lbHit.setText("0");
            TKUtils.sleepMilisecs(300);
            Sounds.vurusKacirildiSesi();
            TKUtils.sleepSecs(2);
            Application.lbHit.setVisible(false);
            Application.dovusButonlariniAc();
        }
    }

    public static void deneyimKatVeDuzeyYokla(Player player, AbstractMonster m){
        Random ran = new Random();
        // eger duz yaratik ise 150-350 arasi deneyim verir
        // eger boss ise 500-1000 arasi deneyim verir
        // ---------------------------------

        // deneyimi verme
        if( (m.getClass() == BlueSlime.class) || (m.getClass() == Eunectes.class) ||
                (m.getClass() == TheTenebrosity.class) || (m.getClass() == TheTenebrosity.class) ||
                (m.getClass() == Yek.class) || (m.getClass() == TheraphoseBlondi.class))
        {
            kazanilanDeneyim = (1000 - (int) Math.floor(ran.nextFloat() * 500)  );
            player.setExperience(player.getExperience() + kazanilanDeneyim );
        }
        else{ // boss degil
            kazanilanDeneyim = (350 - (int) Math.floor(ran.nextFloat() * 200)  );
            player.setExperience(player.getExperience() + kazanilanDeneyim );
        }
        // ----------------------------------

        // duzey atlama
        if(player.getExperience() >= 1000){
            player.setLevel(player.getLevel() + 1);
            player.setExperience(player.getExperience() - 1000);
            if(player.getChClass() == "knight"){
                player.setMaxHealth(player.getMaxHealth() + 5);
                player.setCurHealth(player.getMaxHealth());
                player.setEvade(player.getEvade() + 3);

            }
            else if(player.getChClass() == "archer"){
                player.setMaxHealth(player.getMaxHealth() + 10);
                player.setCurHealth(player.getMaxHealth());
                player.setEvade(player.getEvade() + 4);
            }
            else if(player.getChClass() == "assassin"){
                player.setMaxHealth(player.getMaxHealth() + 5);
                player.setCurHealth(player.getMaxHealth());
                player.setEvade(player.getEvade() + 1);
            }
            else if(player.getChClass() == "swordsman"){
                player.setMaxHealth(player.getMaxHealth() + 15);
                player.setCurHealth(player.getMaxHealth());
                // evade artmaz
            }
        }
        // ----------------------------------
        return;

    }

    public static void zorlugaGoreOdulVer(Player player, AbstractMonster m){
        float med = 0.9f;  // loot un yuzde doksanini ver anlaminda
        float hard = 0.75f;
        float ultra = 0.5f;
        if(player.getDifficulty() == "easy"){ player.setMoney( player.getMoney() + m.getLoot() ) ; } // easy ise ayni
        else if(player.getDifficulty() == "medium"){ player.setMoney(player.getMoney() + (int) (m.getLoot() * med ) ); }
        else if(player.getDifficulty() == "hard"){ player.setMoney(player.getMoney() + (int) (m.getLoot() * hard ) ); }
        else if(player.getDifficulty() == "ultra"){ player.setMoney(player.getMoney() + (int) (m.getLoot() * ultra ) ); }
    }

    public static int zorlugaGoreOdulDon(Player player, AbstractMonster m){
        float med = 0.9f;  // loot un yuzde doksanini ver anlaminda
        float hard = 0.75f;
        float ultra = 0.5f;
        if(player.getDifficulty() == "easy")       { return m.getLoot() ; } // easy ise ayni
        else if(player.getDifficulty() == "medium"){ return (int) (m.getLoot() * med ) ; }
        else if(player.getDifficulty() == "hard")  { return (int) (m.getLoot() * hard ) ; }
        else if(player.getDifficulty() == "ultra") { return (int) (m.getLoot() * ultra ) ; }
        return 0; // def value
    }

    public static AbstractMonster zorlugaGoreCanArttir(AbstractMonster m){
        Player player = Application.getPlayer();
        float med = 1.25f;
        float hard = 1.75f;
        float ultra = 2.5f;
        if(player.getDifficulty() == "easy") { return m; } // easy ise ayni
        else if(player.getDifficulty() == "medium"){ m.setMaxHealth( (int) (m.getMaxHealth() * med ) ); m.setHealth( (int) (m.getHealth() * med ) ); return m; }
        else if(player.getDifficulty() == "hard")  { m.setMaxHealth( (int) (m.getMaxHealth() * hard ) ); m.setHealth( (int) (m.getHealth() * hard ) );  return m;}
        else if(player.getDifficulty() == "ultra") { m.setMaxHealth( (int) (m.getMaxHealth() * ultra ) );  m.setHealth( (int) (m.getHealth() * ultra ) );  return m;}
        return m;
    }

    public static void yeniYaratigaGoreIlerle(){
        Random ran = new Random();
        yaratikBoolAyarla();

        if(!MonsterCounters.shop1){
            if(!MonsterCounters.slimeIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new Slime());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.slimeSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.skeletonIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new Slime());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.skeletonIsDone){
                        MonsterCounters.skeletonIsStarted = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new Skeleton());
                        yaratikYazisiniYaz(newMonster);
                        MonsterCounters.skeletonSlained--;
                    }
                    else{
                        if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.chainedCorpseIsStarted){
                            AbstractMonster newMonster = zorlugaGoreCanArttir(new Skeleton());
                            yaratikYazisiniYaz(newMonster);
                        }
                        else{ yaratikYazisiniYazShopaYolla(); MonsterCounters.skeletonIsDone = true; MonsterCounters.shop1 = true; }
                    }
                }
            }
            return;
        }

        else if(!MonsterCounters.shop2){
            if(!MonsterCounters.chainedCorpseIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new ChainedCorpse());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.chainedCorpseSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.blueSlimeIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new ChainedCorpse());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.blueSlimeIsDone){
                        MonsterCounters.blueSlimeIsStarted = true;
                        MonsterCounters.blueSlimeIsDone = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new BlueSlime());
                        yaratikYazisiniYazBOSS(newMonster);
                        MonsterCounters.blueSlimeSlained--;
                    }
                    else{
                        yaratikYazisiniYazShopaYolla();
                        MonsterCounters.blueSlimeIsDone = true;
                        MonsterCounters.shop2 = true;
                    }
                }
            }
            return;
        }
        else if(!MonsterCounters.shop3){
            if(!MonsterCounters.armoredSkeletonIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new ArmoredSkeleton());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.armoredSkeletonSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.mummyIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new ArmoredSkeleton());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.mummyIsDone){
                        MonsterCounters.mummyIsStarted = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new Mummy());
                        yaratikYazisiniYaz(newMonster);
                        MonsterCounters.mummySlained--;
                    }
                    else{
                        if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.armoredChainedCorpseIsStarted){
                            AbstractMonster newMonster = zorlugaGoreCanArttir(new Mummy());
                            yaratikYazisiniYaz(newMonster);
                        }
                        else{ yaratikYazisiniYazShopaYolla(); MonsterCounters.mummyIsDone = true; MonsterCounters.shop3 = true; }
                    }
                }
            }
            return;
        }
        else if(!MonsterCounters.shop4){

            if(!MonsterCounters.armoredChainedCorpseIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new ArmoredChainedCorpse());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.armoredChainedCorpseSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.eunectesIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new ArmoredChainedCorpse());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.eunectesIsDone){
                        MonsterCounters.eunectesIsStarted = true;
                        MonsterCounters.eunectesIsDone = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new Eunectes());
                        yaratikYazisiniYazBOSS(newMonster);
                        MonsterCounters.eunectesSlained--;
                    }
                    else{
                        yaratikYazisiniYazShopaYolla();
                        MonsterCounters.eunectesIsDone = true;
                        MonsterCounters.shop4 = true;
                    }
                }
            }
            return;
        }
        else if(!MonsterCounters.shop5){

            if(!MonsterCounters.inenormisIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new InenormisAranea());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.inenormisSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.veneficusIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new InenormisAranea());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.veneficusIsDone){
                        MonsterCounters.veneficusIsStarted = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new VeneficusAranea());
                        yaratikYazisiniYaz(newMonster);
                        MonsterCounters.veneficusSlained--;
                    }
                    else{
                        if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.parilisIsStarted){
                            AbstractMonster newMonster = zorlugaGoreCanArttir(new VeneficusAranea());
                            yaratikYazisiniYaz(newMonster);
                        }
                        else{ yaratikYazisiniYazShopaYolla(); MonsterCounters.veneficusIsDone = true; MonsterCounters.shop5 = true; }
                    }
                }
            }
            return;
        }
        else if(!MonsterCounters.shop6){

            if(!MonsterCounters.parilisIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new ParilisAranea());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.parilisSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.theraphoseBlondiIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new ParilisAranea());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.theraphoseBlondiIsDone){
                        MonsterCounters.theraphoseBlondiIsStarted = true;
                        MonsterCounters.theraphoseBlondiIsDone = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new TheraphoseBlondi());
                        yaratikYazisiniYazBOSS(newMonster);
                        MonsterCounters.theraphoseBlondiSlained--;
                    }
                    else{
                        yaratikYazisiniYazShopaYolla();
                        MonsterCounters.theraphoseBlondiIsDone = true;
                        MonsterCounters.shop6 = true;
                    }
                }
            }
            return;
        }
        else if(!MonsterCounters.shop7){

            if(!MonsterCounters.phoenixIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new Phoenix());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.phoenixSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.cerberusIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new Phoenix());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.cerberusIsDone){
                        MonsterCounters.cerberusIsStarted = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new Cerberus());
                        yaratikYazisiniYaz(newMonster);
                        MonsterCounters.cerberusSlained--;
                    }
                    else{
                        if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.hellSpiderIsStarted){
                            AbstractMonster newMonster = zorlugaGoreCanArttir(new Cerberus());
                            yaratikYazisiniYaz(newMonster);
                        }
                        else{ yaratikYazisiniYazShopaYolla(); MonsterCounters.cerberusIsDone = true; MonsterCounters.shop7 = true; }
                    }
                }
            }
            return;
        }
        else if(!MonsterCounters.shop8){

            if(!MonsterCounters.hellSpiderIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new HellSpider());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.hellSpiderSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.yekIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new HellSpider());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.yekIsDone){
                        MonsterCounters.yekIsStarted = true;
                        MonsterCounters.yekIsDone = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new Yek());
                        yaratikYazisiniYazBOSS(newMonster);
                        MonsterCounters.yekSlained--;
                    }
                    else{
                        yaratikYazisiniYazShopaYolla();
                        MonsterCounters.yekIsDone = true;
                        MonsterCounters.shop8 = true;
                    }
                }
            }
            return;
        }

        else if(!MonsterCounters.shop9){

            if(!MonsterCounters.fireOrbIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new FireOrb());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.fireOrbSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.iceOrbIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new FireOrb());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.iceOrbIsDone){
                        MonsterCounters.iceOrbIsStarted = true;
                        AbstractMonster newMonster = zorlugaGoreCanArttir(new IceOrb());
                        yaratikYazisiniYaz(newMonster);
                        MonsterCounters.iceOrbSlained--;
                    }
                    else{
                        if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.darkOrbIsStarted){
                            AbstractMonster newMonster = zorlugaGoreCanArttir(new IceOrb());
                            yaratikYazisiniYaz(newMonster);
                        }
                        else{ yaratikYazisiniYazShopaYolla(); MonsterCounters.iceOrbIsDone = true; MonsterCounters.shop9 = true; }
                    }
                }
            }
            return;
        }
        else{
            if(!MonsterCounters.darkOrbIsDone){
                AbstractMonster newMonster = zorlugaGoreCanArttir(new DarkOrb());
                Application.setCurrentMonster(newMonster);
                yaratikYazisiniYaz(newMonster);
                MonsterCounters.darkOrbSlained--;
            }
            else{
                if(ran.nextInt(101)<=yeniYaratikOlasiligi && !MonsterCounters.theTenebrosityIsStarted){
                    AbstractMonster newMonster = zorlugaGoreCanArttir(new DarkOrb());
                    yaratikYazisiniYaz(newMonster);
                }
                else{
                    if(!MonsterCounters.theTenebrosityIsDone){
                        MonsterCounters.theTenebrosityIsStarted = true;
                        MonsterCounters.theTenebrosityIsDone = true;
                        AbstractMonster newMonster;
                        newMonster = zorlugaGoreCanArttir(new TheTenebrosity());
                        yaratikYazisiniYazBOSS(newMonster);
                        MonsterCounters.theTenebrositySlained--;
                    }
                    else{
                        Application.dovusButonlariniKapa();
                        Application.tumBarlariKapa();
                        Application.statSakla();
                        Application.lbRight.setVisible(false);
                        Application.lbLeft.setVisible(false);
                        Application.lbHit.setVisible(false);
                        Application.lbMiddle.setVisible(true);
                        PanGameListener.cutsceneNo = 999999;
                        Application.btnCutscenes.setVisible(true);
                        Application.btnCutscenes.setText(Strings.endIt);
                        TKUtils.cutsceneTK(Strings.cutsceneENDING, Images.cutENDING, 250, 300).execute();

                    }
                }
            }
            return;
        }


    }

    public static void yaratikYazisiniYaz(AbstractMonster newMonster){
        Application.dovusButonlariniKapa();
        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
        String post = "</pre></html>";
        String[] dizi;
        dizi = Strings.diziyeGecir(pre, Strings.aNewMonsterAppears(newMonster.getName()), post);
        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
        Application.lbDown.setText("");
        Application.setCurrentMonster(newMonster);
        Application.lbRight.setIcon(newMonster.getIcon());
        Application.dovusButonlariniAc();
        Application.updateAllBars();
        Application.updateStats();
    }

    public static void yaratikYazisiniYazBOSS(AbstractMonster newMonster){
        Application.dovusButonlariniKapa();
        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
        String post = "</pre></html>";
        String[] dizi;
        dizi = Strings.diziyeGecir(pre, Strings.aNewMonsterAppearsBOSS(newMonster.getName()), post);
        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
        Application.lbDown.setText("");
        Application.setCurrentMonster(newMonster);
        Application.lbRight.setIcon(newMonster.getIcon());
        Application.dovusButonlariniAc();
        Application.updateAllBars();
        Application.updateStats();
    }

    public static void yaratikYazisiniYazShopaYolla() {
        Application.dovusButonlariniKapa();
        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
        String post = "</pre></html>";
        String[] dizi;
        dizi = Strings.diziyeGecir(pre, Strings.nothingAppears, post);
        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
        Application.lbDown.setText("");
        Application.dovusButonlariniAc();
        Application.updateAllBars();
        Application.updateStats();
        Application.panGame.setVisible(false);
        Application.panShop.setVisible(true);
    }

    public static void yaratikBoolAyarla(){
        if(MonsterCounters.slimeSlained <= 0 )               {
            MonsterCounters.slimeIsDone = true; }
        if(MonsterCounters.skeletonSlained <= 0 )            {
            MonsterCounters.skeletonIsDone = true; }
        if(MonsterCounters.chainedCorpseSlained <= 0 )       {
            MonsterCounters.chainedCorpseIsDone = true; }
        if(MonsterCounters.armoredSkeletonSlained <= 0 )     {
            MonsterCounters.armoredSkeletonIsDone = true; }
        if(MonsterCounters.mummySlained <= 0 )               {
            MonsterCounters.mummyIsDone = true; }
        if(MonsterCounters.armoredChainedCorpseSlained <= 0 ){
            MonsterCounters.armoredChainedCorpseIsDone = true; }
        if(MonsterCounters.inenormisSlained <= 0 )           {
            MonsterCounters.inenormisIsDone = true; }
        if(MonsterCounters.veneficusSlained <= 0 )           {
            MonsterCounters.veneficusIsDone = true; }
        if(MonsterCounters.parilisSlained <= 0 )             {
            MonsterCounters.parilisIsDone = true; }
        if(MonsterCounters.phoenixSlained <= 0 )             {
            MonsterCounters.phoenixIsDone = true; }
        if(MonsterCounters.cerberusSlained <= 0 )            {
            MonsterCounters.cerberusIsDone = true; }
        if(MonsterCounters.hellSpiderSlained <= 0 )          {
            MonsterCounters.hellSpiderIsDone = true; }
        if(MonsterCounters.fireOrbSlained <= 0 )             {
            MonsterCounters.fireOrbIsDone = true; }
        if(MonsterCounters.iceOrbSlained <= 0 )              {
            MonsterCounters.iceOrbIsDone = true; }
        if(MonsterCounters.darkOrbSlained <= 0 )             {
            MonsterCounters.darkOrbIsDone = true; }
    }

    public static void itemIcinYazma(String s){
        Application.dovusButonlariniKapa();
        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
        String post = "</pre></html>";
        String[] dizi;
        dizi = Strings.diziyeGecir(pre, s, post);
        TKUtils.animas_TK(dizi, Application.lbDown, 250, 100).execute();
        TKUtils.sleepMilisecs(1500 + dizi.length * 250);
        Application.lbDown.setText("");
        Application.updateAllBars();
        Application.updateStats();
        Application.invGuncelle();
    }

    public static void asagiSiraylaYaz(String s){
        itemIcinYazma(s);
        Application.dovusButonlariniAc();
    }

    public static void itemKullanma(String id) {
        if(id == "smallHP"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkSmallHP);
                    return null;
                }
            }.execute();
        }
        else if(id == "mediumHP"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkMediumHP);
                    return null;
                }
            }.execute();
        }
        else if(id == "largeHP"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkLargeHP);
                    return null;
                }
            }.execute();
        }
        else if(id == "smallRegen"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkSmallRegen);
                    return null;
                }
            }.execute();
        }
        else if(id == "mediumRegen"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkMediumRegen);
                    return null;
                }
            }.execute();
        }
        else if(id == "largeRegen"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkLargeRegen);
                    return null;
                }
            }.execute();
        }
        else if(id == "water"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkWater);
                    return null;
                }
            }.execute();
        }
        else if(id == "strength"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkStrength);
                    return null;
                }
            }.execute();
        }
        else if(id == "antivenom"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkAntivenom);
                    return null;
                }
            }.execute();
        }
        else if(id == "speed"){
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    itemIcinYazma(Strings.drinkSpeed);
                    return null;
                }
            }.execute();
        }

    }

    public static int itemKullanmayaGoreUzunluk(String id) {
        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
        String post = "</pre></html>";
        if(id == "smallHP"){ return Strings.diziyeGecir(pre, Strings.drinkSmallHP, post).length; }
        else if(id == "mediumHP"){ return Strings.diziyeGecir(pre, Strings.drinkMediumHP, post).length; }
        else if(id == "largeHP"){ return Strings.diziyeGecir(pre, Strings.drinkLargeHP, post).length; }
        else if(id == "smallRegen"){ return Strings.diziyeGecir(pre, Strings.drinkSmallRegen, post).length; }
        else if(id == "mediumRegen"){ return Strings.diziyeGecir(pre, Strings.drinkMediumRegen, post).length; }
        else if(id == "largeRegen"){ return Strings.diziyeGecir(pre, Strings.drinkLargeRegen, post).length; }
        else if(id == "water"){ return Strings.diziyeGecir(pre, Strings.drinkWater, post).length; }
        else if(id == "strength"){ return Strings.diziyeGecir(pre, Strings.drinkStrength, post).length; }
        else if(id == "antivenom"){ return Strings.diziyeGecir(pre, Strings.drinkAntivenom, post).length; }
        else if(id == "speed"){ return Strings.diziyeGecir(pre, Strings.drinkSpeed, post).length; }
        return -1;
    }

} // en son ayrac
