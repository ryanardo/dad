package dao;

import models.Login;


public interface LoginDao {

    //create
    void add(Login login);

    //read
    Login findByUserLogin(String username, String password);
    //update

    //delete
}


