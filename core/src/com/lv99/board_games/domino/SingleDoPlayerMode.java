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
public class SingleDoPlayerMode implements DominoGameMode{
    int index=0;
    int startingPeices=8;
    DominoPeice selectedpPeice;
    
Array<DominoPlayer> players=new Array<>(2);
    Array<Vector2>deck=new Array<>();

    public SingleDoPlayerMode(String playerName) {
        DominoPlayer player1=new DominoPlayer();
        DominoPlayer cpu=new DominoPlayer();
        player1.setPosition(BoardPosition.BOTTOM);
        player1.setName(playerName);
        cpu.setPosition(BoardPosition.TOP);
        players.addAll(player1,cpu);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                deck.add(new Vector2(i, j));
            }
        }
        deck.shuffle();
        for(int i=0;i<startingPeices;i++){
            System.out.println("size="+deck.size);
            Vector2 v = deck.pop();
            
            
        }
        
    }

    @Override
    public void switchPlayer() {
        index++;
        if(index>players.size)
            index=0;
        if(getCurrentPlayer().getPlayerType()==PlayerType.GUEST){
            getCurrentPlayer().domMove();
        }
    }

    @Override
    public void decideWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPlayersList(Array<DominoPlayer> players) {
        this.players=players;
    }

    @Override
    public DominoPlayer getCurrentPlayer() {
       return players.get(index);
    }
    
}
