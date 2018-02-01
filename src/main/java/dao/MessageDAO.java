package dao;

import models.Message;
import models.User;

import java.util.List;

public interface MessageDAO {

    void add(Message message);

//    Message findById(int id);

//    List<Integer> getUsersReceivers(int userId);
//
//    List<Integer> getUsersSenders(int userId);

    List<User> getDialogsList(int userId);



    List<Message> getDialog(int userId, int friendId);
}
