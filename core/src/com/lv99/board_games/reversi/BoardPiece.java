package com.lv99.board_games.reversi;

import box2dLight.RayHandler;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.bitfire.postprocessing.PostProcessor;

public class BoardPiece extends Actor {

    private final ShapeRenderer renderer = new ShapeRenderer();
    private static final int STROKE_WIDTH = 5;
    ReversiSphere sphere;
    private final ReversiGameScreen game;
    private final int tileNumber;
    PostProcessor post;
    RayHandler rayHandler;

    public BoardPiece(int x, int y, int width, int height, ReversiGameScreen game, int tileNumber, RayHandler rayHandler) {
        setBounds(x, y, width, height);
        this.game = game;
        addListener(new ClickHandler(this));
        this.tileNumber = tileNumber;
        this.rayHandler = rayHandler;
    }

    public void resize(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        if(sphere!=null)
        sphere.setBounds((int) (getWidth() / 4 + getX()), (int) (getHeight() / 4 + getY()), (int) getWidth() / 2, (int) getHeight() / 2);
    }

    @Override
    public String toString() {
        return (getX() + ";" + getY());
    }

    @Override
    public void act(float delta) {

        super.act(delta);
        if (sphere != null)
            sphere.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
//        renderer.translate(getX(), getY(), 0);

        renderer.begin(ShapeType.Filled);
        renderer.setColor(0.5f, 0.3f, 0.1f, 0.0f);

        renderer.rect(getX(), getY(), getWidth(), getHeight());
        renderer.setColor(125 / 255f, 125 / 255f, 125 / 255f, 0.7f);
        renderer.rect(getX() + STROKE_WIDTH, getY() + STROKE_WIDTH, getWidth() - (STROKE_WIDTH * 2), getHeight() - (STROKE_WIDTH * 2));
        if (sphere != null) {
            sphere.drawSphere(batch, parentAlpha);
        }
        //
        // rayHandler.update();
        // rayHandler.render();
        renderer.end();
        batch.begin();

    }

    public void addSphere() {
        if (sphere == null) {
            sphere = new ReversiSphere((int) (getWidth() / 4 + getX()), (int) (getHeight() / 4 + getY()), (int) getWidth() / 2, (int) getHeight() / 2, game.getPlayer(), renderer);
            game.doMove(tileNumber);
            game.switchPlayer();
        } else {

        }
    }
}
