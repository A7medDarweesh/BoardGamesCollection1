package com.lv99.board_games.domino;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DominoBoardFrame extends Actor {
    private static final float STROKE_WIDTH = 0.3f;
    ShapeRenderer renderer;

    public DominoBoardFrame(float x, float y, float width, float height) {
        renderer = new ShapeRenderer();
        setBounds(x, y, width, height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.end();

        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.BROWN);
        renderer.rect(getX(), getY(), getWidth(), getHeight());
        renderer.setColor(Color.GREEN);
        renderer.rect(getX() + STROKE_WIDTH, getY() + STROKE_WIDTH, getWidth() - (STROKE_WIDTH * 2), getHeight() - (STROKE_WIDTH * 2));

        renderer.end();
       
        batch.begin();

    }
}
