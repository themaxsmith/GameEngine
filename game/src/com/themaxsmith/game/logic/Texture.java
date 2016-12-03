package com.themaxsmith.game.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	public BufferedImage rawimage;
	public int[] texture;
	public boolean isAnimated=false;
	public int width, height;
	public Texture(String file){
		try{
			rawimage = ImageIO.read(new File("Images/"+file));
			width = rawimage.getWidth();
			height = rawimage.getHeight();
			
		} catch (IOException e){	
		e.printStackTrace();	
		}
		texture = new int[rawimage.getHeight() * rawimage.getWidth()];
		
		for (int y=0; y < (rawimage.getHeight()); y++){
			for (int x=0; x < (rawimage.getWidth()); x++){
				texture[x + (y * rawimage.getWidth())] = rawimage.getRGB((int) x, (int) y);
			}
		}
	
		
		
	}
	
}
