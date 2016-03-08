import org.sql2o.*;
import java.util.List;

public class Player {

  private int id;
  private int image;
  private String name;
  private int buzz;
  private int fullness;
  private int alertness;
  private int kind_bud;
  private int doughnuts;
  private int beers;
  private int coffees;
  private boolean growler;
  private boolean coffee_cup;
  private boolean dime_bag;
  private boolean doughnut_box;
  private final static int MAX_BUZZ = 11;
  private final static int MAX_FULLNESS = 10;
  private final static int MAX_ALERTNESS = 10;

  public Player(String name, int image){
    this.name = name;
    this.image = image;
    this.buzz = MAX_BUZZ;
    this.fullness = MAX_FULLNESS;
    this.alertness = MAX_ALERTNESS;
    this.kind_bud = 0;
    this.doughnuts = 0;
    this.beers = 0;
    this.coffees = 0;
    this.growler = false;
    this.coffee_cup = false;
    this.dime_bag = false;
    this.doughnut_box = false;
  }

  @Override
  public boolean equals(Object otherPlayer){
    if (!(otherPlayer instanceof Player)) {
      return false;
    } else {
      Player newPlayer = (Player) otherPlayer;
      return this.getName().equals(newPlayer.getName());
    }
  }

  //BASIC GETTERS//

  public int getId(){
    return id;
  }

  public int getImage() {
    return image;
  }

  public String getName(){
    return name;
  }

  public int getFullness() {
    return fullness;
  }

  public int getAlertness(){
    return alertness;
  }

  public int getBuzz(){
    return buzz;
  }

//INVENTORY GETTERS//

  public int getDoughnuts() {
    return doughnuts;
  }

  public int getCoffees() {
    return coffees;
  }

  public int getKindBud() {
    return kind_bud;
  }

  public int getBeers() {
    return beers;
  }

//MODIFIER GETTERS//

  public boolean getGrowler(){
    return growler;
  }

  public boolean getCoffeeCup() {
    return coffee_cup;
  }

  public boolean getDimeBag() {
    return dime_bag;
  }

  public boolean getDoughnutBox() {
    return doughnut_box;
  }

  //BASIC SETTERS//

  public void setAlertness(int stoked) {
    this.alertness += stoked;
  }

  public void setBuzz(int chem) {
    this.buzz += chem;
  }

  public void setFullness(int nom) {
    this.fullness += nom;
  }

  public void reduceStats() {
    this.fullness --;
    this.buzz --;
    this.alertness --;
  }

  //INVENTORY SETTERS//

  public void setDoughnuts(int doughnut) {
    this.doughnuts += doughnut;
  }

  public void setCoffees(int coffee) {
    this.coffees += coffee;
  }

  public void setKindBud(int nugs) {
    this.kind_bud += nugs;
  }

  public void setBeers(int beer) {
    this.beers += beer;
  }

  //MODIFIER SETTERS//

  public void setGrowler(){
    this.growler = true;
  }

  public void setCoffeeCup() {
    this.coffee_cup = true;
  }

  public void setDimeBag() {
    this.dime_bag = true;
  }

  public void setDoughnut() {
    this.doughnut_box = true;
  }

  //CREATE//

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO players (image, name, growler, coffee_cup, dime_bag, doughnut_box, buzz, fullness, alertness, kind_bud, beers, doughnuts, coffees) VALUES (:image, :name, :growler, :coffee_cup, :dime_bag, :doughnut_box, :buzz, :fullness, :alertness, :kind_bud, :beers, :doughnuts, :coffees)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("image", this.image)
        .addParameter("name", this.name)
        .addParameter("growler", this.growler)
        .addParameter("coffee_cup", this.coffee_cup)
        .addParameter("dime_bag", this.dime_bag)
        .addParameter("doughnut_box", this.doughnut_box)
        .addParameter("buzz", this.buzz)
        .addParameter("fullness", this.fullness)
        .addParameter("alertness", this.alertness)
        .addParameter("kind_bud", this.kind_bud)
        .addParameter("beers", this.beers)
        .addParameter("doughnuts", this.doughnuts)
        .addParameter("coffees", this.coffees)
        .executeUpdate()
        .getKey();
    }
  }

  //READ//

  public static List<Player> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM players";
      return con.createQuery(sql)
      .executeAndFetch(Player.class);
    }
  }

  public static Player find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM players WHERE id=:id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Player.class);
    }
  }

  //UPDATE//

  public void updateInventory() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE players SET growler = :growler, coffee_cup = :coffee_cup, dime_bag = :dime_bag, doughnut_box = :doughnut_box, kind_bud=:kind_bud, beers=:beers, doughnuts=:doughnuts, coffees=:coffees WHERE id = :id";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .addParameter("growler", this.growler)
        .addParameter("coffee_cup", this.coffee_cup)
        .addParameter("dime_bag", this.dime_bag)
        .addParameter("doughnut_box", this.doughnut_box)
        .addParameter("kind_bud", this.kind_bud)
        .addParameter("beers", this.beers)
        .addParameter("doughnuts", this.doughnuts)
        .addParameter("coffees", this.coffees)
        .executeUpdate();
    }
  }

  public void updateStats() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE players SET buzz = :buzz, alertness = :alertness, fullness = :fullness WHERE id = :id";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .addParameter("buzz", this.buzz)
        .addParameter("fullness", this.fullness)
        .addParameter("alertness", this.alertness)
        .executeUpdate();
    }
  }
}
