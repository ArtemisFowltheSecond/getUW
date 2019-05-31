package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, Runnable{

	//testing testing 123
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH;
	public static final Font main = new Font("Bebas Neue Regular", Font.PLAIN, 28);

	private Thread game;
	private boolean running = false;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	private long startTime;
	private long elapsed;
	private boolean set;
	private Gameboard board;
	
	//Order of everything that happens once game opens hopefully
	public Game() {

		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		
		board= new Gameboard(WIDTH/2-Gameboard.BOARD_WIDTH/2, HEIGHT - Gameboard.BOARD_HEIGHT-10);
	}
	
	public void update() {
		board.update();
		Keyboard.update();
	}

	public synchronized void start() { 
		if(running) return;
		running = true;
		game = new Thread(this, "game");
		game.start();
	}
	
	public synchronized void stop() { 
		if(!running) return;
		running = false;
		System.exit(0);
	}
	
	//Creates a new tile in a blank spot -- needs to include graphics as well
//	public Tile createNewTile() {
//		int row = (int) (Math.random() *3);
//		int column = (int) (Math.random() *3);
//		while (grid[row][column] != 0) {
//			createNewTile();
//		}
//				
//		Tile randomTile = new Tile(row, column);
//		grid[row][column] = randomTile.getTileValue();
//		
//		return randomTile;
//	}
	
	public void run() {
		//Game loop got off online game building tutorial
		int fps = 0;
		int update = 0;
		long fpsTimer = System.currentTimeMillis();
		double nsPerUpdate = 10000000000.0/60;
		
		//last update time
		double then = System.nanoTime();
		double unprocessed = 0;
		
		while(running) {
			boolean shouldRender = false;
			double now = System.nanoTime();
			unprocessed += (now-then) / nsPerUpdate;
			then = now;
		
		//update queue
		while(unprocessed >= 1) {
			update++;
			update();
			shouldRender = true;
		}
		
		//render
		if(shouldRender) {
			fps++;
			render();
			shouldRender = false;
		} else {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//FPS timer
		
		if(System.currentTimeMillis() - fpsTimer > 1000) {
			System.out.printf("%d fps %d update", fps, update);
			System.out.println();
			fps = 0;
			update = 0;
			fpsTimer += 1000;
		}
		
		}
	}
	
	private void render() {
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//render board
		board.render(g);
		g.dispose();
		
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		
//		BufferStrategy bs = this.getBufferStrategy();
//		if (bs == null) {
//			this.createBufferStrategy(3);
//			return;
//		}
//		
//		Graphics g = bs.getDrawGraphics();
//		
//		//background color
//		g.setColor(Color.gray);
//		g.fillRect(0, 0, WIDTH, HEIGHT);
//		
//		//grid
//		g.setColor(Color.white);
//		g.fillRect(60, 60, 520, 520);
//		g.setColor(Color.gray);
//		g.drawRect(60, 60, 130, 520);
//		g.drawRect(60, 60, 260, 520);
//		g.drawRect(60, 60, 390, 520);
//		g.drawRect(60, 60, 520, 520);
//		g.drawRect(60, 60, 520, 130);
//		g.drawRect(60, 60, 520, 260);
//		g.drawRect(60, 60, 520, 390);
//		g.drawRect(60, 60, 520, 520);
//		
//		//Squares and tiles are 60 * 60 & start at 60-580 for position values.
//		
//		handler.render(g);
//		
//		g.dispose();
//		bs.show();
	}
	
	public static void main(String args[]) {
		new Game();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Keyboard.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Keyboard.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
