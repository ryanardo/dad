<<<<<<< HEAD
import com.sun.org.apache.xpath.internal.operations.Mod;
import dao.LoginSQL;
import models.Login;
import models.User;
import org.omg.CORBA.INTERNAL;
=======
import dao.LoginSQL;
import models.Login;
import models.User;
>>>>>>> 14f0b1e0d50a1fbff23b65bfe440c269b3fc6c13
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
<<<<<<< HEAD
        String connectionString = "jdbc:h2:~/dad2.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
=======
        String connectionString = "jdbc:h2:~/dad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
>>>>>>> 14f0b1e0d50a1fbff23b65bfe440c269b3fc6c13
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        InterestSQL interestDao = new InterestSQL(sql2o);
        UserSQL userDao = new UserSQL(sql2o);
        LoginSQL loginDao = new LoginSQL(sql2o);


        //HOME PAGE/LOGIN
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
<<<<<<< HEAD
=======

>>>>>>> 14f0b1e0d50a1fbff23b65bfe440c269b3fc6c13
            return new ModelAndView(model, "login.hbs");
        }, new HandlebarsTemplateEngine());


<<<<<<< HEAD

        //SHOW EXISTING USER AFTER LOGIN
        get("/user/login", (request, response)-> {
            Map<String, Object>model = new HashMap<>();

            String username = request.queryParams("user-name");
            String password = request.queryParams("password");
            Integer login_id = loginDao.findByUserLogin(username, password);

            User user = userDao.findUserByLoginId(login_id);

            model.put("user", user);
            model.put("login", loginDao.findById(login_id));
            return new ModelAndView(model, "profile.hbs");
        }, new HandlebarsTemplateEngine());

//        post("/user/login", (request, response)-> {
//            Map<String, Object>model = new HashMap<>();
//
//            String username = request.queryParams("user-name");
//            String password = request.queryParams("password");
//            Integer login_id = loginDao.findByUserLogin(username, password);
//
//            User user = userDao.findUserByLoginId(login_id);
//
//            int idOfUser = Integer.parseInt(request.params("user_id"));
//            User foundUser = userDao.findById(idOfUser);
//            model.put("user", foundUser);
//            model.put("login", foundUser);
//            return new ModelAndView(model, "profile.hbs");
//        }, new HandlebarsTemplateEngine());

//        get("/user/:user_id/profile", (request, response) -> {
//            Map<String, Object>model = new HashMap<>();
//
//            return new ModelAndView(model, "profile.hbs");
//        }, new HandlebarsTemplateEngine());
=======
        //SHOW EXISTING USER AFTER LOGIN

>>>>>>> 14f0b1e0d50a1fbff23b65bfe440c269b3fc6c13


        //NEW USER FORM/SIGN UP
        get("/user/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sign-up.hbs");
        }, new HandlebarsTemplateEngine());

<<<<<<< HEAD


        get("/user/:user_id/profile", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            User user = userDao.findById(Integer.parseInt(request.params("user_id")));
            model.put("user", user);

            return new ModelAndView(model, "profile.hbs");
        }, new HandlebarsTemplateEngine());


        //PROCESS NEW USER
        post("/user/new", (request, response)->{
            Map<String, Object> model = new HashMap<>();

            String userName = request.queryParams("user-name");
            String password = request.queryParams("password");
            String birthday = request.queryParams("birthday");

            Login newLogin = new Login(userName, password, birthday);
            int loginId = newLogin.getId();

            String name = request.queryParams("name");
            String gender = request.queryParams("gender");
            String preferredGender = request.queryParams("preference");
            String userTagLine = request.queryParams("userTagLine");

            User newUser = new User(loginId, name, gender, preferredGender);
            userDao.add(newUser);

            model.put("user", userDao.findById(newUser.getId()));
            model.put("login", loginDao.findById(newLogin.getId()));
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

        //DELETE PROFILE

        get("/user/:user_id/delete", (request, response)-> {
            Map<String, Object> model = new HashMap<>();
            int idOfUser = Integer.parseInt(request.params("userId"));
            User deleteUser = userDao.findById(idOfUser);
            return new ModelAndView(model, "goodbye.hbs");
        }, new HandlebarsTemplateEngine());
=======


        //PROCESS NEW USER
//        post("/user/new", (request, response)->{
//            Map<String, Object> model = new HashMap<>();
//            String userName = request.queryParams("userName");
//            String password = request.queryParams("password");
//            String birthday = request.queryParams("birthday");
//            Login newLogin = new Login(userName, password, birthday);
//
//            int loginId = newLogin.getId();
//            String name = request.queryParams("name");
//            String gender = request.queryParams("gender");
//            String preference = request.queryParams("preference");
//            String userTagLine = request.queryParams("userTagLine");
//            User newUser = new User(loginId, name, gender, preference);
//
//            userDao.add(newUser);
//            model.put("user", newUser);
//            return new ModelAndView(model, "welcome.hbs");
//        }, new HandlebarsTemplateEngine());

        //UPDATE USER/EXPAND PROFILE

        //SHOW ALL USERS BY PREFERENCE

        //SHOW A SELECTED USER'S PROFILE

        //LIKE A SELECTED USER

        //
>>>>>>> 14f0b1e0d50a1fbff23b65bfe440c269b3fc6c13
    }
}