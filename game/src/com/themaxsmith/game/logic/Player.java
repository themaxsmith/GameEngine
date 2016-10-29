package com.themaxsmith.game.logic;

import java.awt.event.KeyEvent;

public class Player extends Object {

	public Player(String filename, int x, int y) {
		super(filename, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	public void onKey(KeyEvent e){
		System.out.println(e.getKeyChar());
		
	}

}
