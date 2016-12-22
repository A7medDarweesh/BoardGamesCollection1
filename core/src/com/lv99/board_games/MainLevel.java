package com.lv99.board_games;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lv99.board_games.domino.DominGameScreen;
import com.lv99.board_games.domino.singlePlayerMode;

public class MainLevel extends Game {
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new DominGameScreen(new singlePlayerMode("Ahmed")));
	}

	@Override
	public void render () {
        super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
