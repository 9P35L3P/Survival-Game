import javax.swing.*;

public class SurvivalGame extends JFrame {

  public SurvivalGame() {
  
    setTitle("Survival Game");
    setSize(800, 820);
    
    Game panel = new Game();
    Thread thread = new Thread(panel, "game");
    add(panel);
    thread.start();
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  
  }
  
  public static void main(String[] args) {

    new SurvivalGame();
  
  }

}
