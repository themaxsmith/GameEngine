package com.themaxsmith.game.logic;

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
	public void setScene(GameEngine game,Scene scene) {
	currentScene =scene;
	game.addKeyListener(currentScene.setKeyListener());
		
	}

}
