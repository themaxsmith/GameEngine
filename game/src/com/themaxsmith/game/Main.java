package com.themaxsmith.game;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {
	public static JFrame frame;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 1;
	public static Thread thread;
	private boolean running = false;
	public static final String NAME = "2D Game Engine";
	public static final Dimension DIMENSIONS = new Dimension(WIDTH * SCALE,HEIGHT * SCALE);
	private static Main game = new Main();
	public static void main(String[] args){
		
		game.setMinimumSize(Main.DIMENSIONS);
		game.setMaximumSize(Main.DIMENSIONS);
		game.setPreferredSize(Main.DIMENSIONS);

		frame = new JFrame(Main.NAME);

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
	private void render() {
		// TODO Auto-generated method stub
		
	}
	private void tick() {
	
		
	}
}
