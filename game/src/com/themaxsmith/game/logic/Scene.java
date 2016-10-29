package com.themaxsmith.game.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class Scene {
	private ArrayList<Object> objects = new ArrayList<Object>();

	public void render(Screen screen) {
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
	public abstract KeyListener setKeyListener();

}
