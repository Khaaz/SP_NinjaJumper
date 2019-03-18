package com.iut.jumper.core.managers;

import com.iut.jumper.models.AEntity;
import com.iut.jumper.models.Jumper;

import java.util.ArrayList;
import java.util.List;

public class InstanceManager {

    private List<AEntity> plateforms;

    private Jumper jumper;

    public InstanceManager() {
        this.plateforms = new ArrayList<>();
        this.jumper = new Jumper();
    }

    public Jumper getJumper() {
        return jumper;
    }

    public List<AEntity> getPlateforms() {
        return plateforms;
    }
}
