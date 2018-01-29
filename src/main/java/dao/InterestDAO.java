package dao;

import models.*;

import java.util.List;

public interface InterestDAO {

    //create
    void add(Interest interest);

    //read
    Interest findById(int id);
    List<Interest> getAll();

    //update
    void update(int id, String interest);

    //delete
    void deleteInterestById(int id);
    void deleteAll();

}
