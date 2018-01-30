package dao;

import models.Login;


public interface LoginDao {

    //create

    //read
    Login getUserIdFromLogin(String username, String password);


    //update

    //delete
}