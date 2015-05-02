package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;

import Model.Tower;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	private GameCanvas canvas;
	private Vector<Tower> towerList;
	
	public MainWindow(int width, int height, Vector<Tower> towerList){
		super();
        this.setUndecorated(true);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(width,height));
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.towerList = towerList;
        initComponents();
	}
	
	private void initComponents(){
		this.canvas = new GameCanvas(this.getContentPane().getWidth(),this.getContentPane().getHeight(),towerList);
        this.setLayout(new BorderLayout());
        this.getContentPane().add(this.canvas,BorderLayout.CENTER);
	}
	
	public void step(){
		this.canvas.repaint();
	}
	
}
