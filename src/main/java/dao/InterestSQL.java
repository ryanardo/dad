package dao;

import models.*;
import org.omg.CORBA.SystemException;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class InterestSQL implements InterestDAO {

    private final Sql2o sql2o;
    public InterestSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Interest interest) {
        String sql = "INSERT INTO interests (interest) VALUES (:interest)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(interest)
                    .executeUpdate()
                    .getKey();
            interest.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Interest findById(int id) {
        String sql = "SELECT * FROM interests WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Interest.class);
        }
    }

    @Override
    public List<Interest> getAll() {
        return null;
    }

    @Override
    public void update(int id, String interest) {

    }

    @Override
    public void deleteInterestById(int id) {

    }

    @Override
    public void deleteAll() {

    }
}