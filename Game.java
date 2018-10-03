import javax.swing.*;
import java.awt.*;
import java.lang.Thread;

public class Game extends JPanel implements Runnable {

  public static Player player;
  public static Enemy enemy;

  public Game() {

    player = new Player();
    enemy = new Enemy();

  }

  @Override
  public void run() {}

  @Override
  public void paint(Graphics g) {

    g.setColor(Color.DARK_GRAY);
    g.fillRect(0, 0, 768, 768);

    drawGrid(g);
    player.draw(g);
    enemy.draw(g);

    g.setColor(new Color(110, 50, 0));
    g.fillRect(0, 640, 768, 768);

  }

  public static void drawGrid(Graphics g) {
  
    g.setColor(Color.GRAY);

    for (int i = 0; i < 24; i++) {

      for (int w = 0; w < 24; w++) {

        g.drawRect(i * 32, w * 32, 32, 32);

      }

    }

  }

}
