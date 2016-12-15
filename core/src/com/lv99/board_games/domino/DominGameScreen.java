package com.lv99.board_games.domino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class DominGameScreen implements Screen {
    private final Stage stage;
    int worldWidth=20;
    int worldHeight=20;
    Viewport screen ;
    ShapeRenderer renderer;
    public DominGameScreen() {
        renderer=new ShapeRenderer();
        // screen=new ScreenViewport();
        screen = new ExtendViewport(worldWidth, worldHeight, worldWidth, worldHeight);
        // screen = new FillViewport(worldWidth, worldHeight);
        stage = new Stage(screen);
        DominoBoard board = new DominoBoard(2f, 2f, 16, 16);
        for (int i = 0; i < 8; i++) {
            DominoPeice actor = new DominoPeice(MathUtils.random(0, 6), MathUtils.random(0, 6), 2f + (i), 0.1f, 0.75f, 1.5f, screen);
            stage.addActor(actor);

        }
        stage.addActor(board);
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.7f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act(delta);
        screen.apply();

        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
       screen.update(width, height, true);

    }

    @Override
    public void pause() {
        

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        renderer.dispose();

    }

}
