package com.lv99.board_games.domino;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class DominoPlayer {
    String name;
    int score;
    List<DomioPiece> holdedPieces;
    PlayerType playerType;
    Vector2 firstAvailablePoint;
}
