/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lv99.board_games.domino;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author Ahmed Darweesh
 */
public interface DominoGameMode {
    void switchPlayer();
    void decideWinner();
    void setPlayersList(Array<DominoPlayer>players);
    DominoPlayer getCurrentPlayer();

    Array<DominoPlayer> getParticipatingPlayers();
    
    
}
