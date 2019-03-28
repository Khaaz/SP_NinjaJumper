package com.iut.jumper.utils;

import com.iut.jumper.R;

import java.util.HashMap;
import java.util.Map;

public enum PlateformType {
    DEFAULT(R.drawable.plateform_default),
    MOVING_HORIZONTAL(R.drawable.plateform_horizontal),
    MOVING_VERTICAL(R.drawable.plateform_vertical),
    ONE_JUMP(R.drawable.plateform_disappear);

    private int value;
    private static Map map = new HashMap();

    PlateformType(int value) {
        this.value = value;
    }

    static {
        for (PlateformType p : PlateformType.values()) {
            map.put(p.value, p);
        }
    }

    public static PlateformType valueOf(int plateformType) {
        return (PlateformType) map.get(plateformType);
    }

    public int getValue() {
        return value;
    }
}
