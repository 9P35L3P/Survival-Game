import java.awt.*;

public class Enemy {

  public int x;
  public int y;

  public Enemy() {

    x = (int) (Math.random() * 24);
    y = (int) (Math.random() * 20);

  }

  public void draw(Graphics g) {

    g.setColor(Color.RED);
    g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);

  }

}
