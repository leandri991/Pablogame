package com.dinadisotteo.haxballsuper.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.dinadisotteo.haxballsuper.HaxballSuper;
import com.dinadisotteo.haxballsuper.utiles.Config;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
    
    
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("haxball-super");
        configuration.setResizable(false);
        configuration.setWindowedMode(Config.ANCHO,Config.ALTO);
      new Lwjgl3Application(new HaxballSuper(), configuration);
    }
    
}