package com.twistral.entities.normal;

import com.twistral.consts.Images;
import com.twistral.consts.Strings;
import com.twistral.entities.AbstractMonster;

public class Slime extends AbstractMonster {
    public Slime(){
        super(20, 15, 0.95f, 0.5f, 0, 12, Strings.slime, Images.slime);
    }
}
