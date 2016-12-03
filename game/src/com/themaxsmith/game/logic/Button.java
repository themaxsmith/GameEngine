package com.themaxsmith.game.logic;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Button implements onHit, HitBoxParent{
	private int x,y, width, height;
	private String text;
	private HitBox hit;
	
	public Button(SceneHandler sceneHandler, HitBoxHandler hand,String text, int x, int y) {
	   this.text = text;
	   this.x =x;
	   this.y =y;
	
		hit = new HitBox(this,x,y, width, height) {@Override
		public void onHit() {hit();}};
		hand.initHitBox(hit);
	}
public void hit(){
		
		onHit();
	}
	public void renderOverlay(Graphics g) {


		g.setColor(new Color(0, 0, 0, 170));
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawString(text, x+10, y+10);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}
	
}
