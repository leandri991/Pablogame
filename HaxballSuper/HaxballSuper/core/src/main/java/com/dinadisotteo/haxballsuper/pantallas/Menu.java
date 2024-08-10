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
	
	int opc = 1;
	boolean mouseArriba = false;
	public float tiempo = 0;
	
	
	
	Entradas entradas = new Entradas();
    
	
	@Override
	public void show() {

		fondo = new Imagen(Recursos.FONDO);
		fondo.setSize(Config.ANCHO, Config.ALTO);
		b = Render.batch;
		
	   Gdx.input.setInputProcessor(entradas);
	   
	   for(int i = 0; i < opciones.length; i++) {
		   opciones[i] = new Texto(Recursos.FUENTEMENU, 60 , Color.WHITE, true);
		   opciones[i].setTexto(textos[i]);
		   opciones[i].setPosition(500, 300 - (i * 50));
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
		 int cont = 0;
		  for(int i = 0; i< opciones.length; i++) {
			 if((entradas.getMouseX()>=opciones[i].getX())&&(entradas.getMouseX()<=(opciones[i].getX()+opciones[i].getAncho()))) {
			if((entradas.getMouseY()>=opciones[i].getY()-opciones[i].getAlto())&&(entradas.getMouseY()<=(opciones[i].getY()))) {
				opc=i+1;
			    cont++;
			    mouseArriba = true;
			}
		}
	}
		  if(cont>0) {
			  mouseArriba = true;
		  }else {
			  mouseArriba = false;
		  }
		  
		 for(int i = 0; i < opciones.length; i++) {
			 if(i==(opc-1)) {
				 opciones[i].setColor(Color.GREEN);
				 
			 }else {
				 opciones[i].setColor(Color.WHITE);
			 }
		 }
		 
		 if((entradas.isEnter()) || ((entradas.isClick()))) {
			 if(((opc == 1) && (entradas.isEnter())) || ((opc==1)&&(entradas.isClick())&&(mouseArriba))) {
				 Render.app.setScreen(new PantallaJuego());
			 } else  if(((opc == 3) && (entradas.isEnter())) || ((opc==4)&&(entradas.isClick())&&(mouseArriba))) {
				 Gdx.app.exit();
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