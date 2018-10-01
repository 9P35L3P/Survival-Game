
import javax.swing.*;
import java.awt.*;
import java.lang.Thread;

public class Game extends JPanel implements Runnable {
  
  public Game() {
    
  }
  
  @Override
  public void paint(Graphics g) {
  
    g.setColor(new Color(30, 160, 30));
    g.fillRect(0, 0, 768, 768);
  
  }

  @Override
  public void run() {
  
    try {
      Thread.sleep(1000/30);
    } catch (Exception e) { 
    }
    
  }
  
}
