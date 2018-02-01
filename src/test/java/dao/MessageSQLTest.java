package dao;

import models.Message;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class MessageSQLTest {

    private MessageSQL messageDao;
    private UserSQL userDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        messageDao = new MessageSQL(sql2o);
        userDao = new UserSQL(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() {
        Message message = new Message(1, 2, "Hello");
        messageDao.add(message);

        assertEquals(1, message.getId());
    }

    @Test
    public void getUsersReceivers() {
        int userId = 1;
        Message message1 = new Message(userId, 2, "hi");
        messageDao.add(message1);

        Message message2 = new Message(2, userId, "hello");
        messageDao.add(message2);

        Message message3 = new Message(userId, 2, "how are you");
        messageDao.add(message3);

        Message message4 = new Message(2, userId, "fine");
        messageDao.add(message4);


        Message message5 = new Message(userId, 3, "i like your picture");
        messageDao.add(message5);


        Message message6 = new Message(4, userId, "hey, wanna meet?");
        messageDao.add(message6);

        assertEquals(2, messageDao.getUsersReceivers(userId).size());
        assertTrue(messageDao.getUsersReceivers(userId).contains(3));
    }

    @Test
    public void getUsersSenders() {
        int userId = 1;
        Message message1 = new Message(userId, 2, "hi");
        messageDao.add(message1);

        Message message2 = new Message(2, userId, "hello");
        messageDao.add(message2);

        Message message3 = new Message(userId, 2, "how are you");
        messageDao.add(message3);

        Message message4 = new Message(2, userId, "fine");
        messageDao.add(message4);


        Message message5 = new Message(userId, 3, "i like your picture");
        messageDao.add(message5);


        Message message6 = new Message(4, userId, "hey, wanna meet?");
        messageDao.add(message6);

        assertEquals(2, messageDao.getUsersSenders(userId).size());
        assertTrue(messageDao.getUsersSenders(userId).contains(4));
    }

    @Test
    public void getDialogsList() {
        User user1 = new User("jack", "male", "male");
        userDao.add(user1);
        User user2 = new User("jim", "male", "male");
        userDao.add(user2);
        User user3 = new User("joe", "male", "male");
        userDao.add(user3);
        User user4 = new User("jerald", "male", "male");
        userDao.add(user4);


        int userId = user1.getId();
        Message message1 = new Message(userId, user2.getId(), "hi");
        messageDao.add(message1);

        Message message2 = new Message(user2.getId(), userId, "hello");
        messageDao.add(message2);

        Message message3 = new Message(userId, user2.getId(), "how are you");
        messageDao.add(message3);

        Message message4 = new Message(user2.getId(), userId, "fine");
        messageDao.add(message4);


        Message message5 = new Message(userId, user3.getId(), "i like your picture");
        messageDao.add(message5);


        Message message6 = new Message(user4.getId(), userId, "hey, wanna meet?");
        messageDao.add(message6);



        assertEquals(3, messageDao.getDialogsList(userId).size());
        assertTrue(messageDao.getDialogsList(userId).contains(user2));
        assertTrue(messageDao.getDialogsList(userId).contains(user3));
        assertTrue(messageDao.getDialogsList(userId).contains(user4));
    }

    @Test
    public void getDialog() {
        User user1 = new User("jack", "male", "male");
        userDao.add(user1);
        User user2 = new User("jim", "male", "male");
        userDao.add(user2);
        User user3 = new User("joe", "male", "male");
        userDao.add(user3);
        User user4 = new User("jerald", "male", "male");
        userDao.add(user4);


        int userId = user1.getId();
        Message message1 = new Message(userId, user2.getId(), "hi");
        messageDao.add(message1);

        Message message2 = new Message(user2.getId(), userId, "hello");
        messageDao.add(message2);

        Message message3 = new Message(userId, user2.getId(), "how are you");
        messageDao.add(message3);

        Message message4 = new Message(user2.getId(), userId, "fine");
        messageDao.add(message4);


        Message message5 = new Message(userId, user3.getId(), "i like your picture");
        messageDao.add(message5);


        Message message6 = new Message(user4.getId(), userId, "hey, wanna meet?");
        messageDao.add(message6);

        assertEquals(4, messageDao.getDialog(userId, user2.getId()).size());
        assertTrue(messageDao.getDialog(userId, user2.getId()).contains(message1));
        assertTrue(messageDao.getDialog(userId, user2.getId()).contains(message2));
        assertTrue(messageDao.getDialog(userId, user2.getId()).contains(message3));
        assertTrue(messageDao.getDialog(userId, user2.getId()).contains(message4));
    }
}