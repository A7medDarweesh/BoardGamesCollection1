/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lv99.board_games.domino;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 *
 * @author ahmed_darweeesh
 */
class DominoSegmentInputManger extends InputListener {
DomioPiece segment;
    public DominoSegmentInputManger(DomioPiece segment) {
        this.segment=segment;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
         if (button != Input.Buttons.LEFT || pointer > 0)
            return false;
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        segment.toggleFlipState();
    }
    
}
