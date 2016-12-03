package com.themaxsmith.game.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Scene {
	private ArrayList<Object> objects = new ArrayList<Object>();
	private ArrayList<HitBox> hitboxs = new ArrayList<HitBox>();
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
	public void onClick(MouseEvent e) {
		synchronized (getHitBoxes()) {
		
				for(HitBox box : getHitBoxes()){
					box.onClick(e);
				}
			
		}
	}
	public boolean onHover(MouseEvent e) {
		for(HitBox box : getHitBoxes()){
			if (box.isHovering(e))
				return true;
		}
		return false;
	}

	public synchronized ArrayList<HitBox> getHitBoxes(){
		return hitboxs;
	}

	public void initHitBox(HitBox x){
		synchronized (getHitBoxes()) {
			getHitBoxes().add(x);
		}}
		
	public void tick() {
		for(Object object : objects){
			object.tickQ();
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
