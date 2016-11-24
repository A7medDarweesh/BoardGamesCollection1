package com.lv99.board_games.domino;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by ahmed_darweeesh on 11/18/2016.
 */

public class DominoSegment extends Actor {
    private static final int STROKE_WIDTH = 3;
    private DominoValues value;
    ShapeRenderer renderer;
    boolean flipped;

    public DominoSegment(ShapeRenderer renderer, DominoValues value) {
        this.renderer = renderer;
        this.value = value;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.BLACK);
        int effectiveStrokeWidth = flipped ? 0 : STROKE_WIDTH;
        renderer.rect(getX(), getY(), getWidth(), getHeight());
        renderer.setColor(Color.OLIVE);
        renderer.rect(getX() + effectiveStrokeWidth, getY() + effectiveStrokeWidth, getWidth() - (effectiveStrokeWidth * 2), getHeight() - (effectiveStrokeWidth * 2));
        if(flipped){
            drawNumber();
        }
        renderer.end();
        batch.begin();
        
    }

    private void drawNumber() {
        for (int i = 0; i < value.value; i += 2) {
            renderer.circle(value.getCoordinates()[i] * (getWidth() / 10), value.getCoordinates()[i + 1] * (getHeight() / 10), getWidth() * getHeight() / 100);
        }
    }
}
