package com.lv99.board_games.domino;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class DominoPlayer {
    private String name;
    private int score;
    private List<DominoPeice> holdedPieces;
    private PlayerType playerType;
    private Vector2 firstAvailablePoint;
    private BoardPosition position;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the holdedPieces
     */
    public List<DominoPeice> getHoldedPieces() {
        return holdedPieces;
    }

    /**
     * @param holdedPieces the holdedPieces to set
     */
    public void setHoldedPieces(List<DominoPeice> holdedPieces) {
        this.holdedPieces = holdedPieces;
    }

    /**
     * @return the playerType
     */
    public PlayerType getPlayerType() {
        return playerType;
    }

    /**
     * @param playerType the playerType to set
     */
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    /**
     * @return the firstAvailablePoint
     */
    public Vector2 getFirstAvailablePoint() {
        return firstAvailablePoint;
    }

    /**
     * @param firstAvailablePoint the firstAvailablePoint to set
     */
    public void setFirstAvailablePoint(Vector2 firstAvailablePoint) {
        this.firstAvailablePoint = firstAvailablePoint;
    }

    void domMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BoardPosition getPosition() {
        return position;
    }

    public void setPosition(BoardPosition position) {
        this.position = position;
    }
    
}
