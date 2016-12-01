package com.lv99.board_games.domino;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Created by ahmed_darweeesh on 11/18/2016.
 */

public class DomioPiece extends Group {
    DominoSegment upperSegment, lowerSegment;
    ShapeRenderer renderer;

    public DomioPiece(int upperNumber, int lowernumber, int x, int y, int width, int height) {
        renderer = new ShapeRenderer();

        DominoValues lower = DominoValues.valueOf(lowernumber);
        DominoValues uper = DominoValues.valueOf(upperNumber);
        lowerSegment = new DominoSegment(renderer, lower);
        lowerSegment.setBounds(x, y, width, height / 2);
        setOrigin(width / 2, height);
        upperSegment = new DominoSegment(renderer, uper);
        upperSegment.setBounds(x, y + (height / 2), width, height / 2);
        addActor(lowerSegment);
        addActor(upperSegment);
        addListener(new DominoSegmentInputManger(this));
    }

    public void rotate() {
        addAction(Actions.rotateBy(-90, 1, Interpolation.circle));
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
