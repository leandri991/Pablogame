package com.dinadisotteo.haxballsuper.pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dinadisotteo.haxballsuper.utiles.Config;
import com.dinadisotteo.haxballsuper.utiles.Render;

public class PantallaJuego implements Screen{

	private SpriteBatch batch;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;
    private Viewport viewport;

	@Override
	public void show() {
		batch = Render.batch;

        // Cargar el mapa de Tiled
        map = new TmxMapLoader().load("mapas/cancha.tmx");

        // Crear el renderizador de mapas
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        // Configurar la cámara
        camera = new OrthographicCamera();
        viewport = new FitViewport(Config.ANCHO, Config.ALTO, camera);
        camera.position.set(Config.ANCHO/ 2f, Config.ALTO / 2f, 0);
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(1, 1, 1);
	}

	@Override
	public void resize(int width, int height) {
		
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
