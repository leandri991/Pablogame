package com.dinadisotteo.haxballsuper.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dinadisotteo.haxballsuper.utiles.Render;

public class Jugador {

	public Texture textura;
	public Sprite spr;
	
	public Jugador(float x, float y,float ancho, float alto) {
		this.textura = new Texture("player.png");
        this.spr = new Sprite(textura);
        this.spr.setPosition(x, y);
        this.spr.setSize(ancho, alto);
	}
	
	public void dibujar() {
		spr.draw(Render.batch);
	}
	
	public void setX(float x) {
		spr.setX(x);
	}
	
	public void setY(float y) {
		spr.setY(y);
	}
	
	public void mover(float deltaX, float deltaY) {
	    spr.setPosition(deltaX, deltaY);
	}
	
	public float getX( ) {
		return spr.getX();
	}
	
	public float getY() {
		return spr.getY();
	}
}