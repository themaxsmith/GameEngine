package com.themaxsmith.TestGame;

import java.awt.Graphics;

import com.themaxsmith.game.logic.GameEngine;
import com.themaxsmith.game.logic.GameScene;
import com.themaxsmith.game.logic.HitBox;
import com.themaxsmith.game.logic.Player;
import com.themaxsmith.game.logic.Scene;

public class Test extends GameEngine {

	public static void main(String[] args) {
	startThread(new Test());

	}

	@Override
	public void init() {
		 Scene scene = new GameScene(new Player("player.png", 10, 10),"background.png");
			
		 getSceneHand().setScene(this, scene);
		
	}

	@Override
	public void tick() {
	tickScene();

	}

	@Override
	public void renderGUI(Graphics g) {
		 g.drawString("Hello", 10, 10);
		 
		
	}

}
