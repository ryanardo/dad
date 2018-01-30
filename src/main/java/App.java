import dao.LoginSQL;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
//import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.*;


import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/dad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        InterestSQL interestDao = new InterestSQL(sql2o);
        UserSQL userDao = new UserSQL(sql2o);
        LoginSQL loginDao = new LoginSQL(sql2o);

    }

    //HOME PAGE
    get("/", (req, res) -> {
        Map<String, Object> model = new HashMap<>();




    }
}