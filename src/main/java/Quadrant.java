import org.sql2o.*;
import java.util.List;

public class Quadrant {

  private int id;
  private String name;
  private int beer;
  private int coffee;
  private int kind_bud;
  private int doughnut;

  public Quadrant(String name, int beer, int coffee, int kind_bud, int doughnut) {
    this.name = name;
    this.beer = beer;
    this.coffee = coffee;
    this.kind_bud = kind_bud;
    this.doughnut = doughnut;
  }

  @Override
  public boolean equals(Object otherQuadrant){
    if (!(otherQuadrant instanceof Quadrant)) {
      return false;
    } else {
      Quadrant newQuadrant = (Quadrant) otherQuadrant;
      return this.getName().equals(newQuadrant.getName());
    }
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getBeer() {
    return beer;
  }

  public int getCoffee() {
    return coffee;
  }

  public int getKindBud() {
    return kind_bud;
  }

  public int getDoughnut() {
    return doughnut;
  }

  public void setBeer(int pint) {
    this.beer += pint;
  }

  public void setCoffee(int cup) {
    this.coffee += cup;
  }

  public void setKindBud(int bud) {
    this.kind_bud += bud;
  }

  public void setDoughnut(int hole) {
    this.doughnut += hole;
  }

  public static List<Quadrant> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM quadrant";
      return con.createQuery(sql)
      .executeAndFetch(Quadrant.class);
    }
  }

}
