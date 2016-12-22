/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lv99.board_games.domino;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * 
 * @author Ahmed Darweesh
 */
public class singlePlayerMode implements DominoGameMode {
    int index = 0;
    int startingPeices = 8;
    DominoPeice selectedpPeice;

    Array<DominoPlayer> players = new Array<>(2);
    Array<Vector2> deck = new Array<>();
    Array<Vector2> player1Pieces = new Array<>();
    Array<Vector2> player2Pieces = new Array<>();

    public singlePlayerMode(String playerName) {
        DominoPlayer player1 = new DominoPlayer();
        DominoPlayer cpu = new DominoPlayer();
        player1.setPosition(BoardPosition.BOTTOM);
        player1.setName(playerName);
        player1.setOwner(true);
        cpu.setPosition(BoardPosition.TOP);
        players.addAll(player1, cpu);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                deck.add(new Vector2(i, j));
            }
        }
        deck.shuffle();
        for (int i = 0; i < startingPeices; i++) {
            Vector2 v = deck.pop();
            player1Pieces.add(v);
        }
        player1.setStartingPositions(player1Pieces);
        for (int i = 0; i < startingPeices; i++) {
            Vector2 v = deck.pop();
            player2Pieces.add(v);
        }
        cpu.setStartingPositions(player2Pieces);
        player1.setupPieces();
        cpu.setupPieces();

    }

    @Override
    public void switchPlayer() {
        index++;
        if (index > players.size)
            index = 0;
        if (getCurrentPlayer().getPlayerType() == PlayerType.GUEST) {
            getCurrentPlayer().domMove();
        }
    }

    @Override
    public void decideWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPlayersList(Array<DominoPlayer> players) {
        this.players = players;
    }

    @Override
    public DominoPlayer getCurrentPlayer() {
        return players.get(index);
    }

    @Override
    public Array<DominoPlayer> getParticipatingPlayers() {

        return players;
    }

}
