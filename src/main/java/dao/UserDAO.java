package dao;


import models.User;

import java.util.List;

public interface UserDAO {

    /* CREATE * * * * * * * * * * */
    void add(User user);

    /* READ * * * * * * * * * * */
    User findById(int id);
    List<User> findAll();

    /* UPDATE * * * * * * * * * * */
    void updateUser(int id, String realName, String gender, String userTagLine);

    /* DELETE * * * * * * * * * * */
    void deleteById(int id);

}
