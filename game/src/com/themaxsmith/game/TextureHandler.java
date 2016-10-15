package com.themaxsmith.game;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TextureHandler {
private Map<String,Texture> textures = new HashMap<String, Texture>();
public TextureHandler(){
File x = new File("Images");
if (x.exists()){
	File[] files = new File("Images").listFiles();
			
			for (File file : files){
				if (file.isFile()){
					textures.put(file.getName(), new Texture(file.getName()));
					System.out.println("Loaded: "+file.getName());;
					
				}
				
				
			}
}else{
	System.out.println("Failed To Load Resources");
}
}

public Texture getTexture(String path){
	return textures.get(path);
	
}
}
