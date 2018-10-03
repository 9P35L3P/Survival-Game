import javax.swing.*;

public class Main extends JFrame {

  public Main() {

    setTitle("Survival Game");
    setSize(768, 798);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    Game game = new Game();
    add(game);

    Thread thread = new Thread(game, "game");
    thread.start();

    setVisible(true);

  }

  public static void main(String[] args) {

    new Main();

  }

}
