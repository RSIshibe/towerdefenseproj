package Controller;

import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.event.MouseInputListener;

import Model.Tower;


public class MouseHandler implements MouseInputListener {
	private Vector<Tower> towerList;
	
	public MouseHandler(Vector<Tower> towerList){
		this.towerList = towerList;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int radius = 10;
		Tower newTower = new Tower(e.getX()-radius/2,e.getY()-radius/2, radius, radius);
		this.towerList.addElement(newTower);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
