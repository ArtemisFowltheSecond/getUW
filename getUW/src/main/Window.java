package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Game game = new Game();
		
		JFrame window = new JFrame("GetUW!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		game.start();
	}
}
