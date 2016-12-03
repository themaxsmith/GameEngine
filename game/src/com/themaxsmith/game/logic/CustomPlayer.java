package com.themaxsmith.game.logic;

import java.awt.event.KeyEvent;

public abstract class CustomPlayer extends Object {

	public CustomPlayer(Texture texture, int x, int y, int speed, int health) {
		super(texture, x, y);
	}

	@Override
	public abstract void tick();

	@Override
	public abstract void init();
	
	public abstract void onKey(KeyEvent e);

}
