package dao;

import models.Login;

/**
 * Created by Guest on 1/29/18.
 */
public interface LoginDao {

    //create

    //read
    Login getUserIdFromLogin(String username, String password);


    //update

    //delete
}