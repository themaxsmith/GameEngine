package com.themaxsmith.game.logic;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public abstract class GameEngine extends Canvas implements Runnable {
	public static JFrame frame;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH / 12 * 9;

	public static final int SCALE = 1;
	public static Thread thread;
	private boolean running = false;
	public static final String NAME = "2D Game Engine";
	private TextureHandler textHandler;
	private Screen screen;
	private SceneHandler sceneHand;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
 
	public static final Dimension DIMENSIONS = new Dimension(WIDTH * SCALE,HEIGHT * SCALE);

	public static void startThread(GameEngine game){
		game.setMinimumSize(GameEngine.DIMENSIONS);
		game.setMaximumSize(GameEngine.DIMENSIONS);
		game.setPreferredSize(GameEngine.DIMENSIONS);

		frame = new JFrame(GameEngine.NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(game, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		
	}
	
	public synchronized void start(){
		running = true;
		thread= new Thread(this, NAME+"_main");
		thread.start();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		int ticks=0;
		int frames=0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		initGE();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime=now;
			boolean shouldRender = true;
			while (delta >=1){
				ticks++;
				tick();
				delta -=1;
				shouldRender = true;
			}
			
			
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (shouldRender){
					
					frames++;
					render();
				}
				if (System.currentTimeMillis() - lastTimer >=1000){
					lastTimer +=1000;
					System.out.println("FPS: "+frames+" Ticks: "+ticks);
					frames=0;
					ticks=0;
				
					
				}
			
			
		}
		
	}
	private void initGE() {
	 textHandler = new TextureHandler();
	 screen = new Screen(WIDTH, HEIGHT);
	 sceneHand = new SceneHandler(this);

	 init();
	}
 public abstract void init();
	private void render() {
	 BufferStrategy bs = getBufferStrategy();
	 if (bs == null){
		createBufferStrategy(3);
	 return;
	 }
	sceneHand.render(screen);
	 for(int y = 0; y < screen.getHeight(); y++){
		 for(int x = 0; x < screen.getWidth(); x++){
			pixels[x+y * WIDTH] = screen.pixels[x + y * WIDTH];
			 
			 
		 } 
		 
	 }
	 Graphics g = bs.getDrawGraphics();
	 g.drawImage(image, 0, 0, getWidth(),getHeight(),null);
	g.dispose();
	 bs.show();
	}
	private void tick() {
	
		
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	public static void setFrame(JFrame frame) {
		GameEngine.frame = frame;
	}
	public static Thread getThread() {
		return thread;
	}
	public static void setThread(Thread thread) {
		GameEngine.thread = thread;
	}
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	public TextureHandler getTextHandler() {
		return textHandler;
	}
	public void setTextHandler(TextureHandler textHandler) {
		this.textHandler = textHandler;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public SceneHandler getSceneHand() {
		return sceneHand;
	}
	public void setSceneHand(SceneHandler sceneHand) {
		this.sceneHand = sceneHand;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int[] getPixels() {
		return pixels;
	}
	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getScale() {
		return SCALE;
	}

	public static Dimension getDimensions() {
		return DIMENSIONS;
	}
}
