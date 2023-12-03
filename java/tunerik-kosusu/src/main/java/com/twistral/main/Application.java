package com.twistral.main;

import com.twistral.consts.*;
import com.twistral.*;
import com.twistral.utils.*;
import com.twistral.listeners.PanGameListener;
import com.twistral.entities.normal.*;
import com.twistral.gui.*;
import com.twistral.entities.*;
import javax.swing.*;


public class Application extends JFrame {

    private static Player player;
    private static AbstractMonster currentMonster;

    public static JLabel[] arrShopLabels;

    public static final int EN = 1280;
    public static final int BOY = 720;

    public static JLayeredPane laypan;
    public static JPanel panMain, panNewGame, panSettings, panGamesSettings, panCredits, panGame, panShop, panGameOver,
                         panInventoryFromShop, panInventoryFromGame;
    public static JLabel lbVersion, lbAppTitle, lbCredits, lbVersion2, lbCharacterImage, lbSelectCharacter, lbSelectClass,
                         lbSelectDifficulty, lbSelectSaveName, lbVersion3, lbMeleeDam, lbMeleeCrit, lbRangedDam, lbRangedCrit,
                         lbDefense, lbEvade, lbRightShopDescription, lbYouHaveDied, lbMoneyShop,
                         lbWoodenclub, lbWoodenbow, lbLeatherchestplate, lbSmallhealthpotion, lbWoodensword, lbShuriken,
                         lbLeatherhelmet, lbMediumhealthpotion, lbMedievalaxe, lbReinforcedbow, lbSilverchestplate,
                         lbShortsword, lbCrossbow, lbSilverhelmet, lbSmallregenerationpotion, lbKnightssword, lbKunai,
                         lbMediumregenerationpotion, lbPaladinssword, lbOnzil, lbBronzehelmet, lbLargeregenerationpotion, lbHellsword,
                         lbHellbow, lbVineregen, lbBronzechestplate, lbLargehealthpotion, lbStrengthpotion, lbVinegriand,
                         lbObsidianchestplate, lbWaterbucket, lbOdrokus, lbAlav, lbObsidianhelmet, lbDarkheart, lbSpeedpotion,
                         lbDarkrobe, lbAntivenom, lbZugoron, lbKotperes, lbLeftShop, lbRightShop,
                         lbMeleeDamShop, lbRangedDamShop, lbMeleeCritShop, lbRangedCritShop, lbDefenseShop, lbEvadeShop,
                         lbMiddle, lbDown, lbLeft, lbRight, lbHit, lbItem1, lbItem2, lbItem3, lbItem4, lbItem5, lbItem6,
                         lbItem7, lbItem8, lbItem9, lbItem10, lbItemGame1, lbItemGame2, lbItemGame3, lbItemGame4, lbItemGame5,
                         lbItemGame6, lbItemGame7, lbItemGame8, lbItemGame9, lbItemGame10, lbArtAlan1;
    public static JButton btnNewGame, btnSettings, btnCredits, btnQuit, btnToMain, btnToMain2, btnStartTheGame,
                          btnSettings2, btnToMain3, btnToGame, btnCutscenes, btnMelee,  btnRanged, btnDefend, btnItems, btnDeadToMain,
                          btnContinue, btnBuyTheWeapon, btnShopToInv, btnInvToShop, btnInvToGame;
    public static JRadioButton rbtnTekin, rbtnAyca, rbtnEasy, rbtnMedium, rbtnHard, rbtnUltra, rbtnKnight, rbtnArcher,
                               rbtnAssassin, rbtnSwordsman;
    public static ButtonGroup groupDifficulty, groupClass, groupCharacter;

    public static JProgressBar barLevel, barHealth, barMonster, barLevelShop, barHealthShop;
    public static JSlider sliderSFX, sliderMusic, sliderSFXGame, sliderMusicGame;

    public Application(){
        this.player = new Player();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50,50,EN+16,BOY+39);
        this.setTitle(Strings.frameTitle);
        this.setResizable(false);
        this.setIconImage(Images.gameIcon.getImage());
        laypan = new JLayeredPane();
        this.setContentPane(laypan);
        this.setCursor(Cursors.cursor1);

        // main
        panMain = Panels.tkPanel();
        lbAppTitle = Labels.appTitle();
        lbVersion = Labels.version();
        lbVersion2 = Labels.version();
        lbVersion3 = Labels.version();

        // credits
        panCredits = Panels.tkPanel();
        lbCredits = Labels.credits();

        // settings
        panSettings = Panels.tkPanel();
        sliderSFX = Sliders.sfx();
        sliderMusic = Sliders.music();

        // settings
        panGamesSettings = Panels.tkPanel();
        sliderSFXGame = Sliders.sfxGame();
        sliderMusicGame = Sliders.musicGame();

        // new game
        panNewGame = Panels.tkPanel();
        lbCharacterImage = Labels.characterImage();
        lbSelectCharacter = Labels.selectCharacter();
        lbSelectClass = Labels.selectClass();
        lbSelectDifficulty = Labels.selectDifficulty();
        lbSelectSaveName = Labels.selectSaveName();

        rbtnKnight = RadioButtons.knight();
        rbtnArcher = RadioButtons.archer();
        rbtnSwordsman = RadioButtons.swordsman();
        rbtnAssassin = RadioButtons.assassin();
        rbtnTekin = RadioButtons.tekin();
        rbtnAyca = RadioButtons.ayca();
        rbtnEasy = RadioButtons.easy();
        rbtnHard = RadioButtons.hard();
        rbtnMedium = RadioButtons.medium();
        rbtnUltra = RadioButtons.ultra();

        groupDifficulty = new ButtonGroup();
        groupClass = new ButtonGroup();
        groupCharacter = new ButtonGroup();
        TKUtils.addAllToGroup(groupDifficulty, rbtnEasy, rbtnHard, rbtnMedium, rbtnUltra);
        TKUtils.addAllToGroup(groupClass, rbtnArcher, rbtnAssassin, rbtnSwordsman, rbtnKnight);
        TKUtils.addAllToGroup(groupCharacter, rbtnTekin, rbtnAyca);

        rbtnEasy.setSelected(true);
        rbtnKnight.setSelected(true);
        rbtnTekin.setSelected(true);

        btnStartTheGame = Buttons.startTheGame();


        // panGame
        currentMonster = new Slime();

        panGame = Panels.tkPanel();
        panGame.addMouseListener(new PanGameListener());

        lbMiddle = Labels.middle();
        lbDown = Labels.down();
        lbLeft = Labels.left();
        lbRight = Labels.right();
        lbHit = Labels.hit();
        lbMeleeDam = Labels.meleeDamage();
        lbRangedDam = Labels.rangedDamage();
        lbMeleeCrit = Labels.meleeCrit();
        lbRangedCrit = Labels.rangedCrit();
        lbDefense = Labels.defense();
        lbEvade = Labels.evade();
        barLevel = Bars.level();
        barHealth = Bars.health();
        barMonster = Bars.monster();
        btnCutscenes = Buttons.cutscenes();
        btnMelee  = Buttons.battleOptionMelee();
        btnRanged = Buttons.battleOptionRanged();
        btnDefend = Buttons.battleOptionDefend();
        btnItems  = Buttons.battleOptionItems();

        TKUtils.hideAll(btnMelee, btnRanged, btnDefend, btnItems, barLevel, barHealth, barMonster, lbLeft, lbRight, lbHit,
                 lbMeleeDam, lbMeleeCrit, lbRangedDam, lbRangedCrit, lbDefense, lbEvade);
        TKUtils.showAll(lbDown, lbMiddle);


        // shop
        panShop = Panels.shopPanel();

        lbWoodenclub = Labels.woodenclub();
        lbWoodensword = Labels.woodensword();
        lbMedievalaxe = Labels.medievalaxe();
        lbShortsword = Labels.shortsword();
        lbKnightssword = Labels.knightssword();
        lbPaladinssword = Labels.paladinssword();
        lbHellsword = Labels.hellsword();
        lbOdrokus = Labels.odrokus();
        lbVinegriand = Labels.vinegriand();
        lbZugoron = Labels.zugoron();
        lbWoodenbow = Labels.woodenbow();
        lbShuriken = Labels.shuriken();
        lbReinforcedbow = Labels.reinforcedbow();
        lbCrossbow = Labels.crossbow();
        lbKunai = Labels.kunai();
        lbOnzil = Labels.onzil();
        lbHellbow = Labels.hellbow();
        lbAlav = Labels.alav();
        lbVineregen = Labels.vineregen();
        lbKotperes = Labels.kotperes();
        lbLeatherchestplate = Labels.leatherchestplate();
        lbLeatherhelmet = Labels.leatherhelmet();
        lbSilverchestplate = Labels.silverchestplate();
        lbSilverhelmet = Labels.silverhelmet();
        lbBronzechestplate = Labels.bronzechestplate();
        lbBronzehelmet = Labels.bronzehelmet();
        lbObsidianchestplate = Labels.obsidianchestplate();
        lbObsidianhelmet = Labels.obsidianhelmet();
        lbDarkrobe = Labels.darkrobe();
        lbDarkheart = Labels.darkheart();
        lbSmallhealthpotion = Labels.smallhealthpotion();
        lbMediumhealthpotion = Labels.mediumhealthpotion();
        lbLargehealthpotion = Labels.largehealthpotion();
        lbSmallregenerationpotion = Labels.smallregenerationpotion();
        lbMediumregenerationpotion = Labels.mediumregenerationpotion();
        lbLargeregenerationpotion = Labels.largeregenerationpotion();
        lbWaterbucket = Labels.waterbucket();
        lbStrengthpotion = Labels.strengthpotion();
        lbAntivenom = Labels.antivenom();
        lbSpeedpotion = Labels.speedpotion();

        arrShopLabels = new JLabel[]{lbWoodenclub, lbWoodensword, lbMedievalaxe, lbShortsword, lbKnightssword, lbPaladinssword,
                lbHellsword, lbOdrokus, lbVinegriand, lbZugoron, lbWoodenbow, lbShuriken, lbReinforcedbow, lbCrossbow, lbKunai, lbOnzil,
                lbHellbow, lbAlav, lbVineregen, lbKotperes, lbLeatherchestplate, lbLeatherhelmet, lbSilverchestplate, lbSilverhelmet,
                lbBronzechestplate, lbBronzehelmet, lbObsidianchestplate, lbObsidianhelmet, lbDarkrobe, lbDarkheart, lbSmallhealthpotion,
                lbMediumhealthpotion, lbLargehealthpotion, lbSmallregenerationpotion, lbMediumregenerationpotion, lbLargeregenerationpotion,
                lbWaterbucket, lbStrengthpotion, lbAntivenom, lbSpeedpotion};

        lbLeftShop = Labels.leftShop();
        lbRightShop = Labels.rightShop();
        lbRightShopDescription = Labels.rightShopDesc();

        lbMeleeDamShop = Labels.meleeDamage();
        lbRangedDamShop = Labels.rangedDamage();
        lbMeleeCritShop = Labels.meleeCrit();
        lbRangedCritShop = Labels.rangedCrit();
        lbDefenseShop = Labels.defense();
        lbEvadeShop = Labels.evade();
        lbMoneyShop = Labels.moneyShop();
        barLevelShop = Bars.level();
        barHealthShop = Bars.health();
        btnContinue = Buttons.continueBtn();
        btnBuyTheWeapon = Buttons.buyTheWeapon();
        TKUtils.showAll(lbMeleeDamShop, lbRangedDamShop, lbMeleeCritShop, lbRangedCritShop, lbDefenseShop,
                  lbEvadeShop, barLevelShop, barHealthShop, lbMoneyShop, btnContinue, btnBuyTheWeapon);


        // game over
        panGameOver = Panels.tkPanel();
        lbYouHaveDied = Labels.youHaveDied();

        // inventoryFromShop
        panInventoryFromShop = Panels.tkPanel();
        lbItem1 = Labels.itemShop1();
        lbItem2 = Labels.itemShop2();
        lbItem3 = Labels.itemShop3();
        lbItem4 = Labels.itemShop4();
        lbItem5 = Labels.itemShop5();
        lbItem6 = Labels.itemShop6();
        lbItem7 = Labels.itemShop7();
        lbItem8 = Labels.itemShop8();
        lbItem9 = Labels.itemShop9();
        lbItem10= Labels.itemShop10();


        // inventoryFromGame
        panInventoryFromGame = Panels.tkPanel();
        lbItemGame1 = Labels.itemGame1();
        lbItemGame2 = Labels.itemGame2();
        lbItemGame3 = Labels.itemGame3();
        lbItemGame4 = Labels.itemGame4();
        lbItemGame5 = Labels.itemGame5();
        lbItemGame6 = Labels.itemGame6();
        lbItemGame7 = Labels.itemGame7();
        lbItemGame8 = Labels.itemGame8();
        lbItemGame9 = Labels.itemGame9();
        lbItemGame10= Labels.itemGame10();

        invGuncelle();

        btnQuit = Buttons.quit();
        // gecis butonlari gereksiz old dolayi sona atildi
        btnNewGame = Buttons.mainToNew();
        btnSettings = Buttons.mainToSettings();
        btnSettings2 = Buttons.gameToSettings();
        btnCredits = Buttons.mainToCredits();
        btnToMain = Buttons.creditsToMain();
        btnToMain2 = Buttons.newGameToMain();
        btnToMain3 = Buttons.settingsToMain();
        btnToGame = Buttons.gamesSettingsToGame();
        btnDeadToMain = Buttons.deadToMain();
        btnShopToInv = Buttons.shopToInv();
        btnInvToShop = Buttons.invToShop();
        btnInvToGame = Buttons.invToGame();


        lbArtAlan1 = Labels.bgLabel(Images.bg1);

        // panele ve laypan a ekleme
        TKUtils.addAllToPanel(panMain, btnNewGame, btnSettings, btnCredits, btnQuit, lbAppTitle, lbVersion);
        TKUtils.addAllToPanel(panCredits, lbCredits, btnToMain, lbVersion2, lbArtAlan1);
        TKUtils.addAllToPanel(panNewGame, lbCharacterImage, lbSelectCharacter, rbtnTekin, rbtnAyca, lbSelectClass, rbtnKnight, rbtnArcher,
                      rbtnSwordsman, rbtnAssassin,lbSelectDifficulty, btnToMain2, rbtnEasy, rbtnMedium, rbtnHard, rbtnUltra,
                      lbSelectSaveName, btnStartTheGame, lbVersion3);
        TKUtils.addAllToPanel(panGame, lbMiddle, lbDown, lbLeft, lbRight, barHealth, barLevel, btnSettings2, btnCutscenes, btnMelee,
                      btnRanged ,btnDefend ,btnItems, barMonster, lbHit, lbMeleeDam, lbMeleeCrit, lbRangedDam, lbRangedCrit,
                      lbDefense, lbEvade);
        TKUtils.addAllToPanel(panSettings, sliderSFX, sliderMusic, btnToMain3);
        TKUtils.addAllToPanel(panGamesSettings, sliderSFXGame, sliderMusicGame, btnToGame);
        TKUtils.addAllToPanel(panGameOver, lbYouHaveDied, btnDeadToMain);
        TKUtils.addAllToPanel(panShop, lbWoodenclub, lbWoodenbow, lbLeatherchestplate, lbSmallhealthpotion, lbWoodensword, lbShuriken,
                      lbLeatherhelmet, lbMediumhealthpotion, lbMedievalaxe, lbReinforcedbow, lbSilverchestplate,
                      lbShortsword, lbCrossbow, lbSilverhelmet, lbSmallregenerationpotion, lbKnightssword, lbKunai,
                      lbMediumregenerationpotion, lbPaladinssword, lbOnzil, lbBronzehelmet, lbLargeregenerationpotion, lbHellsword,
                      lbHellbow, lbVineregen, lbBronzechestplate, lbLargehealthpotion, lbStrengthpotion, lbVinegriand,
                      lbObsidianchestplate, lbWaterbucket, lbOdrokus, lbAlav, lbObsidianhelmet, lbDarkheart, lbSpeedpotion,
                      lbDarkrobe, lbAntivenom, lbZugoron, lbKotperes, lbLeftShop, lbRightShop, lbRightShopDescription,
                      lbMeleeDamShop, lbRangedDamShop, lbMeleeCritShop, lbRangedCritShop, lbDefenseShop, lbEvadeShop,
                      barLevelShop, barHealthShop, lbMoneyShop, btnContinue, btnBuyTheWeapon, btnShopToInv);
        TKUtils.addAllToPanel(panInventoryFromShop, lbItem1, lbItem2, lbItem3, lbItem4, lbItem5, lbItem6, lbItem7, lbItem8, lbItem9, lbItem10, btnInvToShop);

        TKUtils.addAllToPanel(panInventoryFromGame, lbItemGame1, lbItemGame2, lbItemGame3, lbItemGame4, lbItemGame5, lbItemGame6, lbItemGame7,
                      lbItemGame8, lbItemGame9, lbItemGame10, btnInvToGame);

        TKUtils.addAllToLayeredPane(laypan, panMain, panSettings, panGamesSettings, panCredits, panNewGame, panGame, panShop,
                       panGameOver, panInventoryFromShop, panInventoryFromGame);


        // panellerin gizlenmesi
        TKUtils.hideAll(panNewGame, panSettings, panGamesSettings, panCredits, panGame, panShop, panGameOver, panInventoryFromShop, panInventoryFromGame);
        panMain.setVisible(true);

//        hileYap();

        this.setVisible(true);


    }

    public static void invGuncelle(){
        lbItem1.setText(String.valueOf(getPlayer().getInventory().get("smallHealthPotion")));
        lbItem2.setText(String.valueOf(getPlayer().getInventory().get("mediumHealthPotion")));
        lbItem3.setText(String.valueOf(getPlayer().getInventory().get("largeHealthPotion")));
        lbItem4.setText(String.valueOf(getPlayer().getInventory().get("smallRegenerationPotion")));
        lbItem5.setText(String.valueOf(getPlayer().getInventory().get("mediumRegenerationPotion")));
        lbItem6.setText(String.valueOf(getPlayer().getInventory().get("largeRegenerationPotion")));
        lbItem7.setText(String.valueOf(getPlayer().getInventory().get("waterBottle")));
        lbItem8.setText(String.valueOf(getPlayer().getInventory().get("strengthPotion")));
        lbItem9.setText(String.valueOf(getPlayer().getInventory().get("antivenom")));
        lbItem10.setText(String.valueOf(getPlayer().getInventory().get("speedPotion")));

        lbItemGame1.setText(String.valueOf(getPlayer().getInventory().get("smallHealthPotion")));
        lbItemGame2.setText(String.valueOf(getPlayer().getInventory().get("mediumHealthPotion")));
        lbItemGame3.setText(String.valueOf(getPlayer().getInventory().get("largeHealthPotion")));
        lbItemGame4.setText(String.valueOf(getPlayer().getInventory().get("smallRegenerationPotion")));
        lbItemGame5.setText(String.valueOf(getPlayer().getInventory().get("mediumRegenerationPotion")));
        lbItemGame6.setText(String.valueOf(getPlayer().getInventory().get("largeRegenerationPotion")));
        lbItemGame7.setText(String.valueOf(getPlayer().getInventory().get("waterBottle")));
        lbItemGame8.setText(String.valueOf(getPlayer().getInventory().get("strengthPotion")));
        lbItemGame9.setText(String.valueOf(getPlayer().getInventory().get("antivenom")));
        lbItemGame10.setText(String.valueOf(getPlayer().getInventory().get("speedPotion")));
    }

    public static void nesneTuketimiSonrasi() {
        invGuncelle();
        updateAllBars();
        updateStats();
    }

    public static void updateStats(){
        // panGame icin
        Application.lbMeleeDam.setText   (String.valueOf(getPlayer().getMeleeDamage()));
        Application.lbMeleeCrit.setText  (String.valueOf(getPlayer().getMeleeCrit()) + "%");
        Application.lbRangedDam.setText  (String.valueOf(getPlayer().getRangedDamage()));
        Application.lbRangedCrit.setText (String.valueOf(getPlayer().getRangedCrit()) + "%");
        Application.lbDefense.setText    (String.valueOf(getPlayer().getDefense()));
        Application.lbEvade.setText      (String.valueOf(getPlayer().getEvade()) + "%");
        // panShop icin
        Application.lbMeleeDamShop.setText   (String.valueOf(getPlayer().getMeleeDamage()));
        Application.lbMeleeCritShop.setText  (String.valueOf(getPlayer().getMeleeCrit()) + "%");
        Application.lbRangedDamShop.setText  (String.valueOf(getPlayer().getRangedDamage()));
        Application.lbRangedCritShop.setText (String.valueOf(getPlayer().getRangedCrit()) + "%");
        Application.lbDefenseShop.setText    (String.valueOf(getPlayer().getDefense()));
        Application.lbEvadeShop.setText      (String.valueOf(getPlayer().getEvade()) + "%");
        // ikisi icin de
        Application.lbMoneyShop.setText  (String.valueOf(getPlayer().getMoney()));
    }

    public static void updateAllBars(){
        barHealthGuncelle();
        barLevelGuncelle();
        barMonsterGuncelle();
    }

    public static void barLevelGuncelle(){
        // panGame icin
        Application.barLevel.setValue(Application.getPlayer().getExperience());
        Application.barLevel.setString( Application.getPlayer().getExperience() + " / " + "1000");
        // panShop icin
        Application.barLevelShop.setValue(Application.getPlayer().getExperience());
        Application.barLevelShop.setString( Application.getPlayer().getExperience() + " / " + "1000");
    }

    public static void barHealthGuncelle(){
        // panGame icin
        Application.barHealth.setMaximum(Application.getPlayer().getMaxHealth());
        Application.barHealth.setValue  (Application.getPlayer().getCurHealth());
        Application.barHealth.setString( Application.getPlayer().getCurHealth() + " / " + Application.getPlayer().getMaxHealth());
        // panShop icin
        Application.barHealthShop.setMaximum(Application.getPlayer().getMaxHealth());
        Application.barHealthShop.setValue  (Application.getPlayer().getCurHealth());
        Application.barHealthShop.setString( Application.getPlayer().getCurHealth() + " / " + Application.getPlayer().getMaxHealth());

    }

    public static void barMonsterGuncelle(){
        // yalnizca progressbar i degil labeli de gunceller
        Application.barMonster.setMaximum(currentMonster.getMaxHealth());
        Application.barMonster.setValue(currentMonster.getHealth());
        Application.barMonster.setString( currentMonster.getHealth() + " / " + currentMonster.getMaxHealth());

        if(currentMonster.getIcon() != Application.lbRight.getIcon()){
            Application.lbRight.setIcon(currentMonster.getIcon());
        }
    }

    public static void tumBarlariKapa(){
        Application.barMonster.setVisible(false);
        Application.barHealth.setVisible(false);
        Application.barLevel.setVisible(false);
        Application.btnSettings2.setVisible(false);
    }

    public static void showAllBars(){
        Application.barMonster.setVisible(true);
        Application.barHealth.setVisible(true);
        Application.barLevel.setVisible(true);
        Application.btnSettings2.setVisible(true);
    }

    public static void dovusButonlariniKapa(){
        Application.btnItems.setVisible(false);
        Application.btnDefend.setVisible(false);
        Application.btnMelee.setVisible(false);
        Application.btnRanged.setVisible(false);
        Application.btnSettings2.setVisible(false);
    }

    public static void dovusButonlariniAc(){
        Application.btnItems.setVisible(true);
        Application.btnDefend.setVisible(true);
        Application.btnMelee.setVisible(true);
        Application.btnRanged.setVisible(true);
        Application.btnSettings2.setVisible(true);
    }

    public static void showAllStats(){
        Application.lbMeleeDam.setVisible(true);
        Application.lbMeleeCrit.setVisible(true);
        Application.lbRangedDam.setVisible(true);
        Application.lbRangedCrit.setVisible(true);
        Application.lbDefense.setVisible(true);
        Application.lbEvade.setVisible(true);
        Application.btnSettings2.setVisible(true);
    }

    public static void statSakla(){
        Application.lbMeleeDam.setVisible(false);
        Application.lbMeleeCrit.setVisible(false);
        Application.lbRangedDam.setVisible(false);
        Application.lbRangedCrit.setVisible(false);
        Application.lbDefense.setVisible(false);
        Application.lbEvade.setVisible(false);
        Application.btnSettings2.setVisible(false);
    }

    public static Player getPlayer() { return player; }

    public static void setOyuncu(Player player) { Application.player = player; }

    public static AbstractMonster getCurrentMonster() { return currentMonster; }

    public static void setCurrentMonster(AbstractMonster currentMonster) { Application.currentMonster = currentMonster; }

    private void hileYap() {
        MonsterCounters.iceOrbIsDone = true;
        MonsterCounters.iceOrbIsStarted = true;
        MonsterCounters.iceOrbSlained = 0;
        MonsterCounters.fireOrbIsDone = true;
        MonsterCounters.fireOrbIsStarted = true;
        MonsterCounters.fireOrbSlained = 0;
        MonsterCounters.yekIsDone = true;
        MonsterCounters.yekIsStarted = true;
        MonsterCounters.yekSlained = 0;
        MonsterCounters.hellSpiderIsDone = true;
        MonsterCounters.hellSpiderIsStarted = true;
        MonsterCounters.hellSpiderSlained = 0;
        MonsterCounters.cerberusIsDone = true;
        MonsterCounters.cerberusIsStarted = true;
        MonsterCounters.cerberusSlained = 0;
        MonsterCounters.phoenixIsDone = true;
        MonsterCounters.phoenixIsStarted = true;
        MonsterCounters.phoenixSlained = 0;
        MonsterCounters.theraphoseBlondiIsDone = true;
        MonsterCounters.theraphoseBlondiIsStarted = true;
        MonsterCounters.theraphoseBlondiSlained = 0;
        MonsterCounters.parilisIsDone = true;
        MonsterCounters.parilisIsStarted = true;
        MonsterCounters.parilisSlained = 0;
        MonsterCounters.veneficusIsDone = true;
        MonsterCounters.veneficusIsStarted = true;
        MonsterCounters.veneficusSlained = 0;
        MonsterCounters.inenormisIsDone = true;
        MonsterCounters.inenormisIsStarted = true;
        MonsterCounters.inenormisSlained = 0;
        MonsterCounters.eunectesIsDone = true;
        MonsterCounters.eunectesIsStarted = true;
        MonsterCounters.eunectesSlained = 0;
        MonsterCounters.armoredChainedCorpseIsDone = true;
        MonsterCounters.armoredChainedCorpseIsStarted = true;
        MonsterCounters.armoredChainedCorpseSlained = 0;
        MonsterCounters.mummyIsDone = true;
        MonsterCounters.mummyIsStarted = true;
        MonsterCounters.mummySlained = 0;
        MonsterCounters.armoredSkeletonIsDone = true;
        MonsterCounters.armoredSkeletonIsStarted = true;
        MonsterCounters.armoredSkeletonSlained = 0;
        MonsterCounters.blueSlimeIsDone = true;
        MonsterCounters.blueSlimeIsStarted = true;
        MonsterCounters.blueSlimeSlained = 0;
        MonsterCounters.chainedCorpseIsDone = true;
        MonsterCounters.chainedCorpseIsStarted = true;
        MonsterCounters.chainedCorpseSlained = 0;
        MonsterCounters.skeletonIsDone = true;
        MonsterCounters.skeletonIsStarted = true;
        MonsterCounters.skeletonSlained = 0;
        MonsterCounters.slimeIsDone = true;
        MonsterCounters.slimeSlained = 0;
        MonsterCounters.shop1 = true;
        MonsterCounters.shop2 = true;
        MonsterCounters.shop3 = true;
        MonsterCounters.shop4 = true;
        MonsterCounters.shop5 = true;
        MonsterCounters.shop6 = true;
        MonsterCounters.shop7 = true;
        MonsterCounters.shop8 = true;
        MonsterCounters.shop9 = true;
    }


} // en son ayrac
