package com.themaxsmith.game.logic;



public class Screen {
	
	public int[] pixels;

	private int width, height;
	private int[] level,player,wholelevel;
	
	public Screen(int width, int height){
		this.setWidth(width);
		this.setHeight(height);
		
		pixels = (new int[width*height]);
	}
	public void render (int xP, int yP, Texture text){
		int color;
		for (int y = 0; y < text.height; y++){
			for (int x = 0; x < text.height; x++){
				 
				if (y + yP < height && x+ xP < width && x+ xP > 0 && y + yP > 0){
					color = text.texture[x+(y*text.width)];
				pixels[xP+x+((y)*getWidth())] = color;}
			}
			
			
		}
		
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}