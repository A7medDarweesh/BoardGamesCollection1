/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lv99.board_games.reversi;

import com.badlogic.gdx.graphics.Color;

/**
 *
 * @author ahmed_darweeesh
 */
public enum Player {
    BLACK,WHITE;
    public Color getColor(){
        return this == BLACK ? Color.BLACK : Color.WHITE;
    }
}
