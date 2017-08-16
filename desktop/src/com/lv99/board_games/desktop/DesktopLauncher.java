package com.lv99.board_games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lv99.board_games.reversi.ReversiGameBase;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1024;
        config.height = 840;
                config.title="Board Games";
        new LwjglApplication(new ReversiGameBase(), config);
	}
}
