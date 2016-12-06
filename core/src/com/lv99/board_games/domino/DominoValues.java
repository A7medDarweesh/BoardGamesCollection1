package com.lv99.board_games.domino;

import java.util.HashMap;
import java.util.Map;


public enum DominoValues {
    ONE(1, new float[] { 0.5f, 0.5f }),
    ZERO(0, null),
    TWO(2, new float[] { 0.3f, 0.3f, 0.7f, 0.7f }),
    THREE(3, new float[] { 0.3f, 0.3f, 0.5f, 0.5f, 0.7f, 0.7f }),
    FOUR(4, new float[] { 0.3f, 0.3f, 0.7f, 0.3f, 0.3f, 0.7f, 0.7f, 0.7f }),
    FIVE(5, new float[] { 0.3f, 0.3f, 0.7f, 0.3f, 0.3f, 0.7f, 0.7f, 0.7f, 0.5f, 0.5f }),
    SIX(6, new float[] { 0.3f, 0.3f, 0.7f, 0.3f, 0.3f, 0.7f, 0.7f, 0.7f, 0.3f, 0.5f, 0.7f, 0.5f });

    private DominoValues(int value, float[] coordinates) {
        this.value = value;
        this.coordinates = coordinates;
    }

    private static Map<Integer, DominoValues> map = new HashMap<>();

    static {
        for (DominoValues value : DominoValues.values()) {
            map.put(value.value, value);
        }
    }



    public static DominoValues valueOf(int legNo) {
        return map.get(legNo);
    }

    int value;
    float[] coordinates;

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the coordinates
     */
    public float[] getCoordinates() {
        return coordinates;
    }

}
