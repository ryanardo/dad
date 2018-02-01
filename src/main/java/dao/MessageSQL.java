package dao;

import models.Message;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class MessageSQL implements MessageDAO{

    private final Sql2o sql2o;
    public MessageSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
        userDao = new UserSQL(sql2o);
    }

    private UserSQL userDao;

    @Override
    public void add(Message message) {
        String sql = "INSERT INTO messages (senderId, receiverId, content) VALUES (:senderId, :receiverId, :content)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(message)
                    .executeUpdate()
                    .getKey();
            message.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


//    @Override
    public List<Integer> getUsersReceivers(int userId) {
        List<Integer> receivers;
        List<Integer> result = new ArrayList<>();
        String sql = "SELECT receiverId FROM messages WHERE senderId = :userId";
        try (Connection con  = sql2o.open()) {
            receivers =  con.createQuery(sql)
                    .addParameter("userId", userId)
                    .executeAndFetch(Integer.class);
        }

        for (int i=0; i<receivers.size(); i++) {
            if (!result.contains(receivers.get(i))) {
                result.add(receivers.get(i));
            }
        }
        return result;
    }

//    @Override
    public List<Integer> getUsersSenders(int userId) {
        List<Integer> senders;
        List<Integer> result = new ArrayList<>();
        String sql = "SELECT senderId FROM messages WHERE receiverId = :userId";
        try (Connection con  = sql2o.open()) {
            senders = con.createQuery(sql)
                    .addParameter("userId", userId)
                    .executeAndFetch(Integer.class);
        }

        for (int i=0; i<senders.size(); i++) {
            if (!result.contains(senders.get(i))) {
                result.add(senders.get(i));
            }
        }
        return result;
    }


    public List<Integer> getDialogsListIds(int userId) {

        List<Integer> dialogs = new ArrayList<>();

        List<Integer> receivers = getUsersReceivers(userId);
        List<Integer> senders = getUsersSenders(userId);

        for(int i = 0; i < senders.size(); i++) {
            if(!receivers.contains(senders.get(i))) {
                receivers.add(senders.get(i));
            }
        }

        for (int j=0; j<receivers.size(); j++) {
            dialogs.add(receivers.get(j));
        }

        return dialogs;
    }

    @Override
    public List<User> getDialogsList(int userId) {

        List<Integer> dialogsIds = getDialogsListIds(userId);

        List<User> dialogs = new ArrayList<>();
         for (int i=0; i<dialogsIds.size(); i++) {
             User dialog = userDao.findById(dialogsIds.get(i));
             dialogs.add(dialog);
         }

        return dialogs;
    }

    @Override
    public List<Message> getDialog(int userId, int friendId) {
        String sql = "SELECT * FROM messages WHERE (senderId = :userId AND receiverId = :friendId) OR (receiverId = :userId AND senderId = :friendId)";
        try (Connection con  = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("userId", userId)
                    .addParameter("friendId", friendId)
                    .executeAndFetch(Message.class);
        }
    }

}
