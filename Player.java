import java.awt.*;

public class Player {

  public int x;
  public int y;

  public Player() {

    x = (int) (Math.random() * 24);
    y = (int) (Math.random() * 20);

  }

  public void draw(Graphics g) {

    g.setColor(Color.BLUE);
    g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);

  }

}
