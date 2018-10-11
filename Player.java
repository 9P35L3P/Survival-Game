import java.awt.*;

public class Player {

  public int x;
  public int y;

  public Player() {

    x = (int) (Math.random() * 22 + 1);
    y = (int) (Math.random() * 18 + 1);

  }
  
  public void move(String dir) {
  	
  	switch (dir) {
  		
	  case "W":
	    if (Game.board[y - 1][x] == 0) {
  	
		    Game.board[y][x] = 0;
		    y--;
		    Game.moveEnemy();
		
		  }
		  break;
		
	  case "A":
	    if (Game.board[y][x - 1] == 0) {
      		
		    Game.board[y][x] = 0;
		    x--;
		    Game.moveEnemy();
      	
		  }
		  break;
	
	  case "S":
	  	if (Game.board[y + 1][x] == 0) {
		      
		    Game.board[y][x] = 0;
		    y++;
		    Game.moveEnemy();
      	
		  }
		  break;
	
	  case "D":
	  	if (Game.board[y][x + 1] == 0) {
      		
		    Game.board[y][x] = 0;
	  	  x++;
		    Game.moveEnemy();
      	
		  }
		  break;
  		
  	}
  	
  }

}
