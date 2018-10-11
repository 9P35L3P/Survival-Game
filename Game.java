import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable, KeyListener {

  public static Player player;
  public static ArrayList<Enemy> enemies;

  public static int board[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

  public Game() {
  
    setFocusable(true);

    player = new Player();

    enemies = new ArrayList<Enemy>();
    enemies.add(new Enemy());

    addKeyListener(this);

  }

  @Override
  public void run() {

    while (true) {

      try {

        Thread.sleep(1000/30);

      } catch (Exception e) {}

      updateBoard();    
      repaint();

    }

  }

  @Override
  public void paint(Graphics g) {

    for (int y = 0; y < board.length; y++) {

      for (int x = 0; x < board[0].length; x++) {

        switch (board[y][x]) {
	  case 0:
	    g.setColor(Color.WHITE);
            g.fillRect(x * 32, y * 32, 32, 32);
            break;
			
	  case 1:
	     g.setColor(Color.DARK_GRAY);
             g.fillRect(x * 32, y * 32, 32, 32);
             break;
			
          case 2:
            g.setColor(Color.BLUE);
            g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);
            break;
          case 3:
            g.setColor(Color.RED);
            g.fillRect(x * 32 + 1, y * 32 + 1, 31, 31);
            break;
            
        }

      }

    }
    
    drawGrid(g);

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

  public static void updateBoard() {
    
    board[player.y][player.x] = 2;

    for (int i = 0; i < enemies.size(); i++) {
      
      board[enemies.get(i).y][enemies.get(i).x] = 3;
 
    }

  }

  public static void moveEnemy() {

    for (int i = 0; i < enemies.size(); i++) {
      
      board[enemies.get(i).y][enemies.get(i).x] = 0;
      enemies.get(i).move(player);

    }

  }
	
  @Override
  public void keyPressed(KeyEvent e) {
 
    int keycode = e.getKeyCode();

    switch (keycode) {

      case 'W':
      	player.move("W");
      	updateBoard();
      	moveEnemy();
        break;
      case 'A':
      	player.move("A");
      	updateBoard();
      	moveEnemy();
        break;
      case 'S':
      	player.move("S");
      	updateBoard();
      	moveEnemy();
        break;
      case 'D':
      	player.move("D");
      	updateBoard();
      	moveEnemy();
        break;

    }
  
  }
  
  @Override
  public void keyReleased(KeyEvent e) {}
  
  @Override
  public void keyTyped(KeyEvent e) {}

}
