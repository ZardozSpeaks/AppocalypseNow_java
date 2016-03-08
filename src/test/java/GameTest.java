import org.junit.*;
import static org.junit.Assert.*;

public class Game {

  @Test
  public void gameClockDecrementsPlayerStats() {
    Game newGame = new Game();
    Player newPlayer = new Player("John", 4);
    newTime = startTime + 299;
    assertEquals(newPlayer.getBuzz(), 10);
  }
}
