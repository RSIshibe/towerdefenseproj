package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Tower;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel{
	private Vector<Tower> towerList;
	
	public GameCanvas(int width, int height, Vector<Tower> towerList){
		super();
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(Color.BLACK);
		this.towerList = towerList;
	}
	
	public void paint (Graphics g) {
		for (Tower tower:towerList){
			g.drawOval(tower.getX(), tower.getY(), tower.getWidth(), tower.getHeight());
		}
	}
}
