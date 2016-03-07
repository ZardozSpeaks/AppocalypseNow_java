import org.sql2o.*
import java.util.List;

public class Player {

  private int id;
  private int image;
  private String name;
  private boolean growler;
  private boolean coffee_cup;
  private boolean dime_bag;
  private boolean doughnut_box;

  public Player(String name, int image){
    this.name = name;
    this.image = image;
    this.growler = false;
    this.coffee_cup = false;
    this.dime_bag = false;
    this.doughnut_box = false;
  }

  //GETTER METHODS//

  public int getId(){
    return id;
  }

  public int getImage() {
    return image;
  }

  public String getName(){
    return name;
  }

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

  //SETTER METHODS//

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
}
