package dao;

import models.Login;

/**
 * Created by Guest on 1/29/18.
 */
public interface LoginDAO {

    //create
    public void add(Login login);

    //read
    Login findByUserLogin(String username, String password);
//    void Login getUserIdFromLogin(String username, String password);

    //update

    //delete
}