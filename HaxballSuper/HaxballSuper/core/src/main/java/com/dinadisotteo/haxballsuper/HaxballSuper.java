package com.dinadisotteo.haxballsuper;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dinadisotteo.haxballsuper.pantallas.PantallaCarga;
import com.dinadisotteo.haxballsuper.utiles.Render;

public class HaxballSuper extends Game {

    @Override
    public void create() {
      Render.app = this;
      Render.batch = new SpriteBatch();
      this.setScreen(new PantallaCarga());
    }

    @Override
    public void render() {
    super.render(); 
    }
     
    private void update() {
    	
    }

    @Override
    public void dispose() {
       Render.batch.dispose();
    }
}
