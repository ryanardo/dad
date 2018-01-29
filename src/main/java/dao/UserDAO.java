package dao;


import models.User;

import java.util.List;

public interface UserDAO {

    /* CREATE * * * * * * * * * * */
    void add(int loginId, String realName, String gender, String userTagLine);

    /* READ * * * * * * * * * * */
    void findById(int id);
    List<User> findAll(User user);

    /* UPDATE * * * * * * * * * * */
    void updateUser(String realName, String gender, String userTagLine);

    /* DELETE * * * * * * * * * * */
    void deleteById(int id);

}
