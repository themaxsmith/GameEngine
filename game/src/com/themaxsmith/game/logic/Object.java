package com.themaxsmith.game.logic;

public abstract class Object {
	private String filename;
	public int x,y;
	public Object(String filename, int x, int y){
		this.filename=filename;
		this.x = x;
		this.y = y;
		init();
	}
	public abstract void tick();
	public abstract void init();
	public void render(Screen screen){
		screen.render(x, y, TextureHandler.getTexture(filename));
	}
}
