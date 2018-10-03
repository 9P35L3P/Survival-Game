import java.awt.*;

public class Player{
  
  public int x = 11;
  public int y = 11;

  public Player() {
  
    
  }

  public void draw(Graphics g) {

    g.setColor(new Color(0, 160, 190));
    g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);

  }
  
  public void moveRight() {
  	
  	x++;
  	
  }
  
  public void moveLeft() {
  	
  	x--;
  	
  }
  
  public void moveUp() {
  	
  	y--;
  	
  }
  
  public void moveDown() {
  	
  	y++;
  	
  }
  
}
