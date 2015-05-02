package Controller;

import java.util.Vector;

import Model.PotentialField;
import Model.Tower;
import View.MainWindow;

public class GameController implements Runnable{
	private MainWindow window;
	private MouseHandler mouse;
	private KeyboardHandler keyboard;
	private Vector<Tower> towerList;
	private PotentialField pf;
	
	
	public GameController(){
		towerList = new Vector<Tower>();
		towerList.clear();
		
		window = new MainWindow(800,800,towerList);
		window.setVisible(true);
		
		this.mouse = new MouseHandler(towerList);
		this.keyboard = new KeyboardHandler();
		
		this.window.addMouseListener(this.mouse);
		this.window.addKeyListener(this.keyboard);
		
		this.pf = new PotentialField(800,800);

	}

	private void initViewComponents(){
		
	}
	
	private void initControllerComponents(){
		
	}
	
	private void initModelComponents(){
		
	}
	public void run(){
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
		while(true){
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 5 - timeDiff;

            if (sleep < 0) {
                sleep = 1;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
            window.step();	
		}
		
	}
}
