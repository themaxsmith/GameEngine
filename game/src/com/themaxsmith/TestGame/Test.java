package com.themaxsmith.TestGame;

import com.themaxsmith.game.logic.GameEngine;
import com.themaxsmith.game.logic.GameScene;
import com.themaxsmith.game.logic.Scene;

public class Test extends GameEngine {

	public static void main(String[] args) {
	startThread(new Test());

	}

	@Override
	public void init() {
		 Scene scene = new GameScene();
			
		 getSceneHand().setScene(this, scene);
		
	}

}
