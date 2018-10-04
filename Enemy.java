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

  public void move(Player player) {

    int rand = (int) (Math.random() * 2);

    if (rand == 0) {

      if (x > player.x) {

        x--;
    
      } else if (x < player.x) {

        x++;

      } 

    } else {

      if (y > player.y) {

        y--;
    
      } else if (y < player.y) {

        y++;

      }

    }

  }

}
