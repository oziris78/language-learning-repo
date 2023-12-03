package com.twistral.consts;



import com.twistral.listeners.BtnBuyTheWeaponListener;

import java.util.ArrayList;
import java.util.List;

public class Strings {

    public static String versionNumber = "2.8";
    public static String currentLanguage, nothingAppears,
                         version, versionForLabel, frameTitle, sfx, music, crossbow, hellBowD,
                         strNewGame, strCredits, strSettings, strQuit, strBuyTheWeapon,
                         credits, strBack, meleeAttack, rangedAttack, defend, items, bronzeChestplateD,
                         armoredChainedCorpse, skeleton, chainedCorpse, armoredSkeleton, mummy, inenormisAranea,
                         veneficusAranea, parilisAranea, phoenix, cerberus, hellSpider, fireOrb, darkOrb, iceOrb,
                         blueSlime, eunectes, theraphoseBlondi, yek, theTenebrosity, waterBottleD,
                         start, easy, medium, hard, ultra, tekin, ayca, swordsman, archer, knight, assassin,
                         selecCharacter, selecClass , selecDifficulty, selecSaveName, goToMainMenu,
                         woodenClub, woodenBow, leatherChestplate, smallHealthPotion, woodenSword, shuriken, leatherHelmet,
                         mediumHealthPotion, medievalAxe, reinforcedBow, silverChestplate, largeHealthPotion, shortSword,
                         silverHelmet, smallRegenerationPotion, knightsSword, kunai, bronzeChestplate, mediumRegenerationPotion,
                         paladinsSword, onzil, bronzeHelmet, largeRegenerationPotion, hellSword, hellBow, obsidianChestplate,
                         waterBottle, odrokus, alav, obsidianHelmet, strengthPotion, vinegriand, vineregen, darkRobe, antivenom,
                         zugoron, kotperes, darkHeart, speedPotion, strContinue, slime, next, mediumHealthPotionD,
                         woodenClubD, woodenSwordD, medievalAxeD, shortSwordD, knightsSwordD, paladinsSwordD, hellSwordD,
                         odrokusD, vinegriandD, zugoronD, woodenBowD, shurikenD, reinforcedBowD, crossbowD, kunaiD, onzilD,
                         alavD, vineregenD, kotperesD, leatherChestplateD, leatherHelmetD, silverChestplateD, silverHelmetD,
                         bronzeHelmetD, obsidianChestplateD, obsidianHelmetD, darkRobeD, darkHeartD, smallHealthPotionD,
                         largeHealthPotionD, smallRegenerationPotionD, mediumRegenerationPotionD, largeRegenerationPotionD,
                         strengthPotionD, antivenomD, speedPotionD, youHaveDiedUpperCase, pre2, post2, inventory, endIt,
                         drinkSmallHP, drinkMediumHP, drinkLargeHP, drinkSmallRegen, drinkMediumRegen, drinkLargeRegen,
                         drinkWater, drinkStrength, drinkAntivenom, drinkSpeed, tenebEfekti, iceOrbEfekti, darkOrbEfekti,
                         blueSlimeEfekti, eunectesEfekti, veneficusEfekti, parilisEfekti, theraphoseEfekti,
                         phoenixEfekti, cerberusEfekti, hellSpiderEfekti, yekEfekti, fireOrbEfekti;


    public static String[] cutscene1, cutscene2, cutscene3, cutscene4, cutscene5, cutsceneENDING;

    public static String burning3;
    public static String burning2;
    public static String burning1;
    public static String bleeding2;
    public static String bleeding1;
    public static String regen1;
    public static String regen2;
    public static String regen3;
    public static String noDefense;
    public static String slowness2;
    public static String slowness1;
    public static String strengthEffect;
    public static String defenseYap;

    static {
        currentLanguage = "EN";

        // genel
        versionForLabel = "v"+ versionNumber +"     ";
        version = "v"+ versionNumber;
        frameTitle = "T\u00fcnerik Ko\u015fusu " + version;
        sfx = "<html><span color='#bf0f1e'>SFX Volume</span></html>";
        music = "<html><span color='#bf0f1e'>Music Volume</span></html>";
        // panMain
        strNewGame   = "NEW GAME";
        strCredits  = "CREDITS";
        strSettings   = "SETTINGS";
        strQuit  = "QUIT";
        // panCredits
        strBack = "BACK";
        credits = "<html><pre>\n\n\n\n" +
                "\n" +
                "Programming : O\u011fuzhan Topalo\u011flu\n\n" +
                "Design : O\u011fuzhan Topalo\u011flu\n\t Yunus Emre \u00c7ay</pre></html>";
        // panNewGame
        start = "START";
        easy = "Easy";
        medium = "Medium";
        hard = "Hard";
        ultra = "Ultra";
        tekin = "Tekin";
        ayca = "Ay\u00e7a";
        swordsman = "Swordsman";
        archer = "Archer";
        knight = "Knight";
        assassin = "Assassin";
        selecCharacter  = "Character:";
        selecClass      = "Class:";
        selecDifficulty = "Difficulty:";
        next = "NEXT";
        meleeAttack = "MELEE ATTACK";
        rangedAttack = "RANGED ATTACK";
        defend = "DEFEND";
        items = "ITEMS";
        defenseYap = "You@defend@yourself@against@this@attack...";

        // game over
        goToMainMenu = "GO TO MAIN MENU";
        youHaveDiedUpperCase = "YOU HAVE DIED";


        // monsters
        nothingAppears = "No@monster@appears...";
        slime = "Slime";
        armoredChainedCorpse  = "Armored Chained Corpse";
        skeleton = "Skeleton";
        chainedCorpse = "Chained Corpse";
        armoredSkeleton = "Armored Skeleton";
        mummy = "Mummy";
        inenormisAranea = "Inenormis Aranea";
        veneficusAranea = "Veneficus Aranea";
        parilisAranea = "Parilis Aranea";
        phoenix = "Phoenix";
        cerberus = "Cerberus";
        hellSpider = "Hell Spider";
        fireOrb = "Fire Orb";
        darkOrb = "Dark Orb";
        iceOrb = "Ice Orb";
        blueSlime = "Blue Slime";
        eunectes = "Eunectes";
        theraphoseBlondi = "Theraphose Blondi";
        yek = "Yek";
        theTenebrosity = "The Tenebrosity";
        endIt = "END";

        // potion drinking
        drinkSmallHP  = "You@used@a@small@health@potion.";
        drinkMediumHP = "You@used@a@medium@health@potion.";
        drinkLargeHP  = "You@used@a@large@health@potion.";
        drinkSmallRegen = "You@used@a@small@regeneration@potion.";
        drinkMediumRegen  = "You@used@a@medium@regeneration@potion.";
        drinkLargeRegen   = "You@used@a@large@regeneration@potion.";
        drinkWater  = "You@used@a@water@bottle@to@extinguish@yourself.";
        drinkStrength = "You@used@a@strength@potion.";
        drinkAntivenom  = "You@used@an@antivenom.";
        drinkSpeed = "You@used@a@speed@potion.";

        // effects
        tenebEfekti = "The@Tenebrosity@regenerates@it's@health...";
        iceOrbEfekti = "Ice@Orb@freezes@your@armor.\n@You@lose@all@of@your@defense@for@one@round...";
        darkOrbEfekti = "Dark@Orb@darkens@your@soul.\n@You@lose@all@of@your@evade@for@one@round...";
        blueSlimeEfekti = "Blue@Slime@hits@you@deep.\n@Your@evade@is@decreased@for@two@rounds...";
        eunectesEfekti = "Eunectes@cuts@you@deep...\n@You@will@bleed@for@two@rounds.";
        veneficusEfekti = "Veneficus@Aranea@hits@you@deep.\n@Your@evade@is@decreased@for@two@rounds...";
        parilisEfekti = "Parilis@Aranea@burns@you.\n@You@will@burn@for@two@rounds...";
        theraphoseEfekti = "Theraphose@Blondi@cuts@you@deep...\n@You@will@bleed@for@two@rounds.";
        phoenixEfekti = "Phoenix@burns@you.\n@You@will@burn@for@two@rounds...";
        cerberusEfekti = "Cerberus@burns@you.\n@You@will@burn@for@two@rounds...";
        hellSpiderEfekti = "Hell@Spider@burns@you.\n@You@will@burn@for@two@rounds...";
        yekEfekti = "Yek@burns@you.\n@You@will@burn@for@two@rounds...";
        fireOrbEfekti = "Fire@Orb@burns@you.\n@You@will@burn@for@two@rounds...";
        // effects (sonuclar)
        burning3 = "You@burn@and@lose@health...";
        regen1 = "You@regenerate@some@health...";
        bleeding2 = "You@bleed@and@lose@health...";
        noDefense = "Your@defense@is@decreased@to@zero!";
        slowness2 = "Your@evade@has@been@decreased...";
        strengthEffect = "Your@damage@has@increased!";
        burning2 = burning3;
        burning1 = burning3;
        bleeding1 = bleeding2;
        regen2 = regen1;
        regen3 = regen1;
        slowness1 = slowness2;

        // cutscenes
        String pre = "<html><pre style='padding-left:8px; padding-top:3px;'>";
        String post = "</pre></html>";
        String cut = "You@wake@up@with@a@terrible@headache@and@find@yourself@in@a@dungeon@with@bloody\n@walls.";
        String cut2 = "You@take@a@look@around@and@see@a@piece@of@paper@that@is@lying@on@the@floor.@You\n@don't@understand@what@it@means@but@you@read@it@anyways.@It@looks@like@it's@from\n@a@poem...";
        String cut3 = "You@don't@understand@why@it@is@here@or@how@you@ended@up@here.";
        String cut4 = "You@hear@a@weird@sound@approaching.@You@realize@that@there@are@<span color='red'>small rocks</span>@and@a@\n@<span color='red'>sharp stick</span>@laying@on@the@floor.@You@take@them@and@wait@for@the@sound@to@come\n@even@closer.";
        String cut5 = "A@<span color='red'>Slime</span>@approaches!@It@doesn't@look@friendly@at@all...";
        String cut6 = "The@<span color='red'>monster</span>@drops@the@remaining@pieces@of@the@poem@you've@found@in@the@beginning.@\n@You@understand@it@now" +
                "@but@realize@that@it's@all@too@late...";
        cutscene1 = diziyeGecir(pre, cut, post);
        cutscene2 = diziyeGecir(pre, cut2 , post);
        cutscene3 = diziyeGecir(pre, cut3 ,post);
        cutscene4 = diziyeGecir(pre, cut4 ,post);
        cutscene5 = diziyeGecir(pre, cut5 ,post);
        cutsceneENDING = diziyeGecir(pre, cut6 ,post);


        // shop
        strContinue  = "CONTINUE";
        strBuyTheWeapon = "BUY";
        inventory = "INVENTORY";

        woodenClub                = "Wooden Club";
        woodenBow                 = "Wooden Bow";
        leatherChestplate         = "Leather Chestplate";
        smallHealthPotion         = "Small HP Potion";
        woodenSword               = "Wooden Sword";
        shuriken                  = "Shuriken";
        leatherHelmet             = "Leather Helmet";
        mediumHealthPotion        = "Medium HP Potion";
        medievalAxe               = "Medieval Axe";
        reinforcedBow             = "Reinforced Bow";
        silverChestplate          = "Silver Chestplate";
        largeHealthPotion         = "Large HP Potion";
        shortSword                = "Short Sword";
        crossbow                  = "Crossbow";
        silverHelmet              = "Silver Helmet";
        smallRegenerationPotion   = "Small Regeneration Potion";
        knightsSword              = "Knight's Sword";
        kunai                     = "Kunai";
        bronzeChestplate          = "Bronze Chestplate";
        mediumRegenerationPotion  = "Medium Regeneration Potion";
        paladinsSword             = "Paladin's Sword";
        onzil                     = "Onzil";
        bronzeHelmet              = "Bronze Helmet";
        largeRegenerationPotion   = "Large Regeneration Potion";
        hellSword                 = "Hell Sword";
        hellBow                   = "Hell Bow";
        obsidianChestplate        = "Obsidian Chestplate";
        waterBottle               = "Water Bottle";
        odrokus                   = "Odrokus";
        alav                      = "Alav";
        obsidianHelmet            = "Obsidian Helmet";
        strengthPotion            = "Strength Potion";
        vinegriand                = "Vinegriand";
        vineregen                 = "Vineregen";
        darkRobe                  = "Dark Robe";
        antivenom                 = "Antivenom";
        zugoron                   = "Zugoron";
        kotperes                  = "Kotperes";
        darkHeart                 = "Dark Heart";
        speedPotion               = "Speed Potion";

        pre2 = "<html><pre style='color:#d6d6d6; font-size:14px; margin:0px; padding:0px;'>";
        post2  = "</pre></html>";



        woodenClubD                 = pre2 + "<span style='font-size:19px;'>Wooden Club</span>\n" +
                                             "A wooden club that you can\n" +
                                             "use to bash some monster's\n" +
                                             "heads." + degerAl(1) + post2;
        woodenSwordD                = pre2 + "<span style='font-size:19px;'>Wooden Sword</span>\n" +
                                             "A simple wooden sword,\nit's better than a club\nI guess..." + degerAl(2) + post2;
        medievalAxeD                = pre2 + "<span style='font-size:19px;'>Medieval Axe</span>\n" +
                                             "Perfect for chopping down\nheads!" + degerAl(3) + post2;
        shortSwordD                 = pre2 + "<span style='font-size:19px;'>Short Sword</span>\n" +
                                             "Size doesn't matter,\ndamage does." + degerAl(4) + post2;
        knightsSwordD               = pre2 + "<span style='font-size:19px;'>Knight's Sword</span>\n" +
                                             "A sword droppen by a\nfallen Knight." + degerAl(5) + post2;
        paladinsSwordD              = pre2 + "<span style='font-size:19px;'>Paladin's Sword</span>\n" +
                                             "A sword droppen by a\nfallen Paladin, it looks\nsharp and bloody." + degerAl(6) + post2;
        hellSwordD                  = pre2 + "<span style='font-size:19px;'>Hell Sword</span>\n" +
                                             "A sword straight out of\nHell! Be careful while\nusing it, it's probably\nhot as hell." + degerAl(7) + post2;
        odrokusD                    = pre2 + "<span style='font-size:19px;'>Odrokus</span>\n" +
                                             "You can feel it's fury\nfilling your empty soul." + degerAl(8) + post2;
        vinegriandD                 = pre2 + "<span style='font-size:19px;'>Vinegriand</span>\n" +
                                             "Serious, deadly, shiny." + degerAl(9) + post2;
        zugoronD                    = pre2 + "<span style='font-size:19px;'>Zugoron</span>\n" +
                                             "You feel dead inside just\nby seeing it's blade." + degerAl(10) + post2;
        woodenBowD                  = pre2 + "<span style='font-size:19px;'>Wooden Bow</span>\n" +
                                             "A wooden bow that you can\nuse to attack from range." + degerAl(11) + post2;
        shurikenD                   = pre2 + "<span style='font-size:19px;'>Shuriken</span>\n" +
                                             "Ninja style! Just like in\nthe movies..." + degerAl(12) + post2;
        reinforcedBowD              = pre2 + "<span style='font-size:19px;'>Reinforced Bow</span>\n" +
                                             "A bow made out of\nreinforced iron. It's way\nbetter the other bow." + degerAl(13) + post2;
        crossbowD                   = pre2 + "<span style='font-size:19px;'>Crossbow</span>\n" +
                                             "Think of it as a fast\nshooting, slow reloading\nbow." + degerAl(14) + post2;
        kunaiD                      = pre2 + "<span style='font-size:19px;'>Kunai</span>\n" +
                                             "Ninja style 2!" + degerAl(15) + post2;
        onzilD                      = pre2 + "<span style='font-size:19px;'>Onzil</span>\n" +
                                             "Straight out of Africa!" + degerAl(16) + post2;
        hellBowD                    = pre2 + "<span style='font-size:19px;'>Hell Bow</span>\n" +
                                             "A bow straight out of\nthe depths of hell..." + degerAl(17) + post2;
        alavD                       = pre2 + "<span style='font-size:19px;'>Alav</span>\n" +
                                             "You can feel it's warmth\nin your hands..." + degerAl(18) + post2;
        vineregenD                  = pre2 + "<span style='font-size:19px;'>Vineregen</span>\n" +
                                             "A perfect bow for the\nperfect rangers." + degerAl(19) + post2;
        kotperesD                   = pre2 + "<span style='font-size:19px;'>Kotperes</span>\n" +
                                             "The most deadliest bow\never existed, just by\nlooking at you feel a\nstrong temptation to\nhold it in your hands..." + degerAl(20) + post2;
        leatherChestplateD          = pre2 + "<span style='font-size:19px;'>Leather Chestplate</span>\n" +
                                             "A chestplate made out of\nleather." + degerAl(21) + post2;
        leatherHelmetD              = pre2 + "<span style='font-size:19px;'>Leather Helmet</span>\n" +
                                             "A helmet made out of\nleather." + degerAl(22) + post2;
        silverChestplateD           = pre2 + "<span style='font-size:19px;'>Silver Chestplate</span>\n" +
                                             "A chestplate made out of\nsilver." + degerAl(23) + post2;
        silverHelmetD               = pre2 + "<span style='font-size:19px;'>Silver Helmet</span>\n" +
                                             "A helmet made out of\nsilver." + degerAl(24) + post2;
        bronzeChestplateD           = pre2 + "<span style='font-size:19px;'>Bronze Chestplate</span>\n" +
                                             "A chestplate made out of\nbronze." + degerAl(25) + post2;
        bronzeHelmetD               = pre2 + "<span style='font-size:19px;'>Bronze Helmet</span>\n" +
                                             "A helmet made out of\nbronze." + degerAl(26) + post2;
        obsidianChestplateD         = pre2 + "<span style='font-size:19px;'>Obsidian Chestplate</span>\n" +
                                             "A chestplate made out of\nobsidian." + degerAl(27) + post2;
        obsidianHelmetD             = pre2 + "<span style='font-size:19px;'>Obsidian Helmet</span>\n" +
                                             "A helmet made out of\nobsidian." + degerAl(28) + post2;
        darkRobeD                   = pre2 + "<span style='font-size:19px;'>Dark Robe</span>\n" +
                                             "The darkest robe ever\nexisted." + degerAl(29) + post2;
        darkHeartD                  = pre2 + "<span style='font-size:19px;'>Dark Heart</span>\n" +
                                             "The darkest heart ever\nexisted for the darkest\npeople with a tenebrosity\ninside their hearts." + degerAl(30) + post2;
        smallHealthPotionD          = pre2 + "<span style='font-size:19px;'>Small Health Potion</span>\n" +
                                             "A small HP potion." + degerAl(31) + post2;
        mediumHealthPotionD         = pre2 + "<span style='font-size:19px;'>Medium Health Potion</span>\n" +
                                             "A medium HP potion." + degerAl(32) + post2;
        largeHealthPotionD          = pre2 + "<span style='font-size:19px;'>Large Health Potion</span>\n" +
                                             "A large HP potion." + degerAl(33) + post2;
        smallRegenerationPotionD    = pre2 + "<span style='font-size:19px;'>Small Regen Potion</span>\n" +
                                             "A small Regen potion." + degerAl(34) + post2;
        mediumRegenerationPotionD   = pre2 + "<span style='font-size:19px;'>Medium Regen Potion</span>\n" +
                                             "A medium Regen potion." + degerAl(35) + post2;
        largeRegenerationPotionD    = pre2 + "<span style='font-size:19px;'>Large Regen Potion</span>\n" +
                                             "A large Regen potion." + degerAl(36) + post2;
        waterBottleD                = pre2 + "<span style='font-size:19px;'>Water Bottle</span>\n" +
                                             "Some water that you can\nuse to extinguish\nyourself if you ever need\nto..." + degerAl(37) + post2;
        strengthPotionD             = pre2 + "<span style='font-size:19px;'>Strength Potion</span>\n" +
                                             "A potion giving you\ntemporarily strength and\npower beyond your\nimagination." + degerAl(38) + post2;
        antivenomD                  = pre2 + "<span style='font-size:19px;'>Antivenom</span>\n" +
                                             "A potion brewed with\nvarious herbs to cure any\ntype of poisoning..." + degerAl(39) + post2;
        speedPotionD                = pre2 + "<span style='font-size:19px;'>Speed Potion</span>\n" +
                                             "A potion giving you\ntemporarily speed, you\nmight use this speed to\nevade many attacks." + degerAl(40) + post2;

    }

    public static String odulVermeYazisi(int odul){
        if(currentLanguage == "EN"){
            return "You've@earned@<span color='yellow'>" + odul + "</span>@coins...";
        }
        else if(currentLanguage == "TR"){
            // yazilacak
        }
        return "";
    }


    public static String duzeyAtlamaYazisi() {
        if(currentLanguage == "EN"){
            return "You@have@leveled@up!@Your@health@and@evade@has@increased!";
        }
        else if(currentLanguage == "TR"){
            // yazilacak
        }
        return "";
    }

    public static String deneyimVermeYazisi(int kazanilanDeneyim) {
        if(currentLanguage == "EN"){
            return "You@have@gained@<span color='green'>" + kazanilanDeneyim + "</span>@exp!";
        }
        else if(currentLanguage == "TR"){
            // yazilacak
        }
        return "";
    }

    public static String youHaveDied() {
        if(currentLanguage == "EN"){
            return "You@have@died...";
        }
        else if(currentLanguage == "TR"){
            // yazilacak
        }
        return "";

    }


    public static String aNewMonsterAppears(String s) {
        if(currentLanguage == "EN"){
            return "A@new@<span color='red'>" + s + "</span>@appears!";
        }
        else if(currentLanguage == "TR"){
            // yazilacak
        }
        return "";
    }


    public static String aNewMonsterAppearsBOSS(String s) {
        if(currentLanguage == "EN"){
            return "<span color='red'>" + s + "</span>@appears!";
        }
        else if(currentLanguage == "TR"){
            // yazilacak
        }
        return "";
    }


    public static String[] diziyeGecir(String pre, String s, String post){
        String[] aradakiler = s.split("@");
        List<String> donusecek = new ArrayList<String>();
        for(int i = 0; i < aradakiler.length; i++){
            String t = "";
            for(int j = 0; j <= i; j++) {
                if( !(j+1 <= i ) ){ t += aradakiler[j]; }
                else{ t += aradakiler[j] + " "; }
            }
            donusecek.add(pre + t + post);
        }
        String[] arr = new String[donusecek.size()];
        arr = donusecek.toArray(arr);
        return arr;
    }

    public static String degerAl(int i){
        Object[] dizi = BtnBuyTheWeaponListener.nesneSozlugu.get(i);
        if(dizi[1].toString() == "M" || dizi[1].toString() == "R"){ return "\nValue: " + dizi[0].toString() +"\nDamage: "+ dizi[2].toString() +"\nCrit: "+ dizi[3].toString() +"%"; }
        else if(dizi[1].toString() == "A"){ return "\nValue: " + dizi[0].toString() +"\nDefense: "+ dizi[2].toString(); }
        else if(dizi[1].toString() == "O"){ return "\nValue: " + dizi[0].toString(); }
        return "";
    }



}
