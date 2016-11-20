/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lv99.board_games.reversi;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 *
 * @author ahmed_darweeesh
 */
public class ClickHandler extends ClickListener{
BoardPiece boardPiece;
    public ClickHandler(BoardPiece boardPiece) {
        this.boardPiece=boardPiece;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        // boardPiece.addSphere();
        // System.out.println("current piece="+boardPiece);
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0)
            return false;
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        boardPiece.addSphere();
    }
}
