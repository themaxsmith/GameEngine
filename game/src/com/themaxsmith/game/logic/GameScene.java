package com.themaxsmith.game.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends Scene {
	Player player;
	public GameScene(Player player, String background) {
		super(background);
		this.player = player;
		addObject(player);
	}
	@Override
	public KeyListener setKeyListener() {
		return  new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				player.onKey(e);
				
			}
		};
	}

}
