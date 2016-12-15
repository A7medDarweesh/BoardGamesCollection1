package com.lv99.board_games.domino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class DominoBoard extends Group {

    public DominoBoard(float x, float y, float width, float height) {
        setBounds(x, y, width, height);
        DominoBoardFrame frame = new DominoBoardFrame(0, 0, width, height);
        addActor(frame);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.ALT_LEFT)) {
            rotate();
        }
    }



    public void rotate() {
        addAction(Actions.rotateBy(-15, 0.5f));
        // addAction(Actions.forever(Actions.sequence(Actions.scaleTo(2, 2, 0.5f), Actions.scaleTo(1, 1, 0.5f), Actions.delay(0.5f))));
    }
}
