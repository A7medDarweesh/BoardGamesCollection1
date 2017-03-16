package com.lv99.board_games.domino;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class DominoStage extends Stage {
    private DominoPeice selectedPiece;

    public DominoStage(Viewport screen) {
        super(screen);
    }

    public DominoPeice getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(DominoPeice selectedPiece) {
        this.selectedPiece = selectedPiece;
    }
}
