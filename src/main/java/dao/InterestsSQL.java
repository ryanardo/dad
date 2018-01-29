package dao;

import models.Interests;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

/**
 * Created by Guest on 1/29/18.
 */
public class InterestsSQL implements InterestsDAO {

    private final Sql2o sql2o;
    public InterestsSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Interests interests) {
        String sql = "INSERT INTO interests (interests) VALUES (:interests)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(interests)
                    .executeUpdate()
                    .getKey();
            interests.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
}


//    //read
//    Interests findInterestsById(int id);
//    List<Interests> getAll();
//    //update
//    void update(int id, String Interests);
//
//    //delete
//    void deleteInterestById(int id);
//    void deleteAll();