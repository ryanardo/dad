package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class UserSQL implements UserDAO {

    private final Sql2o sql2o;
    public UserSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

  /* CREATE * * * * * * * * * * */
    @Override
    public void add(User user) {
        String sql = "INSERT INTO USERS (loginId, realName, gender, userTagLine) VALUES (:loginId, :realName, :gender, :userTagLine)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    /* READ * * * * * * * * * * */
    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(User.class);
        }
    }

    /* UPDATE * * * * * * * * * * */
    @Override
    public void updateUser(int id, String realName, String gender, String userTagLine) {
        String sql = "UPDATE users SET realName = :realName, gender = :gender, userTagLine = :userTagLine WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("realName", realName)
                    .addParameter("gender", gender)
                    .addParameter("userTagLine", userTagLine)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    /* DELETE * * * * * * * * * * */
    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
