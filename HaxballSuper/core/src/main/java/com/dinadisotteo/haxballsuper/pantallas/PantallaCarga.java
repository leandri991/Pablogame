package com.dinadisotteo.haxballsuper.pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dinadisotteo.haxballsuper.elementos.Imagen;
import com.dinadisotteo.haxballsuper.utiles.Recursos;
import com.dinadisotteo.haxballsuper.utiles.Render;

public class PantallaCarga implements Screen{

	Imagen fondo;
	SpriteBatch b;
	boolean fadeInterminado = false, termina = false;
	float a = 0;
	float tiempoEspera = 5, contTiempo = 0;
    float contTiempoTermina=0;
	float tiempoTermina=5;
	
	@Override
	public void show() {
	 fondo = new Imagen(Recursos.LOGO);
	 b = Render.batch;
	 fondo.setTransparencia(a);
	}

	@Override
	public void render(float delta) {
	   Render.limpiarPantalla(0, 0, 0);
	   b.begin();
	   fondo.dibujar();
	   b.end();
	   
	   procesarFade();
	}
	
	private void procesarFade() {
		if (!fadeInterminado) {
			a += 0.1f;

			if (a > 1) {
				a = 1;
				fadeInterminado = true;
			}
		}else {
			 contTiempo += 0.1f;
			if(contTiempo>tiempoEspera) {
				a -= 0.01f;

				if (a < 0) {
					a = 0;
					termina = true;
			}
				}
		}
		fondo.setTransparencia(a);
		
		if(termina) {
			System.out.println("si");
			contTiempoTermina+=0.1f;
			if(contTiempoTermina>tiempoTermina) {
				Render.app.setScreen(new Menu());
			}
		}
		
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
