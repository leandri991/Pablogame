package io;

import com.badlogic.gdx.InputProcessor;
import com.dinadisotteo.haxballsuper.pantallas.Menu;
import com.dinadisotteo.haxballsuper.utiles.Config;
import com.badlogic.gdx.Input.Keys;

public class Entradas implements InputProcessor{

	private boolean abajo = false, arriba = false;
	private int mouseX=0,mouseY=0;
	private boolean click = false;
	
	private boolean enter = false;
	
	
	Menu app;
	
	
	public Entradas(Menu app) {
		this.app = app;
	}
	
	
	public boolean isAbajo() {
		return abajo;
	}

	public boolean isArriba() {
		return arriba;
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		
     app.tiempo = 0.05f;
		
      if(keycode == Keys.DOWN) {
    	  abajo = true;
      }else  if(keycode == Keys.UP) {
    	  arriba = true;
      }
      
      if(keycode == Keys.ENTER) {
    	  enter = true;
      }
		return false;
	}

	

	@Override
	public boolean keyUp(int keycode) {
	    if(keycode == Keys.DOWN) {
	    	  abajo = false;
	      }else if(keycode == Keys.UP) {
	    	  arriba = false ;
	      }		
	    
	    if(keycode == Keys.ENTER) {
	    	  enter = false;
	      }
	    return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		click = true;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		click = false;
		return false;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		mouseX = screenX;
		mouseY = Config.ALTO - screenY ;
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
	

	public int getMouseX() {
		return mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public boolean isClick() {
		return click;
	}
	 public boolean isEnter() {
		return enter;
	}

}
