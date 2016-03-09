import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst_equalToZero() {
    assertEquals(Player.all().size(), 0);
  }

  @Test
  public void equals_recognizesPlayersWithSameName_true() {
    Player firstPlayer = new Player("Spock",1);
    Player secondPlayer  = new Player("Spock",1);
    assertTrue(secondPlayer.equals(firstPlayer));
  }

  @Test
  public void save_savesPlayerToTheDataBase_true() {
    Player testPlayer = new Player("Kirk", 1);
    testPlayer.save();
    assertTrue(Player.all().get(0).equals(testPlayer));
  }

  @Test
  public void find_returnsTheCorrectPlayer_true() {
    Player testPlayer1 = new Player("Paul", 2);
    Player testPlayer2 = new Player("Rick", 3);
    testPlayer1.save();
    testPlayer2.save();
    Player savedPlayer = Player.find(testPlayer2.getId());
    assertTrue(savedPlayer.equals(testPlayer2));
  }

  @Test
  public void update_updatesTokens() {
    Player testPlayer = new Player("Jesse", 4);
    testPlayer.save();
    testPlayer.setGrowler();
    testPlayer.setDimeBag();
    testPlayer.updateInventory();
    Player savedPlayer = Player.find(testPlayer.getId());
    assertEquals(savedPlayer.getGrowler(), true);
    assertEquals(savedPlayer.getDimeBag(), true);
  }
}
