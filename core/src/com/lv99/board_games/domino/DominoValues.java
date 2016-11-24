package com.lv99.board_games.domino;

import java.util.HashMap;
import java.util.Map;


public enum DominoValues {
    ONE(1, new int[] { 5, 5 }),
    TWO(2, new int[] { 2, 2, 9, 9 }),
    THREE(3, new int[] { 2, 2, 5, 5, 9, 9 }),
    FOUR(4, new int[] { 2, 2, 8, 2, 2, 8, 8, 8 }),
    FIVE(5, new int[] { 2, 2, 8, 2, 2, 8, 8, 8, 5, 5 }),
    SIX(6, new int[] { 2, 2, 8, 2, 2, 8, 8, 8, 2, 5, 8, 5 });

    private DominoValues(int value, int[] coordinates) {
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
    int[] coordinates;

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the coordinates
     */
    public int[] getCoordinates() {
        return coordinates;
    }

}
