package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;

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
    public void updateUser() throws Exception {
        User user1 = new User(4, "Whatthefuckever", "dolphin", "EEEEEE");
        daoUser.add(user1);
        int idUser1 = user1.getId();
        daoUser.updateUser(idUser1, "Huh", "whale", "uuuooOOO");

        assertEquals("Huh", daoUser.findById(idUser1).getRealName());
    }

    @Test
    public void deleteById() throws Exception {
    }

}