package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import pictureLab.ImageDisplay;
import pictureLab.ImagePanel;
import pictureLab.Picture;

public class Tile {
	
	protected int x, y;
	//Protected can only be accessed by which object inherits Tile and can be initialized here
	protected int tile_value = 0;	
	
	Graphics g;
	//Did git hub work???
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		int random = (int) (Math.random() * 2);
		if (random == 0) {
			//Tile 4
			drawTile4();
		} else {
			drawTile2();
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	public int getTileValue() {
		return tile_value;
	}
	
	public void setX (int x) {
		this.x = x;
	}
	
	public void setY (int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	//Different tile values -- need to include graphics as well
	public void drawTile2() {
		tile_value = 2;
		//call image
		ImagePanel tile2 = new ImagePanel("WSU Tile.png", x, y);
		tile2.paintComponents(g);
	}
	
	public void drawTile4() {
		tile_value = 4;
		ImagePanel tile4 = new ImagePanel("Evergreen Tile.png", x, y);
		tile4.paintComponents(g);
	}
	
	public void drawTile8() {
		tile_value = 8;
		ImagePanel tile8 = new ImagePanel("Central Tile.png", x, y);
		tile8.paintComponents(g);
	}
	
	public void drawTile16() {
		tile_value = 16;
		ImagePanel tile16 = new ImagePanel("Western Tile.png", x, y);
		tile16.paintComponents(g);
	}
	
	public void drawTile32() {
		tile_value = 32;
		ImagePanel tile32 = new ImagePanel("Whitman Tile.png", x, y);
		tile32.paintComponents(g);
	}
	
	public void drawTile64() {
		tile_value = 64;
		ImagePanel tile64 = new ImagePanel("SPU Tile.png", x, y);
		tile64.paintComponents(g);
	}
	
	public void drawTile128() {
		tile_value = 128;
		ImagePanel tile128 = new ImagePanel("Eastern Tile.png", x, y);
		tile128.paintComponents(g);
	}
	
	public void drawTile256() {
		tile_value = 256;
		ImagePanel tile256 = new ImagePanel("Digipen Tile.png", x, y);
		tile256.paintComponents(g);
	}
	
	public void drawTile512() {
		tile_value = 512;
		ImagePanel tile512 = new ImagePanel("PLU Tile.png", x, y);
		tile512.paintComponents(g);
	}
	
	public void drawTile1024() {
		tile_value = 1024;
		ImagePanel tile1024 = new ImagePanel("Gonzaga Tile.png", x, y);
		tile1024.paintComponents(g);
	}
	
	public void drawTile2048() {
		tile_value = 2048;
		ImagePanel tile2048 = new ImagePanel("UW Tile.png", x, y);
		tile2048.paintComponents(g);
	}
}
