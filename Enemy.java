import java.awt.*;

public class Enemy {

  public int x;
  public int y;

  public Enemy() {
   
    x = (int) (Math.random() * 22);
    y = (int) (Math.random() * 22);
    
    
  }
  
  public void draw(Graphics g) {
  	
  	g.setColor(new Color(190, 0, 0));
  	g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);
  	
  }
  
}
