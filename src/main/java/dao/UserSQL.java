package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class UserSQL implements UserDAO {

    private final Sql2o sql2o;
    public UserSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


  /* CREATE * * * * * * * * * * */
    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (loginId, realName, gender, preferredGender, userTagLine, age, location, sign, job, kids, profilePic) VALUES (:loginId, :realName, :gender, :preferredGender, :userTagLine, :age, :location, :sign, :job, :kids, :profilePic)";
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

    @Override
    public void addLike(int userId, int likedId) {
        String sql = "INSERT INTO users_likes (userId, likedId) VALUES (:userId, :likedId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("userId", userId)
                    .addParameter("likedId", likedId)
                    .executeUpdate();
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
    public User findUserByLoginId(int loginId) {
        String sql = "SELECT * FROM users WHERE loginId = :loginId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("loginId", loginId)
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


    @Override
    public List<User> matchingGender(User user) {
        if (user.getPreferredGender().equals("noPref")) {
            String sql = "SELECT * FROM users WHERE ((preferredGender = :gender OR preferredGender = 'noPref') AND id != :id)";
            try (Connection con = sql2o.open()) {
                return con.createQuery(sql)
                        .addParameter("gender", user.getGender())
                        .addParameter("id", user.getId())
                        .executeAndFetch(User.class);
            }
        } else {
            String sql = "SELECT * FROM users WHERE (gender = :preferredGender AND preferredGender = :gender AND id != :id)";
            try (Connection con = sql2o.open()) {
                return con.createQuery(sql)
                        .addParameter("preferredGender", user.getPreferredGender())
                        .addParameter("gender", user.getGender())
                        .addParameter("id", user.getId())
                        .executeAndFetch(User.class);
            }
        }
    }


    @Override
    public List<Integer> userLikes(User user) {
        String sql = "SELECT likedId FROM users_likes WHERE userId = :userId";
        try (Connection con  = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("userId", user.getId())
                    .executeAndFetch(Integer.class);
        }
    }

    @Override
    public List<Integer> userLikedBy(User user) {
        String sql = "SELECT userId FROM users_likes WHERE likedId = :userId";
        try (Connection con = sql2o.open()) {
            return con. createQuery(sql)
                    .addParameter("userId", user.getId())
                    .executeAndFetch(Integer.class);
        }
    }

    @Override
    public List<User> getMatchedPairs(User user) {

        List<Integer> likes = userLikes(user);
        List<Integer> likedBy = userLikedBy(user);

        List<User> matchedPairs = new ArrayList<>();
        for (int i = 0; i < likes.size(); i++) {
            for (int j = 0; j < likedBy.size(); j++) {
                if (likes.get(i) == likedBy.get(j)) {
                    matchedPairs.add(findById(likes.get(i)));
                }
            }
        }
        return matchedPairs;
    }

    /* UPDATE * * * * * * * * * * */
    @Override
    public void updateUser(int id, String realName, String gender, String preferredGender, String userTagLine, String age, String location, String sign, String job, String kids, String profilePic) {
        String sql = "UPDATE users SET realName = :realName, gender = :gender, preferredGender = :preferredGender, userTagLine = :userTagLine, age = :age, location = :location, sign = :sign, job = :job, kids = :kids, profilePic = :profilePic WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("realName", realName)
                    .addParameter("gender", gender)
                    .addParameter("preferredGender", preferredGender)
                    .addParameter("userTagLine", userTagLine)
                    .addParameter("age", age)
                    .addParameter("location", location)
                    .addParameter("sign", sign)
                    .addParameter("job", job)
                    .addParameter("kids", kids)
                    .addParameter("profilePic", profilePic)
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
