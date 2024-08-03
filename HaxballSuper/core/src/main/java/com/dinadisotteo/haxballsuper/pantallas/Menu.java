package com.dinadisotteo.haxballsuper.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dinadisotteo.haxballsuper.elementos.Imagen;
import com.dinadisotteo.haxballsuper.elementos.Texto;
import com.dinadisotteo.haxballsuper.utiles.Config;
import com.dinadisotteo.haxballsuper.utiles.Recursos;
import com.dinadisotteo.haxballsuper.utiles.Render;

import io.Entradas;

public class Menu implements Screen{

	Imagen fondo;
	SpriteBatch b;
	
	
	

	Texto opciones[] = new Texto[3];
	String textos[] = {"PATADA INCIAL", "OPCIONES", "SALIR"};
	
	int opc=1;
	
	public float tiempo = 0;
	
	Entradas entradas = new Entradas(this);
    
	
	@Override
	public void show() {

		fondo = new Imagen(Recursos.FONDO);
		fondo.setSize(Config.ANCHO, Config.ALTO);
		b = Render.batch;
		
	   Gdx.input.setInputProcessor(entradas);
	   
	   for(int i = 0; i < opciones.length; i++) {
		   opciones[i] = new Texto(Recursos.FUENTEMENU, 60 , Color.WHITE, true);
		   opciones[i].setTexto(textos[i]);
		   opciones[i].setPosition(380, 300- (i * 50));
	   }
	

		
		
		
	}

	@Override
	public void render(float delta) {
		b.begin();
		fondo.dibujar();
		for(int i = 0; i<opciones.length; i++) {
			opciones[i].dibujar();
		}
		b.end();
		
		tiempo+=delta;
	
		 if(entradas.isAbajo()){
			 if(tiempo>0.1f) {
				 tiempo=0;
		        opc++;
		        if (opc > 3) { 
		            opc = 1;
		        }
		 }
			 }

		 if(entradas.isArriba()){
			 if(tiempo>0.1f) {
				 tiempo=0;
		        opc--;
		        if (opc < 1) { 
		            opc = 3;
		        }
		 }
			 }
		 
		 for(int i = 0; i < opciones.length; i++) {
			 if(i==(opc-1)) {
				 opciones[i].setColor(Color.GREEN);
				 
			 }else {
				 opciones[i].setColor(Color.WHITE);
			 }
		 }
		 
		 if(entradas.isEnter()) {
			 if(opc == 1) {
				 Render.app.setScreen(new PantallaJuego());
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
