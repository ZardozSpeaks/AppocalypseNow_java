import java.lang.*;

public class Game {

  private int startTime;
  private boolean gameRunning;

  public Game(){
    startTime = getSec();
    gameRunning = true;
  }

  int getSec() {
    return (int) System.currentTimeMillis() / 1000;
  }

  public void gameLoop(Player player) {
    while (gameRunning = true) {
      int newTime = getSec();
      if ((startTime - newTime) % 300 == 0) {
        player.reduceStats();
        player.updateStats();
        startTime = newTime;
      }
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
