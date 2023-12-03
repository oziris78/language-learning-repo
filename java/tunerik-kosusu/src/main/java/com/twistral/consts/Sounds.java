package com.twistral.consts;


import com.twistral.utils.ClipUtils;
import com.twistral.utils.ResourceUtils;
import com.twistral.entities.normal.IceOrb;
import com.twistral.main.*;
import com.twistral.main.Main;
import com.twistral.entities.*;

import javax.sound.sampled.*;
import javax.swing.*;
import com.twistral.entities.normal.*;
import com.twistral.entities.bosses.*;


public class Sounds {

    public static Clip clipMenuClick1, clipMenuClick2, clipMenuClick3, clipFailed, clipSwitch1, clipSwitch2, clipSwitch3, clipSwitch4,
                       clipHitMissed, clipMeleeHit ,clipMeleeHitCrit ,clipRangedHit, clipRangedHitCrit,
                       clipYaratikVurduslime, clipYaratikVurduarmoredChainedCorpse, clipYaratikVurduskeleton, clipYaratikVurduchainedCorpse,
                       clipYaratikVurduarmoredSkeleton, clipYaratikVurdumummy, clipYaratikVurduinenormisAranea, clipYaratikVurduveneficusAranea,
                       clipYaratikVurduparilisAranea, clipYaratikVurduphoenix, clipYaratikVurducerberus, clipYaratikVurduhellSpider,
                       clipYaratikVurdudarkOrb, clipYaratikVurduiceOrb, clipYaratikVurdublueSlime, clipYaratikVurdueunectes,
                       clipYaratikVurduyek, clipYaratikVurdutheTenebrosity, clipYaratikVurulduslime, clipYaratikVurulduarmoredChainedCorpse,
                       clipYaratikVurulduskeleton, clipYaratikVurulduchainedCorpse, clipYaratikVurulduarmoredSkeleton, clipYaratikVuruldumummy,
                       clipYaratikVurulduinenormisAranea, clipYaratikVurulduveneficusAranea, clipYaratikVurulduparilisAranea,
                       clipYaratikVurulducerberus, clipYaratikVurulduhellSpider, clipYaratikVuruldufireOrb, clipYaratikVuruldudarkOrb,
                       clipYaratikVuruldublueSlime, clipYaratikVuruldueunectes, clipYaratikVuruldutheraphoseBlondi, clipYaratikVurulduyek,
                       clipYaratikVuruldutheTenebrosity, clipYaratikOlduslime, clipYaratikOlduarmoredChainedCorpse, clipYaratikOlduskeleton,
                       clipYaratikOlduchainedCorpse, clipYaratikOlduarmoredSkeleton, clipYaratikOldumummy, clipYaratikOlduinenormisAranea,
                       clipYaratikOlduveneficusAranea, clipYaratikOlduparilisAranea, clipYaratikOlduphoenix, clipYaratikOlducerberus,
                       clipYaratikOlduhellSpider, clipYaratikOldufireOrb, clipYaratikOldudarkOrb, clipYaratikOlduiceOrb,
                       clipYaratikOldueunectes, clipYaratikOldutheraphoseBlondi, clipYaratikOlduyek, clipYaratikOldutheTenebrosity,
                       clipYaratikVurulduiceOrb, clipYaratikVurdutheraphoseBlondi, clipYaratikVurdufireOrb,
                       clipYaratikVurulduphoenix,clipYaratikOldublueSlime, clipAycaOldu, clipTekinOldu, clipAycaVuruldu, clipTekinVuruldu,
                       clipBetiBulma, clipBuy1, clipBuy2, clipBuy3, clipPotIcme, clipBleedingUyg, clipBleedingVerilme, clipSlownessUyg,
                       clipSlownessVerilme, clipBurningUyg, clipBurningVerilme, clipNoDefenseUyg, clipNoDefenseVerilme, clipTenebCanBasma,
                       clipRegenUyg, clipStrengthUyg;

    public static Clip[] sfxArray, musicArray;


    static {
        try{
            clipMenuClick1 = ResourceUtils.getClip(Main.class.getResource("/res/menuClick.wav"));
            clipMenuClick2 = ResourceUtils.getClip(Main.class.getResource("/res/menuClick.wav"));
            clipMenuClick3 = ResourceUtils.getClip(Main.class.getResource("/res/menuClick.wav"));
            clipFailed = ResourceUtils.getClip(Main.class.getResource("/res/basarisiz.wav"));
            clipBetiBulma = ResourceUtils.getClip(Main.class.getResource("/res/betiBulma.wav"));
            clipPotIcme = ResourceUtils.getClip(Main.class.getResource("/res/icme.wav"));
            clipBuy1 = ResourceUtils.getClip(Main.class.getResource("/res/buySomething.wav"));
            clipBuy2 = ResourceUtils.getClip(Main.class.getResource("/res/buySomething.wav"));
            clipBuy3 = ResourceUtils.getClip(Main.class.getResource("/res/buySomething.wav"));
            clipSwitch1 = ResourceUtils.getClip(Main.class.getResource("/res/switch.wav"));
            clipSwitch2 = ResourceUtils.getClip(Main.class.getResource("/res/switch.wav"));
            clipSwitch3 = ResourceUtils.getClip(Main.class.getResource("/res/switch.wav"));
            clipSwitch4 = ResourceUtils.getClip(Main.class.getResource("/res/switch.wav"));
            clipBleedingUyg = ResourceUtils.getClip(Main.class.getResource("/res/bleedingUygulanma.wav"));
            clipBleedingVerilme = ResourceUtils.getClip(Main.class.getResource("/res/bleedingVerilme.wav"));
            clipSlownessUyg = ResourceUtils.getClip(Main.class.getResource("/res/slownessUygulanma.wav"));
            clipSlownessVerilme = ResourceUtils.getClip(Main.class.getResource("/res/slownessVerilme.wav"));
            clipBurningUyg = ResourceUtils.getClip(Main.class.getResource("/res/burningUygulanma.wav"));
            clipBurningVerilme = ResourceUtils.getClip(Main.class.getResource("/res/burningVerilme.wav"));
            clipNoDefenseUyg = ResourceUtils.getClip(Main.class.getResource("/res/noDefenseUygulanma.wav"));
            clipNoDefenseVerilme = ResourceUtils.getClip(Main.class.getResource("/res/noDefenseVerilme.wav"));
            clipTenebCanBasma = ResourceUtils.getClip(Main.class.getResource("/res/tenebCanBasma.wav"));
            clipRegenUyg = ResourceUtils.getClip(Main.class.getResource("/res/regenUygulanma.wav"));
            clipStrengthUyg = ResourceUtils.getClip(Main.class.getResource("/res/strengthUygulanma.wav"));
            clipYaratikVurduarmoredChainedCorpse  = ResourceUtils.getClip(Main.class.getResource("/res/11.wav"));
            clipYaratikVurduslime  = ResourceUtils.getClip(Main.class.getResource("/res/12.wav"));
            clipYaratikVurduskeleton  = ResourceUtils.getClip(Main.class.getResource("/res/13.wav"));
            clipYaratikVurduchainedCorpse  = ResourceUtils.getClip(Main.class.getResource("/res/14.wav"));
            clipYaratikVurduarmoredSkeleton  = ResourceUtils.getClip(Main.class.getResource("/res/15.wav"));
            clipYaratikVurdumummy  = ResourceUtils.getClip(Main.class.getResource("/res/16.wav"));
            clipYaratikVurduinenormisAranea  = ResourceUtils.getClip(Main.class.getResource("/res/17.wav"));
            clipYaratikVurduveneficusAranea  = ResourceUtils.getClip(Main.class.getResource("/res/18.wav"));
            clipYaratikVurduparilisAranea  = ResourceUtils.getClip(Main.class.getResource("/res/19.wav"));
            clipYaratikVurduphoenix  = ResourceUtils.getClip(Main.class.getResource("/res/20.wav"));
            clipYaratikVurducerberus  = ResourceUtils.getClip(Main.class.getResource("/res/21.wav"));
            clipYaratikVurduhellSpider  = ResourceUtils.getClip(Main.class.getResource("/res/22.wav"));
            clipYaratikVurdufireOrb  = ResourceUtils.getClip(Main.class.getResource("/res/23.wav"));
            clipYaratikVurdudarkOrb  = ResourceUtils.getClip(Main.class.getResource("/res/24.wav"));
            clipYaratikVurduiceOrb  = ResourceUtils.getClip(Main.class.getResource("/res/25.wav"));
            clipYaratikVurdublueSlime  = ResourceUtils.getClip(Main.class.getResource("/res/26.wav"));
            clipYaratikVurdueunectes  = ResourceUtils.getClip(Main.class.getResource("/res/27.wav"));
            clipYaratikVurdutheraphoseBlondi  = ResourceUtils.getClip(Main.class.getResource("/res/28.wav"));
            clipYaratikVurduyek  = ResourceUtils.getClip(Main.class.getResource("/res/29.wav"));
            clipYaratikVurdutheTenebrosity  = ResourceUtils.getClip(Main.class.getResource("/res/30.wav"));
            clipYaratikVurulduslime  = ResourceUtils.getClip(Main.class.getResource("/res/31.wav"));
            clipYaratikVurulduarmoredChainedCorpse  = ResourceUtils.getClip(Main.class.getResource("/res/32.wav"));
            clipYaratikVurulduskeleton  = ResourceUtils.getClip(Main.class.getResource("/res/33.wav"));
            clipYaratikVurulduchainedCorpse  = ResourceUtils.getClip(Main.class.getResource("/res/34.wav"));
            clipYaratikVurulduarmoredSkeleton  = ResourceUtils.getClip(Main.class.getResource("/res/35.wav"));
            clipYaratikVuruldumummy  = ResourceUtils.getClip(Main.class.getResource("/res/36.wav"));
            clipYaratikVurulduinenormisAranea  = ResourceUtils.getClip(Main.class.getResource("/res/37.wav"));
            clipYaratikVurulduveneficusAranea  = ResourceUtils.getClip(Main.class.getResource("/res/38.wav"));
            clipYaratikVurulduparilisAranea  = ResourceUtils.getClip(Main.class.getResource("/res/39.wav"));
            clipYaratikVurulduphoenix  = ResourceUtils.getClip(Main.class.getResource("/res/40.wav"));
            clipYaratikVurulducerberus  = ResourceUtils.getClip(Main.class.getResource("/res/41.wav"));
            clipYaratikVurulduhellSpider  = ResourceUtils.getClip(Main.class.getResource("/res/42.wav"));
            clipYaratikVuruldufireOrb  = ResourceUtils.getClip(Main.class.getResource("/res/43.wav"));
            clipYaratikVuruldudarkOrb  = ResourceUtils.getClip(Main.class.getResource("/res/44.wav"));
            clipYaratikVurulduiceOrb  = ResourceUtils.getClip(Main.class.getResource("/res/45.wav"));
            clipYaratikVuruldublueSlime  = ResourceUtils.getClip(Main.class.getResource("/res/46.wav"));
            clipYaratikVuruldueunectes  = ResourceUtils.getClip(Main.class.getResource("/res/47.wav"));
            clipYaratikVuruldutheraphoseBlondi  = ResourceUtils.getClip(Main.class.getResource("/res/48.wav"));
            clipYaratikVurulduyek  = ResourceUtils.getClip(Main.class.getResource("/res/49.wav"));
            clipYaratikVuruldutheTenebrosity  = ResourceUtils.getClip(Main.class.getResource("/res/50.wav"));
            clipYaratikOlduslime  = ResourceUtils.getClip(Main.class.getResource("/res/51.wav"));
            clipYaratikOlduarmoredChainedCorpse  = ResourceUtils.getClip(Main.class.getResource("/res/52.wav"));
            clipYaratikOlduskeleton  = ResourceUtils.getClip(Main.class.getResource("/res/53.wav"));
            clipYaratikOlduchainedCorpse  = ResourceUtils.getClip(Main.class.getResource("/res/54.wav"));
            clipYaratikOlduarmoredSkeleton  = ResourceUtils.getClip(Main.class.getResource("/res/55.wav"));
            clipYaratikOldumummy  = ResourceUtils.getClip(Main.class.getResource("/res/56.wav"));
            clipYaratikOlduinenormisAranea  = ResourceUtils.getClip(Main.class.getResource("/res/57.wav"));
            clipYaratikOlduveneficusAranea  = ResourceUtils.getClip(Main.class.getResource("/res/58.wav"));
            clipYaratikOlduparilisAranea  = ResourceUtils.getClip(Main.class.getResource("/res/59.wav"));
            clipYaratikOlduphoenix  = ResourceUtils.getClip(Main.class.getResource("/res/60.wav"));
            clipYaratikOlducerberus  = ResourceUtils.getClip(Main.class.getResource("/res/61.wav"));
            clipYaratikOlduhellSpider  = ResourceUtils.getClip(Main.class.getResource("/res/62.wav"));
            clipYaratikOldufireOrb  = ResourceUtils.getClip(Main.class.getResource("/res/63.wav"));
            clipYaratikOldudarkOrb  = ResourceUtils.getClip(Main.class.getResource("/res/64.wav"));
            clipYaratikOlduiceOrb  = ResourceUtils.getClip(Main.class.getResource("/res/65.wav"));
            clipYaratikOldublueSlime  = ResourceUtils.getClip(Main.class.getResource("/res/66.wav"));
            clipYaratikOldueunectes  = ResourceUtils.getClip(Main.class.getResource("/res/67.wav"));
            clipYaratikOldutheraphoseBlondi  = ResourceUtils.getClip(Main.class.getResource("/res/68.wav"));
            clipYaratikOlduyek  = ResourceUtils.getClip(Main.class.getResource("/res/69.wav"));
            clipYaratikOldutheTenebrosity = ResourceUtils.getClip(Main.class.getResource("/res/70.wav"));
            clipHitMissed = ResourceUtils.getClip(Main.class.getResource("/res/101.wav"));
            clipMeleeHit = ResourceUtils.getClip(Main.class.getResource("/res/103.wav"));
            clipMeleeHitCrit = ResourceUtils.getClip(Main.class.getResource("/res/104.wav"));
            clipRangedHit = ResourceUtils.getClip(Main.class.getResource("/res/105.wav"));
            clipRangedHitCrit = ResourceUtils.getClip(Main.class.getResource("/res/106.wav"));
            clipAycaOldu = ResourceUtils.getClip(Main.class.getResource("/res/1004.wav"));
            clipTekinOldu = ResourceUtils.getClip(Main.class.getResource("/res/1001.wav"));
            clipAycaVuruldu = ResourceUtils.getClip(Main.class.getResource("/res/1002.wav"));
            clipTekinVuruldu = ResourceUtils.getClip(Main.class.getResource("/res/1003.wav"));


            sfxArray = new Clip[] {clipMenuClick1, clipMenuClick2, clipMenuClick3, clipFailed, clipSwitch1, clipSwitch2, clipSwitch3, clipSwitch4,
                    clipHitMissed, clipMeleeHit ,clipMeleeHitCrit ,clipRangedHit, clipRangedHitCrit,
                    clipYaratikVurduslime, clipYaratikVurduarmoredChainedCorpse, clipYaratikVurduskeleton, clipYaratikVurduchainedCorpse,
                    clipYaratikVurduarmoredSkeleton, clipYaratikVurdumummy, clipYaratikVurduinenormisAranea, clipYaratikVurduveneficusAranea,
                    clipYaratikVurduparilisAranea, clipYaratikVurduphoenix, clipYaratikVurducerberus, clipYaratikVurduhellSpider,
                    clipYaratikVurdudarkOrb, clipYaratikVurduiceOrb, clipYaratikVurdublueSlime, clipYaratikVurdueunectes,
                    clipYaratikVurduyek, clipYaratikVurdutheTenebrosity, clipYaratikVurulduslime, clipYaratikVurulduarmoredChainedCorpse,
                    clipYaratikVurulduskeleton, clipYaratikVurulduchainedCorpse, clipYaratikVurulduarmoredSkeleton, clipYaratikVuruldumummy,
                    clipYaratikVurulduinenormisAranea, clipYaratikVurulduveneficusAranea, clipYaratikVurulduparilisAranea,
                    clipYaratikVurulducerberus, clipYaratikVurulduhellSpider, clipYaratikVuruldufireOrb, clipYaratikVuruldudarkOrb,
                    clipYaratikVuruldublueSlime, clipYaratikVuruldueunectes, clipYaratikVuruldutheraphoseBlondi, clipYaratikVurulduyek,
                    clipYaratikVuruldutheTenebrosity, clipYaratikOlduslime, clipYaratikOlduarmoredChainedCorpse, clipYaratikOlduskeleton,
                    clipYaratikOlduchainedCorpse, clipYaratikOlduarmoredSkeleton, clipYaratikOldumummy, clipYaratikOlduinenormisAranea,
                    clipYaratikOlduveneficusAranea, clipYaratikOlduparilisAranea, clipYaratikOlduphoenix, clipYaratikOlducerberus,
                    clipYaratikOlduhellSpider, clipYaratikOldufireOrb, clipYaratikOldudarkOrb, clipYaratikOlduiceOrb,
                    clipYaratikOldueunectes, clipYaratikOldutheraphoseBlondi, clipYaratikOlduyek, clipYaratikOldutheTenebrosity,
                    clipYaratikVurulduiceOrb, clipYaratikVurdutheraphoseBlondi, clipYaratikVurdufireOrb,
                    clipYaratikVurulduphoenix,clipYaratikOldublueSlime, clipAycaOldu, clipTekinOldu, clipAycaVuruldu, clipTekinVuruldu,
                    clipBetiBulma, clipBuy1, clipBuy2, clipBuy3, clipPotIcme};

            musicArray = new Clip[] {clipBuy1};  //clipBuy1 silinecek oylesine ekledim

            ClipUtils.setVolumeToClips(Sounds.sfxArray, 0.25d);
            ClipUtils.setVolumeToClips(Sounds.musicArray, 0.25d);
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Seslerde sorun cikti", "ERROR #002", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void oyuncuOlmeSesiVeGameOver(){
        if(Application.getPlayer().getCharacterImage().equals(Images.ayca)){
            ClipUtils.playClip(Sounds.clipAycaOldu);
        }
        else{ //tekin sesi
            ClipUtils.playClip(Sounds.clipTekinOldu);
        }
    }

    public static void oyuncuVurulduSesi(){
        if(Application.getPlayer().getCharacterImage().equals(Images.ayca)){
            ClipUtils.playClip(Sounds.clipAycaVuruldu);
        }
        else{ //tekin sesi
            ClipUtils.playClip(Sounds.clipTekinVuruldu);
        }
    }

    public static void vurusKacirildiSesi(){ ClipUtils.playClip(Sounds.clipHitMissed); } // tek ses

    public static void oyuncuVurduSesi(boolean isCritical, String type){ // tek ses
        if(isCritical && type=="melee"){ // crit melee atilma sesi
            ClipUtils.playClip(Sounds.clipMeleeHitCrit);
        }
        else if(type=="melee"){ // crit olmadan melee sesi
            ClipUtils.playClip(Sounds.clipMeleeHit);
        }
        else if(isCritical && type=="ranged"){ // crit ile ranged vurma sesi
            ClipUtils.playClip(Sounds.clipRangedHitCrit);
        }
        else if(type=="ranged"){ // crit olmadan ranged vurma sesi
            ClipUtils.playClip(Sounds.clipRangedHit);
        }

    }

    public static void yaratikOlduSesi(AbstractMonster m){
        if(m.getClass() == Slime.class)                        ClipUtils.playClip(Sounds.clipYaratikOlduslime);
        else if(m.getClass() == Skeleton.class)                ClipUtils.playClip(Sounds.clipYaratikOlduskeleton);
        else if(m.getClass() == ChainedCorpse.class)           ClipUtils.playClip(Sounds.clipYaratikOlduchainedCorpse);
        else if(m.getClass() == ArmoredSkeleton.class)         ClipUtils.playClip(Sounds.clipYaratikOlduarmoredSkeleton);
        else if(m.getClass() == Mummy.class)                   ClipUtils.playClip(Sounds.clipYaratikOldumummy);
        else if(m.getClass() == ArmoredChainedCorpse.class)    ClipUtils.playClip(Sounds.clipYaratikOlduarmoredChainedCorpse);
        else if(m.getClass() == InenormisAranea.class)         ClipUtils.playClip(Sounds.clipYaratikOlduinenormisAranea);
        else if(m.getClass() == VeneficusAranea.class)         ClipUtils.playClip(Sounds.clipYaratikOlduveneficusAranea);
        else if(m.getClass() == ParilisAranea.class)           ClipUtils.playClip(Sounds.clipYaratikOlduparilisAranea);
        else if(m.getClass() == Phoenix.class)                 ClipUtils.playClip(Sounds.clipYaratikOlduphoenix);
        else if(m.getClass() == Cerberus.class)                ClipUtils.playClip(Sounds.clipYaratikOlducerberus);
        else if(m.getClass() == HellSpider.class)              ClipUtils.playClip(Sounds.clipYaratikOlduhellSpider);
        else if(m.getClass() == FireOrb.class)                 ClipUtils.playClip(Sounds.clipYaratikOldufireOrb);
        else if(m.getClass() == DarkOrb.class)                 ClipUtils.playClip(Sounds.clipYaratikOldudarkOrb);
        else if(m.getClass() == IceOrb.class)                  ClipUtils.playClip(Sounds.clipYaratikOlduiceOrb);
        else if(m.getClass() == BlueSlime.class)               ClipUtils.playClip(Sounds.clipYaratikOldublueSlime);
        else if(m.getClass() == Eunectes.class)                ClipUtils.playClip(Sounds.clipYaratikOldueunectes);
        else if(m.getClass() == TheraphoseBlondi.class)        ClipUtils.playClip(Sounds.clipYaratikOldutheraphoseBlondi);
        else if(m.getClass() == Yek.class)                     ClipUtils.playClip(Sounds.clipYaratikOlduyek);
        else if(m.getClass() == TheTenebrosity.class)          ClipUtils.playClip(Sounds.clipYaratikOldutheTenebrosity);
    }

    public static void yaratikVurulduSesi(AbstractMonster m){
        if(m.getClass() == Slime.class)                        { ClipUtils.playClip(Sounds.clipYaratikVurulduslime); }
        else if(m.getClass() == Skeleton.class)                { ClipUtils.playClip(Sounds.clipYaratikVurulduskeleton); }
        else if(m.getClass() == ChainedCorpse.class)           { ClipUtils.playClip(Sounds.clipYaratikVurulduchainedCorpse); }
        else if(m.getClass() == ArmoredSkeleton.class)         { ClipUtils.playClip(Sounds.clipYaratikVurulduarmoredSkeleton); }
        else if(m.getClass() == Mummy.class)                   { ClipUtils.playClip(Sounds.clipYaratikVuruldumummy); }
        else if(m.getClass() == ArmoredChainedCorpse.class)    { ClipUtils.playClip(Sounds.clipYaratikVurulduarmoredChainedCorpse); }
        else if(m.getClass() == InenormisAranea.class)         { ClipUtils.playClip(Sounds.clipYaratikVurulduinenormisAranea); }
        else if(m.getClass() == VeneficusAranea.class)         { ClipUtils.playClip(Sounds.clipYaratikVurulduveneficusAranea); }
        else if(m.getClass() == ParilisAranea.class)           { ClipUtils.playClip(Sounds.clipYaratikVurulduparilisAranea); }
        else if(m.getClass() == Phoenix.class)                 { ClipUtils.playClip(Sounds.clipYaratikVurulduphoenix); }
        else if(m.getClass() == Cerberus.class)                { ClipUtils.playClip(Sounds.clipYaratikVurulducerberus); }
        else if(m.getClass() == HellSpider.class)              { ClipUtils.playClip(Sounds.clipYaratikVurulduhellSpider); }
        else if(m.getClass() == FireOrb.class)                 { ClipUtils.playClip(Sounds.clipYaratikVuruldufireOrb); }
        else if(m.getClass() == DarkOrb.class)                 { ClipUtils.playClip(Sounds.clipYaratikVuruldudarkOrb); }
        else if(m.getClass() == IceOrb.class)                  { ClipUtils.playClip(Sounds.clipYaratikVurulduiceOrb); }
        else if(m.getClass() == BlueSlime.class)               { ClipUtils.playClip(Sounds.clipYaratikVuruldublueSlime); }
        else if(m.getClass() == Eunectes.class)                { ClipUtils.playClip(Sounds.clipYaratikVuruldueunectes); }
        else if(m.getClass() == TheraphoseBlondi.class)        { ClipUtils.playClip(Sounds.clipYaratikVuruldutheraphoseBlondi); }
        else if(m.getClass() == Yek.class)                     { ClipUtils.playClip(Sounds.clipYaratikVurulduyek); }
        else if(m.getClass() == TheTenebrosity.class)          { ClipUtils.playClip(Sounds.clipYaratikVuruldutheTenebrosity); }
    }

    public static void yaratikVurduSesi(AbstractMonster m){
        if(m.getClass() == Slime.class)                        ClipUtils.playClip(Sounds.clipYaratikVurduslime);
        else if(m.getClass() == Skeleton.class)                ClipUtils.playClip(Sounds.clipYaratikVurduskeleton);
        else if(m.getClass() == ChainedCorpse.class)           ClipUtils.playClip(Sounds.clipYaratikVurduchainedCorpse);
        else if(m.getClass() == ArmoredSkeleton.class)         ClipUtils.playClip(Sounds.clipYaratikVurduarmoredSkeleton);
        else if(m.getClass() == Mummy.class)                   ClipUtils.playClip(Sounds.clipYaratikVurdumummy);
        else if(m.getClass() == ArmoredChainedCorpse.class)    ClipUtils.playClip(Sounds.clipYaratikVurduarmoredChainedCorpse);
        else if(m.getClass() == InenormisAranea.class)         ClipUtils.playClip(Sounds.clipYaratikVurduinenormisAranea);
        else if(m.getClass() == VeneficusAranea.class)         ClipUtils.playClip(Sounds.clipYaratikVurduveneficusAranea);
        else if(m.getClass() == ParilisAranea.class)           ClipUtils.playClip(Sounds.clipYaratikVurduparilisAranea);
        else if(m.getClass() == Phoenix.class)                 ClipUtils.playClip(Sounds.clipYaratikVurduphoenix);
        else if(m.getClass() == Cerberus.class)                ClipUtils.playClip(Sounds.clipYaratikVurducerberus);
        else if(m.getClass() == HellSpider.class)              ClipUtils.playClip(Sounds.clipYaratikVurduhellSpider);
        else if(m.getClass() == FireOrb.class)                 ClipUtils.playClip(Sounds.clipYaratikVurdufireOrb);
        else if(m.getClass() == DarkOrb.class)                 ClipUtils.playClip(Sounds.clipYaratikVurdudarkOrb);
        else if(m.getClass() == IceOrb.class)                  ClipUtils.playClip(Sounds.clipYaratikVurduiceOrb);
        else if(m.getClass() == BlueSlime.class)               ClipUtils.playClip(Sounds.clipYaratikVurdublueSlime);
        else if(m.getClass() == Eunectes.class)                ClipUtils.playClip(Sounds.clipYaratikVurdueunectes);
        else if(m.getClass() == TheraphoseBlondi.class)        ClipUtils.playClip(Sounds.clipYaratikVurdutheraphoseBlondi);
        else if(m.getClass() == Yek.class)                     ClipUtils.playClip(Sounds.clipYaratikVurduyek);
        else if(m.getClass() == TheTenebrosity.class)          ClipUtils.playClip(Sounds.clipYaratikVurdutheTenebrosity);
    }

}
