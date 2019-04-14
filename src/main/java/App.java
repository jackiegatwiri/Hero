import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
        port(9000);

        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/squadForm.vtl"); //renders a form that a user fills for the new squad
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            Squad newSquad = new Squad(name); //adds the new squad to the Squads.vtl then displays success form squadSuccess
            model.put("template", "templates/squadSuccess.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", Squad.all());
            model.put("template", "templates/squads.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("heroes", request.session().attribute("heroes"));//adding into the session and displaying into the index.vtl
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("squads/:id/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squadHeroesForm.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", Hero.all()); //replaces the arralist that we were initially creating
            model.put("template", "templates/heroes.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();//Remember, any extra information the template needs must be packaged in a HashMap named model
            Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, Integer.parseInt(age), power, weakness);

            squad.addHero(newHero);
            model.put("squad", squad);
            model.put("template", "templates/squadHeroesSuccess.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
            model.put("hero", hero);
            model.put("template", "templates/hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



    }
}
