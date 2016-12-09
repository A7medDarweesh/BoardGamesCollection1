package com.lv99.board_games.reversi;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bitfire.postprocessing.PostProcessor;
import com.bitfire.postprocessing.effects.Bloom;
import com.bitfire.utils.ShaderLoader;

public class ReversiGameScreen implements Screen {
    private final Stage stage;
    ReversiGameBase game;
    private int  boardWidth=8,boardHeight=8,pieceWidth=50,pieceHeiht=50;
    private boolean firstDraw=true;
    private Player player;
    int addedSphere;
    public PostProcessor postProcessor;
    RayHandler rayHandler;
    private World world;
    public Bloom bloom;
    private final BoardPiece[]pieces=new BoardPiece[boardWidth*boardHeight];

    public ReversiGameScreen(ReversiGameBase reversiGameBase) {
        ShaderLoader.BasePath = "shaders/";
        world=new World(new Vector2(10, 10), true);
        rayHandler = new RayHandler(world);
         new PointLight(rayHandler, 5, new Color(1,1,1,1),5, 0, 0);
        game = reversiGameBase;
        Viewport fitViewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ScreenViewport screen = new ScreenViewport();
        stage = new Stage(screen);
        Gdx.input.setInputProcessor(stage);

        player=Player.WHITE;
        setUpPostProcessor();
    }

    private void setUpPostProcessor() {
        boolean isDesktop = (Gdx.app.getType() == ApplicationType.Desktop);
        postProcessor = new PostProcessor(false, true, isDesktop);
        bloom = new Bloom((int) (Gdx.graphics.getWidth() * 0.1f), (int) (Gdx.graphics.getHeight() * 0.1f));

        postProcessor.addEffect(bloom);
        //

        // initializeEffects();
    }

    private void drawBoard(boolean redraw) {

        pieceWidth = Gdx.graphics.getWidth() / 10;
        pieceHeiht = (int) ((Gdx.graphics.getHeight() / 10));
        int screenHeight = Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();
        int effectiveDimension=Math.min(pieceWidth, pieceHeiht);
        int xTranslate=(screenWidth-(boardWidth*effectiveDimension))/2;
        int yTranselate=(screenHeight-(boardHeight*effectiveDimension))/2;
        
        if (redraw) {
            Array<Actor> actors = stage.getActors();
            for (int i = 0; i < actors.size; i++) {
                if(actors.get(i)instanceof BoardPiece){
                    BoardPiece piece=(BoardPiece) actors.get(i);
                    piece.resize(xTranslate + (i % boardWidth) * effectiveDimension, yTranselate + (i / boardWidth) * effectiveDimension, effectiveDimension, effectiveDimension);
                }
                
            }
        } else {

            for (int i = 0; i < boardHeight * boardWidth; i++) {
                BoardPiece currentpBoardPiece = new BoardPiece(xTranslate + (i % boardWidth) * pieceWidth, yTranselate + (i / boardWidth) * pieceHeiht, effectiveDimension, effectiveDimension, this, i);
                pieces[i] = currentpBoardPiece;
                stage.addActor(currentpBoardPiece);
            }
        }
        postProcessor.render();
    }
    @Override
    public void render(float delta) {
//        postProcessor.capture();
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.7f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.font.draw(game.batch, "Black:"+0, 0, 0);
        game.batch.end();
        stage.act(delta);

        rayHandler.update();
        rayHandler.render();
        stage.draw();
//        postProcessor.render();
        if(firstDraw){
            drawBoard(false);
            drawBoard(true);
            firstDraw=false;
        }

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        drawBoard(true);

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        stage.dispose();

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    void switchPlayer() {
        if(player==Player.BLACK){
            player=Player.WHITE;
        }else{
            player=Player.BLACK;
        }
    }

    void doMove(int tileNumber) {
        addedSphere++;
        for(Directions dir:Directions.values()){
            int nextTileNumber=tileNumber;
            List<ReversiSphere> spheresToFlip = new LinkedList<>();
        while(true){
            nextTileNumber+=dir.getStep();
            if(nextTileNumber<0||nextTileNumber>=pieces.length){
                 break;
            }
               
                BoardPiece currentPiece = pieces[nextTileNumber];
                if(currentPiece.sphere==null){
                    break;
                }
                if(player==currentPiece.sphere.getPlayer()){
                    for(ReversiSphere s:spheresToFlip){
                        s.switchPlayer();
                    }
                    break;
                }
                   spheresToFlip.add(currentPiece.sphere);
                if (nextTileNumber % 8 == 0 || nextTileNumber % 8 == 7) {
                    break;
                }
        }
    }
        if(addedSphere>=pieces.length){
            showScore();
        }
    }

    private void showScore() {
        
    }

}
