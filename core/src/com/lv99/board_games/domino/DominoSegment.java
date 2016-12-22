package com.lv99.board_games.domino;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ahmed_darweeesh on 11/18/2016.
 */
public class DominoSegment extends Actor {

    private static final float STROKE_WIDTH = 0.1f;
    private DominoValues value;
    ShapeRenderer renderer;
    boolean flipped;
    Viewport viewport;

    public DominoSegment(ShapeRenderer renderer, DominoValues value, Viewport viewport) {
        this.renderer = renderer;
        this.value = value;
        this.viewport = viewport;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        // renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.BLACK);
        float effectiveStrokeWidth = !flipped ? 0 : STROKE_WIDTH;
        renderer.rect(getX(), getY(), getWidth(), getHeight());
        renderer.setColor(Color.MAROON);
        renderer.rect(getX() + effectiveStrokeWidth, getY() + effectiveStrokeWidth, getWidth() - (effectiveStrokeWidth * 2), getHeight() - (effectiveStrokeWidth * 2));
        if (flipped) {
            renderer.setColor(Color.SALMON);
            drawNumber();
        }
        renderer.end();
        batch.begin();

    }

    private void drawNumber() {
        if (value.getCoordinates() != null)
        for (int i = 0; i < value.getCoordinates().length; i += 2) {
            // System.out.println("value=" + value + " and x=" + getX() + " and x coord=" + value.getCoordinates()[i] + " and effective circle x=" + (getX() + value.getCoordinates()[i]));
            renderer.circle(getX() + (value.getCoordinates()[i] * getWidth()), getY() + (value.getCoordinates()[i + 1] * getHeight()), getWidth() / 10, 40);
        }
    }
}
