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

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", request.session().attribute("heroes"));//adding into the session and displaying into the index.vtl
            model.put("template", "templates/index.vtl");

            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();//Remember, any extra information the template needs must be packaged in a HashMap named model
           ArrayList<Hero> heroes = request.session().attribute("heroes"); //this arraylist retrieves all your heoers, were heres are being saved of it ain't there create a new one

           if(heroes == null){
               heroes = new ArrayList<Hero>(); //adds a new arraylist if not yet created
               request.session().attribute("heroes", heroes);}
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, Integer.parseInt(age), power, weakness);
            heroes.add(newHero); //add the new hero to the heroes arraylist

            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



    }
}
