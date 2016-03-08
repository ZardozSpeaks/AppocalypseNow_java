import org.junit.*;
import static org.junit.Assert.*;

public class QuadrantTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst_equalToZero() {
    assertEquals(Quadrant.all().size(), 0);
  }

  @Test
  public void equals_recognizesQuadrantsWithSameName_true() {
    Quadrant firstQuadrant = new Quadrant("NW");
    Quadrant secondQuadrant  = new Quadrant("NW");
    assertTrue(secondQuadrant.equals(firstQuadrant));
  }

  @Test
  public void save_savesQuadrantToTheDataBase_true() {
    Quadrant testQuadrant = new Quadrant("NE");
    testQuadrant.save();
    assertTrue(Quadrant.all().get(0).equals(testQuadrant));
  }

  @Test
  public void find_returnsTheCorrectQuadrant_true() {
    Quadrant testQuadrant1 = new Quadrant("SE");
    Quadrant testQuadrant2 = new Quadrant("NE");
    testQuadrant1.save();
    testQuadrant2.save();
    Quadrant savedQuadrant = Quadrant.find(testQuadrant2.getId());
    assertTrue(savedQuadrant.equals(testQuadrant2));
  }
}
