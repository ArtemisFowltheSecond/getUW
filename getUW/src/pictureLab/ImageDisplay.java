
package pictureLab;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.Scrollable;

public class ImageDisplay extends JFrame implements Scrollable{
	
	//attributes
	private Image image;
	private Dimension prefSize;
	private int currentX = 0;
	private int currentY = 0;
	
	//Constructor
	public ImageDisplay(Image image) {
		this.image = image;
		prefSize = new Dimension(60, 60);
		setPreferredSize(prefSize);
		revalidate();
	}
	
	public ImageDisplay(Image image, int x, int y) {
		this(image);
		currentX = x;
		currentY = y;
	}
	
	//Methods Automatically implemented
	
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Other methods
	
	public Image getImage() {
		return image;
	}
	
	public int getCurrentX() {
		return currentX;
	}
	
	public int getCurrentY() {
		return currentY;
	}
	
	public void setCurrentX(int x) {
		currentX = x;
		repaint();
	}
	
	public void setCurrentY(int y) {
		currentY = y;
		repaint();
	}
	
	public void setImage(Image newimage) {
		image = newimage;
		setPreferredSize(new Dimension(60, 60));
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(image, 0, 0, this);
		int xStart = currentX;
		int xEnd = currentX + 60;
		int yStart = currentY;
		int yEnd = currentY + 60;
		int maxX = 520;
		int maxY = 520;
		int width = 60;
		int height = 60;
		if (currentX >= 0 && currentX < width && currentY >= 0 && currentY < height){
		      // check that the start and end values are visible
		      if (xStart < 0) {
		        xStart = 0;
		      }
		      if (xEnd > maxX) {
		        xEnd = maxX;
		      }
		      if (yStart < 0) {
		        yStart = 0;
		      }
		      if (yEnd > maxY) {
		        yEnd = maxY;
		      }
		 }
	}

}