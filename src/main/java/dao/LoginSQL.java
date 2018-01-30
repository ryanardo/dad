package dao;

import models.Login;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

/**
 * Created by Guest on 1/29/18.
 */
public class LoginSQL implements LoginDao{

    private final Sql2o sql2o;
    public LoginSQL(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Login login){
        String sql = "INSERT INTO logins (username, password, birthday) VALUES (:username, :password, :birthday)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(login)
                    .executeUpdate()
                    .getKey();
            login.setId(id);
        } catch (Sql2oException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public Login findByUserLogin(String username, String password) {
        String sql = "SELECT id FROM logins WHERE username = :username, password = :password";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .executeAndFetchFirst(Login.class);
        }
    }
}