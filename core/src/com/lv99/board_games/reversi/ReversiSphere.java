/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lv99.board_games.reversi;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author ahmed_darweeesh
 */
public class ReversiSphere extends Actor {
    private Player player;
    private final ShapeRenderer renderer ;
    public boolean isNotDrawnYet = true;
    void switchPlayer() {
        System.out.println(getColor());
        System.out.println(player.getColor());
        if (player == Player.BLACK) {
            player = Player.WHITE;
        } else {
            player = Player.BLACK;
        }
        System.out.println(player.getColor());
        addAction(color(player.getColor(), 0.5f, Interpolation.linear));
        System.out.println(getColor());

    }
public ReversiSphere(int x, int y, int width, int height,Player player,ShapeRenderer renderer) {
        setBounds(x, y, width, height);
        this.player=player;
        this.renderer=renderer;
        setColor(player.getColor());

    }
    @Override
    public void act(float delta) {
        super.act(delta); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
     
        
        // renderer.setColor(player.getColor());
        // renderer.ellipse(getX(), getY(), getWidth(), getHeight());
    }

    public void drawSphere(Batch batch, float parentAlpha) {
        Color color = getColor();
        renderer.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        // renderer.setColor(player.getColor());
        renderer.ellipse(getX(), getY(), getWidth(), getHeight());
        isNotDrawnYet = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
