package com.lv99.board_games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lv99.board_games.MainLevel;
import com.lv99.board_games.domino.DominoGame;
import com.lv99.board_games.reversi.ReversiGameBase;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width=600;
                config.height=600;
		new LwjglApplication(new DominoGame(), config);
	}
}
