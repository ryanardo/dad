package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class UserSQLTest {

    private UserSQL daoUser;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        daoUser = new UserSQL(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_canCreateUser_true() throws Exception {
        User user1 = new User(1, "Ross 'SoFetch' Fletcher", "Male", "Hi, I'm big and dumb!");
        daoUser.add(user1);

        assertEquals(1, daoUser.getAll().size());
    }

    @Test
    public void addLike_canAddLikeToUserLikesJoinTable_true() throws Exception {
        User user1 = new User(1, "Ross 'SoFetch' Fletcher", "Male", "Unknown", "Hi, I'm big and dumb!");
        daoUser.add(user1);

        User user2 = new User(1, "Ryan 'SoHawt' Ferris" , "Unknown", "Male", "Hi, I'm big and dumb!");
        daoUser.add(user2);

        int idUser1 = user1.getId();
        int idUser2 = user2.getId();

        daoUser.addLike(idUser1, idUser2);

        assertEquals(1, daoUser.userLikes(user1).size());
        assertEquals(user2.getRealName(), daoUser.findById(daoUser.userLikes(user1).get(0)).getRealName());

        daoUser.addLike(idUser2, idUser1);
        assertEquals(user2.getRealName(), daoUser.findById(daoUser.userLikedBy(user1).get(0)).getRealName());
    }

    @Test
    public void getMatchedPairs_canFindAccurateMatches_true() throws Exception {
        User user1 = new User(1, "Ross 'SoFetch' Fletcher", "Male", "Male", "Hi, I'm big and dumb!");
        daoUser.add(user1);

        User user2 = new User(2, "Ryan 'SoHawt' Ferris" , "Male", "Male", "Hi, I'm big and dumb!");
        daoUser.add(user2);

        User user3 = new User(3, "Britney Spears", "Male", "Male", "I'm Britney Bitch.");
        daoUser.add(user3);

        User user4 = new User(4, "JT" , "Male", "Male", "Bye! Bye! Bye!");
        daoUser.add(user4);

        int idUser1 = user1.getId();
        int idUser2 = user2.getId();
        int idUser3 = user3.getId();
        int idUser4 = user4.getId();

        daoUser.addLike(idUser1, idUser2);
        daoUser.addLike(idUser1, idUser3);
        daoUser.addLike(idUser1, idUser4);

        daoUser.addLike(idUser2, idUser1);
        daoUser.addLike(idUser3, idUser1);
        daoUser.addLike(idUser3, idUser4);

        assertEquals(2, daoUser.getMatchedPairs(user1).size());
        assertTrue(daoUser.getMatchedPairs(user1).contains(user3));
        assertTrue(daoUser.getMatchedPairs(user1).contains(user2));
    }

    @Test
    public void findById_canFindUserById() throws Exception {
        User user1 = new User(1, "Ross 'SoFetch' Fletcher", "Male", "Hi, I'm big and dumb!");
        daoUser.add(user1);
        int idUser1 = user1.getId();

        User user2 = new User(2, "Sam 'Guest-Pass' Gespass", "Male", "Hi!");
        daoUser.add(user2);
        int idUser2 = user2.getId();

        assertEquals(2, daoUser.findById(idUser2).getLoginId());
    }

    @Test
    public void getAll() throws Exception {
        User user1 = new User(4, "Whatthefuckever", "dolphin", "EEEEEE");
        daoUser.add(user1);

        User user2 = new User(8, "Youneek", "mosquito", "buzz baby");
        daoUser.add(user2);

        assertEquals(2, daoUser.getAll().size());

    }

    @Test
    public void matchingGender3() throws Exception {
        User user1 = new User(4, "Whatthefuckever", "male", "noPref", "EEEEEE");
        daoUser.add(user1);

        User user2 = new User(8, "Youneek", "female", "male", "buzz baby");
        daoUser.add(user2);

        User user3 = new User(8, "Youneek", "other", "noPref", "buzz baby");
        daoUser.add(user3);

        User user4 = new User(8, "Youneek", "other", "female", "buzz baby");
        daoUser.add(user4);

        User user5 = new User(8, "Youneek", "other", "male", "buzz baby");
        daoUser.add(user5);


        assertEquals(3, daoUser.matchingGender(user1).size());
        assertTrue(daoUser.matchingGender(user1).contains(user2));
        assertTrue(daoUser.matchingGender(user1).contains(user3));
        assertNotEquals(true, daoUser.matchingGender(user1).contains(user4));
        assertTrue(daoUser.matchingGender(user1).contains(user5));
    }

    @Test
    public void matchingGender() throws Exception {
        User user1 = new User(4, "Whatthefuckever", "dolphin", "shark", "EEEEEE");
        daoUser.add(user1);

        User user2 = new User(8, "Youneek", "shark", "dolphin", "buzz baby");
        daoUser.add(user2);

        User user3 = new User(8, "Youneek2", "shark", "shark", "buzz baby");
        daoUser.add(user3);

        assertEquals(1, daoUser.matchingGender(user1).size());
        assertEquals(user2.getRealName(), daoUser.matchingGender(user1).get(0).getRealName());
    }

    @Test
    public void matchingGender2() throws Exception {
        User user1 = new User(1, "mike", "male", "male", "cool");
        daoUser.add(user1);

        User user2 = new User(2, "jack", "male", "male", "very cool");
        daoUser.add(user2);

        User user3 = new User(3, "bob", "male", "male", "very very cool");
        daoUser.add(user3);

        List<User> users = daoUser.matchingGender(user1);

        assertEquals(2, users.size());
        assertEquals("jack", users.get(0).getRealName());
    }


    @Test
    public void updateUser() throws Exception {
        User user1 = new User(4, "Whatthefuckever", "dolphin", "EEEEEE");
        daoUser.add(user1);
        int idUser1 = user1.getId();
        daoUser.updateUser(idUser1, "Huh", "whale", "dolphin", "uuuooOOO");

        assertEquals("Huh", daoUser.findById(idUser1).getRealName());
    }

    @Test
    public void deleteById_canDeleteUserById() throws Exception {
        User user1 = new User(1, "Ross 'SoFetch' Fletcher", "Male", "Hi, I'm big and dumb!");
        daoUser.add(user1);
        int idUser1 = user1.getId();

        User user2 = new User(2, "Sam 'Guest-Pass' Gespass", "Male", "Hi!");
        daoUser.add(user2);
        int idUser2 = user2.getId();

        daoUser.deleteById(idUser1);

        assertEquals(1, daoUser.getAll().size());
    }

}