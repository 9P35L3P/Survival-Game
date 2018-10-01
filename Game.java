
import javax.swing.*;
import java.awt.*;
import java.lang.Thread;

public class Game extends JPanel implements Runnable {
  
  public Game() {
    
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
  
  }

  @Override
  public void run() {
  
    try {
      Thread.sleep(1000/30);
    } catch (Exception e) { 
    }
    
    repaint();
    
  }
  
}
