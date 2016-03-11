import java.util.*;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String [] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/map", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      Player player = Player.find(playerId);
      model.put("player", player);
      model.put("template", "templates/map.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/map", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      int selectedImage = Integer.parseInt(request.queryParams("image"));
      Player newPlayer = new Player(name, selectedImage);
      newPlayer.save();
      int playerId = newPlayer.getId();
      Game newGame = new Game();
      newGame.save();
      int gameId = newGame.getId();
      request.session().attribute("playerId", playerId);
      request.session().attribute("gameId", gameId);
      model.put("player", Player.find(playerId));
      model.put("game", Game.find(gameId));
      model.put("template", "templates/map.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/nw", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/nw.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/ne", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/ne.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sw", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/sw.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/se", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/se.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/nw/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      Quadrant quadrant = Quadrant.find(1);
      model.put("game", game);
      model.put("player", player);
      model.put("quadrant", quadrant);
      model.put("template", "templates/nw1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/nw/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      Quadrant quadrant = Quadrant.find(1);
      String userAction = request.queryParams("activity");

      quadrant.setDoughnut();
      quadrant.setBeer();

      if (userAction.equals("search")) {
        game.search(player,quadrant);
      } else if (userAction.equals("sleep")) {
        game.drinkCoffee(player);
      } else if (userAction.equals("eat")) {
        game.eatDoughnuts(player);
      } else if (userAction.equals("burn")){
        game.burnOneDown(player);
      }
      response.redirect("/nw/1");
      return null;
    });

    get("/nw/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      Quadrant quadrant = Quadrant.find(2);
      model.put("game", game);
      model.put("player", player);
      model.put("quadrant", quadrant);
      model.put("template", "templates/nw2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/nw/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      Quadrant quadrant = Quadrant.find(2);
      String userAction = request.queryParams("activity");

      quadrant.setCoffee();
      quadrant.setDoughnut();
      quadrant.setBeer();

      if (userAction.equals("search")) {
        game.search(player,quadrant);
      } else if (userAction.equals("drinkBeer")) {
        game.drinkBeer(player);
      } else if (userAction.equals("eatDoughnuts")) {
        game.eatDoughnuts(player);
      } else if (userAction.equals("burn")){
        game.burnOneDown(player);
      }
      response.redirect("/nw/2");
      return null;
    });

    get("/nw/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/nw3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/nw/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/nw3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/nw/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/nw4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/nw/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/nw4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/se/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/se1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/se/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/se1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/se/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/se2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/se/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/se2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/se/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/se3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/se/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/se3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/se/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/se4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/se/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/se4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sw/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/sw1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sw/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/sw1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sw/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/sw2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sw/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/sw2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sw/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/sw3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sw/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/sw3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sw/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/sw4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sw/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/sw4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/ne/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/ne1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/ne/1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/ne1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/ne/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/ne2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/ne/2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/ne2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/ne/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/ne3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/ne/3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/ne3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/ne/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int playerId = request.session().attribute("playerId");
      int gameId = request.session().attribute("gameId");
      Player player = Player.find(playerId);
      Game game = Game.find(gameId);
      model.put("player", player);
      model.put("template", "templates/ne4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/ne/4", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/ne4.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
