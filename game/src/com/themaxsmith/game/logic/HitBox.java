package com.themaxsmith.game.logic;

import java.awt.event.MouseEvent;

public abstract class HitBox implements onHit {
private int x,y,endx,endy;
private boolean reg = true, remove= false;
private HitBoxParent parent;
public HitBox(HitBoxParent p, int x, int y, int width, int height){
	this.x =x;
	this.y = y;
	this.parent = p;
	this.endx = x+width;
	this.endy = x+height;
}

public boolean didClick(MouseEvent e){
	
	if (x < e.getX() && e.getX() < endx && y < e.getY() && e.getY() < endy && reg)
	return true;
	return false;
	
}
public boolean isHovering(MouseEvent e){
	
	if (x < e.getX() && e.getX() < endx && y < e.getY() && e.getY() < endy && reg)
	return true;
	return false;
	
}
public void setHit(int x, int y, int width, int height){
	this.x = x;
	this.y = y;
	this.endx = x+width;
	this.endy = y+height;
}
public void onClick(MouseEvent e){
	if (didClick(e))
		onHit();
}
public boolean isRemove() {
	if (parent.isRemove()){
	parent=null;
	return true;
	}
	return false;
}
}
