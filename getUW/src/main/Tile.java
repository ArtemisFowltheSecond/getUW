package main;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	
	protected int x, y;
	//Protected can only be accessed by which object inherits Tile and can be initialized here
	protected int tile_value = 0;	
	
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
	}
	
	public void drawTile4() {
		tile_value = 4;
	}
	
	public void drawTile8() {
		tile_value = 8;
	}
	
	public void drawTile16() {
		tile_value = 16;
	}
	
	public void drawTile32() {
		tile_value = 32;
	}
	
	public void drawTile64() {
		tile_value = 64;
	}
	
	public void drawTile128() {
		tile_value = 128;
	}
	
	public void drawTile256() {
		tile_value = 256;
	}
	
	public void drawTile512() {
		tile_value = 512;
	}
	
	public void drawTile1024() {
		tile_value = 1024;
	}
	
	public void drawTile2048() {
		tile_value = 2048;
	}
}
