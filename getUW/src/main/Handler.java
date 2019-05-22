package main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<Tile> object = new LinkedList<Tile>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			Tile tempObj = object.get(i);
			
			tempObj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			Tile tempObj = object.get(i);
			
			tempObj.render(g);
		}
	}
	
	public void addObject(Tile object) {
		this.object.add(object);
	}
	
	public void removeObject(Tile object) {
		this.object.remove(object);
	}
}
