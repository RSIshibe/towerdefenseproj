package Model;

import java.awt.Point;
import java.util.Vector;

public class PotentialField {
	private Vector<Point> goals;
	private Vector<Point> obstacles;
	private int[][] potentialField;
	private int[][] pFGoals;
	private int[][] pFObstacles;
	private int width;
	private int height;

	public PotentialField(int width, int height){
		this.potentialField = new int[height][width];
		this.pFGoals = new int[height][width];
		this.pFObstacles = new int[height][width];
		this.goals = new Vector<Point>();
		this.obstacles = new Vector<Point>();
		this.width = width;
		this.height = height;
		
	}

	private boolean isValid(int x, int y){
		return (x>=0 && x<height && y>=0 && y<width);
	}

	private boolean isValid(Point p){
		return(isValid(p.x,p.y));
	}

	protected void createGoal(int x, int y){
		if(isValid(x,y)){
			this.goals.addElement(new Point(x,y));
		}
	}
	
	protected void createGoal(Point p){
		if(isValid(p)){
			this.goals.addElement(p);
		}
	}

	protected void removeGoal(int index){
		this.goals.remove(index);
	}
	
	protected void removeGoal(Point p){
		this.goals.remove(p);
	}
	
	protected void removeGoal(int x, int y){
		removeGoal(new Point(x,y));
	}
	
	protected void createObstacle(int x, int y){
		if(isValid(x,y)){
			this.obstacles.addElement(new Point(x,y));
		}
	}

	protected void createObstacle(Point p){
		if(isValid(p)){
			this.obstacles.addElement(p);
		}
	}

	protected void removeObstacle(int index){
		this.obstacles.remove(index);
	}
	
	protected void removeObstacle(Point p){
		this.obstacles.remove(p);
	}
	
	protected void removeObstacle(int x, int y){
		removeObstacle(new Point(x,y));
	}
	
	protected void initPotentialField(){
		calculateGoals();
		calculateObstacles();
	}

	public void calculateGoals(){
		// Set all goals and blocks in the potential Field

		pf(pFGoals);
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				// Set all goals
				for(int k = 0; k < this.goals.size(); k++){
					Point point = this.goals.get(k);
					if(Math.abs(point.x - i) < Math.abs(point.y - j)){
						pFGoals[i][j] += Math.abs(point.y - j);
					}else{
						pFGoals[i][j] += Math.abs(point.x - i);
					}
				}
			}
		}
	}

	public void calculateObstacles(int repulsion){
		// Set all obstacles in the potential Field
		pf(pFObstacles);
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				// Set all obstacles
				for(int k = 0; k < this.obstacles.size(); k++){
					Point point = this.obstacles.get(k);
					if(Math.abs(point.x - i) < repulsion && Math.abs(point.y - j) < repulsion){
						if(Math.abs(point.x - i) < Math.abs(point.y - j) ){
							pFObstacles[i][j] -= Math.abs(point.y - j);	
						}else{
							pFObstacles[i][j] -= Math.abs(point.x - i);
						}
					}
				}
			}
		}
	}

	public void calculateObstacles(){
		calculateObstacles(3);
	}
	
	protected void pf(int[][] pf){
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				pf[i][j] = 0;
			}
		}
	}
	protected void print(){
		int i,j;
		for(i=0;i<this.width;i++){
			for(j=0;j<this.height;j++){
				System.out.printf("%02d ",this.potentialField[i][j]);
			}
			System.out.printf("\n");
		}
	}
}
