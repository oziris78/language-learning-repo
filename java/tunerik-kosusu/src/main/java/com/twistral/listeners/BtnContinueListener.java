package com.twistral.listeners;

import com.twistral.consts.Sounds;
import com.twistral.utils.*;
import com.twistral.entities.AbstractMonster;
import com.twistral.entities.MonsterCounters;
import com.twistral.entities.normal.*;
import com.twistral.main.Application;
import com.twistral.utils.TKUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnContinueListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        ClipUtils.playClip(Sounds.clipMenuClick1);

        if(MonsterCounters.iceOrbIsDone){ // dark orba yolla
            MonsterCounters.darkOrbSlained--;
            funcWorker(new DarkOrb());
        }
        else if(MonsterCounters.hellSpiderIsDone){ // fire orb'a yolla
            MonsterCounters.fireOrbSlained--;
            funcWorker(new FireOrb());
        }
        else if(MonsterCounters.cerberusIsDone){ // hellSpider a yolla
            MonsterCounters.hellSpiderSlained--;
            funcWorker(new HellSpider());
        }
        else if(MonsterCounters.parilisIsDone){ // phoenix e yolla
            MonsterCounters.phoenixSlained--;
            funcWorker(new Phoenix());
        }
        else if(MonsterCounters.veneficusIsDone){ // parilis e yolla
            MonsterCounters.parilisSlained--;
            funcWorker(new ParilisAranea());
        }
        else if(MonsterCounters.armoredChainedCorpseIsDone){ // inenormis e yolla
            MonsterCounters.inenormisSlained--;
            funcWorker(new InenormisAranea());
        }
        else if(MonsterCounters.mummyIsDone){ // armored chained corpse a yolla
            MonsterCounters.armoredChainedCorpseSlained--;
            funcWorker(new ArmoredChainedCorpse());
        }
        else if(MonsterCounters.chainedCorpseIsDone){ // armored skeleton a yolla
            MonsterCounters.armoredSkeletonSlained--;
            funcWorker(new ArmoredSkeleton());
        }
        else if(MonsterCounters.skeletonIsDone){ // chained corpse a yolla
            MonsterCounters.chainedCorpseSlained--;
            funcWorker(new ChainedCorpse());
        }
    }

    public static void funcWorker(AbstractMonster newMonster){
        new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                Application.dovusButonlariniKapa();
                Application.panShop.setVisible(false);
                Application.panGame.setVisible(true);
                Application.setCurrentMonster(newMonster);
                Application.updateAllBars();
                Application.updateStats();
                Application.lbRight.setIcon(newMonster.getIcon());
                TKUtils.sleepMilisecs(500);
                Algorithms.yaratikYazisiniYaz(newMonster);
                return null;
            }
        }.execute();
    }


}
