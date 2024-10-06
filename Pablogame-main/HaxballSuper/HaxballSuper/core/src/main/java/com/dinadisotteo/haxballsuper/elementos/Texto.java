package com.dinadisotteo.haxballsuper.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.dinadisotteo.haxballsuper.utiles.Render;

public class Texto {
	
    BitmapFont  fuente;
    private float x=0,y=0;
    private String texto="";
    GlyphLayout layout;
    boolean sombra;
    
    public Texto(String rutaFuente, int dimension, Color color, boolean sombra){
    	generarTexto(rutaFuente, dimension, color, sombra);
    }

    private void generarTexto(String rutaFuente, int dimension, Color color, boolean sombra) {
    	FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente)); 
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = dimension;
		parameter.color = color;
		if(sombra) {
		    parameter.shadowColor = Color.BLACK;
			parameter.shadowOffsetX = 1;
			parameter.shadowOffsetY = 1;
		}
		fuente = generator.generateFont(parameter);	
		layout = new GlyphLayout();
    }

    public void dibujar() {
    	fuente.draw(Render.batch, texto, x, y);
    }
    
    public void setColor(Color color) {
    	fuente.setColor(color);
    }
    
    public void setPosition(int x, int y) {
    	this.x = x;
    	this.y = y;
    }

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		layout.setText(fuente, texto);
	}
    
	public float getAncho() {
		return layout.width;
	} 
	
	public float getAlto() {
		return layout.height;
	} 
	
	public Vector2 getDimension() {
		return  new Vector2(layout.width,layout.height);
	}
	
	public Vector2 getPosition() {
		return  new Vector2(layout.width,layout.height);
	}
    
    
}
