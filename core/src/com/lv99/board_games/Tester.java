/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lv99.board_games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 *
 * @author Ahmed Darweesh
 */
public class Tester extends ApplicationAdapter{
   
    static final float WORLD_SIZE = 10;

    ShapeRenderer renderer;
    FitViewport viewport;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.RED);
        renderer.rect(2, 3.5f, 3, 1.5f, 8, 1, 1, 1, 0);
        renderer.setColor(Color.GREEN);
        renderer.rect(2, 3.5f, 3, 1.5f, 6, 2, 1, 1, 120);
        renderer.setColor(Color.BLUE);
        renderer.rect(2, 3.5f, 3, 1.5f, 6, 1, 1, 1, 240);

        // TODO: Make it look like the left end of RED is on top of BLUE
        renderer.setColor(Color.RED);
        renderer.rect(2, 3.5f, 3, 1.5f, 3, 1, 1, 1, 0);
        renderer.end();
    }
}
