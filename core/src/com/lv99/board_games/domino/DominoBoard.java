package com.lv99.board_games.domino;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;

public class DominoBoard extends Group {
    DominoStage stage;
    Array<DominoPeice> addedPieces;
    public DominoBoard(float x, float y, float width, float height) {
        setBounds(x, y, width, height);
        DominoBoardFrame frame = new DominoBoardFrame(0, 0, width, height);
        addActor(frame);
        addedPieces = new Array<>();
        addListener(new BoardInputProcessor());


    }
    @Override
    public void act(float delta) {
        super.act(delta);

    }



    public void rotate() {
        addAction(Actions.rotateBy(-15, 0.5f));
        // addAction(Actions.forever(Actions.sequence(Actions.scaleTo(2, 2, 0.5f), Actions.scaleTo(1, 1, 0.5f), Actions.delay(0.5f))));
    }



class BoardInputProcessor extends InputListener {
    @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            if (stage == null) {
                stage = (DominoStage) getStage();
            }
            DominoPeice p = stage.getSelectedPiece();
            if (p != null) {
                stage.getActors().removeValue(p, true);
                addActor(p);
                setActorPosistion(x, y, p);
                addedPieces.add(p);
            }
    }
    @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        if (!(button == Input.Buttons.LEFT || button == Input.Buttons.RIGHT) || pointer > 0)
            return false;
        return true;
    }
}

    public void setActorPosistion(float x, float y, DominoPeice p) {
        if (addedPieces.size > 0) {
            p.setPosition(x, y);
        } else {
            p.setPosition(0, 0);
        }

    }
}
