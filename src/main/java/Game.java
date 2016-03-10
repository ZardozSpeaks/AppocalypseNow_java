import java.lang.*;
import org.sql2o.*;

public class Game {

  private int id;
  private int start_time;
  private boolean game_running;

  public Game(){
    start_time = getSec();
    game_running = true;
  }

  int getSec() {
    return (int) System.currentTimeMillis() / 1000;
  }

  public void gameLoop(Player player) {
    while (game_running = true) {
      int newTime = getSec();
      if ((start_time - newTime) % 300 == 0) {
        player.reduceStats();
        player.updateStats();
        start_time = newTime;
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
      player.setKindBud(-1);
      player.updateStats();
      player.updateInventory();
    } else {
      player.setBuzz(1);
      player.setAlertness(-1);
      player.setKindBud(-1);
      player.updateStats();
      player.updateInventory();
    }
  }

  public void eatDoughnuts(Player player) {
    if(player.getDoughnutBox() == true) {
      player.setFullness(2);
      player.setBuzz(-1);
      player.setDoughnuts(-1);
      player.setDoughnuts(-1);
      player.updateStats();
      player.updateInventory();
    } else {
      player.setFullness(1);
      player.setBuzz(-1);
      player.setDoughnuts(-1);
      player.updateStats();
      player.updateInventory();
    }
  }

  public void drinkCoffee(Player player) {
    if(player.getCoffeeCup() == true) {
      player.setAlertness(2);
      player.setFullness(-1);
      player.setCoffees(-1);
      player.updateStats();
      player.updateInventory();
    } else {
      player.setAlertness(1);
      player.setFullness(-1);
      player.setCoffees(-1);
      player.updateStats();
      player.updateInventory();
    }
  }

  public void drinkBeer(Player player) {
    if (player.getGrowler() == true) {
      player.setBuzz(2);
      player.setFullness(-1);
      player.setBeers(-1);
      player.setAlertness(-1);
      player.updateStats();
      player.updateInventory();
    } else {
      player.setBuzz(1);
      player.setFullness(-1);
      player.setAlertness(-1);
      player.setBeers(-1);
      player.updateStats();
      player.updateInventory();
    }
  }

  public void search(Player player, Quadrant quadrant) {
    player.setBeers(quadrant.getBeer());
    player.setKindBud(quadrant.getKindBud());
    player.setCoffees(quadrant.getCoffee());
    player.setDoughnuts(quadrant.getDoughnut());
    player.updateInventory();
  }

  public boolean isDead(Player player) {
    if((player.getBuzz() == 0) || (player.getAlertness() == 0) || (player.getFullness() == 0)) {
      return true;
    } else {
      return false;
    }
  }

  public int getId(){
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO games (start_time, game_running) VALUES (:start_time, :game_running)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("start_time", this.start_time)
      .addParameter("game_running", this.game_running)
      .executeUpdate()
      .getKey();
    }
  }

  public static Game find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM games where id=:id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Game.class);
    }
  }
}
