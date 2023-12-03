package com.twistral.listeners;

import com.twistral.consts.Sounds;
import com.twistral.utils.*;
import com.twistral.consts.Strings;
import com.twistral.main.Application;
import com.twistral.utils.TKUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class BtnBuyTheWeaponListener implements ActionListener {

    public static HashMap<Integer, Object[]> nesneSozlugu;

    static{

        nesneSozlugu = new HashMap<>();
        // MELEE => [buyValue, type, meleeDamage, meleeCrit]
        nesneSozlugu.put(1,  new Object[] {40,"M",  20, 3} );  // "Wooden Club"
        nesneSozlugu.put(2,  new Object[] {50,"M",  25, 3} );  // "Wooden Sword"
        nesneSozlugu.put(3,  new Object[] {60,"M",  30, 3} );  // "Medieval Axe"
        nesneSozlugu.put(4,  new Object[] {70,"M",  35, 3} );  // "Short Sword"
        nesneSozlugu.put(5,  new Object[] {80,"M",  40, 3} );  // "Knight's Sword"
        nesneSozlugu.put(6,  new Object[] {90,"M",  45, 3} );  // "Paladin's Sword"
        nesneSozlugu.put(7,  new Object[] {100,"M", 55, 3} );  // "Hell Sword"
        nesneSozlugu.put(8,  new Object[] {150,"M", 60, 3} );  // "Odrokus"
        nesneSozlugu.put(9,  new Object[] {200,"M", 80, 3} );  // "Vinegriand"
        nesneSozlugu.put(10, new Object[] {350,"M", 100, 3} );  // "Zugoron"))
        // RANGED => [buyValue, type, rangedDamage, rangedCrit]
        nesneSozlugu.put(11, new Object[] {40, "R", 20, 3} );  // "Wooden Bow"))
        nesneSozlugu.put(12, new Object[] {50, "R", 25, 3} );  // "Shuriken"))
        nesneSozlugu.put(13, new Object[] {60, "R", 30, 3} );  // "Reinforced Bow"))
        nesneSozlugu.put(14, new Object[] {70, "R", 35, 3} );  // "Crossbow"))
        nesneSozlugu.put(15, new Object[] {80, "R", 40, 3} );  // "Kunai"))
        nesneSozlugu.put(16, new Object[] {90, "R", 45, 3} );  // "Onzil"))
        nesneSozlugu.put(17, new Object[] {100,"R", 55, 3} );  // "Hell Bow"))
        nesneSozlugu.put(18, new Object[] {150,"R", 60, 3} );  // "Alav"))
        nesneSozlugu.put(19, new Object[] {200,"R", 80, 3} );  // "Vineregen"))
        nesneSozlugu.put(20, new Object[] {350,"R", 100, 3} );  // "Kotperes"))
        // ARMOR => [buyValue, type, defense]
        nesneSozlugu.put(21, new Object[] {40,"A", 5} );  // "Leather Chestplate"))
        nesneSozlugu.put(22, new Object[] {40,"A", 5} );  // "Leather Helmet"))
        nesneSozlugu.put(23, new Object[] {50,"A", 8} );  // "Silver Chestplate"))
        nesneSozlugu.put(24, new Object[] {50,"A", 8} );  // "Silver Helmet"))
        nesneSozlugu.put(25, new Object[] {70,"A", 10} );  // "Bronze Chestplate"))
        nesneSozlugu.put(26, new Object[] {70,"A", 10} );  // "Bronze Helmet"))
        nesneSozlugu.put(27, new Object[] {100,"A", 12} );  // "Obsidian Chestplate"))
        nesneSozlugu.put(28, new Object[] {100,"A", 12} );  // "Obsidian Helmet"))
        nesneSozlugu.put(29, new Object[] {150,"A", 20} );  // "Dark Robe"))
        nesneSozlugu.put(30, new Object[] {150,"A", 20} );  // "Dark Heart"))
        // OTHERS => [buyValue, type]
        nesneSozlugu.put(31, new Object[] {15,"O"} );  // "Small Health Potion"))
        nesneSozlugu.put(32, new Object[] {25,"O"} );  // "Medium Health Potion"))
        nesneSozlugu.put(33, new Object[] {40,"O"} );  // "Large Health Potion"))
        nesneSozlugu.put(34, new Object[] {15,"O"} );  // "Small Regen Potion"))
        nesneSozlugu.put(35, new Object[] {25,"O"} );  // "Medium Regen Potion"))
        nesneSozlugu.put(36, new Object[] {40,"O"} );  // "Large Regen Potion"))
        nesneSozlugu.put(37, new Object[] {20,"O"} );  // "Water Bottle"))
        nesneSozlugu.put(38, new Object[] {20,"O"} );  // "Strength Potion"))
        nesneSozlugu.put(39, new Object[] {20,"O"} );  // "Antivenom"))
        nesneSozlugu.put(40, new Object[] {20,"O"} );  // "Speed Potion") )
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(Application.lbRightShopDescription.getText() != ""){
            if(silahAdi().startsWith("Wooden Club"))                {satinAlmaIslemi(1);}
            else if(silahAdi().startsWith("Wooden Sword"))          {satinAlmaIslemi(2);}
            else if(silahAdi().startsWith("Medieval Axe"))          {satinAlmaIslemi(3);}
            else if(silahAdi().startsWith("Short Sword"))           {satinAlmaIslemi(4);}
            else if(silahAdi().startsWith("Knight's Sword"))        {satinAlmaIslemi(5);}
            else if(silahAdi().startsWith("Paladin's Sword"))       {satinAlmaIslemi(6);}
            else if(silahAdi().startsWith("Hell Sword"))            {satinAlmaIslemi(7);}
            else if(silahAdi().startsWith("Odrokus"))               {satinAlmaIslemi(8);}
            else if(silahAdi().startsWith("Vinegriand"))            {satinAlmaIslemi(9);}
            else if(silahAdi().startsWith("Zugoron"))               {satinAlmaIslemi(10);}
            else if(silahAdi().startsWith("Wooden Bow"))            {satinAlmaIslemi(11);}
            else if(silahAdi().startsWith("Shuriken"))              {satinAlmaIslemi(12);}
            else if(silahAdi().startsWith("Reinforced Bow"))        {satinAlmaIslemi(13);}
            else if(silahAdi().startsWith("Crossbow"))              {satinAlmaIslemi(14);}
            else if(silahAdi().startsWith("Kunai"))                 {satinAlmaIslemi(15);}
            else if(silahAdi().startsWith("Onzil"))                 {satinAlmaIslemi(16);}
            else if(silahAdi().startsWith("Hell Bow"))              {satinAlmaIslemi(17);}
            else if(silahAdi().startsWith("Alav"))                  {satinAlmaIslemi(18);}
            else if(silahAdi().startsWith("Vineregen"))             {satinAlmaIslemi(19);}
            else if(silahAdi().startsWith("Kotperes"))              {satinAlmaIslemi(20);}
            else if(silahAdi().startsWith("Leather Chestplate"))    {satinAlmaIslemi(21);}
            else if(silahAdi().startsWith("Leather Helmet"))        {satinAlmaIslemi(22);}
            else if(silahAdi().startsWith("Silver Chestplate"))     {satinAlmaIslemi(23);}
            else if(silahAdi().startsWith("Silver Helmet"))         {satinAlmaIslemi(24);}
            else if(silahAdi().startsWith("Bronze Chestplate"))     {satinAlmaIslemi(25);}
            else if(silahAdi().startsWith("Bronze Helmet"))         {satinAlmaIslemi(26);}
            else if(silahAdi().startsWith("Obsidian Chestplate"))   {satinAlmaIslemi(27);}
            else if(silahAdi().startsWith("Obsidian Helmet"))       {satinAlmaIslemi(28);}
            else if(silahAdi().startsWith("Dark Robe"))             {satinAlmaIslemi(29);}
            else if(silahAdi().startsWith("Dark Heart"))            {satinAlmaIslemi(30);}
            else if(silahAdi().startsWith("Small Health Potion"))   {satinAlmaIslemi(31);}
            else if(silahAdi().startsWith("Medium Health Potion"))  {satinAlmaIslemi(32);}
            else if(silahAdi().startsWith("Large Health Potion"))   {satinAlmaIslemi(33);}
            else if(silahAdi().startsWith("Small Regen Potion"))    {satinAlmaIslemi(34);}
            else if(silahAdi().startsWith("Medium Regen Potion"))   {satinAlmaIslemi(35);}
            else if(silahAdi().startsWith("Large Regen Potion"))    {satinAlmaIslemi(36);}
            else if(silahAdi().startsWith("Water Bottle"))          {satinAlmaIslemi(37);}
            else if(silahAdi().startsWith("Strength Potion"))       {satinAlmaIslemi(38);}
            else if(silahAdi().startsWith("Antivenom"))             {satinAlmaIslemi(39);}
            else if(silahAdi().startsWith("Speed Potion") )         {satinAlmaIslemi(40);}
            Application.invGuncelle();
        }}

    public static String silahAdi(){
        return Application.lbRightShopDescription.getText().substring(Strings.pre2.length() + "<span style='font-size:19px;'>".length(), Application.lbRightShopDescription.getText().indexOf(Strings.post2));
    }

    public static void satinAlmaIslemi(int i){
        Object[] dizi = nesneSozlugu.get(i);
        if(Application.getPlayer().getMoney() >= Integer.parseInt(dizi[0].toString()) && Application.arrShopLabels[i-1].isEnabled() ){ // alabiliyor ise
            TKUtils.playClipMod(Sounds.clipBuy1, Sounds.clipBuy2, Sounds.clipBuy3);
            // onceki butonlari setDisabled() yapma
            if(i>=1 && i<=10){  for(int y = i; y!=0; y--){Application.arrShopLabels[y-1].setEnabled(false);}  }
            else if(i>=11 && i<=20){  for(int y = i; y!=10; y--){Application.arrShopLabels[y-1].setEnabled(false);}  }
            else if(i>=21 && i<=30){  for(int y = i; y>=21; y-=2){Application.arrShopLabels[y-1].setEnabled(false);}  }
            // nesneyi verme
            Application.getPlayer().setMoney(Application.getPlayer().getMoney() - Integer.parseInt(dizi[0].toString()));
            if (dizi[1].toString() == "M") {
                Application.getPlayer().setMeleeDamage(Application.getPlayer().getMeleeDamage() + Integer.parseInt(dizi[2].toString()));
                Application.getPlayer().setMeleeCrit(Application.getPlayer().getMeleeCrit() + Integer.parseInt(dizi[3].toString()));
            }
            else if (dizi[1].toString() == "R") {
                Application.getPlayer().setRangedDamage(Application.getPlayer().getRangedDamage() + Integer.parseInt(dizi[2].toString()));
                Application.getPlayer().setRangedCrit(Application.getPlayer().getRangedCrit() + Integer.parseInt(dizi[3].toString()));
            }
            else if (dizi[1].toString() == "A") {
                Application.getPlayer().setDefense(Application.getPlayer().getDefense() + Integer.parseInt(dizi[2].toString()));
            }
            else if (dizi[1].toString() == "O") {
                if(i == 31)     {Application.getPlayer().getInventory().put("smallHealthPotion", Application.getPlayer().getInventory().get("smallHealthPotion") + 1 );}
                else if(i == 32){Application.getPlayer().getInventory().put("mediumHealthPotion",Application.getPlayer().getInventory().get("mediumHealthPotion") + 1 );}
                else if(i == 33){Application.getPlayer().getInventory().put("largeHealthPotion",Application.getPlayer().getInventory().get("largeHealthPotion") + 1 );}
                else if(i == 34){Application.getPlayer().getInventory().put("smallRegenerationPotion",Application.getPlayer().getInventory().get("smallRegenerationPotion") + 1 );}
                else if(i == 35){Application.getPlayer().getInventory().put("mediumRegenerationPotion",Application.getPlayer().getInventory().get("mediumRegenerationPotion") + 1 );}
                else if(i == 36){Application.getPlayer().getInventory().put("largeRegenerationPotion",Application.getPlayer().getInventory().get("largeRegenerationPotion") + 1 );}
                else if(i == 37){Application.getPlayer().getInventory().put("waterBottle",Application.getPlayer().getInventory().get("waterBottle") + 1 );}
                else if(i == 38){Application.getPlayer().getInventory().put("strengthPotion",Application.getPlayer().getInventory().get("strengthPotion") + 1 );}
                else if(i == 39){Application.getPlayer().getInventory().put("antivenom",Application.getPlayer().getInventory().get("antivenom") + 1 );}
                else if(i == 40){Application.getPlayer().getInventory().put("speedPotion",Application.getPlayer().getInventory().get("speedPotion") + 1 );}
            }
        }
        else{
            ClipUtils.playClip(Sounds.clipFailed);
        }

        Application.updateAllBars();
        Application.updateStats();
    }


}
