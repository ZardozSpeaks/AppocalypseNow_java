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

  public void burnOneDown(Player player) {
    if(player.getDimeBag() == true){
      player.setBuzz(2);
      player.setAlertness(-1);
      player.updateStats();
    } else {
      player.setBuzz(1);
      player.setAlertness(-1);
      player.updateStats();
    }
  }

  public void eatDoughnuts(Player player) {
    if(player.getDoughnutBox() == true) {
      player.setFullness(2);
      player.setBuzz(-1);
      player.updateStats();
    } else {
      player.setFullness(1);
      player.setBuzz(-1);
      player.updateStats();
    }
  }

  public void drinkCoffee(Player player) {
    if(player.getCoffee() == true) {
      player.setAlertness(2);
      player.setFullness(-1);
      player.updateStats();
    } else {
      player.setAlertness(1);
      player.setFullness(-1);
      player.updateStats();
    }
  }

  public void drinkBeer(Player player) {
    if (player.getGrowler() == true) {
      player.setBuzz(2);
      player.setFullness(-1);
      player.updateStats()
    } else {
      player.setBuzz(1);
      player.setFullness(-1);
      player.updateStats()
    }
  }

  public void search(Player player, Quadrant quadrant) {
    quadrant.getBeer();
  }
}
