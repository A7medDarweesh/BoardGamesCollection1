package com.lv99.board_games.domino;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class DominoPlayer {
    private String name;
    private int score;
    private Array<DominoPeice> holdedPieces = new Array<>();
    private Array<Vector2> startingNumbers;
    private PlayerType playerType;
    private Vector2 firstAvailablePoint;
    private BoardPosition position;
    private boolean owner;

    public DominoPlayer() {
    }

    public void setupPieces() {
        Vector2 startingPosition = position.startingPosition;
        float i = 0;
        for (Vector2 numberPair : startingNumbers) {
            float posX = startingPosition.x + (i * position.xIncrement);
            float posY = startingPosition.y + (i++ * position.yIncrement);
            DominoPeice piece = new DominoPeice((int) numberPair.x, (int) numberPair.y, posX, posY, Constants.PICE_WIDTH, Constants.PIECE_HEIGHT, null);
            if (owner) {
                piece.toggleFlipState();
            }
            holdedPieces.add(piece);
        }

    }
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
    public Array<DominoPeice> getHoldedPieces() {
        return holdedPieces;
    }

    /**
     * @param holdedPieces the holdedPieces to set
     */
    public void setHoldedPieces(Array<DominoPeice> holdedPieces) {
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

    public Array<Vector2> getStartingPositions() {
        return startingNumbers;
    }

    public void setStartingPositions(Array<Vector2> startingPositions) {
        this.startingNumbers = startingPositions;
    }

    public void setOwner(boolean b) {
        this.owner = b;

    }
    
}
