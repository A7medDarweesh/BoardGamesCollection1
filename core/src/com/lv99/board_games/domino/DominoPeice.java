package com.lv99.board_games.domino;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ahmed_darweeesh on 11/18/2016.
 */

public class DominoPeice extends Group {
    DominoSegment upperSegment, lowerSegment;
    ShapeRenderer renderer;

    public DominoPeice(int upperNumber, int lowernumber, float x, float y, float width, float height, Viewport viewport) {
        renderer = new ShapeRenderer();
        System.out.println(x);
        // setBounds(x, y, width, height);
        DominoValues lower = DominoValues.valueOf(lowernumber);
        DominoValues uper = DominoValues.valueOf(upperNumber);
        lowerSegment = new DominoSegment(renderer, lower, viewport);
        lowerSegment.setBounds(x, y, width, height / 2);
        setOrigin(x + width / 2, y + height / 2);
        upperSegment = new DominoSegment(renderer, uper, viewport);
        upperSegment.setBounds(x, y + (height / 2), width, height / 2);
        addActor(lowerSegment);
        addActor(upperSegment);
        addListener(new DominoSegmentInputManger(this));
    }

    @Override
    public void act(float delta) {
        // TODO Auto-generated method stub
        super.act(delta);
    }
    public void rotate() {
        addAction(Actions.rotateBy(-90, 0.5f));
        // addAction(Actions.forever(Actions.sequence(Actions.scaleTo(2, 2, 0.5f), Actions.scaleTo(1, 1, 0.5f), Actions.delay(0.5f))));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        super.draw(batch, parentAlpha);
    }

    void toggleFlipState() {
        lowerSegment.flipped=!lowerSegment.flipped;
        upperSegment.flipped=!upperSegment.flipped;
    }
}
