import java.awt.*;

public class Enemy {

  public int x;
  public int y;

  public Enemy() {

    x = (int) (Math.random() * 22 + 1);
    y = (int) (Math.random() * 18 + 1);

  }

  public void move(Player player) {

    int rand = (int) (Math.random() * 2);

    if (rand == 0) {

      if (x > player.x && Game.board[y][x - 1] == 0) {

        x--;
    
      } else if (x < player.x && Game.board[y][x + 1] == 0) {

        x++;

      } 

    } else {

      if (y > player.y && Game.board[y - 1][x] == 0) {

        y--;
    
      } else if (y < player.y && Game.board[y + 1][x] == 0) {

        y++;

      }

    }

  }

}
