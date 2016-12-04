package com.lv99.board_games.domino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class DominGameScreen implements Screen {
    private final Stage stage;
    int worldWidth=20;
    int worldHeight=20;
    Viewport screen ;
    ShapeRenderer renderer;
    public DominGameScreen() {
        renderer=new ShapeRenderer();
//         screen=new ScreenViewport();
         screen=new ExtendViewport(worldWidth,worldHeight);
        stage = new Stage(screen);

//        DominoPeice actor = new DominoPeice(5, 4, 10, 50, 50, 100);
//        stage.addActor(actor);
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
 screen.apply();
        renderer.setProjectionMatrix(screen.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.RED);
       renderer.rect(1, 1, 2, 2);
       renderer.rect(4, 1, 2, 2);
       renderer.rect(7, 1, 2, 2);
       renderer.rect(10, 1, 2, 2);
       renderer.rect(14, 1, 2, 2);
       renderer.rect(17, 1, 2, 2);
       renderer.rect(21, 1, 2, 2);
       renderer.rect(25, 1, 2, 2);
       renderer.rect(29, 1, 2, 2);
        renderer.end();
        stage.act(delta);

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
        // TODO Auto-generated method stub

    }

}
