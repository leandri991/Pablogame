package com.dinadisotteo.haxballsuper.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dinadisotteo.haxballsuper.utiles.Render;

public class Jugador {

	public Texture textura;
	public Sprite spr;
	
	public Jugador(float x, float y,float ancho, float alto) {
		textura = new Texture("prueba jugADOR.webp");
		spr = new Sprite(textura);
		spr.setPosition(x, y);
		spr.setSize(ancho, alto);
	}
	
	public void dibujar() {
		spr.draw(Render.batch);
	}
	
	public void setX(float x) {
		spr.setX(x);
	}
	
	public void setY(float y) {
		spr.setX(y);
	}
}
