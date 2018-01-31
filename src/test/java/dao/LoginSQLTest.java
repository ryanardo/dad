package dao;

import models.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

/**
 * Created by Guest on 1/29/18.
 */
public class LoginSQLTest {

    private LoginSQL loginDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        loginDao = new LoginSQL(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() throws Exception {
        Login testLogin = setupLogin();
        loginDao.add(testLogin);
        assertEquals(1, testLogin.getId());
    }

    @Test
    public void getLoginId() throws Exception {
        Login testLogin = setupLogin();
        Login testSecondLogin = setupSecondLogin();
        loginDao.add(testLogin);
        loginDao.add(testSecondLogin);

        String testUserName = testLogin.getUserName();
        String testPassword = testLogin.getPassword();

        String testUserName2 = testSecondLogin.getUserName();
        String testPassword2 = testSecondLogin.getPassword();

        assertEquals(1, (int) loginDao.getLoginId(testUserName, testPassword));
        assertEquals(2, (int) loginDao.getLoginId(testUserName2, testPassword2));
    }


    public Login setupLogin() {
        return new Login("username", "password", "birthday");
    }

    public Login setupSecondLogin() {
        return new Login("username2", "password2", "birthday2");
    }

}