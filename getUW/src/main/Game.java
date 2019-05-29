package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	//testing testing 123
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH;
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	//Keeping track of game
	private final int winning_score = 2048;
	private final int[][] grid = new int[4][4];
	//If 0, there is no tile in that spot. The number of the element matches the tile value in that spot.
	private boolean game_over = false;
	private boolean game_won = false;
	
	//Order of everything that happens once game opens hopefully
	public Game() {

		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "getUW!", this);

		Tile newTile = createNewTile();
		handler.addObject(newTile);
		grid[newTile.getX()][newTile.getY()] = newTile.getTileValue();		
		
		render();
	}

	public synchronized void start() { 
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() { 
		try {
			thread.join();
			//Stops thread all together
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
			// Run an error bug in our console.
		}
	}
	
	//Creates a new tile in a blank spot -- needs to include graphics as well
	public Tile createNewTile() {
		int row = (int) (Math.random() *3);
		int column = (int) (Math.random() *3);
		while (grid[row][column] != 0) {
			createNewTile();
		}
				
		Tile randomTile = new Tile(row, column);
		grid[row][column] = randomTile.getTileValue();
		
		return randomTile;
	}
	
	public void run() {
		//Game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta --;
			}
			if (running) {
				render();
			}
			
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//background color
		g.setColor(Color.gray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//grid
		g.setColor(Color.white);
		g.fillRect(60, 60, 520, 520);
		g.setColor(Color.gray);
		g.drawRect(60, 60, 130, 520);
		g.drawRect(60, 60, 260, 520);
		g.drawRect(60, 60, 390, 520);
		g.drawRect(60, 60, 520, 520);
		g.drawRect(60, 60, 520, 130);
		g.drawRect(60, 60, 520, 260);
		g.drawRect(60, 60, 520, 390);
		g.drawRect(60, 60, 520, 520);
		
		//Squares and tiles are 60 * 60 & start at 60-580 for position values.
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
}
