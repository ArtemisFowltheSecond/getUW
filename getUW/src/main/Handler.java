package main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<Tile> object = new LinkedList<Tile>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			Tile tempObj = object.get(i);
		}
	}
	
	public void render(Graphics g) {
		
	}
}
