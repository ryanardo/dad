package dao;

import models.Login;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


public class LoginSQL implements LoginDAO {

    private final Sql2o sql2o;
    public LoginSQL(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Login login){
        String sql = "INSERT INTO logins (userName, password, birthday) VALUES (:userName, :password, :birthday)";
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
    public Integer getLoginId(String username, String password) {
        String sql = "SELECT id FROM logins WHERE (username = :username AND password = :password)";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .executeAndFetchFirst(Integer.class);
        }
    }

    @Override
    public Login findById(int id) {
        String sql = "SELECT * FROM logins WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Login.class);
        }
    }

    @Override
    public void deleteLogin(int id) {
        String sql = "DELETE FROM logins WHERE id = :id";
        try (Connection con = sql2o.open()) {
             con.createQuery(sql)
                    .addParameter("id", id)
                     .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}