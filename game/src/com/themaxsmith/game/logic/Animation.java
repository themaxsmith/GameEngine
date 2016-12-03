package com.themaxsmith.game.logic;

public class Animation extends Texture {
	public Texture main;
	public Animation(String file) {
		super(file);

		isAnimated =true;
		
	}
	public void tick() {
		System.out.println("ANIMATION CLASS");
		
	}

}
