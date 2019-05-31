package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import pictureLab.ImageDisplay;
import pictureLab.ImagePanel;
import pictureLab.Picture;

public class Tile {
	
	public static final int WIDTH = 80;
	public static final int HEIGHT = 80;
	public static final int SLIDE_SPEED = 20;
	public static final int ARC_WIDTH = 15;
	public static final int ARC_HEIGHT = 15;
	
	private int value;
	private BufferedImage tileimage;
	private Color background;
	private Color text;
	private Font font;
	private int x;
	private int y;
	
	public Tile(int value, int x, int y) {
		this.value = value;
		this.x = x;
		this.y = y;
		tileimage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		drawImage();
	}
	
	public void drawImage() {
		Graphics2D g = (Graphics2D)tileimage.getGraphics();
		if(value == 2) {
			background = new Color(234,17,14);
			text = new Color(255,255,255);
		} else if (value == 4) {
			//display Evergreen tile
			background = new Color(9,84, 1);
			text = new Color(255,255,255);
		} else if (value == 8) {
			//display Central tile
			background = new Color(234,17,14);
			text = new Color(255,255,255);
		} else if (value == 16) {
			background = new Color(8,51,160);
			text = new Color(255,255,255);
		} else if (value == 32) {
			//display Whitman tile
			background = new Color(4, 16, 84);
			text = new Color(247,239,150);
		} else if (value == 64) {
			//display SPU tile
			background = new Color(79,3,3);
			text = new Color(255,255,255);
		} else if (value == 128) {
			//display Eastern tile
			background = new Color(234,17,14);
			text = new Color(0,0,0);
		} else if (value == 256) {
			//display DigiPen tile
			background = new Color(79,3,3);
			text = new Color(0,0,0);
		} else if (value == 512) {
			//display PLU tile
			background = new Color(0,0,0);
			text = new Color(235,239,4);
		} else if (value == 1024) {
			//display Gonzaga tile
			background = new Color(255,255,255);
			text = new Color(4, 16, 84);
		} else if (value == 2048) {
			//display UW tile
			background = new Color(66,2,135);
			text = new Color(235,239,4);
		} else {
			background = new Color(0,0,0);
			text = new Color(255,255,255);
		}
		
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(background);
		g.fillRoundRect(0, 0, WIDTH, HEIGHT, ARC_WIDTH, ARC_HEIGHT);
		
		g.setColor(text);
		
		if (value <= 64) {
			font = Game.main.deriveFont(36f);
		} else {
			font = Game.main;
		}
		
		g.setFont(font);
		
		int drawX = WIDTH/2 - DrawUtils.getMessageWidth("" + value, font, g)/2;
		int drawY = HEIGHT/2 + DrawUtils.getMessageHeight("" + value, font, g)/2;
		g.drawString("" + value, drawX, drawY);
		g.dispose();
	}
}
