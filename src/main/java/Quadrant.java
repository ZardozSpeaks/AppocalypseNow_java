import org.sql2o.*;
import java.util.List;
import java.lang.Math;

public class Quadrant {

  private int id;
  private String name;
  private int beer;
  private int coffee;
  private int kind_bud;
  private int doughnut;

  public Quadrant(String name) {
    this.name = name;
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

  //GETTER METHODS//

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

  //SETTER METHODS//

  public void setBeer() {
    this.beer = (int) (Math.random() * 3);
  }

  public void setCoffee() {
    this.coffee = (int) (Math.random() * 3);
  }

  public void setKindBud() {
    this.kind_bud = (int) (Math.random() * 3);
  }

  public void setDoughnut() {
    this.doughnut = (int) (Math.random() * 3);
  }

  //CREATE//

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO quadrants (name) VALUES (:name) ";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }

  //READ//

  public static Quadrant find() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM quadrants where id=:id";
      return con.createQuery(sql)
      .executeAndFetchFirst(Quadrant.class);
    }
  }

  public static List<Quadrant> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM quadrants";
      return con.createQuery(sql)
      .executeAndFetch(Quadrant.class);
    }
  }

}
