package com.themaxsmith.game.logic;

public abstract class Object {
	private Texture texture;
	public int x,y;
	public Object(String filename, int x, int y){
		this.texture=TextureHandler.getTexture(filename);
		this.x = x;
		this.y = y;
		init();
	}
	public Object(Texture text, int x, int y){
		this.texture=text;
		this.x = x;
		this.y = y;
		init();
	}
	public  void tickQ(){
		tick();
		if (texture.isAnimated)
		((Animation) texture).tick();
	};
	public abstract void tick();
	public abstract void init();
	public void render(Screen screen){
		screen.render(x, y, texture);
	}
}
