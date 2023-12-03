package com.twistral.consts;

import com.twistral.utils.ResourceUtils;
import com.twistral.main.Main;

import javax.swing.*;

public class Images {

    public static ImageIcon bg1;

    public static ImageIcon appTitle, ayca, btnMenu, btnMenuClick, btnMenuHover, cog, cogKirmizi, gameIcon, radio,
                            radioHover, cogKara, cut1, cut2, cut3, cut4, cut5,
                            radioSelected, slime, tekin, hitIcon, statMeleeDamage, statMeleeCrit, statRangedDamage, statRangedCrit,
                            statEvade, statDefense, statMoney, skeleton, armoredChainedCorpse, chainedCorpse, armoredSkeleton,
                            mummy, inenormisAranea, veneficusAranea, parilisAranea, phoenix, cerberus, hellSpider, fireOrb,
                            iceOrb, darkOrb, blueSlime, yek, eunectes, theraphoseBlondi, theTenebrosityTEKIN, theTenebrosityAYCA,
                            woodenClub, woodenBow, leatherChestplate, smallHealthPotion, woodenSword, shuriken, leatherHelmet,
                            mediumHealthPotion, medievalAxe, reinforcedBow, silverChestplate, largeHealthPotion, shortSword, crossbow,
                            silverHelmet, smallRegenerationPotion, knightsSword, kunai, bronzeChestplate, mediumRegenerationPotion,
                            paladinsSword, onzil, bronzeHelmet, largeRegenerationPotion, hellSword, hellBow, obsidianChestplate,
                            waterBottle, odrokus, alav, obsidianHelmet, strengthPotion, vinegriand, vineregen, darkRobe, antivenom,
                            zugoron, kotperes, darkHeart, speedPotion, woodenClubAcik, woodenSwordAcik, medievalAxeAcik, shortSwordAcik,
                            knightsSwordAcik, paladinsSwordAcik, hellSwordAcik, odrokusAcik, vinegriandAcik, zugoronAcik, woodenBowAcik,
                            shurikenAcik, reinforcedBowAcik, crossbowAcik, kunaiAcik, onzilAcik, hellBowAcik, alavAcik, vineregenAcik,
                            kotperesAcik, leatherChestplateAcik, leatherHelmetAcik, silverChestplateAcik, silverHelmetAcik, bronzeChestplateAcik,
                            bronzeHelmetAcik, obsidianChestplateAcik, obsidianHelmetAcik, darkRobeAcik, darkHeartAcik, smallHealthPotionAcik,
                            mediumHealthPotionAcik, largeHealthPotionAcik, smallRegenerationPotionAcik, mediumRegenerationPotionAcik,
                            largeRegenerationPotionAcik, waterBottleAcik, strengthPotionAcik, antivenomAcik, speedPotionAcik,
                            woodenClubKapali, woodenSwordKapali, medievalAxeKapali, shortSwordKapali, knightsSwordKapali, paladinsSwordKapali,
                            hellSwordKapali, odrokusKapali, vinegriandKapali, zugoronKapali, woodenBowKapali, shurikenKapali,
                            reinforcedBowKapali, crossbowKapali, kunaiKapali, onzilKapali, hellBowKapali, alavKapali,
                            vineregenKapali, kotperesKapali, leatherChestplateKapali, leatherHelmetKapali, silverChestplateKapali,
                            silverHelmetKapali, bronzeChestplateKapali, bronzeHelmetKapali, obsidianChestplateKapali, obsidianHelmetKapali,
                            darkRobeKapali, darkHeartKapali, smallHealthPotionKapali, mediumHealthPotionKapali, largeHealthPotionKapali,
                            smallRegenerationPotionKapali, mediumRegenerationPotionKapali, largeRegenerationPotionKapali, waterBottleKapali,
                            strengthPotionKapali, antivenomKapali, speedPotionKapali, cutENDING;

    static {
        bg1                       = ResourceUtils.getImageIcon(Main.class.getResource("/res/artalan1.png"));
        appTitle                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/appTitle.png"));
        ayca                      = ResourceUtils.getImageIcon(Main.class.getResource("/res/ayca.png"));
        tekin                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/tekin.png"));
        btnMenu                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/btnMenu.png"));
        btnMenuClick              = ResourceUtils.getImageIcon(Main.class.getResource("/res/btnMenuClick.png"));
        btnMenuHover              = ResourceUtils.getImageIcon(Main.class.getResource("/res/btnMenuHover.png"));
        cog                       = ResourceUtils.getImageIcon(Main.class.getResource("/res/cog.png"));
        cogKirmizi                = ResourceUtils.getImageIcon(Main.class.getResource("/res/cogKirmizi.png"));
        cogKara                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/cogKara.png"));
        gameIcon                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/gameIcon.png"));
        radio                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/radio.png"));
        radioHover                = ResourceUtils.getImageIcon(Main.class.getResource("/res/radioHover.png"));
        radioSelected             = ResourceUtils.getImageIcon(Main.class.getResource("/res/radioSelected.png"));
        cut1                      = ResourceUtils.getImageIcon(Main.class.getResource("/res/cut1.png"));
        cut2                      = ResourceUtils.getImageIcon(Main.class.getResource("/res/cut2.png"));
        cut3                      = ResourceUtils.getImageIcon(Main.class.getResource("/res/cut3.png"));
        cut4                      = cut1;
        cut5                      = ResourceUtils.getImageIcon(Main.class.getResource("/res/cut4.png"));
        hitIcon                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/hitImage.png"));
        statMeleeDamage           = ResourceUtils.getImageIcon(Main.class.getResource("/res/melDam.png"));
        statMeleeCrit             = ResourceUtils.getImageIcon(Main.class.getResource("/res/melCrit.png"));
        statRangedDamage          = ResourceUtils.getImageIcon(Main.class.getResource("/res/ranDam.png"));
        statRangedCrit            = ResourceUtils.getImageIcon(Main.class.getResource("/res/ranCrit.png"));
        statEvade                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/evade.png"));
        statDefense               = ResourceUtils.getImageIcon(Main.class.getResource("/res/defense.png"));
        statMoney                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/money.png"));
        // yaratiklar (21 adet, 20 yaratik var the tenebrosity iki gorsel)
        slime                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/slime.png"));
        skeleton                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/skeleton.png"));
        armoredChainedCorpse      = ResourceUtils.getImageIcon(Main.class.getResource("/res/armoredChainedCorpse.png"));
        chainedCorpse             = ResourceUtils.getImageIcon(Main.class.getResource("/res/chainedCorpse.png"));
        armoredSkeleton           = ResourceUtils.getImageIcon(Main.class.getResource("/res/armoredSkeleton.png"));
        mummy                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/mummy.png"));
        inenormisAranea           = ResourceUtils.getImageIcon(Main.class.getResource("/res/inenormisAranea.png"));
        veneficusAranea           = ResourceUtils.getImageIcon(Main.class.getResource("/res/veneficusAranea.png"));
        parilisAranea             = ResourceUtils.getImageIcon(Main.class.getResource("/res/parilisAranea.png"));
        phoenix                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/phoenix.png"));
        cerberus                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/cerberus.png"));
        hellSpider                = ResourceUtils.getImageIcon(Main.class.getResource("/res/hellSpider.png"));
        fireOrb                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/fireOrb.png"));
        iceOrb                    = ResourceUtils.getImageIcon(Main.class.getResource("/res/iceOrb.png"));
        darkOrb                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/darkOrb.png"));
        blueSlime                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/blueSlime.png"));
        yek                       = ResourceUtils.getImageIcon(Main.class.getResource("/res/yek.png"));
        eunectes                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/eunectes.png"));
        theraphoseBlondi          = ResourceUtils.getImageIcon(Main.class.getResource("/res/theraphoseBlondi.png"));
        theTenebrosityTEKIN       = ResourceUtils.getImageIcon(Main.class.getResource("/res/theTenebrosityTEKIN.png"));
        theTenebrosityAYCA        = ResourceUtils.getImageIcon(Main.class.getResource("/res/theTenebrosityAYCA.png"));


        // shop
        woodenClub                = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenClub.png"));
        woodenBow                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenBow.png"));
        leatherChestplate         = ResourceUtils.getImageIcon(Main.class.getResource("/res/leatherChestplate.png"));
        smallHealthPotion         = ResourceUtils.getImageIcon(Main.class.getResource("/res/smallHealthPotion.png"));
        woodenSword               = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenSword.png"));
        shuriken                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/shuriken.png"));
        leatherHelmet             = ResourceUtils.getImageIcon(Main.class.getResource("/res/leatherHelmet.png"));
        mediumHealthPotion        = ResourceUtils.getImageIcon(Main.class.getResource("/res/mediumHealthPotion.png"));
        medievalAxe               = ResourceUtils.getImageIcon(Main.class.getResource("/res/medievalAxe.png"));
        reinforcedBow             = ResourceUtils.getImageIcon(Main.class.getResource("/res/reinforcedBow.png"));
        silverChestplate          = ResourceUtils.getImageIcon(Main.class.getResource("/res/silverChestplate.png"));
        largeHealthPotion         = ResourceUtils.getImageIcon(Main.class.getResource("/res/largeHealthPotion.png"));
        shortSword                = ResourceUtils.getImageIcon(Main.class.getResource("/res/shortSword.png"));
        crossbow                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/crossbow.png"));
        silverHelmet              = ResourceUtils.getImageIcon(Main.class.getResource("/res/silverHelmet.png"));
        smallRegenerationPotion   = ResourceUtils.getImageIcon(Main.class.getResource("/res/smallRegenerationPotion.png"));
        knightsSword              = ResourceUtils.getImageIcon(Main.class.getResource("/res/knightsSword.png"));
        kunai                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/kunai.png"));
        bronzeChestplate          = ResourceUtils.getImageIcon(Main.class.getResource("/res/bronzeChestplate.png"));
        mediumRegenerationPotion  = ResourceUtils.getImageIcon(Main.class.getResource("/res/mediumRegenerationPotion.png"));
        paladinsSword             = ResourceUtils.getImageIcon(Main.class.getResource("/res/paladinsSword.png"));
        onzil                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/onzil.png"));
        bronzeHelmet              = ResourceUtils.getImageIcon(Main.class.getResource("/res/bronzeHelmet.png"));
        largeRegenerationPotion   = ResourceUtils.getImageIcon(Main.class.getResource("/res/largeRegenerationPotion.png"));
        hellSword                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/hellSword.png"));
        hellBow                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/hellbow.png"));
        obsidianChestplate        = ResourceUtils.getImageIcon(Main.class.getResource("/res/obsidianChestplate.png"));
        waterBottle               = ResourceUtils.getImageIcon(Main.class.getResource("/res/waterBucket.png"));
        odrokus                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/odrokus.png"));
        alav                      = ResourceUtils.getImageIcon(Main.class.getResource("/res/alav.png"));
        obsidianHelmet            = ResourceUtils.getImageIcon(Main.class.getResource("/res/obsidianHelmet.png"));
        strengthPotion            = ResourceUtils.getImageIcon(Main.class.getResource("/res/strengthPotion.png"));
        vinegriand                = ResourceUtils.getImageIcon(Main.class.getResource("/res/vinegriand.png"));
        vineregen                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/vineregen.png"));
        darkRobe                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/darkRobe.png"));
        antivenom                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/antivenom.png"));
        zugoron                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/zugoron.png"));
        kotperes                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/kotperes.png"));
        darkHeart                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/darkHeart.png"));
        speedPotion               = ResourceUtils.getImageIcon(Main.class.getResource("/res/speedPotion.png"));

        woodenClubAcik                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenClubAcik.png"));
        woodenSwordAcik                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenSwordAcik.png"));
        medievalAxeAcik                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/medievalAxeAcik.png"));
        shortSwordAcik                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/shortSwordAcik.png"));
        knightsSwordAcik                = ResourceUtils.getImageIcon(Main.class.getResource("/res/knightsSwordAcik.png"));
        paladinsSwordAcik               = ResourceUtils.getImageIcon(Main.class.getResource("/res/paladinsSwordAcik.png"));
        hellSwordAcik                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/hellSwordAcik.png"));
        odrokusAcik                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/odrokusAcik.png"));
        vinegriandAcik                  = ResourceUtils.getImageIcon(Main.class.getResource("/res/vinegriandAcik.png"));
        zugoronAcik                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/zugoronAcik.png"));
        woodenBowAcik                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenBowAcik.png"));
        shurikenAcik                    = ResourceUtils.getImageIcon(Main.class.getResource("/res/shurikenAcik.png"));
        reinforcedBowAcik               = ResourceUtils.getImageIcon(Main.class.getResource("/res/reinforcedBowAcik.png"));
        crossbowAcik                    = ResourceUtils.getImageIcon(Main.class.getResource("/res/crossbowAcik.png"));
        kunaiAcik                       = ResourceUtils.getImageIcon(Main.class.getResource("/res/kunaiAcik.png"));
        onzilAcik                       = ResourceUtils.getImageIcon(Main.class.getResource("/res/onzilAcik.png"));
        hellBowAcik                     = ResourceUtils.getImageIcon(Main.class.getResource("/res/hellbowAcik.png"));
        alavAcik                        = ResourceUtils.getImageIcon(Main.class.getResource("/res/alavAcik.png"));
        vineregenAcik                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/vineregenAcik.png"));
        kotperesAcik                    = ResourceUtils.getImageIcon(Main.class.getResource("/res/kotperesAcik.png"));
        leatherChestplateAcik           = ResourceUtils.getImageIcon(Main.class.getResource("/res/leatherChestplateAcik.png"));
        leatherHelmetAcik               = ResourceUtils.getImageIcon(Main.class.getResource("/res/leatherHelmetAcik.png"));
        silverChestplateAcik            = ResourceUtils.getImageIcon(Main.class.getResource("/res/silverChestplateAcik.png"));
        silverHelmetAcik                = ResourceUtils.getImageIcon(Main.class.getResource("/res/silverHelmetAcik.png"));
        bronzeChestplateAcik            = ResourceUtils.getImageIcon(Main.class.getResource("/res/bronzeChestplateAcik.png"));
        bronzeHelmetAcik                = ResourceUtils.getImageIcon(Main.class.getResource("/res/bronzeHelmetAcik.png"));
        obsidianChestplateAcik          = ResourceUtils.getImageIcon(Main.class.getResource("/res/obsidianChestplateAcik.png"));
        obsidianHelmetAcik              = ResourceUtils.getImageIcon(Main.class.getResource("/res/obsidianHelmetAcik.png"));
        darkRobeAcik                    = ResourceUtils.getImageIcon(Main.class.getResource("/res/darkRobeAcik.png"));
        darkHeartAcik                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/darkHeartAcik.png"));
        smallHealthPotionAcik           = ResourceUtils.getImageIcon(Main.class.getResource("/res/smallHealthPotionAcik.png"));
        mediumHealthPotionAcik          = ResourceUtils.getImageIcon(Main.class.getResource("/res/mediumHealthPotionAcik.png"));
        largeHealthPotionAcik           = ResourceUtils.getImageIcon(Main.class.getResource("/res/largeHealthPotionAcik.png"));
        smallRegenerationPotionAcik     = ResourceUtils.getImageIcon(Main.class.getResource("/res/smallRegenerationPotionAcik.png"));
        mediumRegenerationPotionAcik    = ResourceUtils.getImageIcon(Main.class.getResource("/res/mediumRegenerationPotionAcik.png"));
        largeRegenerationPotionAcik     = ResourceUtils.getImageIcon(Main.class.getResource("/res/largeRegenerationPotionAcik.png"));
        waterBottleAcik                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/waterBucketAcik.png"));
        strengthPotionAcik              = ResourceUtils.getImageIcon(Main.class.getResource("/res/strengthPotionAcik.png"));
        antivenomAcik                   = ResourceUtils.getImageIcon(Main.class.getResource("/res/antivenomAcik.png"));
        speedPotionAcik                 = ResourceUtils.getImageIcon(Main.class.getResource("/res/speedPotionAcik.png"));

        woodenClubKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenClubKapali.png"));
        woodenSwordKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenSwordKapali.png"));
        medievalAxeKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/medievalAxeKapali.png"));
        shortSwordKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/shortSwordKapali.png"));
        knightsSwordKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/knightsSwordKapali.png"));
        paladinsSwordKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/paladinsSwordKapali.png"));
        hellSwordKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/hellSwordKapali.png"));
        odrokusKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/odrokusKapali.png"));
        vinegriandKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/vinegriandKapali.png"));
        zugoronKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/zugoronKapali.png"));
        woodenBowKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/woodenBowKapali.png"));
        shurikenKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/shurikenKapali.png"));
        reinforcedBowKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/reinforcedBowKapali.png"));
        crossbowKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/crossbowKapali.png"));
        kunaiKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/kunaiKapali.png"));
        onzilKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/onzilKapali.png"));
        hellBowKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/hellbowKapali.png"));
        alavKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/alavKapali.png"));
        vineregenKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/vineregenKapali.png"));
        kotperesKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/kotperesKapali.png"));
        leatherChestplateKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/leatherChestplateKapali.png"));
        leatherHelmetKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/leatherHelmetKapali.png"));
        silverChestplateKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/silverChestplateKapali.png"));
        silverHelmetKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/silverHelmetKapali.png"));
        bronzeChestplateKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/bronzeChestplateKapali.png"));
        bronzeHelmetKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/bronzeHelmetKapali.png"));
        obsidianChestplateKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/obsidianChestplateKapali.png"));
        obsidianHelmetKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/obsidianHelmetKapali.png"));
        darkRobeKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/darkRobeKapali.png"));
        darkHeartKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/darkHeartKapali.png"));
        smallHealthPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/smallHealthPotionKapali.png"));
        mediumHealthPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/mediumHealthPotionKapali.png"));
        largeHealthPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/largeHealthPotionKapali.png"));
        smallRegenerationPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/smallRegenerationPotionKapali.png"));
        mediumRegenerationPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/mediumRegenerationPotionKapali.png"));
        largeRegenerationPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/largeRegenerationPotionKapali.png"));
        waterBottleKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/waterBucketKapali.png"));
        strengthPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/strengthPotionKapali.png"));
        antivenomKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/antivenomKapali.png"));
        speedPotionKapali = ResourceUtils.getImageIcon(Main.class.getResource("/res/speedPotionKapali.png"));
        // the end
        cutENDING = ResourceUtils.getImageIcon(Main.class.getResource("/res/theEnd.png"));
    }


}
