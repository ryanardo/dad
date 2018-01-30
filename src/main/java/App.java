import dao.LoginSQL;
import models.Login;
import models.User;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.*;
import spark.ModelAndView;

import static spark.Spark.*;
import static spark.Spark.staticFileLocation;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/dad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        InterestSQL interestDao = new InterestSQL(sql2o);
        UserSQL userDao = new UserSQL(sql2o);
        LoginSQL loginDao = new LoginSQL(sql2o);


        //HOME PAGE/LOGIN
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "login.hbs");
        }, new HandlebarsTemplateEngine());



        //SHOW EXISTING USER AFTER LOGIN
        get("/user/:userId", (request, response)-> {
            Map<String, Object>model = new HashMap<>();
            int idOfUser = Integer.parseInt(request.params("loginId"));
            User foundUser = userDao.findById(idOfUser);
            model.put("user", foundUser);
            model.put("login", foundUser);
            return new ModelAndView(model, "profile.hbs");
        }, new HandlebarsTemplateEngine());


        //NEW USER FORM/SIGN UP
        get("/user/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sign-up.hbs");
        }, new HandlebarsTemplateEngine());



        //PROCESS NEW USER
        post("/user/new", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            String userName = request.queryParams("userName");
            String password = request.queryParams("password");
            String birthday = request.queryParams("birthday");
            Login newLogin = new Login(userName, password, birthday);
            int loginId = newLogin.getId();
            String name = request.queryParams("name");
            String gender = request.queryParams("gender");
            String preference = request.queryParams("preference");
            String userTagLine = request.queryParams("userTagLine");
            User newUser = new User(loginId, name, gender, preference);

            userDao.add(newUser);
            model.put("user", newUser);
            return new ModelAndView(model, "welcome.hbs");
        }, new HandlebarsTemplateEngine());




        //UPDATE USER/EXPAND PROFILE



        //SHOW ALL USERS BY PREFERENCE



        //SHOW A SELECTED USER'S PROFILE



        //LIKE A SELECTED USER

        //SEARCH FOR A POTENTIAL MATCH
        get("/profile/:user_id/search", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            int user_id = Integer.parseInt(request.params("user_id"));
            User user = userDao.findById(user_id);
            List<User> users = userDao.matchingGender(user);

            model.put("users", users);
            return new ModelAndView(model, "search.hbs");
        }, new HandlebarsTemplateEngine());
    }
}