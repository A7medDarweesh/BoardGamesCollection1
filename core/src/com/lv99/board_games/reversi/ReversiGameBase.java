package com.lv99.board_games.reversi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ReversiGameBase extends Game{
    SpriteBatch batch;
    BitmapFont font;
    @Override
    public void create() {
        batch = new SpriteBatch();
        
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        this.setScreen(new ReversiGameScreen(this));
        
    }
    @Override
    public void render() {
        // TODO Auto-generated method stub
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
