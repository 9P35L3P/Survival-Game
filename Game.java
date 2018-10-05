import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable {

  public static Player player;
  public static ArrayList<Enemy> enemies;

  public static int board[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

  public Game() {
  
    setFocusable(true);

    player = new Player();

    enemies = new ArrayList<Enemy>();
    enemies.add(new Enemy());

    addKeyListener(new KeyListen());

  }

  @Override
  public void run() {

    while (true) {

      try {

        Thread.sleep(1000/30);

      } catch (Exception e) {}

      update();
      repaint();

    }

  }

  @Override
  public void paint(Graphics g) {

    g.setColor(Color.DARK_GRAY);
    g.fillRect(0, 0, 768, 768);

    drawGrid(g);

    for (int y = 0; y < board.length; y++) {

      for (int x = 0; x < board[0].length; x++) {

        switch (board[y][x]) {

          case 1:
            g.setColor(Color.BLUE);
            g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);
            break;
          case 2:
            g.setColor(Color.RED);
            g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);
            break;
            
        }

      }

    }

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

  public static void update() {
    
    board[player.y][player.x] = 1;

    for (int i = 0; i < enemies.size(); i++) {
      
      board[enemies.get(i).y][enemies.get(i).x] = 2;
 
    }

  }

  public static void moveEnemy() {

    for (int i = 0; i < enemies.size(); i++) {
     
      board[enemies.get(i).y][enemies.get(i).x] = 0; 
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
      	if (Game.player.y != 0) {
      	
	        Game.board[Game.player.y][Game.player.x] = 0;
	        Game.player.y--;
	        Game.moveEnemy();
	        
      	}
        break;
      case 'A':
      	if (Game.player.x != 0) {
      		
	        Game.board[Game.player.y][Game.player.x] = 0;
	        Game.player.x--;
	        Game.moveEnemy();
      	}
        break;
      case 'S':
      	if (Game.player.y != 19) {
	      
	        Game.board[Game.player.y][Game.player.x] = 0;
	        Game.player.y++;
	        Game.moveEnemy();
      	}
        break;
      case 'D':
      	if (Game.player.x != 23) {
	        Game.board[Game.player.y][Game.player.x] = 0;
	        Game.player.x++;
	        Game.moveEnemy();
      	}
        break;

    }

  }

}
