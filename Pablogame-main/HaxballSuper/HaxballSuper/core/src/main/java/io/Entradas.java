package io;

import com.badlogic.gdx.InputProcessor;
import com.dinadisotteo.haxballsuper.pantallas.Menu;
import com.dinadisotteo.haxballsuper.utiles.Config;
import com.badlogic.gdx.Input.Keys;

public class Entradas implements InputProcessor{

    private boolean abajo = false, arriba = false, izquierda = false, derecha = false, w = false, a = false, s = false, d = false;
	private int mouseX=0,mouseY=0;
	private boolean click = false;
	private boolean enter = false;
	Menu app;	
	
	public boolean isAbajo() {
		return abajo;
	}
	public boolean isArriba() {
		return arriba;
	}
	public boolean isIzquierda() {
        return izquierda;
    }
    public boolean isDerecha() {
        return derecha;
    }
    public boolean isW() {
        return w;
    }
    public boolean isA() {
        return a;
    }
    public boolean isS() {
        return s;
    }
    public boolean isD() {
        return d;
    }
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.DOWN) {
            abajo = true;
        } else if (keycode == Keys.UP) {
            arriba = true;
        } else if (keycode == Keys.LEFT) {
            izquierda = true;
        } else if (keycode == Keys.RIGHT) {
            derecha = true;
        } else if (keycode == Keys.W) {
            w = true;
        } else if (keycode == Keys.A) {
            a = true;
        } else if (keycode == Keys.S) {
            s = true;
        } else if (keycode == Keys.D) {
            d = true;
        }
        if (keycode == Keys.ENTER) {
            enter = true;
        }
        return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.DOWN) {
            abajo = false;
        } else if (keycode == Keys.UP) {
            arriba = false;
        } else if (keycode == Keys.LEFT) {
            izquierda = false;
        } else if (keycode == Keys.RIGHT) {
            derecha = false;
        } else if (keycode == Keys.W) {
            w = false;
        } else if (keycode == Keys.A) {
            a = false;
        } else if (keycode == Keys.S) {
            s = false;
        } else if (keycode == Keys.D) {
            d = false;
        }
        if (keycode == Keys.ENTER) {
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
