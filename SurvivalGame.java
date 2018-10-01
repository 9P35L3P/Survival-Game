import javax.swing.*;
import java.lang.Thread;

public class SurvivalGame extends JFrame {

  public SurvivalGame() {
  
    setTitle("Survival Game");
    setSize(768, 768);
    
    Game game = new Game();
    Thread thread = new Thread(game, "game");
    add(game);
    thread.start();
    
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  
  }
  
  public static void main(String[] args) {

    new SurvivalGame();
  
  }

}
