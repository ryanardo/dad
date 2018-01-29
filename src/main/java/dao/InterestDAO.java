package dao;

import models.*;

import java.util.List;

public interface InterestDAO {

    //create
    void add(Interest interests);

    //read
    Interest findInterestsById(int id);
    List<Interest> getAll();

    //update
    void update(int id, String Interests);

    //delete
    void deleteInterestById(int id);
    void deleteAll();

}
