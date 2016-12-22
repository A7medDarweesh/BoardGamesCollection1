/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lv99.board_games.domino;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Ahmed Darweesh
 */
public enum BoardPosition {
    TOP(1.8f, 0, new Vector2(3, 16.75f)), BOTTOM(1.8f, 0, new Vector2(3, 0.25f)), LEFT(0, -1, new Vector2(1, 19)), RIGHT(0, 1, new Vector2(19, 1));
    float xIncrement, yIncrement;
    Vector2 startingPosition;

    private BoardPosition(float xIncrement, float yIncrement, Vector2 startingPosition) {
        this.xIncrement = xIncrement;
        this.yIncrement = yIncrement;
        this.startingPosition = startingPosition;
    }
    
    
}
