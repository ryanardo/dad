import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Guest on 1/29/18.
 */
public class App {


    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "index.hbs");
    }, new HandlebarsTemplateEngine());





    get("/login", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "index.hbs");
    }, new HandlebarsTemplateEngine());
}
