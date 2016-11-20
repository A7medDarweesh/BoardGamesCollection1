/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lv99.board_games.reversi;

/**
 *
 * @author ahmed_darweeesh
 */
public enum Directions {
    SOUTH(-8),NORTH(8),EAST(1),WEST(-1),NORTH_WEST(7),NORTH_EAST(9),SOUTH_WEST(-9),SOUTHEAST(-7);
    private final int step;

    private Directions(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    
}
