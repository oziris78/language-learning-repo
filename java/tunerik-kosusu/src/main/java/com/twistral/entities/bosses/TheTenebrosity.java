package com.twistral.entities.bosses;

import com.twistral.consts.Images;
import com.twistral.consts.Strings;
import com.twistral.entities.AbstractMonster;
import com.twistral.main.Application;

public class TheTenebrosity extends AbstractMonster {

    public TheTenebrosity(){
        super(500, 70, 0.65f, 0.65f, 40, 9999, Strings.theTenebrosity,
                Application.getPlayer().getCharacterImage().equals(Images.tekin) ? Images.theTenebrosityTEKIN : Images.theTenebrosityAYCA);
    }


}
