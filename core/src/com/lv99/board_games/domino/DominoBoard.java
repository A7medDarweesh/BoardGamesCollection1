package com.lv99.board_games.domino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class DominoBoard extends Group {
    private static final float STROKE_WIDTH = 0.3f;
    ShapeRenderer renderer;
    public DominoBoard(float x, float y, float width, float height) {
        setBounds(x, y, width, height);
        renderer = new ShapeRenderer();
    }
    @Override
    public void act(float delta) {
        super.act(delta);
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
        if (Gdx.input.isKeyPressed(Input.Keys.ALT_LEFT)) {
            rotate();
        }
        batch.begin();
        drawChildren(batch, parentAlpha);

    }

    public void rotate() {
        addAction(Actions.rotateBy(-90, 0.5f));
        // addAction(Actions.forever(Actions.sequence(Actions.scaleTo(2, 2, 0.5f), Actions.scaleTo(1, 1, 0.5f), Actions.delay(0.5f))));
    }
}
