
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Game extends JPanel implements Runnable {
  
  public static Player player;
  public static Enemy enemy1;
  public static Enemy enemy2;
  
  public static boolean playerTurn = true;

  public Game() {

    player = new Player();
    enemy1 = new Enemy();
    enemy2 = new Enemy();
    
    setFocusable(true);
    
    addKeyListener(new KeyListen());
    
  }
  
  @Override
  public void paint(Graphics g) {
  
    g.setColor(new Color(30, 130, 30));
    g.fillRect(0, 0, 768, 768);
    
    g.setColor(Color.DARK_GRAY);
    for (int i = 0; i < 768; i+=32) {
    	
    	for (int w = 0; w < 768; w+=32) {
    		
    		g.drawRect(i, w, 32, 32);
    		
    	}
    	
    }

    player.draw(g);
    enemy1.draw(g);
    enemy2.draw(g);
  
  }

  @Override
  public void run() {
  	while (true) {
  	
	    try {
	    	
	      Thread.sleep(1000/30);
	      repaint();
	      
	    } catch (Exception e) { 
	    }
  	}
    
  }
  
}

class KeyListen extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int keycode = e.getKeyCode();
		
		if (Game.playerTurn) {
			
			switch (keycode) {
			
				case 'D':
					Game.player.moveRight();
					Game.playerTurn = false;
					break;
				case 'A':
					Game.player.moveLeft();
					Game.playerTurn = false;
					break;
				case 'S':
					Game.player.moveDown();
					Game.playerTurn = false;
					break;
				case 'W':
					Game.player.moveUp();
					Game.playerTurn = false;
					break;
				
			}
		}
		
	} 
	
}
