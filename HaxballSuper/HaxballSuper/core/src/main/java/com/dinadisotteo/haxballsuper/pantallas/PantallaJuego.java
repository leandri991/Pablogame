package com.dinadisotteo.haxballsuper.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dinadisotteo.haxballsuper.elementos.Jugador;
import com.dinadisotteo.haxballsuper.elementos.Pelota;
import com.dinadisotteo.haxballsuper.utiles.Config;
import com.dinadisotteo.haxballsuper.utiles.Render;

import io.Entradas;

public class PantallaJuego implements Screen{
	
    private Jugador player;
    private Pelota pelota;
	private SpriteBatch batch;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;
    private Viewport viewport;
    private World world;
    private Entradas entradas;
    
   public  PantallaJuego(){
    	batch = new SpriteBatch();
    	player = new Jugador(200,200,36,36);
        world = new World(new Vector2(0, 0), true);
    	
    }
    
	@Override
	public void show() {
		batch = Render.batch;

        map = new TmxMapLoader().load("mapas/cancha.tmx");


        mapRenderer = new OrthogonalTiledMapRenderer(map);
        
         entradas = new Entradas();
         Gdx.input.setInputProcessor(entradas);

        camera = new OrthographicCamera();
        viewport = new FitViewport(Config.ANCHO, Config.ALTO, camera);
        camera.position.set(Config.ANCHO/ 2f, Config.ALTO / 2f, 0);
        pelota = new Pelota(world, (Config.ANCHO/2), (Config.ALTO/2), 4);
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(1, 1, 1);
	
	    camera.update();
	    mapRenderer.setView(camera);
	    mapRenderer.render();
	    
        batch.begin();
	    pelota.render(batch);
	    player.dibujar();
	    batch.end();
	    
	    world.step(1/60f, 6, 2);  
	    
	  // float speed = 200 * delta; 
       // float deltaX = 100, deltaY = 100;
       

        if(entradas.isIzquierda()||entradas.isA()) {
        	player.setX(player.getX() - 3);
        }
        if(entradas.isDerecha()||entradas.isD()) {
        	player.setX(player.getX() + 3);
        }
        if(entradas.isArriba()||entradas.isW()) {
        	player.setY(player.getY() + 3);
        }
        if(entradas.isAbajo()||entradas.isS()) {
        	player.setY(player.getY() - 3);
        }
        
	}

	@Override
	public void resize(int width, int height) {
		 viewport.update(width, height);
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		 
	}

}