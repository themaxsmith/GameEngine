package com.themaxsmith.game.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class Scene {
	private ArrayList<Object> objects = new ArrayList<Object>();
	public String background;
	public Scene(String back){
		background = back;
	}
	public void render(Screen screen) {
		renderBackground(screen);
		synchronized (objects) {
		for(Object object : objects){
			object.render(screen);
		}}
		
	}

	public void tick() {
		for(Object object : objects){
			object.tick();
		}
		
	}
	public void addObject(Object object){
		synchronized (objects) {
			objects.add(object);
		}
	}
	public void removeObject(Object object){
		synchronized (objects) {
			objects.remove(object);
		}
	}
	public void renderBackground(Screen screen){
		screen.render(0, 0, TextureHandler.getTexture(background));
		
	}
	public abstract KeyListener setKeyListener();

}
