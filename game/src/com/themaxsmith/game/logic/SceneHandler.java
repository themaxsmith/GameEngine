package com.themaxsmith.game.logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SceneHandler {
	private GameEngine main;
	private Scene currentScene;
	public SceneHandler(GameEngine main){
		this.main = main;
	}
	public void render(Screen screen){
		if (currentScene!=null)
		currentScene.render(screen);
	}
	public void tick(){
		if (currentScene!=null)
			currentScene.tick();
	}
	
	public MouseListener onClick() {
		return new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("CLICK x:"+e.getX()+" y:"+e.getY()); 
				currentScene.onClick(e);
			}
			//unused mouse events
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			};
			
		
	}
	public void setScene(GameEngine game,Scene scene) {
	currentScene =scene;
	game.addKeyListener(currentScene.setKeyListener());
		
	}

}
