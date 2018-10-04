import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable {

  public static Player player;

  public static ArrayList<Enemy> enemies;
  public static Enemy enemy;

  public Game() {
  
    setFocusable(true);

    player = new Player();

    enemies = new ArrayList<Enemy>();
    enemy = new Enemy();
    enemies.add(enemy);

    addKeyListener(new KeyListen());

  }

  @Override
  public void run() {

    while (true) {

      try {

        Thread.sleep(1000/30);

      } catch (Exception e) {}

      repaint();

    }

  }

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

  public static void moveEnemy() {

    for (int i = 0; i < enemies.size(); i++) {

      enemies.get(i).move(player);

    }

  }

}

class KeyListen extends KeyAdapter {

  @Override
  public void keyPressed(KeyEvent e) {

    int keycode = e.getKeyCode();

    switch (keycode) {

      case 'W':
        Game.player.y--;
        Game.moveEnemy();
        break;
      case 'A':
        Game.player.x--;
        Game.moveEnemy();
        break;
      case 'S':
        Game.player.y++;
        Game.moveEnemy();
        break;
      case 'D':
        Game.player.x++;
        Game.moveEnemy();
        break;

    }

  }

}
