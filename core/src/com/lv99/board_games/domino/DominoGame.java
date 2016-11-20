/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lv99.board_games.domino;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author ahmed_darweeesh
 */
public class DominoGame extends Game {

    ShapeRenderer renderer;
    SpriteBatch batch;
    float starDensity = 0.1f;
    Array<Vector2> starts = new Array<>();
    int scrrenwidth, screenHeight;
    int numberOfStarts = 0;
    int numberOfSegments = 5;
    int lastLineDelta = 10;
    int lowestArea = 50;
    int startingX, startingY, startingWidth, startingHeight = 0;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();
        screenHeight = Gdx.graphics.getHeight();
        scrrenwidth = Gdx.graphics.getWidth();
        numberOfStarts = (int) (scrrenwidth * screenHeight * starDensity);
        startingWidth = Gdx.graphics.getWidth();
        startingHeight = Gdx.graphics.getHeight();

      //  fillStars();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1f, 1, 1, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLACK);
        drawBoard(startingWidth, startingHeight, startingX, startingY);

        renderer.end();

    }

    private void fillStars() {
        for (int i = 0; i < numberOfStarts; i++) {

            starts.add(new Vector2(MathUtils.random(scrrenwidth), MathUtils.random(screenHeight)));
        }
    }

    private void drawBoard(int startingWidth, int startingHeight, int x, int y) {

        int area = startingHeight * startingWidth;
        if (area <= lowestArea) {
            return;
        }
        Array<Rectangle> rects = getAllRects(new Rectangle(x, y, startingWidth, startingHeight));
        for (int i = 0; i < rects.size; i++) {
            Rectangle currentRect = rects.get(i);
            drawBoard((int) currentRect.width, (int) currentRect.height, (int) currentRect.x, (int) currentRect.y);
            if (i == 4) {
                renderer.rect(currentRect.x, currentRect.y, currentRect.width, currentRect.height);
            }
        }
    }

    private Array<Rectangle> getAllRects(Rectangle rect) {
        Array<Rectangle> rects = new Array<>(9);
        int newRectWidth = (int) (rect.width / 3);
        int newRectHeight = (int) (rect.height / 3);
        for (int i = 0; i < 9; i++) {
            rects.add(new Rectangle(rect.x + (i % 3 * (newRectWidth)), rect.y + (i / 3 * (newRectHeight)), newRectWidth, newRectHeight));
        }
        return rects;
    }

}
